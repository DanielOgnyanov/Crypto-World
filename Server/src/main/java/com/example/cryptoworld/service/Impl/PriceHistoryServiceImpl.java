package com.example.cryptoworld.service.Impl;

import com.example.cryptoworld.repository.PriceHistoryRepository;
import com.example.cryptoworld.service.PriceHistoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceHistoryServiceImpl implements PriceHistoryService {

    private final PriceHistoryRepository priceHistoryRepository;

    public PriceHistoryServiceImpl(PriceHistoryRepository priceHistoryRepository) {
        this.priceHistoryRepository = priceHistoryRepository;
    }


    @Override
    public List<Object[]> groupedCryptoByName() {
        return priceHistoryRepository.groupedCryptoByName();
    }
}
