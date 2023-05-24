package com.example.cryptoworld.web;


import com.example.cryptoworld.models.service.UserRegistrationServiceModel;
import com.example.cryptoworld.models.view.PopularCryptoViewModel;
import com.example.cryptoworld.service.PopularCryptoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/index")
public class PopularCryptoController {


    private final PopularCryptoService popularCryptoService;


    public PopularCryptoController(PopularCryptoService popularCryptoService) {
        this.popularCryptoService = popularCryptoService;
    }


    @GetMapping("/popular/crypto")
    public ResponseEntity<List<PopularCryptoViewModel>> getPopularCrypto() {


        List<PopularCryptoViewModel> findPopularCryptoInDb = popularCryptoService.getPopularCrypto();


        return new ResponseEntity<List<PopularCryptoViewModel>>(findPopularCryptoInDb, HttpStatus.OK);
    }
}
