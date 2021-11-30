package com.example.cryptoworld.service.Impl;

import com.example.cryptoworld.models.entities.CreditCardEntity;
import com.example.cryptoworld.models.entities.CryptoCurrenciesEntity;
import com.example.cryptoworld.models.entities.LogSell;
import com.example.cryptoworld.models.entities.UserEntity;
import com.example.cryptoworld.models.enums.EnumCryptoTop10;
import com.example.cryptoworld.models.service.SellCryptoServiceModel;
import com.example.cryptoworld.models.view.LogSellView;
import com.example.cryptoworld.repository.CreditCardRepository;
import com.example.cryptoworld.repository.CryptoRepository;
import com.example.cryptoworld.repository.LogSellRepository;
import com.example.cryptoworld.repository.UserRepository;
import com.example.cryptoworld.service.LogSellService;
import com.example.cryptoworld.service.WalletService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LogSellServiceImpl implements LogSellService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CreditCardRepository creditCardRepository;
    private final CryptoRepository cryptoRepository;
    private final LogSellRepository logSellRepository;
    private final WalletService walletService;

    public LogSellServiceImpl(UserRepository userRepository,
                              ModelMapper modelMapper,
                              CreditCardRepository creditCardRepository,
                              CryptoRepository cryptoRepository,
                              LogSellRepository logSellRepository, WalletService walletService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.creditCardRepository = creditCardRepository;
        this.cryptoRepository = cryptoRepository;
        this.logSellRepository = logSellRepository;
        this.walletService = walletService;
    }


    @Override
    public void sellLog(SellCryptoServiceModel sellCryptoServiceModel) {

        // LOG SELL START


        LogSell logSell = new LogSell();

        UserEntity userEntity = userRepository.findByUsername
                (sellCryptoServiceModel.getUsernameConfirm()).orElse(null);


        logSell.setSellPerson(userEntity);

        double profit =
                getProfit(sellCryptoServiceModel.getCrypto(),
                        sellCryptoServiceModel.getSellValue());


        logSell.setProfit(profit);

        logSell.setCryptoToSell(sellCryptoServiceModel.getSellValue());

        logSell.setCrypto(sellCryptoServiceModel.getCrypto());

        logSellRepository.save(logSell);

        // END

        // WALLET SET NEW BALANCE

        walletService.sell(sellCryptoServiceModel.getSellValue(),
                sellCryptoServiceModel.getCrypto().name(),
                sellCryptoServiceModel.getUsernameConfirm());

        // END


        // CREDIT CARD START

        CreditCardEntity cardEntity =
                creditCardRepository.findById(userEntity.getId()).orElse(null);


        double newBalance =
                cardEntity.getBalance().doubleValue() + profit;

        cardEntity.setBalance(BigDecimal.valueOf(newBalance));

        creditCardRepository.save(cardEntity);


        // END
    }

    @Override
    public List<LogSellView> getAllSellOrderDesc() {
        return logSellRepository
                .getAllLogSellOrderDesc()
                .stream()
                .map(sell -> modelMapper.map(sell, LogSellView.class))
                .collect(Collectors.toList());
    }


    private double getProfit(EnumCryptoTop10 cryptoName, double sellValue) {


        CryptoCurrenciesEntity currCrypto =
                cryptoRepository.findByCurrencies(cryptoName).orElse(null);


        double result = 0;


        result = sellValue * currCrypto.getPrice();


        return result;
    }
}
