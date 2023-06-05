package com.example.cryptoworld.models.entities;


import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "all_market_cap_4_hour")
public class AllMarketCap4HourEntity extends BaseEntity{

    private BigDecimal newMarketCap;
    private BigDecimal oldMarketCap;


    public AllMarketCap4HourEntity(BigDecimal newMarketCap, BigDecimal oldMarketCap) {
        this.newMarketCap = newMarketCap;
        this.oldMarketCap = oldMarketCap;
    }
}
