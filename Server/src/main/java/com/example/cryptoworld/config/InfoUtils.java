package com.example.cryptoworld.config;

import org.springframework.stereotype.Component;

@Component
public class InfoUtils {

    private  String apiUrl =
            "https://rest.coinapi.io/v1/assets?filter_asset_id=BTC;ETH;BNB;USDT;SOL;XRP;ADA;USDC;DOT;DOGE";

    private  String apiName = "X-CoinAPI-Key";

    private  String privateKey = "C32D27DA-45FA-4F89-9F2A-68F45DEB5A1F";


    public InfoUtils() {
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public String getApiName() {
        return apiName;
    }

    public String getPrivateKey() {
        return privateKey;
    }
}
