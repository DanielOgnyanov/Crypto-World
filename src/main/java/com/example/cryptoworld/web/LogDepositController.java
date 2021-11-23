package com.example.cryptoworld.web;

import com.example.cryptoworld.models.binding.AddCreditCardBindingModel;
import com.example.cryptoworld.models.binding.LogDepositBindingModel;
import com.example.cryptoworld.service.LogDepositService;
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

    public LogDepositController(ModelMapper modelMapper, LogDepositService logDepositService) {
        this.modelMapper = modelMapper;
        this.logDepositService = logDepositService;
    }

    @GetMapping("/add")
    public String card(Model model) {

        if (!model.containsAttribute("logDepositBindingModel")) {
            model.addAttribute("logDepositBindingModel", new LogDepositBindingModel());
        }
        return "log";
    }



    @PostMapping("/add")
    public String addDepositConfirm(@Valid AddCreditCardBindingModel addCreditCardBindingModel,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {



    }
}
