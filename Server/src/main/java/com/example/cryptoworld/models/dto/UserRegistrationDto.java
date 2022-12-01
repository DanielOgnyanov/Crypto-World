package com.example.cryptoworld.models.dto;

import com.example.cryptoworld.models.enums.EnumCountry;

import javax.validation.constraints.*;

public class UserRegistrationDto {


    private String username;
    private String fullName;
    private String email;
    private EnumCountry country;
    private String password;
    private String confirmPassword;

    public UserRegistrationDto() {
    }

    public UserRegistrationDto(String username,
                               String fullName,
                               String email,
                               EnumCountry country,
                               String password,
                               String confirmPassword) {
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.country = country;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    @Min(value = 3)
    @Max(value = 20)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Min(value = 5)
    @Max(value = 20)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EnumCountry getCountry() {
        return country;
    }

    public void setCountry(EnumCountry country) {
        this.country = country;
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
