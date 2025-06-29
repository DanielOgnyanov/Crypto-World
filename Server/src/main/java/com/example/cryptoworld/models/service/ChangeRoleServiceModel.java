package com.example.cryptoworld.models.service;

import com.example.cryptoworld.models.enums.EnumAddOrRemove;

public class ChangeRoleServiceModel {

    private String username;
    private String roleName;

    public ChangeRoleServiceModel() {
    }


    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
