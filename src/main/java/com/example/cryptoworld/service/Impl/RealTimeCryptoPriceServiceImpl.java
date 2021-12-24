package com.example.cryptoworld.service.Impl;


import com.example.cryptoworld.models.entities.CryptoCurrenciesEntity;
import com.example.cryptoworld.repository.CryptoRepository;
import com.example.cryptoworld.service.RealTimeCryptoPriceService;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;

@Service
public class RealTimeCryptoPriceServiceImpl implements RealTimeCryptoPriceService {

    private final CryptoRepository cryptoRepository;

    public RealTimeCryptoPriceServiceImpl(CryptoRepository cryptoRepository) {
        this.cryptoRepository = cryptoRepository;
    }

    @Override
    public void getRealTimePrice() throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://rest.coinapi.io/v1/assets?filter_asset_id=BTC;ETH;BNB;USDT;SOL;XRP;ADA;USDC;DOT;DOGE")
                .addHeader("X-CoinAPI-Key", "C32D27DA-45FA-4F89-9F2A-68F45DEB5A1F")
                .build();

        Response response = client.newCall(request).execute();

        String jsonDataAsString = response.body().string();

        JSONArray jsonArray = new JSONArray(jsonDataAsString);

        for (Object value : jsonArray) {

            JSONObject currentCryptoObject =  new JSONObject(value.toString());

            String name = (String) currentCryptoObject.get("name");

            String assetId = (String) currentCryptoObject.get("asset_id");

            BigDecimal volume24Hour = currentCryptoObject.getBigDecimal("volume_1day_usd");

            BigDecimal price = currentCryptoObject.getBigDecimal("price_usd");

            if (cryptoRepository.count() == 10) {

                setNewPriceToCrypto(name,assetId,volume24Hour ,price);

            } else {

                CryptoCurrenciesEntity currenciesEntity =
                        new CryptoCurrenciesEntity(name,assetId,volume24Hour,price.doubleValue());

                cryptoRepository.save(currenciesEntity);

            }



        }
    }

    private void setNewPriceToCrypto(String name, String assetId,BigDecimal volume24Hour, BigDecimal price) {

        CryptoCurrenciesEntity curr =
                cryptoRepository.getCryptoByAssetStringId(assetId);

        curr.setPrice(price.doubleValue());

        cryptoRepository.save(curr);

    }
}
