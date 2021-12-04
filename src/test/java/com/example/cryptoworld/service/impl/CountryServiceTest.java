package com.example.cryptoworld.service.impl;

import com.example.cryptoworld.models.entities.CountryEntity;
import com.example.cryptoworld.models.enums.EnumCountry;
import com.example.cryptoworld.repository.CountryRepository;
import com.example.cryptoworld.service.CountryService;
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
public class CountryServiceTest {

    private CountryEntity countryEntity;
    private CountryServiceImpl serviceCountry;


    @Mock
    private CountryRepository mockCountryRepo;


    @BeforeEach
    public void init() {

        this.countryEntity = new CountryEntity();
        this.countryEntity.setName(EnumCountry.Bulgaria);

        this.mockCountryRepo = Mockito.mock(CountryRepository.class);


    }

    @Test
    public void testGetCountryByName() {


        Mockito.when(mockCountryRepo.findByName(EnumCountry.Bulgaria)).thenReturn(Optional.of(this.countryEntity));

        CountryService countryService = new CountryServiceImpl(this.mockCountryRepo);

        CountryEntity expected = this.countryEntity;

        CountryEntity actual = countryService.getCountryByName(EnumCountry.Bulgaria);


        Assertions.assertEquals(expected.getName().name(), actual.getName().name());

    }


    @Test
    public void testInitCountryInDb() {

        Mockito.when(mockCountryRepo.findAll()).thenReturn(List.of(this.countryEntity));

        CountryService countryService = new CountryServiceImpl(this.mockCountryRepo);


        countryService.InitCountryInDb();


        Assertions.assertEquals(1, this.mockCountryRepo.findAll().size());


    }


}
