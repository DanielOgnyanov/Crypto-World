package com.example.cryptoworld.models.binding;

import com.example.cryptoworld.models.enums.EnumRole;

public class ChangeRoleBindingModel {


    private String username;
    private EnumRole enumRole;

    public ChangeRoleBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public EnumRole getEnumRole() {
        return enumRole;
    }

    public void setEnumRole(EnumRole enumRole) {
        this.enumRole = enumRole;
    }
}
