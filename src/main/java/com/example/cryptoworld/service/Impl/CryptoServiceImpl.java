package com.example.cryptoworld.service.Impl;

import com.example.cryptoworld.repository.CryptoRepository;
import com.example.cryptoworld.service.CryptoService;
import org.springframework.stereotype.Service;

@Service
public class CryptoServiceImpl implements CryptoService {


    private final CryptoRepository cryptoRepository;

    public CryptoServiceImpl(CryptoRepository cryptoRepository) {
        this.cryptoRepository = cryptoRepository;
    }


    @Override
    public void InitCryptoInDb() {

    }
}
