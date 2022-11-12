package com.example.cryptoworld.models.dto;

import com.example.cryptoworld.models.enums.EnumCryptoTop10;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LogDepositBindingModel {


    private String usernameConfirm;
    private double deposit;
    private EnumCryptoTop10 crypto;


    public LogDepositBindingModel() {
    }
    @NotNull(message = "Username cannot be empty !")
    @NotEmpty(message = "Username cannot be empty !")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters !")
    public String getUsernameConfirm() {
        return usernameConfirm;
    }

    public void setUsernameConfirm(String usernameConfirm) {
        this.usernameConfirm = usernameConfirm;
    }

    @NotNull(message = "Deposit cannot be empty !")
    @DecimalMin(value = "10", message = "Deposit must be Positive and over 10!")
    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    @NotNull(message = "Crypto card cannot be empty !")
    public EnumCryptoTop10 getCrypto() {
        return crypto;
    }

    public void setCrypto(EnumCryptoTop10 crypto) {
        this.crypto = crypto;
    }
}
