package com.example.cryptoworld.service.Impl;

import com.example.cryptoworld.models.entities.CryptoCurrenciesEntity;
import com.example.cryptoworld.models.enums.EnumCountry;
import com.example.cryptoworld.models.enums.EnumCryptoTop10;
import com.example.cryptoworld.repository.CryptoRepository;
import com.example.cryptoworld.service.CryptoService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CryptoServiceImpl implements CryptoService {


    private final CryptoRepository cryptoRepository;

    public CryptoServiceImpl(CryptoRepository cryptoRepository) {
        this.cryptoRepository = cryptoRepository;
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
}
