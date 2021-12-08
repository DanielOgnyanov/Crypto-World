package com.example.cryptoworld.config;


import com.example.cryptoworld.service.LogDepositService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulingConfig {

    private final LogDepositService logDepositService;

    public SchedulingConfig(LogDepositService logDepositService) {
        this.logDepositService = logDepositService;
    }


    @Scheduled(cron = "0 0 0 25 12 ?")
    public void deleteLogDeposit(){
        logDepositService.deleteLowestDeposit();
    }
}
