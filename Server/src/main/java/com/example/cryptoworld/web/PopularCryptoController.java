package com.example.cryptoworld.web;


import com.example.cryptoworld.service.PopularCryptoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/index/popular/crypto")
public class PopularCryptoController {


    private final PopularCryptoService popularCryptoService;


    public PopularCryptoController(PopularCryptoService popularCryptoService) {
        this.popularCryptoService = popularCryptoService;
    }
}
