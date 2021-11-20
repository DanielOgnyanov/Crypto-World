package com.example.cryptoworld.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {

        return "index";
    }

    @GetMapping("/home")
    public String home(Model model) {

        return "home";
    }
}
