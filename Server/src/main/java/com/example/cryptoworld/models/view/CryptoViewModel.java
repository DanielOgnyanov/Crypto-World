package com.example.cryptoworld.models.view;

import java.math.BigDecimal;

public class CryptoViewModel {

    private Long id;
    private String name;
    private double price;
    private BigDecimal volumeFor24Hour;


    public CryptoViewModel() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
