package com.example.cryptoworld.service.Impl;

import com.example.cryptoworld.models.view.CryptoViewModel;
import com.example.cryptoworld.repository.CryptoRepository;
import com.example.cryptoworld.service.CryptoService;
import com.example.cryptoworld.service.RealTimeCryptoPriceService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CryptoServiceImpl implements CryptoService {


    private final CryptoRepository cryptoRepository;
    private final ModelMapper modelMapper;
    private final RealTimeCryptoPriceService realTimeCryptoPriceService;

    public CryptoServiceImpl(CryptoRepository cryptoRepository, ModelMapper modelMapper, RealTimeCryptoPriceService realTimeCryptoPriceService) {
        this.cryptoRepository = cryptoRepository;
        this.modelMapper = modelMapper;
        this.realTimeCryptoPriceService = realTimeCryptoPriceService;
    }


    @Override
    public void InitCryptoInDb() throws IOException {


        realTimeCryptoPriceService.getRealTimePrice();


    }

    @Override
    public List<CryptoViewModel> getAllCrypto() {
        return cryptoRepository.findAll()
                .stream()
                .map(crypto -> modelMapper.map(crypto, CryptoViewModel.class))
                .collect(Collectors.toList());
    }
}
