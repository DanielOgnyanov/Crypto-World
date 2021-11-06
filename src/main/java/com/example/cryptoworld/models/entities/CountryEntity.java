package com.example.cryptoworld.models.entities;

import com.example.cryptoworld.models.enums.EnumCountry;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
public class CountryEntity extends BaseEntity{

    private EnumCountry name;





}
