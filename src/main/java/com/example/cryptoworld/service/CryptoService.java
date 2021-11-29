package com.example.cryptoworld.service;

import com.example.cryptoworld.models.view.CryptoViewModel;

import java.util.List;

public interface CryptoService {
    void InitCryptoInDb();

    List<CryptoViewModel> getAllCrypto();
}
