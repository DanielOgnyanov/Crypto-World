package com.example.cryptoworld.models.entities;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "log_deposit")
public class LogDeposit extends BaseEntity{

    private UserEntity depositPerson;
    private BigDecimal fiatMoney;
    private BigDecimal cryptoValue;


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
    public BigDecimal getFiatMoney() {
        return fiatMoney;
    }

    public void setFiatMoney(BigDecimal fiatMoney) {
        this.fiatMoney = fiatMoney;
    }
    @Column(name = "crypto_value")
    public BigDecimal getCryptoValue() {
        return cryptoValue;
    }

    public void setCryptoValue(BigDecimal cryptoValue) {
        this.cryptoValue = cryptoValue;
    }
}
