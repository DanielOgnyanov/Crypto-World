package com.example.cryptoworld.models.entities;


import javax.persistence.Column;
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


    @Column(name = "new_market_cap", columnDefinition = "Decimal(10,5) default '0.00000'")
    public BigDecimal getNewMarketCap() {
        return newMarketCap;
    }

    public void setNewMarketCap(BigDecimal newMarketCap) {
        this.newMarketCap = newMarketCap;
    }
    @Column(name = "old_market_cap", columnDefinition = "Decimal(10,5) default '0.00000'")
    public BigDecimal getOldMarketCap() {
        return oldMarketCap;
    }

    public void setOldMarketCap(BigDecimal oldMarketCap) {
        this.oldMarketCap = oldMarketCap;
    }
}
