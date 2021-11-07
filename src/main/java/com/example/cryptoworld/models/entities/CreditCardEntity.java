package com.example.cryptoworld.models.entities;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "credit_cards")
public class CreditCardEntity extends BaseEntity{

    private String iban;
    private UserEntity owner;



}
