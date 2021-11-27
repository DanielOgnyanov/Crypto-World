package com.example.cryptoworld.models.service;

import com.example.cryptoworld.models.enums.EnumRole;

public class ChangeRoleServiceModel {

    private String username;
    private EnumRole enumRole;


    public ChangeRoleServiceModel() {
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
