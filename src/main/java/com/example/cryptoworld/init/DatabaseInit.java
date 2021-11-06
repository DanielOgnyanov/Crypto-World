package com.example.cryptoworld.init;

import com.example.cryptoworld.service.CountryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInit implements CommandLineRunner {

    private final CountryService countryService;

    public DatabaseInit(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
