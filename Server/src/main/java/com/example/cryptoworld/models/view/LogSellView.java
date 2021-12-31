package com.example.cryptoworld.models.view;

import com.example.cryptoworld.models.entities.UserEntity;

public class LogSellView {

    private UserEntity sellPerson;
    private String crypto;
    private double cryptoToSell;


    public LogSellView() {
    }


    public UserEntity getSellPerson() {
        return sellPerson;
    }

    public void setSellPerson(UserEntity sellPerson) {
        this.sellPerson = sellPerson;
    }

    public String getCrypto() {
        return crypto;
    }

    public void setCrypto(String crypto) {
        this.crypto = crypto;
    }

    public double getCryptoToSell() {
        return cryptoToSell;
    }

    public void setCryptoToSell(double cryptoToSell) {
        this.cryptoToSell = cryptoToSell;
    }
}
