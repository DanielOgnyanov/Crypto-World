package com.example.cryptoworld.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sell")
public class LogSellController {


    @GetMapping("/add")
    public String card(Model model) {


        return "sell";
    }
}
