package com.example.cryptoworld.service;

import com.example.cryptoworld.models.service.SellCryptoServiceModel;
import com.example.cryptoworld.models.view.LogSellView;

import java.util.List;

public interface LogSellService {
    void sellLog(SellCryptoServiceModel sellCryptoServiceModel);

    List<LogSellView> getAllSellOrderDesc();

    void deleteLowestSell();
}
