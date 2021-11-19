package com.example.cryptoworld.models.entities;


import com.example.cryptoworld.models.enums.EnumCountry;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity{


    private String username;
    private String fullName;
    private String password;
    private String email;
    private EnumCountry country;
    private List<RoleEntity> roles;
    private String walletAddress;
    private Set<LogDeposit> depositSet;

    public UserEntity() {
        this.roles = new ArrayList<>();
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


    @OneToMany(mappedBy = "depositPerson")
    public Set<LogDeposit> getDepositSet() {
        return depositSet;
    }

    public void setDepositSet(Set<LogDeposit> depositSet) {
        this.depositSet = depositSet;
    }

    public UserEntity addRole(RoleEntity roleEntity) {
        this.roles.add(roleEntity);
        return this;
    }
}
