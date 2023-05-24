package com.example.cryptoworld.service.Impl;

import com.example.cryptoworld.repository.CryptoRepository;
import com.example.cryptoworld.service.PopularCryptoService;
import org.modelmapper.ModelMapper;

public class PopularCryptoServiceImpl implements PopularCryptoService {

    private final CryptoRepository cryptoRepository;
    private final ModelMapper modelMapper;


    public PopularCryptoServiceImpl(CryptoRepository cryptoRepository, ModelMapper modelMapper) {
        this.cryptoRepository = cryptoRepository;
        this.modelMapper = modelMapper;
    }
}
