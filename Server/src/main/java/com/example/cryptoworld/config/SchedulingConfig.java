package com.example.cryptoworld.config;


import com.example.cryptoworld.service.LogDepositService;
import com.example.cryptoworld.service.LogSellService;
import com.example.cryptoworld.service.RealTimeCryptoPriceService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SchedulingConfig {

    private final LogDepositService logDepositService;
    private final LogSellService logSellService;
    private final RealTimeCryptoPriceService realTimeCryptoPriceService;

    public SchedulingConfig(LogDepositService logDepositService, LogSellService logSellService, RealTimeCryptoPriceService realTimeCryptoPriceService) {
        this.logDepositService = logDepositService;
        this.logSellService = logSellService;
        this.realTimeCryptoPriceService = realTimeCryptoPriceService;
    }


    @Scheduled(cron = "0 0 0 25 12 ?")
    public void deleteLogDeposit() {
        logDepositService.deleteLowestDeposit();
        logSellService.deleteLowestSell();
    }

    @Scheduled(cron = "*/50 * * * * *") // TODO SET
    public void realTimeCryptoPriceUpdate() throws IOException {
        realTimeCryptoPriceService.getRealTimePrice();

    }
}
