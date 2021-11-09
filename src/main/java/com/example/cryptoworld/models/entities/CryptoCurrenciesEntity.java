package com.example.cryptoworld.models.entities;


import com.example.cryptoworld.models.enums.EnumCryptoTop10;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "crypto_currencies")
public class CryptoCurrenciesEntity extends BaseEntity{

    private EnumCryptoTop10 currencies;
    private double price;


    public CryptoCurrenciesEntity() {
    }


    public CryptoCurrenciesEntity(EnumCryptoTop10 currencies, double price) {
        this.currencies = currencies;
        this.price = price;
    }


    public EnumCryptoTop10 getCurrencies() {
        return currencies;
    }

    public void setCurrencies(EnumCryptoTop10 currencies) {
        this.currencies = currencies;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
