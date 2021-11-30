package com.example.cryptoworld.service;

import com.example.cryptoworld.models.service.LogDepositServiceModel;
import com.example.cryptoworld.models.view.LogDepositView;

import java.util.List;

public interface LogDepositService {
    void addLogDeposit(LogDepositServiceModel logDepositServiceModel);

    List<LogDepositView> getAllDepositOrderedDesc();
}
