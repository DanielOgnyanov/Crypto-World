package com.example.cryptoworld.web;

import com.example.cryptoworld.models.binding.ChangeRoleBindingModel;
import com.example.cryptoworld.models.binding.UserRegistrationBindingModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/setting")

    public String adminPanel(Model model) {

        if (!model.containsAttribute("changeRoleBindingModel")) {
            model.addAttribute("changeRoleBindingModel", new ChangeRoleBindingModel());
        }



        return "admin";
    }
}
