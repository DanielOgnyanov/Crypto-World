package com.example.cryptoworld.service.impl;

import com.example.cryptoworld.models.entities.CountryEntity;
import com.example.cryptoworld.models.enums.EnumCountry;
import com.example.cryptoworld.repository.CountryRepository;
import com.example.cryptoworld.service.Impl.CountryServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CountryServiceImplTest {

    private CountryEntity countryEntity;
    private CountryServiceImpl serviceCountry;


    @Mock
    CountryRepository mockCountryRepo;


    @BeforeEach

    public void init() {
       serviceCountry = new CountryServiceImpl(mockCountryRepo);
    }


    @Test
    public void testSize() {

        countryEntity = new CountryEntity();

        countryEntity.setName(EnumCountry.Bulgaria);

        Assertions.assertEquals("Bulgaria", countryEntity.getName().name());

    }

}
