package com.example.cryptoworld.models.binding;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class LogDepositBindingModel {


    private String usernameConfirm;
    private BigDecimal deposit;


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
    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }
}
