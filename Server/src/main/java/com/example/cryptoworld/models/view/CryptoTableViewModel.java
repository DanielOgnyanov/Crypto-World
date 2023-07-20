package com.example.cryptoworld.models.view;

import java.math.BigDecimal;

public class CryptoTableViewModel {

    private Long id;
    private String name;
    private BigDecimal volumeFor24Hour;
    private double price;
    private double oldPriceTrack;
    private String logoImage;


    public CryptoTableViewModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getVolumeFor24Hour() {
        return volumeFor24Hour;
    }

    public void setVolumeFor24Hour(BigDecimal volumeFor24Hour) {
        this.volumeFor24Hour = volumeFor24Hour;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getOldPriceTrack() {
        return oldPriceTrack;
    }

    public void setOldPriceTrack(double oldPriceTrack) {
        this.oldPriceTrack = oldPriceTrack;
    }

    public String getLogoImage() {
        return logoImage;
    }

    public void setLogoImage(String logoImage) {
        this.logoImage = logoImage;
    }
}
