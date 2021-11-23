package com.example.cryptoworld.models.service;

import com.example.cryptoworld.models.enums.EnumCryptoTop10;

import java.math.BigDecimal;

public class LogDepositServiceModel {

    private String usernameConfirm;
    private BigDecimal deposit;
    private EnumCryptoTop10 crypto;


    public LogDepositServiceModel() {
    }


    public String getUsernameConfirm() {
        return usernameConfirm;
    }

    public void setUsernameConfirm(String usernameConfirm) {
        this.usernameConfirm = usernameConfirm;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public EnumCryptoTop10 getCrypto() {
        return crypto;
    }

    public void setCrypto(EnumCryptoTop10 crypto) {
        this.crypto = crypto;
    }
}
