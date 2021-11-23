package com.example.cryptoworld.service.Impl;

import com.example.cryptoworld.models.entities.CryptoCurrenciesEntity;
import com.example.cryptoworld.models.entities.LogDeposit;
import com.example.cryptoworld.models.entities.UserEntity;
import com.example.cryptoworld.models.enums.EnumCryptoTop10;
import com.example.cryptoworld.models.service.LogDepositServiceModel;
import com.example.cryptoworld.repository.CreditCardRepository;
import com.example.cryptoworld.repository.CryptoRepository;
import com.example.cryptoworld.repository.UserRepository;
import com.example.cryptoworld.service.LogDepositService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class LogDepositServiceImpl implements LogDepositService {


    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CreditCardRepository creditCardRepository;
    private final CryptoRepository cryptoRepository;

    public LogDepositServiceImpl(UserRepository userRepository,
                                 ModelMapper modelMapper,
                                 CreditCardRepository creditCardRepository, CryptoRepository cryptoRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.creditCardRepository = creditCardRepository;
        this.cryptoRepository = cryptoRepository;
    }


    @Override
    public void addLogDeposit(LogDepositServiceModel logDepositServiceModel) {

        LogDeposit logDeposit = new LogDeposit();

        UserEntity userEntity = userRepository.findByUsername
                (logDepositServiceModel.getUsernameConfirm()).orElse(null);

        logDeposit.setDepositPerson(userEntity);
        logDeposit.setFiatMoney(logDepositServiceModel.getDeposit());
        logDeposit.setCrypto(logDepositServiceModel.getCrypto());
        logDeposit.setCryptoValue(calcCryptoValue(
                logDepositServiceModel.getCrypto(),logDepositServiceModel.getDeposit()
        ));

    }


    protected double calcCryptoValue(EnumCryptoTop10 cryptoName, double depositValue) {

        CryptoCurrenciesEntity currCrypto =
                cryptoRepository.findByCurrencies(cryptoName).orElse(null);

        double result = 0;


        result = depositValue / currCrypto.getPrice();


        return result;


    }
}
