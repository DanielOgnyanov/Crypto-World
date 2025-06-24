package com.example.cryptoworld.models.entities;


import com.example.cryptoworld.models.enums.EnumCard;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "credit_cards")
public class CreditCardEntity extends BaseEntity{

    private String iban;
    private UserEntity owner;
    private int expirationDate;
    private BigDecimal balance;
    private EnumCard typeCard;


    public CreditCardEntity() {
    }


    @Column(name = "iban")
    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    @ManyToOne
    @JoinColumn(name = "user_id") // or whatever your join column is
    @JsonBackReference
    public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(UserEntity owner) {
        this.owner = owner;
    }


    @Column(name = "expiration_date")
    public int getExpirationYear() {
        return expirationDate;
    }

    public void setExpirationYear(int expirationYear) {
        this.expirationDate = expirationYear;
    }


    @Column(name = "balance")
    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Column(name = "type_card")
    @Enumerated(EnumType.STRING)
    public EnumCard getTypeCard() {
        return typeCard;
    }

    public void setTypeCard(EnumCard typeCard) {
        this.typeCard = typeCard;
    }
}
