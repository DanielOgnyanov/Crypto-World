package com.example.cryptoworld.models.entities;

import com.example.cryptoworld.models.enums.EnumCountry;

import javax.persistence.*;

@Entity
@Table(name = "countries")
public class CountryEntity extends BaseEntity{


    private EnumCountry name;


    public CountryEntity() {
    }

    public CountryEntity(EnumCountry name) {
        this.name = name;
    }

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    public EnumCountry getName() {
        return name;
    }

    public void setName(EnumCountry name) {
        this.name = name;
    }
}
