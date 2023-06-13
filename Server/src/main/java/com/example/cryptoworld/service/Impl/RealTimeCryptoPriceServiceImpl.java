package com.example.cryptoworld.service.Impl;


import com.example.cryptoworld.config.InfoUtils;
import com.example.cryptoworld.models.entities.CryptoCurrenciesEntity;
import com.example.cryptoworld.models.entities.PriceHistoryEntity;
import com.example.cryptoworld.repository.CryptoRepository;
import com.example.cryptoworld.service.RealTimeCryptoPriceService;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class RealTimeCryptoPriceServiceImpl implements RealTimeCryptoPriceService {

    private final CryptoRepository cryptoRepository;
    private final InfoUtils infoUtils;

    public RealTimeCryptoPriceServiceImpl(CryptoRepository cryptoRepository, InfoUtils infoUtils) {
        this.cryptoRepository = cryptoRepository;

        this.infoUtils = infoUtils;
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

            double oldPriceDefaultValue = 0;



            if (cryptoRepository.count() == 10) {

                setNewPriceToCrypto(name, assetId, volume24Hour, price);

            } else if (cryptoRepository.count() >= 0 && cryptoRepository.count() < 10) {

                File logo = setCryptoLogo(name);



                CryptoCurrenciesEntity currenciesEntity = new CryptoCurrenciesEntity();
                currenciesEntity.setName(name);
                currenciesEntity.setAssetStringId(assetId);
                currenciesEntity.setVolumeFor24Hour(volume24Hour);
                currenciesEntity.setPrice(price.doubleValue());
                currenciesEntity.setOldPriceTrack(oldPriceDefaultValue);
                currenciesEntity.setLogoImage(logo.toString().trim().getBytes());

                PriceHistoryEntity priceHistoryEntity = new PriceHistoryEntity();

                priceHistoryEntity.setPrice(price.doubleValue());
                priceHistoryEntity.setRecordedAt(LocalDateTime.now());


                currenciesEntity.setHistoryOfPrice(priceHistoryEntity);

                cryptoRepository.save(currenciesEntity);


                cryptoRepository.save(currenciesEntity);

            }


        }
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

    private File setCryptoLogo(String cryptoName) {

        String imagePath = "";
        File cryptoLogo = new File(imagePath);

        switch (cryptoName) {

            case "Bitcoin":
                imagePath = "src\\main\\resources\\static\\images\\logo-bitcoin.png";
                break;
            case "Ethereum":
                imagePath = "src\\main\\resources\\static\\images\\ethereum-logo.png";
                break;
            case "Cardano":
                imagePath = "src\\main\\resources\\static\\images\\cardano-logo.png";
                break;
            case "Tether":
                imagePath = "src\\main\\resources\\static\\images\\tether-logo.png";
                break;
            case "SOL":
                imagePath = "src\\main\\resources\\static\\images\\solana-logo.png";
                break;
            case "Ripple":
                imagePath = "src\\main\\resources\\static\\images\\xrp-logo.png";
                break;
            case "DogeCoin":
                imagePath = "src\\main\\resources\\static\\images\\dogecoin-logo.png";
                break;
            case "Dotcoin":
                imagePath = "src\\main\\resources\\static\\images\\dotcoin-logo.png";
                break;
            case "USDC":
                imagePath = "src\\main\\resources\\static\\images\\usdc-logo.png";
                break;


        }

        return cryptoLogo;

    }

    private void setNewPriceToCrypto(String name, String assetId, BigDecimal volume24Hour, BigDecimal price) {

        CryptoCurrenciesEntity curr =
                cryptoRepository.getCryptoByAssetStringId(assetId);

        double getCurrentPrice = cryptoRepository.getCurrentPrice(name);

        curr.setOldPriceTrack(getCurrentPrice);

        curr.setPrice(price.doubleValue());

        curr.setVolumeFor24Hour(volume24Hour);

        curr.getHistoryOfPrice().add(price.doubleValue());


        cryptoRepository.save(curr);

    }
}
