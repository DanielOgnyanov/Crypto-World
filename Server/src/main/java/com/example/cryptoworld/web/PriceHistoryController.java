package com.example.cryptoworld.web;

import com.example.cryptoworld.service.PriceHistoryService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/price/history")
public class PriceHistoryController {

    private final PriceHistoryService priceHistoryService;

    public PriceHistoryController(PriceHistoryService priceHistoryService) {
        this.priceHistoryService = priceHistoryService;
    }


    @GetMapping("/list")

    public ResponseEntity<List<Object[]>> getListOfPriceHistory() {

        try {

            List<Object[]> currentListOfPriceHistory = priceHistoryService.groupedCryptoByName();

            return new ResponseEntity<List<Object[]>>(currentListOfPriceHistory, HttpStatus.OK);

        } catch (Exception e) {

            String errorMessage = "Error occurred while fetching crypto prices list: " + e.getMessage();

            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }


    }

    @RequestMapping(value = "/list", method = RequestMethod.OPTIONS)
    public ResponseEntity<?> handleOptionsRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Methods", "GET, OPTIONS");
        headers.add("Access-Control-Allow-Headers", "Content-Type, Authorization");
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }
}
