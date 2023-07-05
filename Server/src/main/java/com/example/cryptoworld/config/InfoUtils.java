package com.example.cryptoworld.config;

import org.springframework.stereotype.Component;

@Component
public class InfoUtils {

    private  String API_URL =
            "https://rest.coinapi.io/v1/assets?filter_asset_id=BTC;ETH;BNB;USDT;SOL;XRP;ADA;USDC;DOT;DOGE";

    private String API_URL_LOGOS = "https://rest.coinapi.io/v1/assets/icons/50";

    private  String API_NAME = "X-CoinAPI-Key";

    private  String PRIVATE_KEY = "C32D27DA-45FA-4F89-9F2A-68F45DEB5A1F";


    public InfoUtils() {
    }

    public String getAPI_URL() {
        return API_URL;
    }

    public String getAPI_NAME() {
        return API_NAME;
    }

    public String getPRIVATE_KEY() {
        return PRIVATE_KEY;
    }
}
