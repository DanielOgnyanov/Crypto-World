package com.example.cryptoworld.models.entities;


import com.example.cryptoworld.models.enums.EnumCryptoTop10;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "log_sell")
public class LogSell  extends BaseEntity{

    private UserEntity sellPerson;
    private double profit;
    private double cryptoToSell;
    private EnumCryptoTop10 crypto;


    public LogSell() {
    }

    @ManyToOne
    @JoinColumn(name = "deposit_person", referencedColumnName = "full_name")
    @JsonManagedReference
    public UserEntity getSellPerson() {
        return sellPerson;
    }

    public void setSellPerson(UserEntity depositPerson) {
        this.sellPerson = depositPerson;
    }

    @Column(name = "profit")
    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    @Column(name = "crypto_sell")
    public double getCryptoToSell() {
        return cryptoToSell;
    }

    public void setCryptoToSell(double cryptoToSell) {
        this.cryptoToSell = cryptoToSell;
    }

    @Column(name = "crypto_name")
    @Enumerated(EnumType.STRING)
    public EnumCryptoTop10 getCrypto() {
        return crypto;
    }

    public void setCrypto(EnumCryptoTop10 crypto) {
        this.crypto = crypto;
    }
}
