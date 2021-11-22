package com.example.cryptoworld.web;

import com.example.cryptoworld.models.binding.AddCreditCardBindingModel;
import com.example.cryptoworld.models.binding.UserRegistrationBindingModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/card")
public class CreditCardController {



    @GetMapping("/add")
    public String card(Model model) {
        if (!model.containsAttribute("addCreditCardBindingModel")) {
            model.addAttribute("addCreditCardBindingModel", new AddCreditCardBindingModel());
        }
        return "card";
    }



}
