package com.example.cryptoworld.models.entities;


import com.example.cryptoworld.models.enums.EnumCryptoTop10;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "log_deposit")
public class LogDeposit extends BaseEntity{

    private UserEntity depositPerson;
    private double fiatMoney;
    private double cryptoValue;
    private EnumCryptoTop10 crypto;


    public LogDeposit() {
    }

    @ManyToOne
    @JoinColumn(name = "deposit_person", referencedColumnName = "full_name")
    public UserEntity getDepositPerson() {
        return depositPerson;
    }

    public void setDepositPerson(UserEntity depositPerson) {
        this.depositPerson = depositPerson;
    }

    @Column(name = "fiat_money")
    public double getFiatMoney() {
        return fiatMoney;
    }

    public void setFiatMoney(double fiatMoney) {
        this.fiatMoney = fiatMoney;
    }

    @Column(name = "crypto_value")
    public double getCryptoValue() {
        return cryptoValue;
    }

    public void setCryptoValue(double cryptoValue) {
        this.cryptoValue = cryptoValue;
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
