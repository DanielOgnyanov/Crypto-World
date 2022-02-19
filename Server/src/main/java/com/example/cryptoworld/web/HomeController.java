package com.example.cryptoworld.web;


import com.example.cryptoworld.models.view.CryptoViewModel;
import com.example.cryptoworld.service.CreditCartService;
import com.example.cryptoworld.service.CryptoService;
import com.example.cryptoworld.service.WalletService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/home")
public class HomeController {

    private final WalletService walletService;
    private final CryptoService cryptoService;
    private final CreditCartService creditCartService;

    public HomeController(WalletService walletService, CryptoService cryptoService, CreditCartService creditCartService) {
        this.walletService = walletService;
        this.cryptoService = cryptoService;
        this.creditCartService = creditCartService;
    }



    @GetMapping("/cryptoPrice")
    public List<CryptoViewModel> getCryptoPrice(){


        return cryptoService.getAllCrypto();
    }


    // old code
    @GetMapping("/")
    public String index() {

        return "index";
    }

    @GetMapping("/home")
    public String home(Model model) {

        model.addAttribute("wallet" , walletService.getAll());
        model.addAttribute("crypto", cryptoService.getAllCrypto());
        model.addAttribute("card",creditCartService.getCardByOwner());
        return "home";
    }
}
