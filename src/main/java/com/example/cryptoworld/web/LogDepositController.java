package com.example.cryptoworld.web;

import com.example.cryptoworld.models.binding.LogDepositBindingModel;
import com.example.cryptoworld.models.binding.UserRegistrationBindingModel;
import com.example.cryptoworld.service.LogDepositService;
import com.example.cryptoworld.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/deposit")
public class LogDepositController {

    private final ModelMapper modelMapper;
    private final LogDepositService logDepositService;
    private final UserService userService;

    public LogDepositController(ModelMapper modelMapper, LogDepositService logDepositService, UserService userService) {
        this.modelMapper = modelMapper;
        this.logDepositService = logDepositService;
        this.userService = userService;
    }

    @GetMapping("/add")
    public String card(Model model) {

        if (!model.containsAttribute("logDepositBindingModel")) {
            model.addAttribute("logDepositBindingModel", new LogDepositBindingModel());
        }

        if (!model.containsAttribute("registrationBindingModel")) {
            model.addAttribute("registrationBindingModel", new UserRegistrationBindingModel());
            model.addAttribute("userCheckIfIsPresent", false);
        }
        return "log";
    }



    @PostMapping("/add")
    public String addDepositConfirm(@Valid LogDepositBindingModel logDepositBindingModel,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {


        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("logDepositBindingModel", logDepositBindingModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.logDepositBindingModel", bindingResult);

            return "redirect:add";
        }

        if (!userService.existByUsername(logDepositBindingModel.getUsernameConfirm())) {
            redirectAttributes.addFlashAttribute("logDepositBindingModel", logDepositBindingModel);
            redirectAttributes.addFlashAttribute("userCheckIfIsPresent", true);

            return "redirect:add";
        }





        return "redirect:/home";
    }
}
