package com.example.cryptoworld.models.entities;


import javax.persistence.*;

@Entity
@Table(name = "credit_cards")
public class CreditCardEntity extends BaseEntity{

    private String iban;
    private UserEntity owner;


    public CreditCardEntity() {
    }


    @Column(name = "iban", unique = true, updatable = false)
    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    @ManyToOne
    @JoinColumn(name = "owner_name", referencedColumnName = "full_name")
    public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(UserEntity owner) {
        this.owner = owner;
    }
}
