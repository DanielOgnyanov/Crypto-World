package com.example.cryptoworld.service.Impl;


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

            BigDecimal price = currentCryptoObject.getBigDecimal("price_usd");
        }
    }
}
