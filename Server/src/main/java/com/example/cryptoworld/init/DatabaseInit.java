package com.example.cryptoworld.init;

import com.example.cryptoworld.service.*;
import com.example.cryptoworld.utils.InitEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DatabaseInit  {

    private final CountryService countryService;
    private final RoleService roleService;
    private final CryptoService cryptoService;
    private final UserService userService;
    private final CryptoLogoService cryptoLogoService;

    public DatabaseInit(CountryService countryService, RoleService roleService, CryptoService cryptoService, UserService userService, CryptoLogoService cryptoLogoService) {
        this.countryService = countryService;
        this.roleService = roleService;
        this.cryptoService = cryptoService;
        this.userService = userService;
        this.cryptoLogoService = cryptoLogoService;
    }

    //extends CommandLineRunner
    // @Override
    //    public void run(String... args) throws Exception {
    //        countryService.InitCountryInDb();
    //        roleService.InitRoleInDb();
    //        cryptoService.InitCryptoInDb();
    //        userService.initializeUsers();
    //
    //    }


    @EventListener(InitEvent.class)
    public void run () throws IOException {
        countryService.InitCountryInDb();
        roleService.InitRoleInDb();
        cryptoService.InitCryptoInDb();
        userService.initializeUsers();
        cryptoLogoService.initAllLogoInDb();

    }

}
