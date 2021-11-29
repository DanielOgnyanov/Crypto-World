package com.example.cryptoworld.service.Impl;

import com.example.cryptoworld.models.entities.CryptoCurrenciesEntity;
import com.example.cryptoworld.models.enums.EnumCryptoTop10;
import com.example.cryptoworld.models.view.CryptoViewModel;
import com.example.cryptoworld.repository.CryptoRepository;
import com.example.cryptoworld.service.CryptoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CryptoServiceImpl implements CryptoService {


    private final CryptoRepository cryptoRepository;
    private final ModelMapper modelMapper;

    public CryptoServiceImpl(CryptoRepository cryptoRepository, ModelMapper modelMapper) {
        this.cryptoRepository = cryptoRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void InitCryptoInDb() {

        if (cryptoRepository.count() == 0) {

            Arrays.stream(EnumCryptoTop10.values())
                    .forEach(currentValue -> {

                        CryptoCurrenciesEntity currCrypto =
                                new CryptoCurrenciesEntity(currentValue, currentValue.getPrice());

                        cryptoRepository.save(currCrypto);


                    });


        }
    }

    @Override
    public List<CryptoViewModel> getAllCrypto() {
        return cryptoRepository.findAll()
                .stream()
                .map(crypto -> modelMapper.map(crypto, CryptoViewModel.class))
                .collect(Collectors.toList());
    }
}
