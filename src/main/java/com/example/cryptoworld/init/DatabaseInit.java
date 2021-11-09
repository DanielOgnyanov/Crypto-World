package com.example.cryptoworld.init;

import com.example.cryptoworld.service.CountryService;
import com.example.cryptoworld.service.CryptoSrvice;
import com.example.cryptoworld.service.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInit implements CommandLineRunner {

    private final CountryService countryService;
    private final RoleService roleService;
    private final CryptoSrvice cryptoSrvice;

    public DatabaseInit(CountryService countryService, RoleService roleService, CryptoSrvice cryptoSrvice) {
        this.countryService = countryService;
        this.roleService = roleService;
        this.cryptoSrvice = cryptoSrvice;
    }

    @Override
    public void run(String... args) throws Exception {
        countryService.InitCountryInDb();
        roleService.InitRoleInDb();
    }
}
