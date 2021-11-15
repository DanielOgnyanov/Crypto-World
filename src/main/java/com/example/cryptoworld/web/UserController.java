package com.example.cryptoworld.web;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {


    private final ModelMapper modelMapper;

    public UserController(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    @GetMapping("/create")
    public String create(Model model) {


        return "create-account";
    }

    @GetMapping("/sign")
    public String sign(Model model) {


        return "sign-in";
    }

}
