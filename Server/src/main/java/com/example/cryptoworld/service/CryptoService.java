package com.example.cryptoworld.service;

import com.example.cryptoworld.models.view.CryptoViewModel;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface CryptoService {
    void InitCryptoInDb() throws IOException;

    List<CryptoViewModel> getAllCrypto();

    BigDecimal cryptoMarketCap4Hour ();

    double calculateTheMarketDifferenceInPercentage();
}
