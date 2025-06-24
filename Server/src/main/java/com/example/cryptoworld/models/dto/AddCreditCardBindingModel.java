package com.example.cryptoworld.models.dto;

import com.example.cryptoworld.models.enums.EnumCard;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class AddCreditCardBindingModel {

    @NotNull(message = "IBAN cannot be empty!")
    @Size(min = 15, max = 20, message = "IBAN must be between 15 and 20 characters!")
    private String iban;

    @NotNull(message = "Balance cannot be empty!")
    @DecimalMin(value = "100", message = "Balance must be Positive and over 100!")
    private BigDecimal balance;

    @NotNull(message = "Expiration date cannot be empty!")
    @Pattern(regexp = "^(20\\d{2})-(0[1-9]|1[0-2])$", message = "Expiration date must be in the format YYYY-MM")
    private String expirationDate;



    @NotNull(message = "Card type cannot be empty!")
    private EnumCard typeCard;

    public AddCreditCardBindingModel() {}

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public EnumCard getTypeCard() {
        return typeCard;
    }

    public void setTypeCard(EnumCard typeCard) {
        this.typeCard = typeCard;
    }
}
