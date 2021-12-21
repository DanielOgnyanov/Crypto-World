package com.example.cryptoworld.models.entities;


import com.example.cryptoworld.models.enums.EnumCryptoTop10;

import javax.persistence.*;

@Entity
@Table(name = "crypto_currencies")
public class CryptoCurrenciesEntity extends BaseEntity{

    private EnumCryptoTop10 name;
    private double price;


    public CryptoCurrenciesEntity() {
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

    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
