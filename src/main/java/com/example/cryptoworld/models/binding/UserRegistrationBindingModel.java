package com.example.cryptoworld.models.binding;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserRegistrationBindingModel {


    private String username;
    private String fullName;
    private String email;
    private String password;
    private String confirmPassword;


    public UserRegistrationBindingModel() {
    }

    @NotEmpty
    @Size(min = 3, max = 20)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotEmpty
    @Size(min = 3, max = 30)
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
