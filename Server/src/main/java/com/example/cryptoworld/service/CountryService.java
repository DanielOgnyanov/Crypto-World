package com.example.cryptoworld.service;

import com.example.cryptoworld.models.entities.CountryEntity;
import com.example.cryptoworld.models.enums.EnumCountry;

public interface CountryService {
    void InitCountryInDb();

    CountryEntity getCountryByName(EnumCountry country);
}
