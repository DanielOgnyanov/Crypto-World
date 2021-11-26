package com.example.cryptoworld.models.binding;

import com.example.cryptoworld.models.enums.EnumRole;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ChangeRoleBindingModel {


    private String username;
    private EnumRole enumRole;

    public ChangeRoleBindingModel() {
    }

    @NotNull(message = "Username cannot be empty !")
    @NotEmpty(message = "Username cannot be empty !")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters !")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotNull(message = "Role cannot be empty !")
    public EnumRole getEnumRole() {
        return enumRole;
    }

    public void setEnumRole(EnumRole enumRole) {
        this.enumRole = enumRole;
    }
}
