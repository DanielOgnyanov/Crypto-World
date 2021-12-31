package com.example.cryptoworld.models.view;

import com.example.cryptoworld.models.entities.UserEntity;

public class UserByCardBalanceView {

    private UserEntity owner;
    private double balance;


    public UserByCardBalanceView() {
    }


    public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(UserEntity owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
