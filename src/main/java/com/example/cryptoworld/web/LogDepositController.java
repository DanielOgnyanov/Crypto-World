package com.example.cryptoworld.web;

import com.example.cryptoworld.models.binding.AddCreditCardBindingModel;
import com.example.cryptoworld.models.binding.LogDepositBindingModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/deposit")
public class LogDepositController {

    @GetMapping("/add")
    public String card(Model model) {

        if (!model.containsAttribute("logDepositBindingModel")) {
            model.addAttribute("logDepositBindingModel", new LogDepositBindingModel());
        }
        return "log";
    }
}
