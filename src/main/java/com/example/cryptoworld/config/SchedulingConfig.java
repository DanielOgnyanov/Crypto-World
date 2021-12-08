package com.example.cryptoworld.config;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulingConfig {




    @Scheduled(cron = "59 59 23 * * ?")
    public void removeBannedWorkersAndAnimals(){
        workerService.deleteBanned();
        animalService.deleteBanned();
    }
}
