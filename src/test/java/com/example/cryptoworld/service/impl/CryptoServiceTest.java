package com.example.cryptoworld.service.impl;

import com.example.cryptoworld.models.entities.CryptoCurrenciesEntity;
import com.example.cryptoworld.repository.CryptoRepository;
import com.example.cryptoworld.service.Impl.CryptoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class CryptoServiceTest {

    private CryptoCurrenciesEntity cryptoCurrenciesEntity;
    private CryptoServiceImpl cryptoService;


    @Mock
    private CryptoRepository cryptoRepository;

    @BeforeEach
    public void init() {

    }


}
