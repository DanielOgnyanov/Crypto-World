package com.example.cryptoworld.models.enums;

import java.math.BigDecimal;

public enum EnumCryptoTop10 {

    Bitcoin(66000),
    Ethereum(4700),
    Binance(642),
    Cardano(2.28),
    Tether(1),
    Solana(240),
    XRP(1.26),
    Polkadot(51),
    Dogecoin(0.27),
    usdcoin(1);


    private double price;

    EnumCryptoTop10(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
