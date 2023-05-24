package com.example.cryptoworld.service;

import com.example.cryptoworld.models.view.PopularCryptoViewModel;

import java.util.List;

public interface PopularCryptoService {

    List<PopularCryptoViewModel> getPopularCrypto();
}
