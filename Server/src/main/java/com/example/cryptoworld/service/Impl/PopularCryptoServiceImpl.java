package com.example.cryptoworld.service.Impl;

import com.example.cryptoworld.models.view.PopularCryptoViewModel;
import com.example.cryptoworld.repository.CryptoRepository;
import com.example.cryptoworld.service.PopularCryptoService;
import org.modelmapper.ModelMapper;

import java.util.List;

public class PopularCryptoServiceImpl implements PopularCryptoService {

    private final CryptoRepository cryptoRepository;
    private final ModelMapper modelMapper;


    public PopularCryptoServiceImpl(CryptoRepository cryptoRepository, ModelMapper modelMapper) {
        this.cryptoRepository = cryptoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PopularCryptoViewModel> getPopularCrypto() {
        return null;
    }
}
