package com.example.cryptoworld.service.impl;

import com.example.cryptoworld.models.entities.CryptoCurrenciesEntity;
import com.example.cryptoworld.models.enums.EnumCryptoTop10;
import com.example.cryptoworld.repository.CryptoRepository;
import com.example.cryptoworld.service.CryptoService;
import com.example.cryptoworld.service.Impl.CryptoServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;


@ExtendWith(MockitoExtension.class)
public class CryptoServiceTest {

    private CryptoCurrenciesEntity cryptoCurrenciesEntity;
    private CryptoServiceImpl cryptoService;


    @Mock
    private CryptoRepository cryptoRepository;

    @BeforeEach
    public void init() {

        this.cryptoCurrenciesEntity = new CryptoCurrenciesEntity();
        this.cryptoCurrenciesEntity.setCurrencies(EnumCryptoTop10.Bitcoin);
        this.cryptoCurrenciesEntity.setPrice(66000);

        this.cryptoRepository = Mockito.mock(CryptoRepository.class);
    }



    @Test
    public void testInitCryptoInDb() {

        Mockito.when(cryptoRepository.findAll()).thenReturn(List.of(this.cryptoCurrenciesEntity));

        CryptoService cryptoService = new CryptoServiceImpl(this.cryptoRepository, new ModelMapper());


        cryptoService.InitCryptoInDb();


        Assertions.assertEquals(1, this.cryptoRepository.findAll().size());
    }


}
