package com.example.cryptoworld.models.binding;


import com.example.cryptoworld.models.enums.EnumCryptoTop10;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SellCryptoBindingModel {

    private String usernameConfirm;
    private double sellValue;
    private EnumCryptoTop10 crypto;

    public SellCryptoBindingModel() {
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

    @NotNull(message = "Sell value cannot be empty !")
    @DecimalMin(value = "0.001", message = "Sell value must be Positive and over 0.001!")
    public double getSellValue() {
        return sellValue;
    }

    public void setSellValue(double sellValue) {
        this.sellValue = sellValue;
    }

    @NotNull(message = "Crypto card cannot be empty !")
    public EnumCryptoTop10 getCrypto() {
        return crypto;
    }

    public void setCrypto(EnumCryptoTop10 crypto) {
        this.crypto = crypto;
    }
}
