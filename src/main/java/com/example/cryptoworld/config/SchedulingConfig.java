package com.example.cryptoworld.config;


import com.example.cryptoworld.service.LogDepositService;
import com.example.cryptoworld.service.LogSellService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SchedulingConfig {

    private final LogDepositService logDepositService;
    private final LogSellService logSellService;

    public SchedulingConfig(LogDepositService logDepositService, LogSellService logSellService) {
        this.logDepositService = logDepositService;
        this.logSellService = logSellService;
    }


    @Scheduled(cron = "0 0 0 25 12 ?")
    public void deleteLogDeposit(){
        logDepositService.deleteLowestDeposit();
        logSellService.deleteLowestSell();


    }
}
