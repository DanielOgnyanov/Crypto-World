package com.example.cryptoworld.models.service;

import com.example.cryptoworld.models.enums.EnumCard;

import java.math.BigDecimal;

public class AddCreditCardServiceModel {

    private BigDecimal balance;
    private String expirationDate;
    private String Iban;
    private EnumCard typeCard;


    public AddCreditCardServiceModel() {
    }


    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getIban() {
        return Iban;
    }

    public void setIban(String iban) {
        Iban = iban;
    }

    public EnumCard getTypeCard() {
        return typeCard;
    }

    public void setTypeCard(EnumCard typeCard) {
        this.typeCard = typeCard;
    }
}
