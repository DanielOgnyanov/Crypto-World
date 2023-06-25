package com.example.cryptoworld.models.entities;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "price_history")
public class PriceHistoryEntity extends BaseEntity {

    private String name;
    private List<Double> price;
    private Set<LocalDateTime> recordedAt;


    public PriceHistoryEntity() {
        price = new ArrayList<>();
        recordedAt = new HashSet<>();
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

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "crypto_recordAt", joinColumns = @JoinColumn(name = "price_history_id"))
    @Column(name = "recorded_at")
    public Set<LocalDateTime> getRecordedAt() {
        return recordedAt;
    }

    public void setRecordedAt(Set<LocalDateTime> recordedAt) {
        this.recordedAt = recordedAt;
    }
}
