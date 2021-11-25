package com.example.cryptoworld.service;

import com.example.cryptoworld.models.enums.EnumCryptoTop10;

public interface WalletService {
    boolean findUsersWallet(String usernameConfirm);

    void setValue(double cryptoValue, String crypto, String username);

    double sellValueCheck(String usernameConfirm, String cryptoName);
}
