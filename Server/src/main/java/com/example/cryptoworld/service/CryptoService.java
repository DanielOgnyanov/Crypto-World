package com.example.cryptoworld.service;

import com.example.cryptoworld.models.view.CryptoViewModel;

import java.io.IOException;
import java.util.List;

public interface CryptoService {
    void InitCryptoInDb() throws IOException;

    List<CryptoViewModel> getAllCrypto();

    double cryptoMarketCap24Hour ();
}
