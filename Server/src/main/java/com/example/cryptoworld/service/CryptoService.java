package com.example.cryptoworld.service;

import com.example.cryptoworld.models.view.CryptoTableViewModel;
import com.example.cryptoworld.models.view.CryptoViewModel;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface CryptoService {
    void InitCryptoInDb() throws IOException;

    List<CryptoViewModel> getAllCrypto();

    BigDecimal cryptoMarketCap4Hour ();

    BigDecimal calculateTheMarketDifferenceInPercentage();

    List<CryptoTableViewModel> getAllPrices();
}
