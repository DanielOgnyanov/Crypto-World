package com.example.cryptoworld.models.entities;


import com.example.cryptoworld.models.enums.EnumCountry;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity implements Serializable {


    private String username;
    private String fullName;
    private String password;
    private String email;
    private EnumCountry country;
    private List<RoleEntity> roles = new ArrayList<>();
    private String walletAddress;
    private List<LogDeposit> depositSet = new ArrayList<>();
    private List<CreditCardEntity> card;
    private List<LogSell> sellList;
    private boolean isLogged;


    public UserEntity(String username,
                      String fullName,
                      String password,
                      String email,
                      EnumCountry country,
                      List<RoleEntity> roles,
                      String walletAddress,
                      List<LogDeposit> depositSet,
                      boolean isLogged) {
        this.username = username;
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.country = country;
        this.roles = roles;
        this.walletAddress = walletAddress;
        this.depositSet = depositSet;
        this.isLogged = false;
    }

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


    @Column(name = "county_name")
    @Enumerated(EnumType.STRING)
    public EnumCountry getCountry() {
        return country;
    }

    public void setCountry(EnumCountry country) {
        this.country = country;
    }


    @ManyToMany(fetch = FetchType.EAGER)
    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }

    @Column(name = "address")
    public String getWalletAddress() {
        return walletAddress;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    // BIDIRECTIONAL RELATIONS WITH CREDIT_CARD ENTITY



    @OneToMany(mappedBy = "owner")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonBackReference

    public List<CreditCardEntity> getCard() {
        return card;
    }

    public void setCard(List<CreditCardEntity> card) {
        this.card = card;
    }


    // BIDIRECTIONAL RELATIONS WITH LOG_DEPOSIT ENTITY

    @OneToMany(mappedBy = "depositPerson")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonBackReference
    public List<LogDeposit> getDepositSet() {
        return depositSet;
    }

    public void setDepositSet(List<LogDeposit> depositSet) {
        this.depositSet = depositSet;
    }


    // BIDIRECTIONAL RELATIONS WITH LOG_SELL ENTITY

    @OneToMany(mappedBy = "sellPerson")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonBackReference
    public List<LogSell> getSellList() {
        return sellList;
    }

    public void setSellList(List<LogSell> sellList) {
        this.sellList = sellList;
    }


    public UserEntity addRole(RoleEntity roleEntity) {
        this.roles.add(roleEntity);
        return this;
    }

    public UserEntity removeRole(RoleEntity roleEntity) {
        this.roles.remove(roleEntity);
        return this;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }
}
