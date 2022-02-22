package com.example.cryptoworld.service.Impl;

import com.example.cryptoworld.models.view.WalletViewModel;
import com.example.cryptoworld.models.entities.WalletEntity;
import com.example.cryptoworld.repository.WalletRepository;
import com.example.cryptoworld.service.UserService;
import com.example.cryptoworld.service.WalletService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WalletServiceImpl implements WalletService {


    private final WalletRepository walletRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public WalletServiceImpl(WalletRepository walletRepository, UserService userService, ModelMapper modelMapper) {
        this.walletRepository = walletRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }


    @Override
    public boolean findUsersWallet(String usernameConfirm) {

        return walletRepository.existsByUsername(usernameConfirm);
    }

    @Override
    public void setValue(double cryptoValue, String crypto, String username) {

        WalletEntity walletEntity = walletRepository.findByUsername(username);

        double oldValue = 0;


        switch (crypto) {

            case "Bitcoin":
                oldValue = walletEntity.getBitcoin();

                double result = oldValue + cryptoValue;

                walletEntity.setBitcoin(result);

                walletRepository.save(walletEntity);
                break;

            case "Binance":

                oldValue = walletEntity.getBinance();

                walletEntity.setBinance(oldValue + cryptoValue);

                walletRepository.save(walletEntity);

                break;

            case "Ethereum":

                oldValue = walletEntity.getEthereum();

                walletEntity.setEthereum(oldValue + cryptoValue);

                walletRepository.save(walletEntity);

                break;

            case "Cardano":

                oldValue = walletEntity.getCardano();

                walletEntity.setCardano(oldValue + cryptoValue);

                walletRepository.save(walletEntity);

                break;

            case "Tether":

                oldValue = walletEntity.getTether();

                walletEntity.setTether(oldValue + cryptoValue);

                walletRepository.save(walletEntity);

                break;

            case "SOL":

                oldValue = walletEntity.getSolana();

                walletEntity.setSolana(oldValue + cryptoValue);

                walletRepository.save(walletEntity);

                break;


            case "Ripple":

                oldValue = walletEntity.getXrp();

                walletEntity.setXrp(oldValue + cryptoValue);

                walletRepository.save(walletEntity);

                break;


            case "Dotcoin":

                oldValue = walletEntity.getPolkadot();

                walletEntity.setPolkadot(oldValue + cryptoValue);

                walletRepository.save(walletEntity);

                break;


            case "DogeCoin":

                oldValue = walletEntity.getDogecoin();

                walletEntity.setDogecoin(oldValue + cryptoValue);

                walletRepository.save(walletEntity);

                break;


            case "USDC":

                oldValue = walletEntity.getUsdcoin();

                walletEntity.setUsdcoin(oldValue + cryptoValue);

                walletRepository.save(walletEntity);

                break;
        }
    }

    @Override
    public double sellValueCheck(String usernameConfirm, String cryptoName) {

        WalletEntity walletEntity = walletRepository.findByUsername(usernameConfirm);

        double valueToReturn = 0;
        switch (cryptoName) {
            case "Bitcoin":
                valueToReturn = walletEntity.getBitcoin();
                break;

            case "Binance":

                valueToReturn = walletEntity.getBinance();

                break;

            case "Ethereum":

                valueToReturn = walletEntity.getEthereum();

                break;

            case "Cardano":

                valueToReturn = walletEntity.getCardano();

                break;

            case "Tether":

                valueToReturn = walletEntity.getTether();

                break;

            case "SOL":

                valueToReturn = walletEntity.getSolana();

                break;


            case "Ripple":
                valueToReturn = walletEntity.getXrp();

                break;


            case "Dotcoin":

                valueToReturn = walletEntity.getPolkadot();

                break;


            case "DogeCoin":

                valueToReturn = walletEntity.getDogecoin();

                break;


            case "USDC":

                valueToReturn = walletEntity.getUsdcoin();

                break;
        }
        return valueToReturn;
    }

    @Override
    public void sell(double cryptoValue, String crypto, String username) {

        WalletEntity walletEntity = walletRepository.findByUsername(username);

        double oldValue = 0;

        switch (crypto) {

            case "Bitcoin":
                oldValue = walletEntity.getBitcoin();


                walletEntity.setBitcoin(oldValue - cryptoValue);

                walletRepository.save(walletEntity);
                break;

            case "Binance":

                oldValue = walletEntity.getBinance();

                walletEntity.setBinance(oldValue - cryptoValue);

                walletRepository.save(walletEntity);

                break;

            case "Ethereum":

                oldValue = walletEntity.getEthereum();

                walletEntity.setEthereum(oldValue - cryptoValue);

                walletRepository.save(walletEntity);

                break;

            case "Cardano":

                oldValue = walletEntity.getCardano();

                walletEntity.setCardano(oldValue - cryptoValue);

                walletRepository.save(walletEntity);

                break;

            case "Tether":

                oldValue = walletEntity.getTether();

                walletEntity.setTether(oldValue - cryptoValue);

                walletRepository.save(walletEntity);

                break;

            case "SOL":

                oldValue = walletEntity.getSolana();

                walletEntity.setSolana(oldValue - cryptoValue);

                walletRepository.save(walletEntity);

                break;


            case "Ripple":

                oldValue = walletEntity.getXrp();

                walletEntity.setXrp(oldValue - cryptoValue);

                walletRepository.save(walletEntity);

                break;


            case "Dotcoin":

                oldValue = walletEntity.getPolkadot();

                walletEntity.setPolkadot(oldValue - cryptoValue);

                walletRepository.save(walletEntity);

                break;


            case "DogeCoin":

                oldValue = walletEntity.getDogecoin();

                walletEntity.setDogecoin(oldValue - cryptoValue);

                walletRepository.save(walletEntity);

                break;


            case "USDC":

                oldValue = walletEntity.getUsdcoin();

                walletEntity.setUsdcoin(oldValue - cryptoValue);

                walletRepository.save(walletEntity);

                break;
        }

    }

    @Override
    public List<WalletViewModel> getAll() {

        String username = userService.checkUsernameOfLoggedUser();

        return walletRepository.findByUsernameMethod(username)
                .stream()
                .map(wallet -> modelMapper.map(wallet, WalletViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public WalletEntity getUserWallet(String username) {
        return walletRepository.findByUsername(username);
    }
}
