package com.example.cryptoworld.models.view;

public class UserByCardBalanceView {

    private String owner;
    private double balance;


    public UserByCardBalanceView() {
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
