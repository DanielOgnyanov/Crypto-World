package com.example.cryptoworld.models.service;

import java.math.BigDecimal;

public class LogDepositServiceModel {

    private String usernameConfirm;
    private BigDecimal deposit;


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
}
