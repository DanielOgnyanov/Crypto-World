package com.example.cryptoworld.models.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "price_history")
public class PriceHistory extends BaseEntity {

    private CryptoCurrenciesEntity cryptoCurrency;
    private Double price;
    private LocalDateTime recordedAt;

}
