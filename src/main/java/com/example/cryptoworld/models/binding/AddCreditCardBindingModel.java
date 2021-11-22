package com.example.cryptoworld.models.binding;

import com.example.cryptoworld.models.enums.EnumCard;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class AddCreditCardBindingModel {

    private BigDecimal balance;
    private int expirationYear;
    private String Iban;
    private EnumCard typeCard;


    public AddCreditCardBindingModel() {
    }

    @NotNull
    @Min(value = 100, message = "Balance must be Positive and over 100!")
    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @NotNull
    @Min(2021)
    @Max(value = 2030, message = "Expiration year maximum is 2030 !")
    public int getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(int expirationYear) {
        this.expirationYear = expirationYear;
    }

    @NotEmpty
    @Size(min = 15, max = 20, message = "Iban must be between 15 and 20 characters !")
    public String getIban() {
        return Iban;
    }

    public void setIban(String iban) {
        Iban = iban;
    }

    @NotNull(message = "Type card cannot be empty !")
    public EnumCard getTypeCard() {
        return typeCard;
    }

    public void setTypeCard(EnumCard typeCard) {
        this.typeCard = typeCard;
    }
}
