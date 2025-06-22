package com.example.cryptoworld.models.entities;


import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "crypto_currencies")
public class CryptoCurrenciesEntity extends BaseEntity{

    private String name;
    private String assetStringId;

    private double price;
    private double oldPriceTrack;

    private String logoImage;


    public CryptoCurrenciesEntity() {
    }

    public CryptoCurrenciesEntity(String name,
                                  String assetStringId,

                                  double price,
                                  double oldPriceTrack,
                                  String logoImage) {
        this.name = name;
        this.assetStringId = assetStringId;

        this.price = price;
        this.oldPriceTrack = oldPriceTrack;
        this.logoImage = logoImage;
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



    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Column(name = "old_price_track")
    public double getOldPriceTrack() {
        return oldPriceTrack;
    }

    public void setOldPriceTrack(double oldPriceTrack) {
        this.oldPriceTrack = oldPriceTrack;
    }

    @Column(name = "logo_image")
    public String getLogoImage() {
        return logoImage;
    }

    public void setLogoImage(String logoImage) {
        this.logoImage = logoImage;
    }
}
