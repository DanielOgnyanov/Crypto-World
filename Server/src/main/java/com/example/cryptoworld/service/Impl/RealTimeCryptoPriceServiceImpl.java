package com.example.cryptoworld.service.Impl;

import com.example.cryptoworld.models.entities.CryptoCurrenciesEntity;
import com.example.cryptoworld.models.entities.PriceHistoryEntity;
import com.example.cryptoworld.repository.CryptoRepository;
import com.example.cryptoworld.repository.PriceHistoryRepository;
import com.example.cryptoworld.service.RealTimeCryptoPriceService;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class RealTimeCryptoPriceServiceImpl implements RealTimeCryptoPriceService {

    private final CryptoRepository cryptoRepository;
    private final PriceHistoryRepository priceHistoryRepository;

    public RealTimeCryptoPriceServiceImpl(CryptoRepository cryptoRepository,
                                          PriceHistoryRepository priceHistoryRepository) {
        this.cryptoRepository = cryptoRepository;
        this.priceHistoryRepository = priceHistoryRepository;
    }

    @Override
    public void getRealTimePrice() throws IOException {
        // API call
        Response response = getResponse();
        String jsonDataAsString = response.body().string();
        JSONObject priceJson = new JSONObject(jsonDataAsString);

        // Manually map CoinGecko IDs to readable names and correct asset string IDs
        Map<String, String[]> cryptoMap = new HashMap<>();
        cryptoMap.put("bitcoin", new String[]{"Bitcoin", "BTC"});
        cryptoMap.put("ethereum", new String[]{"Ethereum", "ETH"});
        cryptoMap.put("binancecoin", new String[]{"Binance", "BNB"});
        cryptoMap.put("tether", new String[]{"Tether", "USDT"});
        cryptoMap.put("solana", new String[]{"Solana", "SOL"});
        cryptoMap.put("ripple", new String[]{"XRP", "XRP"});
        cryptoMap.put("cardano", new String[]{"Cardano", "ADA"});
        cryptoMap.put("usd-coin", new String[]{"USDC", "USDC"});
        cryptoMap.put("polkadot", new String[]{"Polkadot", "DOT"});
        cryptoMap.put("dogecoin", new String[]{"Dogecoin", "DOGE"});

        for (Map.Entry<String, String[]> entry : cryptoMap.entrySet()) {
            String coingeckoId = entry.getKey();
            String name = entry.getValue()[0];
            String assetStringId = entry.getValue()[1];

            BigDecimal price = priceJson.getJSONObject(coingeckoId).getBigDecimal("usd");

            if (cryptoRepository.count() == 10) {
                setNewPriceToCrypto(name, assetStringId, price);
                setPriceHistoryInDataBase(name, price);
            } else if (cryptoRepository.count() >= 0 && cryptoRepository.count() < 10) {
                initCryptoInDataBase(name, assetStringId, price);
                setPriceHistoryInDataBase(name, price);
            }
        }
    }

    private Response getResponse() throws IOException {
        OkHttpClient client = new OkHttpClient();
        String url = "https://api.coingecko.com/api/v3/simple/price?ids=bitcoin,ethereum,binancecoin,tether,solana,ripple,cardano,usd-coin,polkadot,dogecoin&vs_currencies=usd";

        Request request = new Request.Builder()
                .url(url)
                .build();

        return client.newCall(request).execute();
    }

    private void initCryptoInDataBase(String name, String assetId, BigDecimal price) {
        CryptoCurrenciesEntity entity = new CryptoCurrenciesEntity();
        entity.setName(name);
        entity.setAssetStringId(assetId);
        entity.setPrice(price.doubleValue());
        entity.setOldPriceTrack(0);
        cryptoRepository.save(entity);
    }

    private void setPriceHistoryInDataBase(String name, BigDecimal price) {
        PriceHistoryEntity priceHistory = priceHistoryRepository.findByName(name);

        if (priceHistory == null) {
            priceHistory = new PriceHistoryEntity();
        }

        priceHistory.setName(name);
        priceHistory.getPrice().add(price.doubleValue());
        priceHistory.getRecordedAt().add(LocalDateTime.now());

        priceHistoryRepository.save(priceHistory);
    }

    private void setNewPriceToCrypto(String name, String assetId, BigDecimal price) {
        CryptoCurrenciesEntity entity = cryptoRepository.getCryptoByAssetStringId(assetId);
        double currentPrice = cryptoRepository.getCurrentPrice(name);

        entity.setOldPriceTrack(currentPrice);
        entity.setPrice(price.doubleValue());

        cryptoRepository.save(entity);
    }
}
