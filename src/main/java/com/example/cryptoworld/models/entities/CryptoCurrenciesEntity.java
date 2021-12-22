package com.example.cryptoworld.models.entities;


import com.example.cryptoworld.models.enums.EnumCryptoTop10;

import javax.persistence.*;

@Entity
@Table(name = "crypto_currencies")
public class CryptoCurrenciesEntity extends BaseEntity{

    private EnumCryptoTop10 name;
    private String assetStringId;
    private double price;


    public CryptoCurrenciesEntity() {
    }

    public CryptoCurrenciesEntity(EnumCryptoTop10 name, String assetStringId, double price) {
        this.name = name;
        this.assetStringId = assetStringId;
        this.price = price;
    }

    public CryptoCurrenciesEntity(EnumCryptoTop10 currencies, double price) {
        this.name = currencies;
        this.price = price;
    }

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    public EnumCryptoTop10 getName() {
        return name;
    }

    public void setName(EnumCryptoTop10 currencies) {
        this.name = currencies;
    }

    @Column(name = "asset_string_id")
    public String getAssetStringId() {
        return assetStringId;
    }

    public void setAssetStringId(String assetStringId) {
        this.assetStringId = assetStringId;
    }

    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
