package com.example.cryptoworld.models.view;

import com.example.cryptoworld.models.entities.UserEntity;

public class LogDepositView {

    private UserEntity depositPerson;
    private String crypto;
    private double cryptoValue;


    public LogDepositView() {
    }

    public UserEntity getDepositPerson() {
        return depositPerson;
    }

    public void setDepositPerson(UserEntity depositPerson) {
        this.depositPerson = depositPerson;
    }

    public String getCrypto() {
        return crypto;
    }

    public void setCrypto(String crypto) {
        this.crypto = crypto;
    }

    public double getCryptoValue() {
        return cryptoValue;
    }

    public void setCryptoValue(double cryptoValue) {
        this.cryptoValue = cryptoValue;
    }
}
