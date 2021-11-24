package com.example.cryptoworld.web;

import com.example.cryptoworld.models.binding.LogDepositBindingModel;
import com.example.cryptoworld.models.binding.SellCryptoBindingModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sell")
public class LogSellController {


    @GetMapping("/add")
    public String card(Model model) {

        if (!model.containsAttribute("sellCryptoBindingModel")) {
            model.addAttribute("sellCryptoBindingModel", new SellCryptoBindingModel());
        }

        if (!model.containsAttribute("logDepositBindingModel")) {
            model.addAttribute("logDepositBindingModel", new LogDepositBindingModel());
            model.addAttribute("userCheckIfIsPresent", false);
        }

        if (!model.containsAttribute("logDepositBindingModel")) {
            model.addAttribute("logDepositBindingModel", new LogDepositBindingModel());
            model.addAttribute("sellValueCheck", false);
        }

        return "sell";
    }
}
