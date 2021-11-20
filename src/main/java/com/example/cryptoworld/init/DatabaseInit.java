package com.example.cryptoworld.init;

import com.example.cryptoworld.service.CountryService;
import com.example.cryptoworld.service.CryptoService;
import com.example.cryptoworld.service.RoleService;
import com.example.cryptoworld.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInit implements CommandLineRunner {

    private final CountryService countryService;
    private final RoleService roleService;
    private final CryptoService cryptoService;
    private final UserService userService;

    public DatabaseInit(CountryService countryService, RoleService roleService, CryptoService cryptoService, UserService userService) {
        this.countryService = countryService;
        this.roleService = roleService;
        this.cryptoService = cryptoService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        countryService.InitCountryInDb();
        roleService.InitRoleInDb();
        cryptoService.InitCryptoInDb();
        userService.initializeUsers();

    }
}
