package com.example.cryptoworld.models.entities;


import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity{


    private String username;
    private String fullName;
    private String password;
    private String email;
    private CountryEntity country;

    public UserEntity() {
    }

    @Column(name = "username", unique = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "full_name")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "email", unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "country")
    @ManyToOne
    public CountryEntity getCountry() {
        return country;
    }

    public void setCountry(CountryEntity country) {
        this.country = country;
    }
}
