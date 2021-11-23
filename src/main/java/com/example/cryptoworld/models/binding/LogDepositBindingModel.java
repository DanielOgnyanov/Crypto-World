package com.example.cryptoworld.models.binding;

import java.math.BigDecimal;

public class LogDepositBindingModel {


    private String usernameConfirm;
    private BigDecimal priceValue;


    public LogDepositBindingModel() {
    }


    public String getUsernameConfirm() {
        return usernameConfirm;
    }

    public void setUsernameConfirm(String usernameConfirm) {
        this.usernameConfirm = usernameConfirm;
    }

    public BigDecimal getPriceValue() {
        return priceValue;
    }

    public void setPriceValue(BigDecimal priceValue) {
        this.priceValue = priceValue;
    }
}
