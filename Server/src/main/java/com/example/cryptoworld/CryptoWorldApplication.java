package com.example.cryptoworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CryptoWorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(CryptoWorldApplication.class, args);
    }

}
