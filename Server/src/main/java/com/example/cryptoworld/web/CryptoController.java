package com.example.cryptoworld.web;


import com.example.cryptoworld.models.view.PopularCryptoViewModel;
import com.example.cryptoworld.service.CryptoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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


    @GetMapping("/marketCap4Hour")
    public ResponseEntity<BigDecimal> getMarketCap24Hour() {

        try {

            BigDecimal marketCap24Hour = cryptoService.cryptoMarketCap4Hour();

            return new ResponseEntity<>(marketCap24Hour, HttpStatus.OK);

        } catch (Exception e) {

            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());

        }

    }


    @GetMapping("/marketCapDifferenceInPercentage")

    public ResponseEntity<BigDecimal> getMarketCapPercentageDifference() {

        try {
            BigDecimal percentageDifference = cryptoService.calculateTheMarketDifferenceInPercentage();
            return new ResponseEntity<>(percentageDifference, HttpStatus.OK);
        } catch (Exception e) {

            String errorMessage = "Error occurred while calculating market cap difference percentage: " + e.getMessage();

            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }


    }
}
