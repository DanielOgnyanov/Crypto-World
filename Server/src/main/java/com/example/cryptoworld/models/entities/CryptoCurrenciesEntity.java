package com.example.cryptoworld.models.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Blob;
import java.util.List;

@Entity
@Table(name = "crypto_currencies")
public class CryptoCurrenciesEntity extends BaseEntity{

    private String name;
    private String assetStringId;
    private BigDecimal volumeFor24Hour;
    private double price;
    private double oldPriceTrack;
    private List<Double> historyOfPrice;
    private byte[] logoImage;


    public CryptoCurrenciesEntity() {
    }

    public CryptoCurrenciesEntity(String name, String assetStringId,
                                  BigDecimal volumeFor24Hour, double price,
                                  double oldPriceTrack, byte[] logoImage) {
        this.name = name;
        this.assetStringId = assetStringId;
        this.volumeFor24Hour = volumeFor24Hour;
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

    @Column(name = "volume_for_24_hour", columnDefinition = "Decimal(30,2)")
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

    @Column(name = "old_price_track")
    public double getOldPriceTrack() {
        return oldPriceTrack;
    }

    public void setOldPriceTrack(double oldPriceTrack) {
        this.oldPriceTrack = oldPriceTrack;
    }


    @Column(name = "history_of_price")
    public List<Double> getHistoryOfPrice() {
        return historyOfPrice;
    }

    public void setHistoryOfPrice(List<Double> historyOfPrice) {
        this.historyOfPrice = historyOfPrice;
    }

    @Column(name = "logo_image")
    public byte[] getLogoImage() {
        return logoImage;
    }

    public void setLogoImage(byte[] logoImage) {
        this.logoImage = logoImage;
    }
}
