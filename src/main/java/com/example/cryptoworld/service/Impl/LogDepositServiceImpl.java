package com.example.cryptoworld.service.Impl;

import com.example.cryptoworld.models.entities.*;
import com.example.cryptoworld.models.enums.EnumCryptoTop10;
import com.example.cryptoworld.models.service.LogDepositServiceModel;
import com.example.cryptoworld.repository.CreditCardRepository;
import com.example.cryptoworld.repository.CryptoRepository;
import com.example.cryptoworld.repository.LogDepositRepository;
import com.example.cryptoworld.repository.UserRepository;
import com.example.cryptoworld.service.LogDepositService;
import com.example.cryptoworld.service.WalletService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class LogDepositServiceImpl implements LogDepositService {


    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CreditCardRepository creditCardRepository;
    private final CryptoRepository cryptoRepository;
    private final LogDepositRepository logDepositRepository;
    private final WalletService walletService;

    public LogDepositServiceImpl(UserRepository userRepository,
                                 ModelMapper modelMapper,
                                 CreditCardRepository creditCardRepository, CryptoRepository cryptoRepository, LogDepositRepository logDepositRepository, WalletService walletService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.creditCardRepository = creditCardRepository;
        this.cryptoRepository = cryptoRepository;
        this.logDepositRepository = logDepositRepository;
        this.walletService = walletService;
    }


    @Override
    public void addLogDeposit(LogDepositServiceModel logDepositServiceModel) {


        // LOG DEPOSIT SET VALUR INTO
        LogDeposit logDeposit = new LogDeposit();

        UserEntity userEntity = userRepository.findByUsername
                (logDepositServiceModel.getUsernameConfirm()).orElse(null);

        logDeposit.setDepositPerson(userEntity);
        logDeposit.setFiatMoney(logDepositServiceModel.getDeposit());
        logDeposit.setCrypto(logDepositServiceModel.getCrypto());
        logDeposit.setCryptoValue(calcCryptoValue(
                logDepositServiceModel.getCrypto(),logDepositServiceModel.getDeposit()
        ));

        // END


        // CHECK IF THE USER DEPOSIT FOR FIRST TIME AND SET THE DEPOSIT VALUE IN THE WALLET
        // ELSE CREATE THE WALLET AND SET THE VALUE

        if (walletService.findUsersWallet(logDepositServiceModel.getUsernameConfirm())) {

            walletService.setValue(logDepositServiceModel.getDeposit(),
                    logDepositServiceModel.getCrypto().name(), logDepositServiceModel.getUsernameConfirm());

        } else {
            UserEntity currUser =
                    userRepository
                            .findByUsername(logDepositServiceModel.getUsernameConfirm()).orElse(null);

            WalletEntity walletEntity = new WalletEntity();

            walletEntity.setOwner(currUser);

            walletService.setValue(logDepositServiceModel.getDeposit(),
                    logDepositServiceModel.getCrypto().name(),
                    logDepositServiceModel.getUsernameConfirm());
        }

        // END WALLET SETTING


        // UPDATE CREDIT CARD BALANCE
        CreditCardEntity cardEntity =
                creditCardRepository.findById(userEntity.getId()).orElse(null);

        double newBalance =
                cardEntity.getBalance().doubleValue() - logDepositServiceModel.getDeposit();

        // END


        // SAVE INTO REPO

        cardEntity.setBalance(BigDecimal.valueOf(newBalance));
        creditCardRepository.save(cardEntity);

        logDepositRepository.save(logDeposit);

    }


    protected double calcCryptoValue(EnumCryptoTop10 cryptoName, double depositValue) {

        CryptoCurrenciesEntity currCrypto =
                cryptoRepository.findByCurrencies(cryptoName).orElse(null);

        double result = 0;


        result = depositValue / currCrypto.getPrice();


        return result;


    }
}
