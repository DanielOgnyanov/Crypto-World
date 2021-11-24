package com.example.cryptoworld.service.Impl;

import com.example.cryptoworld.models.entities.CreditCardEntity;
import com.example.cryptoworld.models.entities.CryptoCurrenciesEntity;
import com.example.cryptoworld.models.entities.LogSell;
import com.example.cryptoworld.models.entities.UserEntity;
import com.example.cryptoworld.models.enums.EnumCryptoTop10;
import com.example.cryptoworld.models.service.SellCryptoServiceModel;
import com.example.cryptoworld.repository.CreditCardRepository;
import com.example.cryptoworld.repository.CryptoRepository;
import com.example.cryptoworld.repository.LogSellRepository;
import com.example.cryptoworld.repository.UserRepository;
import com.example.cryptoworld.service.LogSellService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class LogSellServiceImpl implements LogSellService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CreditCardRepository creditCardRepository;
    private final CryptoRepository cryptoRepository;
    private final LogSellRepository logSellRepository;

    public LogSellServiceImpl(UserRepository userRepository,
                              ModelMapper modelMapper,
                              CreditCardRepository creditCardRepository,
                              CryptoRepository cryptoRepository,
                              LogSellRepository logSellRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.creditCardRepository = creditCardRepository;
        this.cryptoRepository = cryptoRepository;
        this.logSellRepository = logSellRepository;
    }


    @Override
    public void sellLog(SellCryptoServiceModel sellCryptoServiceModel) {

        LogSell logSell = new LogSell();

        UserEntity userEntity = userRepository.findByUsername
                (sellCryptoServiceModel.getUsernameConfirm()).orElse(null);


        logSell.setSellPerson(userEntity);

        double profit = getProfit(sellCryptoServiceModel.getCrypto(),sellCryptoServiceModel.getSellValue());
        logSell.setProfit(profit);

        logSell.setCryptoToSell(sellCryptoServiceModel.getSellValue());

        logSell.setCrypto(sellCryptoServiceModel.getCrypto());

        CreditCardEntity cardEntity =
                creditCardRepository.findById(userEntity.getId()).orElse(null);


        double newBalance =
                cardEntity.getBalance().doubleValue() + profit;

        cardEntity.setBalance(BigDecimal.valueOf(newBalance));

        creditCardRepository.save(cardEntity);

        logSellRepository.save(logSell);

    }


    private double getProfit(EnumCryptoTop10 cryptoName, double sellValue) {


        CryptoCurrenciesEntity currCrypto =
                cryptoRepository.findByCurrencies(cryptoName).orElse(null);


        double result = 0;


        result = sellValue * currCrypto.getPrice();


        return result;
    }
}
