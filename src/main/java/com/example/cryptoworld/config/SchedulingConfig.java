package com.example.cryptoworld.config;


import com.example.cryptoworld.service.LogDepositService;
import com.example.cryptoworld.service.LogSellService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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
