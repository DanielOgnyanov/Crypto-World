package com.example.cryptoworld.web;

import com.example.cryptoworld.models.binding.UserRegistrationBindingModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/card")
public class CreditCardController {




    // Model Attribute

    @ModelAttribute("addCreditCardBindingModel")
    public CreditCardController createBindingModel() {
        return new CreditCardController();
    }



    @GetMapping("/add")
    public String card() {

        return "card";
    }



}
