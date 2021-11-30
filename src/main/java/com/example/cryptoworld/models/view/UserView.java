package com.example.cryptoworld.models.view;

import com.example.cryptoworld.models.entities.RoleEntity;

import java.util.List;

public class UserView {

    private String username;
    private String fullName;
    private String email;
    private List<RoleEntity> roles;

    public UserView() {
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }
}
