package com.example.cryptoworld.service.Impl;

import com.example.cryptoworld.models.entities.CryptoCurrenciesEntity;
import com.example.cryptoworld.repository.CryptoRepository;
import com.example.cryptoworld.service.CryptoLogoService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CryptoLogoServiceImpl implements CryptoLogoService {

    private final CryptoRepository cryptoRepository;

    public CryptoLogoServiceImpl(CryptoRepository cryptoRepository) {
        this.cryptoRepository = cryptoRepository;
    }

    @Override
    public void initAllLogoInDb() {
        // Static logo URLs mapped by asset string ID
        Map<String, String> logoMap = new HashMap<>();
        logoMap.put("BTC", "https://s2.coinmarketcap.com/static/img/coins/64x64/1.png");
        logoMap.put("ETH", "https://s2.coinmarketcap.com/static/img/coins/64x64/1027.png");
        logoMap.put("USDT", "https://s2.coinmarketcap.com/static/img/coins/64x64/825.png");
        logoMap.put("XRP", "https://s2.coinmarketcap.com/static/img/coins/64x64/52.png");
        logoMap.put("BNB", "https://s2.coinmarketcap.com/static/img/coins/64x64/1839.png");
        logoMap.put("SOL", "https://s2.coinmarketcap.com/static/img/coins/64x64/5426.png");
        logoMap.put("ADA", "https://s2.coinmarketcap.com/static/img/coins/64x64/2010.png");
        logoMap.put("USDC", "https://s2.coinmarketcap.com/static/img/coins/64x64/3408.png");
        logoMap.put("DOGE", "https://s2.coinmarketcap.com/static/img/coins/64x64/74.png");
        logoMap.put("DOT", "https://s2.coinmarketcap.com/static/cloud/img/logo/polkadot/Polkadot_Logo_Animation_32x32.gif");

        List<CryptoCurrenciesEntity> allCryptos = cryptoRepository.findAll();

        for (CryptoCurrenciesEntity crypto : allCryptos) {
            String assetId = crypto.getAssetStringId().toUpperCase();
            if (logoMap.containsKey(assetId)) {
                crypto.setLogoImage(logoMap.get(assetId));
                cryptoRepository.save(crypto);
            }
        }
    }
}