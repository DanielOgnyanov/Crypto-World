package com.example.cryptoworld.service;

import com.example.cryptoworld.models.entities.WalletEntity;
import com.example.cryptoworld.models.view.WalletViewModel;

import java.util.List;

public interface WalletService {
    boolean findUsersWallet(String usernameConfirm);

    void setValue(double cryptoValue, String crypto, String username);

    double sellValueCheck(String usernameConfirm, String cryptoName);

    void sell(double cryptoValue, String crypto, String username);

    List<WalletViewModel> getAll();

    WalletEntity getUserWallet(String username);
}
