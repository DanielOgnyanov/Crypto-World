package com.example.cryptoworld.service.Impl;

import com.example.cryptoworld.models.entities.*;
import com.example.cryptoworld.models.service.LogDepositServiceModel;
import com.example.cryptoworld.models.view.LogDepositView;
import com.example.cryptoworld.repository.*;
import com.example.cryptoworld.service.LogDepositService;
import com.example.cryptoworld.service.WalletService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LogDepositServiceImpl implements LogDepositService {


    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CreditCardRepository creditCardRepository;
    private final CryptoRepository cryptoRepository;
    private final LogDepositRepository logDepositRepository;
    private final WalletService walletService;
    private final WalletRepository walletRepository;

    public LogDepositServiceImpl(UserRepository userRepository,
                                 ModelMapper modelMapper,
                                 CreditCardRepository creditCardRepository, CryptoRepository cryptoRepository, LogDepositRepository logDepositRepository, WalletService walletService, WalletRepository walletRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.creditCardRepository = creditCardRepository;
        this.cryptoRepository = cryptoRepository;
        this.logDepositRepository = logDepositRepository;
        this.walletService = walletService;
        this.walletRepository = walletRepository;
    }


    @Override
    public void addLogDeposit(LogDepositServiceModel logDepositServiceModel) {


        // LOG DEPOSIT SET VALUE INTO

        LogDeposit logDeposit = new LogDeposit();

        UserEntity userEntity = userRepository.findByUsername
                (logDepositServiceModel.getUsernameConfirm()).orElse(null);

        logDeposit.setDepositPerson(userEntity);
        logDeposit.setFiatMoney(logDepositServiceModel.getDeposit());
        logDeposit.setCrypto(logDepositServiceModel.getCrypto());
        logDeposit.setCryptoValue(calcCryptoValue(
                logDepositServiceModel.getCrypto().toString(), logDepositServiceModel.getDeposit()
        ));

        logDepositRepository.save(logDeposit);

        // END


        // CHECK IF THE USER DEPOSIT FOR FIRST TIME AND SET THE DEPOSIT VALUE IN THE WALLET
        // ELSE CREATE THE WALLET AND SET THE VALUE

        double cryptoValue =
                calcCryptoValue(logDepositServiceModel.getCrypto().toString(),
                        logDepositServiceModel.getDeposit());

        if (walletService.findUsersWallet(logDepositServiceModel.getUsernameConfirm())) {

            walletService.setValue(cryptoValue,
                    logDepositServiceModel.getCrypto().name(), logDepositServiceModel.getUsernameConfirm());

        } else {
            UserEntity currUser =
                    userRepository
                            .findByUsername(logDepositServiceModel.getUsernameConfirm()).orElse(null);

            WalletEntity walletEntity = new WalletEntity();

            walletEntity.setOwner(currUser);
            walletEntity.setUsername(logDepositServiceModel.getUsernameConfirm());

            walletRepository.save(walletEntity);

            walletService.setValue(cryptoValue,
                    logDepositServiceModel.getCrypto().name(),
                    logDepositServiceModel.getUsernameConfirm());
        }

        // END WALLET SETTING


        // UPDATE CREDIT CARD BALANCE

        CreditCardEntity cardEntity =
                creditCardRepository.findByUsernameMethod(userEntity.getUsername());

        double newBalance =
                cardEntity.getBalance().doubleValue() - logDepositServiceModel.getDeposit();

        cardEntity.setBalance(BigDecimal.valueOf(newBalance));
        creditCardRepository.save(cardEntity);

        // END


    }

    @Override
    public List<LogDepositView> getAllDepositOrderedDesc() {
        return logDepositRepository
                .findAllDepositOrderedDesc()
                .stream()
                .map(log -> modelMapper.map(log, LogDepositView.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteLowestDeposit() {
       List<LogDeposit> allOrderedAsc = logDepositRepository.lowestDeposit();

       LogDeposit logToDelete = allOrderedAsc.get(0);

       logDepositRepository.deleteById(logToDelete.getId());
    }


    protected double calcCryptoValue(String cryptoName, double depositValue) {

        CryptoCurrenciesEntity currCrypto =
                cryptoRepository.findByName(cryptoName).orElse(null);

        double result = 0;


        result = depositValue / currCrypto.getPrice();


        return result;


    }
}
