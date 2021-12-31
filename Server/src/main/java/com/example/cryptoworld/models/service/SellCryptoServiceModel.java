package com.example.cryptoworld.models.service;

import com.example.cryptoworld.models.enums.EnumCryptoTop10;

public class SellCryptoServiceModel {

    private String usernameConfirm;
    private double sellValue;
    private EnumCryptoTop10 crypto;


    public SellCryptoServiceModel() {
    }


    public String getUsernameConfirm() {
        return usernameConfirm;
    }

    public void setUsernameConfirm(String usernameConfirm) {
        this.usernameConfirm = usernameConfirm;
    }

    public double getSellValue() {
        return sellValue;
    }

    public void setSellValue(double sellValue) {
        this.sellValue = sellValue;
    }

    public EnumCryptoTop10 getCrypto() {
        return crypto;
    }

    public void setCrypto(EnumCryptoTop10 crypto) {
        this.crypto = crypto;
    }
}
