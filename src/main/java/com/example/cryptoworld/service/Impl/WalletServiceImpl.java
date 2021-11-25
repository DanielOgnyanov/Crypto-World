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

        UserEntity userEntity = userService.findByUsername(usernameConfirm);

        return walletRepository.existsByOwner(userEntity.getFullName());
    }

    @Override
    public void setValue(double deposit, String crypto, String username) {

        UserEntity userEntity = userService.findByUsername(username);

        WalletEntity walletEntity = walletRepository.findByOwner(userEntity.getFullName());

        double oldValue = 0;


        switch (crypto){

            case "Bitcoin":
                oldValue = walletEntity.getBitcoin();


                walletEntity.setBitcoin(oldValue + deposit);

                walletRepository.save(walletEntity);
                break;

            case "Binance":

                oldValue = walletEntity.getBinance();

                walletEntity.setBinance(oldValue + deposit);

                walletRepository.save(walletEntity);

                break;

            case "Ethereum":

                oldValue = walletEntity.getEthereum();

                walletEntity.setEthereum(oldValue + deposit);

                walletRepository.save(walletEntity);

                break;

            case "Cardano":

                oldValue = walletEntity.getCardano();

                walletEntity.setCardano(oldValue + deposit);

                walletRepository.save(walletEntity);

                break;

            case "Tether":

                oldValue = walletEntity.getTether();

                walletEntity.setTether(oldValue + deposit);

                walletRepository.save(walletEntity);

                break;

            case "Solana":

                oldValue = walletEntity.getSolana();

                walletEntity.setSolana(oldValue + deposit);

                walletRepository.save(walletEntity);

                break;


            case "XRP":

                oldValue = walletEntity.getXrp();

                walletEntity.setXrp(oldValue + deposit);

                walletRepository.save(walletEntity);

                break;


            case "Polkadot":

                oldValue = walletEntity.getPolkadot();

                walletEntity.setPolkadot(oldValue + deposit);

                walletRepository.save(walletEntity);

                break;


            case "Dogecoin":

                oldValue = walletEntity.getDogecoin();

                walletEntity.setDogecoin(oldValue + deposit);

                walletRepository.save(walletEntity);

                break;


            case "Usdcoin":

                oldValue = walletEntity.getUsdcoin();

                walletEntity.setUsdcoin(oldValue + deposit);

                walletRepository.save(walletEntity);

                break;
        }
    }
}
