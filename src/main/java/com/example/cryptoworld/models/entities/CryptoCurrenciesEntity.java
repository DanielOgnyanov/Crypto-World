package com.example.cryptoworld.models.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "crypto_currencies")
public class CryptoCurrenciesEntity extends BaseEntity{

    private String name;
    private String assetStringId;
    private BigDecimal volumeFor24Hour;
    private double price;


    public CryptoCurrenciesEntity() {
    }

    public CryptoCurrenciesEntity(String name, String assetStringId, BigDecimal volumeFor24Hour, double price) {
        this.name = name;
        this.assetStringId = assetStringId;
        this.volumeFor24Hour = volumeFor24Hour;
        this.price = price;
    }

    public CryptoCurrenciesEntity(String currencies, double price) {
        this.name = currencies;
        this.price = price;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String currencies) {
        this.name = currencies;
    }

    @Column(name = "asset_string_id")
    public String getAssetStringId() {
        return assetStringId;
    }

    public void setAssetStringId(String assetStringId) {
        this.assetStringId = assetStringId;
    }

    @Column(name = "volume_for_24_hour")
    public BigDecimal getVolumeFor24Hour() {
        return volumeFor24Hour;
    }

    public void setVolumeFor24Hour(BigDecimal volumeFor24Hour) {
        this.volumeFor24Hour = volumeFor24Hour;
    }

    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
