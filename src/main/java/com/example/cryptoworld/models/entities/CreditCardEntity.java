package com.example.cryptoworld.models.entities;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "credit_cards")
public class CreditCardEntity extends BaseEntity{

    private String iban;
    private UserEntity owner;
    private int expirationYear;
    private BigDecimal balance;


    public CreditCardEntity() {
    }


    @Column(name = "iban", unique = true, updatable = false)
    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    @ManyToOne
    @JoinColumn(name = "owner_name", referencedColumnName = "full_name")
    public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(UserEntity owner) {
        this.owner = owner;
    }


    @Column(name = "expiration_year")
    public int getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(int expirationYear) {
        this.expirationYear = expirationYear;
    }


    @Column(name = "balance")
    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
