package com.example.cryptoworld.service.Impl;

import com.example.cryptoworld.models.entities.UserEntity;
import com.example.cryptoworld.models.entities.WalletEntity;
import com.example.cryptoworld.models.enums.EnumCryptoTop10;
import com.example.cryptoworld.repository.WalletRepository;
import com.example.cryptoworld.service.UserService;
import com.example.cryptoworld.service.WalletService;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements WalletService {


    private final WalletRepository walletRepository;
    private final UserService userService;

    public WalletServiceImpl(WalletRepository walletRepository, UserService userService) {
        this.walletRepository = walletRepository;
        this.userService = userService;
    }


    @Override
    public boolean findUsersWallet(String usernameConfirm) {

        return walletRepository.existsByUsername(usernameConfirm);
    }

    @Override
    public void setValue(double cryptoValue, String crypto, String username) {

        WalletEntity walletEntity = walletRepository.findByUsername(username);

        double oldValue = 0;


        switch (crypto){

            case "Bitcoin":
                oldValue = walletEntity.getBitcoin();


                walletEntity.setBitcoin(oldValue + cryptoValue);

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

            case "Solana":

                oldValue = walletEntity.getSolana();

                walletEntity.setSolana(oldValue + cryptoValue);

                walletRepository.save(walletEntity);

                break;


            case "XRP":

                oldValue = walletEntity.getXrp();

                walletEntity.setXrp(oldValue + cryptoValue);

                walletRepository.save(walletEntity);

                break;


            case "Polkadot":

                oldValue = walletEntity.getPolkadot();

                walletEntity.setPolkadot(oldValue + cryptoValue);

                walletRepository.save(walletEntity);

                break;


            case "Dogecoin":

                oldValue = walletEntity.getDogecoin();

                walletEntity.setDogecoin(oldValue + cryptoValue);

                walletRepository.save(walletEntity);

                break;


            case "Usdcoin":

                oldValue = walletEntity.getUsdcoin();

                walletEntity.setUsdcoin(oldValue + cryptoValue);

                walletRepository.save(walletEntity);

                break;
        }
    }
}
