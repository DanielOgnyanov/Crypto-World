package com.example.cryptoworld.service.Impl;

import com.example.cryptoworld.config.InfoUtils;
import com.example.cryptoworld.repository.CryptoRepository;
import com.example.cryptoworld.service.CryptoLogoService;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class CryptoLogoServiceImpl implements CryptoLogoService {

    private final CryptoRepository cryptoRepository;
    private final InfoUtils infoUtils;

    public CryptoLogoServiceImpl(CryptoRepository cryptoRepository, InfoUtils infoUtils) throws IOException {
        this.cryptoRepository = cryptoRepository;
        this.infoUtils = infoUtils;
    }




    private Response fetchCryptoLogo() throws IOException {
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


}
