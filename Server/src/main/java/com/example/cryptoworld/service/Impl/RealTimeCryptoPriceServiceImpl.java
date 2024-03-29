package com.example.cryptoworld.service.Impl;


import com.example.cryptoworld.config.InfoUtils;
import com.example.cryptoworld.models.entities.CryptoCurrenciesEntity;
import com.example.cryptoworld.models.entities.PriceHistoryEntity;
import com.example.cryptoworld.repository.CryptoRepository;
import com.example.cryptoworld.repository.PriceHistoryRepository;
import com.example.cryptoworld.service.RealTimeCryptoPriceService;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class RealTimeCryptoPriceServiceImpl implements RealTimeCryptoPriceService {

    private final CryptoRepository cryptoRepository;
    private final InfoUtils infoUtils;
    private final PriceHistoryRepository priceHistoryRepository;

    public RealTimeCryptoPriceServiceImpl(CryptoRepository cryptoRepository, InfoUtils infoUtils, PriceHistoryRepository priceHistoryRepository) {
        this.cryptoRepository = cryptoRepository;

        this.infoUtils = infoUtils;
        this.priceHistoryRepository = priceHistoryRepository;
    }


    @Override
    public void getRealTimePrice() throws IOException {

        //  call
        Response response = getResponse();

        // end


        // Json data

        String jsonDataAsString = response.body().string();

        JSONArray jsonArray = new JSONArray(jsonDataAsString);

        for (Object value : jsonArray) {

            JSONObject currentCryptoObject = new JSONObject(value.toString());

            String name = (String) currentCryptoObject.get("name");

            if (name.equals("Binance Coin")) {
                name = "Binance";
            }

            String assetId = (String) currentCryptoObject.get("asset_id");

            BigDecimal volume24Hour = currentCryptoObject.getBigDecimal("volume_1day_usd");

            BigDecimal price = currentCryptoObject.getBigDecimal("price_usd");


            if (cryptoRepository.count() == 10) {

                setNewPriceToCrypto(name, assetId, volume24Hour, price);
                setPriceHistoryInDataBase(name, price);

            } else if (cryptoRepository.count() >= 0 && cryptoRepository.count() < 10) {



                initCryptoInDataBase(name, assetId, volume24Hour, price);

                setPriceHistoryInDataBase(name, price);


            }


        }
    }

    private void initCryptoInDataBase(String name, String assetId, BigDecimal volume24Hour, BigDecimal price) throws IOException {

        CryptoCurrenciesEntity currenciesEntity = new CryptoCurrenciesEntity();

        currenciesEntity.setName(name);
        currenciesEntity.setAssetStringId(assetId);
        currenciesEntity.setVolumeFor24Hour(volume24Hour);
        currenciesEntity.setPrice(price.doubleValue());
        currenciesEntity.setOldPriceTrack(0);

        cryptoRepository.save(currenciesEntity);
    }

    private void setPriceHistoryInDataBase(String name, BigDecimal price) {
        PriceHistoryEntity priceHistoryEntity = priceHistoryRepository.findByName(name);

        if(priceHistoryEntity == null) {
            priceHistoryEntity = new PriceHistoryEntity();
        }


        priceHistoryEntity.setName(name);
        priceHistoryEntity.getPrice().add(price.doubleValue());
        priceHistoryEntity.getRecordedAt().add(LocalDateTime.now());

        priceHistoryRepository.save(priceHistoryEntity);
    }

    private Response getResponse() throws IOException {

        try {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url(infoUtils.getAPI_URL())
                    .addHeader(infoUtils.getAPI_NAME(), infoUtils.getPRIVATE_KEY())
                    .build();

            return client.newCall(request).execute();


        } catch (IOException e) {

            throw new IOException(e.getMessage()
                    + "Error occurred while executing the request to fetch crypto information");
        }

    }


    private void setNewPriceToCrypto(String name, String assetId, BigDecimal volume24Hour, BigDecimal price) {

        CryptoCurrenciesEntity currentEntity =
                cryptoRepository.getCryptoByAssetStringId(assetId);

        double getCurrentPrice = cryptoRepository.getCurrentPrice(name);

        currentEntity.setOldPriceTrack(getCurrentPrice);

        currentEntity.setPrice(price.doubleValue());

        currentEntity.setVolumeFor24Hour(volume24Hour);


        cryptoRepository.save(currentEntity);

    }
}
