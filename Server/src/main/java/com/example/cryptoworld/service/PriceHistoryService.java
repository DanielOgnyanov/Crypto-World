package com.example.cryptoworld.service;


import com.example.cryptoworld.models.entities.PriceHistoryEntity;

import java.util.List;

public interface PriceHistoryService {


    List<Object[]> groupedCryptoByName();
}
