package com.example.cryptoworld.models.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "price_history")
public class PriceHistoryEntity extends BaseEntity {

    private CryptoCurrenciesEntity cryptoCurrency;
    private Double price;
    private LocalDateTime recordedAt;


    public PriceHistoryEntity() {
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "crypto_currency_name" , referencedColumnName = "name")
    public CryptoCurrenciesEntity getCryptoCurrency() {
        return cryptoCurrency;
    }

    public void setCryptoCurrency(CryptoCurrenciesEntity cryptoCurrency) {
        this.cryptoCurrency = cryptoCurrency;
    }

    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Column(name = "recorded_at")
    public LocalDateTime getRecordedAt() {
        return recordedAt;
    }

    public void setRecordedAt(LocalDateTime recordedAt) {
        this.recordedAt = recordedAt;
    }
}
