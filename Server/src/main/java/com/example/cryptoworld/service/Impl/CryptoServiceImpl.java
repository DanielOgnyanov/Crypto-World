package com.example.cryptoworld.service.Impl;

import com.example.cryptoworld.models.entities.AllMarketCap4HourEntity;
import com.example.cryptoworld.models.view.CryptoViewModel;
import com.example.cryptoworld.repository.CryptoRepository;
import com.example.cryptoworld.repository.MarketCapRepository;
import com.example.cryptoworld.service.CryptoService;
import com.example.cryptoworld.service.RealTimeCryptoPriceService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CryptoServiceImpl implements CryptoService {


    private final CryptoRepository cryptoRepository;
    private final MarketCapRepository marketCapRepository;
    private final ModelMapper modelMapper;
    private final RealTimeCryptoPriceService realTimeCryptoPriceService;

    public CryptoServiceImpl(CryptoRepository cryptoRepository, MarketCapRepository marketCapRepository, ModelMapper modelMapper, RealTimeCryptoPriceService realTimeCryptoPriceService) {
        this.cryptoRepository = cryptoRepository;
        this.marketCapRepository = marketCapRepository;
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

    @Override
    public BigDecimal cryptoMarketCap4Hour() {

        BigDecimal marketCapAllCrypto4Hour = cryptoRepository.cryptoMarketCap24Hour();
        int counterFirstInsert = 0;
        BigDecimal oldMarketCapValue = BigDecimal.valueOf(0);

        AllMarketCap4HourEntity allMarketCap4HourEntity = new AllMarketCap4HourEntity();



        if (counterFirstInsert == 0) {

            allMarketCap4HourEntity.setNewMarketCap(marketCapAllCrypto4Hour);
            marketCapRepository.save(allMarketCap4HourEntity);
        }






        return marketCapAllCrypto4Hour;
    }
}
