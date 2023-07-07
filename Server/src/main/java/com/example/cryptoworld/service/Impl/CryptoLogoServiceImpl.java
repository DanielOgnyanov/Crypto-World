package com.example.cryptoworld.service.Impl;

import com.example.cryptoworld.config.InfoUtils;
import com.example.cryptoworld.models.entities.CryptoCurrenciesEntity;
import com.example.cryptoworld.repository.CryptoRepository;
import com.example.cryptoworld.service.CryptoLogoService;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CryptoLogoServiceImpl implements CryptoLogoService {

    private final CryptoRepository cryptoRepository;
    private final InfoUtils infoUtils;

    public CryptoLogoServiceImpl(CryptoRepository cryptoRepository, InfoUtils infoUtils) {
        this.cryptoRepository = cryptoRepository;
        this.infoUtils = infoUtils;
    }


    @Override
    public void initAllLogoInDb() throws IOException {

        Response response = fetchCryptoLogo();


        String jsonDataAsString = response.body().string();

        JSONArray jsonArray = new JSONArray(jsonDataAsString);

        for (int i = 0; i < jsonArray.length(); i++) {

            JSONObject cryptoObject = jsonArray.getJSONObject(i);

            String assetId = cryptoObject.getString("asset_id");
            String iconUrl = cryptoObject.getString("url");

            CryptoCurrenciesEntity currentEntity = cryptoRepository.getCryptoByAssetStringId(assetId);


            if (currentEntity != null) {

                currentEntity.setLogoImage(iconUrl);
                cryptoRepository.save(currentEntity);

            }

        }

    }

    private Response fetchCryptoLogo() throws IOException {
        try {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url(infoUtils.getAPI_URL_LOGOS())
                    .addHeader(infoUtils.getAPI_NAME(), infoUtils.getPRIVATE_KEY())
                    .build();

            return client.newCall(request).execute();


        } catch (IOException e) {

            throw new IOException(e.getMessage()
                    + "Error occurred while executing the request to fetch crypto information");
        }
    }


}
