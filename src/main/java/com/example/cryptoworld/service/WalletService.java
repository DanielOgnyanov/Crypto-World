package com.example.cryptoworld.service;

import com.example.cryptoworld.models.enums.EnumCryptoTop10;

public interface WalletService {
    boolean findUsersWallet(String usernameConfirm);

    void setValue(double deposit, String crypto, String username);
}
