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
    @Min(100)
    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @NotNull
    @Min(2021)
    @Max(2030)
    public int getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(int expirationYear) {
        this.expirationYear = expirationYear;
    }

    @NotEmpty
    @Size(min = 15, max = 20)
    public String getIban() {
        return Iban;
    }

    public void setIban(String iban) {
        Iban = iban;
    }

    @NotNull
    public EnumCard getTypeCard() {
        return typeCard;
    }

    public void setTypeCard(EnumCard typeCard) {
        this.typeCard = typeCard;
    }
}
