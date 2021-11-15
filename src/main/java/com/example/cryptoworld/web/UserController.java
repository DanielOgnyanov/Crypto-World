package com.example.cryptoworld.web;


import com.example.cryptoworld.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {


    private final ModelMapper modelMapper;
    private final UserService userService;

    public UserController(ModelMapper modelMapper, UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
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
