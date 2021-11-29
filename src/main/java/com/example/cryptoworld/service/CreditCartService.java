package com.example.cryptoworld.service;

import com.example.cryptoworld.models.entities.CreditCardEntity;
import com.example.cryptoworld.models.service.AddCreditCardServiceModel;
import com.example.cryptoworld.models.view.CreditCardViewModel;

import java.util.List;

public interface CreditCartService {
    void addCreditCard(AddCreditCardServiceModel addCreditCardServiceModel);
    CreditCardEntity getByOwner(String owner);

    List<CreditCardViewModel> getCardByOwner();
}
