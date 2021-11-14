package com.example.cryptoworld.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping("/create")
    public String create(Model model) {


        return "create-account";
    }

    @GetMapping("/sign")
    public String sign(Model model) {


        return "sign-in";
    }

}
