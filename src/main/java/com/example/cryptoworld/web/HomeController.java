package com.example.cryptoworld.web;


import com.example.cryptoworld.service.CryptoService;
import com.example.cryptoworld.service.WalletService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final WalletService walletService;
    private final CryptoService cryptoService;

    public HomeController(WalletService walletService, CryptoService cryptoService) {
        this.walletService = walletService;
        this.cryptoService = cryptoService;
    }

    @GetMapping("/")
    public String index() {

        return "index";
    }

    @GetMapping("/home")
    public String home(Model model) {

        model.addAttribute("wallet" , walletService.getAll());
        model.addAttribute("crypto", cryptoService.getAllCrypto());
        return "home";
    }
}
