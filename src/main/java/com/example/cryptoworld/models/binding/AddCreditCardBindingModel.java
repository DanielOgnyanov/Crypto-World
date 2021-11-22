package com.example.cryptoworld.models.binding;

import java.math.BigDecimal;

public class AddCreditCardBindingModel {

    private BigDecimal balance;
    private int expirationYear;
    private String Iban;


    public AddCreditCardBindingModel() {
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public int getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(int expirationYear) {
        this.expirationYear = expirationYear;
    }

    public String getIban() {
        return Iban;
    }

    public void setIban(String iban) {
        Iban = iban;
    }
}
