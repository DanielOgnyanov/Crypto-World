package com.example.cryptoworld.web;

import com.example.cryptoworld.models.binding.LogDepositBindingModel;
import com.example.cryptoworld.models.binding.SellCryptoBindingModel;
import com.example.cryptoworld.models.entities.UserEntity;
import com.example.cryptoworld.service.CreditCartService;
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
@RequestMapping("/sell")
public class LogSellController {


    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CreditCartService creditCartService;

    public LogSellController(ModelMapper modelMapper, UserService userService, CreditCartService creditCartService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.creditCartService = creditCartService;
    }


    @GetMapping("/add")
    public String card(Model model) {

        if (!model.containsAttribute("sellCryptoBindingModel")) {
            model.addAttribute("sellCryptoBindingModel", new SellCryptoBindingModel());
        }

        if (!model.containsAttribute("sellCryptoBindingModel")) {
            model.addAttribute("logDepositBindingModel", new LogDepositBindingModel());
            model.addAttribute("userCheckIfIsPresent", false);
        }

        if (!model.containsAttribute("sellCryptoBindingModel")) {
            model.addAttribute("sellCryptoBindingModel", new LogDepositBindingModel());
            model.addAttribute("sellValueCheck", false);
        }

        return "sell";
    }


    @PostMapping("/add")
    public String addDepositConfirm(@Valid SellCryptoBindingModel sellCryptoBindingModel,
                                    BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes) {


        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("sellCryptoBindingModel", sellCryptoBindingModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.sellCryptoBindingModel", bindingResult);

            return "redirect:add";
        }

        if (!userService.existByUsername(sellCryptoBindingModel.getUsernameConfirm())) {
            redirectAttributes.addFlashAttribute("sellCryptoBindingModel", sellCryptoBindingModel);
            redirectAttributes.addFlashAttribute("userCheckIfIsPresent", true);

            return "redirect:add";
        }


        userService.getUserCryptoValue(sellCryptoBindingModel.getUsernameConfirm(), sellCryptoBindingModel.getCrypto().name());

        return "redirect:/home";
    }
}
