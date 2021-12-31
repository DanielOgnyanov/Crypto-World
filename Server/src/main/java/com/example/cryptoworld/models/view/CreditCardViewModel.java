package com.example.cryptoworld.models.view;

import com.example.cryptoworld.models.entities.UserEntity;

public class CreditCardViewModel {

    private UserEntity owner;
    private int expirationYear;
    private double balance;
    private String typeCard;

    public CreditCardViewModel() {
    }

    public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(UserEntity owner) {
        this.owner = owner;
    }

    public int getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(int expirationYear) {
        this.expirationYear = expirationYear;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getTypeCard() {
        return typeCard;
    }

    public void setTypeCard(String typeCard) {
        this.typeCard = typeCard;
    }
}
