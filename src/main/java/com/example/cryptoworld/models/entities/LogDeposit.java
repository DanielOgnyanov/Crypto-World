package com.example.cryptoworld.models.entities;


import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "log_deposit")
public class LogDeposit extends BaseEntity{

    private UserEntity depositPerson;
    private BigDecimal fiatMoney;
    private BigDecimal cryptoValue;


    public LogDeposit() {
    }

    public UserEntity getDepositPerson() {
        return depositPerson;
    }

    public void setDepositPerson(UserEntity depositPerson) {
        this.depositPerson = depositPerson;
    }

    public BigDecimal getFiatMoney() {
        return fiatMoney;
    }

    public void setFiatMoney(BigDecimal fiatMoney) {
        this.fiatMoney = fiatMoney;
    }

    public BigDecimal getCryptoValue() {
        return cryptoValue;
    }

    public void setCryptoValue(BigDecimal cryptoValue) {
        this.cryptoValue = cryptoValue;
    }
}
