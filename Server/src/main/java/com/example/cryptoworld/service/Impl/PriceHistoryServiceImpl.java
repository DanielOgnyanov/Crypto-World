package com.example.cryptoworld.service.Impl;

import com.example.cryptoworld.repository.PriceHistoryRepository;
import com.example.cryptoworld.service.PriceHistoryService;

import java.util.List;

public class PriceHistoryServiceImpl implements PriceHistoryService {

    private final PriceHistoryRepository priceHistoryRepository;
    private final PriceHistoryService priceHistoryService;

    public PriceHistoryServiceImpl(PriceHistoryRepository priceHistoryRepository, PriceHistoryService priceHistoryService) {
        this.priceHistoryRepository = priceHistoryRepository;
        this.priceHistoryService = priceHistoryService;
    }


    @Override
    public List<Object[]> groupedCryptoByName() {
        return priceHistoryRepository.groupedCryptoByName();
    }
}
