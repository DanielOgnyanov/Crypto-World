package com.example.cryptoworld.service;

import com.example.cryptoworld.models.entities.CreditCardEntity;
import com.example.cryptoworld.models.service.AddCreditCardServiceModel;

public interface CreditCartService {
    void addCreditCard(AddCreditCardServiceModel addCreditCardServiceModel);
    CreditCardEntity getByOwner(String owner);
}
