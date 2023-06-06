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
import java.math.RoundingMode;
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

        BigDecimal marketCapAllCrypto4Hour = cryptoRepository.cryptoMarketCap4Hour();


        return marketCapAllCrypto4Hour;
    }

    @Override
    public BigDecimal calculateTheMarketDifferenceInPercentage() {

        BigDecimal allMarketCap = cryptoRepository.cryptoMarketCap4Hour();

        BigDecimal oldMarketCapValue = BigDecimal.valueOf(0);

        AllMarketCap4HourEntity allMarketCap4HourEntity = new AllMarketCap4HourEntity();


        BigDecimal checkValue = marketCapRepository.findNewMarketCap();

        if (checkValue == null) {

            allMarketCap4HourEntity.setNewMarketCap(allMarketCap);
            allMarketCap4HourEntity.setOldMarketCap(oldMarketCapValue);

        } else {
            // Here i find the new value to set it as old value market cap and update the new value.

            BigDecimal findNewMarketCapValue = marketCapRepository.findNewMarketCap();

            allMarketCap4HourEntity.setOldMarketCap(findNewMarketCapValue);

            allMarketCap = cryptoRepository.cryptoMarketCap4Hour();
            allMarketCap4HourEntity.setNewMarketCap(allMarketCap);

        }

        marketCapRepository.save(allMarketCap4HourEntity);


        BigDecimal percentageDifference = BigDecimal.ZERO;

        BigDecimal findOldMarketCap = marketCapRepository.findOldMarketCap();

        BigDecimal findNewMarketCap = marketCapRepository.findNewMarketCap();

        if (findOldMarketCap.compareTo(BigDecimal.ZERO) != 0) {

            BigDecimal difference = findNewMarketCap.subtract(findOldMarketCap);

            percentageDifference = difference.divide(findOldMarketCap, 6, RoundingMode.HALF_UP)
                    .multiply(BigDecimal.valueOf(100));

        }


        return percentageDifference;
    }
}
