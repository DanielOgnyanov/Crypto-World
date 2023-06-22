package com.example.cryptoworld.models.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "price_history")
public class PriceHistoryEntity extends BaseEntity {

    private String name;
    private List<Double> price;
    private List<LocalDateTime> recordedAt;


    public PriceHistoryEntity() {
        price = new ArrayList<>();
        recordedAt = new ArrayList<>();
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "crypto_prices", joinColumns = @JoinColumn(name = "price_history_id"))
    @Column(name = "price")
    public List<Double> getPrice() {
        return price;
    }

    public void setPrice(List<Double> price) {
        this.price = price;
    }

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "crypto_recordAt", joinColumns = @JoinColumn(name = "price_history_id"))
    @Column(name = "recorded_at")
    public List<LocalDateTime> getRecordedAt() {
        return recordedAt;
    }

    public void setRecordedAt(List<LocalDateTime> recordedAt) {
        this.recordedAt = recordedAt;
    }
}
