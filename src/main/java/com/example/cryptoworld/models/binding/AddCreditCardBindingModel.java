package com.example.cryptoworld.models.binding;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class AddCreditCardBindingModel {

    private BigDecimal balance;
    private int expirationYear;
    private String Iban;


    public AddCreditCardBindingModel() {
    }

    @NotEmpty
    @Min(100)
    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @NotEmpty
    @Min(2010)
    @Max(2030)
    public int getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(int expirationYear) {
        this.expirationYear = expirationYear;
    }

    @NotEmpty
    @Size(min = 20, max = 20)
    public String getIban() {
        return Iban;
    }

    public void setIban(String iban) {
        Iban = iban;
    }
}
