package com.example.cryptoworld.service.Impl;

import com.example.cryptoworld.repository.CountryRepository;
import com.example.cryptoworld.service.CountryService;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    @Override
    public void InitCountryInDb() {

    }
}
