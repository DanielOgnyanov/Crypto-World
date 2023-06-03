package com.example.cryptoworld.web;


import com.example.cryptoworld.models.view.PopularCryptoViewModel;
import com.example.cryptoworld.service.CryptoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/crypto")
public class CryptoController {


    private final CryptoService cryptoService;

    public CryptoController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }



    @GetMapping("/popular/crypto")
    public ResponseEntity<BigDecimal> getMarketCap24Hour() {





        return ;
    }
}
