package com.example.cryptoworld.models.service;

import com.example.cryptoworld.models.enums.EnumAddOrRemove;
import com.example.cryptoworld.models.enums.EnumRole;

public class ChangeRoleServiceModel {

    private String username;
    private EnumAddOrRemove addOrRemove;


    public ChangeRoleServiceModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public EnumAddOrRemove getAddOrRemove() {
        return addOrRemove;
    }

    public void setAddOrRemove(EnumAddOrRemove addOrRemove) {
        this.addOrRemove = addOrRemove;
    }
}
