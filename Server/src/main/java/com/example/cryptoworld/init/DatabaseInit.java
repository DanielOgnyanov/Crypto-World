package com.example.cryptoworld.init;

import com.example.cryptoworld.service.CountryService;
import com.example.cryptoworld.service.CryptoService;
import com.example.cryptoworld.service.RoleService;
import com.example.cryptoworld.service.UserService;
import com.example.cryptoworld.utils.event.initEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DatabaseInit  {

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

    //extends CommandLineRunner
    // @Override
    //    public void run(String... args) throws Exception {
    //        countryService.InitCountryInDb();
    //        roleService.InitRoleInDb();
    //        cryptoService.InitCryptoInDb();
    //        userService.initializeUsers();
    //
    //    }


    @EventListener(initEvent.class)
    public void run () throws IOException {
        countryService.InitCountryInDb();
        roleService.InitRoleInDb();
        cryptoService.InitCryptoInDb();
        userService.initializeUsers();

    }

}
