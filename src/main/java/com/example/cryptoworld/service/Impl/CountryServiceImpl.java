package com.example.cryptoworld.service.Impl;

import com.example.cryptoworld.models.entities.CountryEntity;
import com.example.cryptoworld.models.enums.EnumCountry;
import com.example.cryptoworld.repository.CountryRepository;
import com.example.cryptoworld.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    @Override
    public void InitCountryInDb() {

        if (countryRepository.count() == 0) {

            Arrays.stream(EnumCountry.values())
                    .forEach(countryName -> {

                        CountryEntity countryEntity = new CountryEntity(countryName);

                        countryRepository.save(countryEntity);

                    });
        }
    }

    @Override
    public CountryEntity getCountryByName(String country) {
        return countryRepository.findByName(country).orElse(null);
    }
}
