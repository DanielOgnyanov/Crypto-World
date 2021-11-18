package com.example.cryptoworld.service;

import com.example.cryptoworld.models.entities.CountryEntity;

public interface CountryService {
    void InitCountryInDb();

    CountryEntity getCountryByName(String country);
}
