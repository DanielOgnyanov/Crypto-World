package com.example.cryptoworld.models.entities;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity{

    private String username;
    private String fullName;
    private String password;
    private String email;
}
