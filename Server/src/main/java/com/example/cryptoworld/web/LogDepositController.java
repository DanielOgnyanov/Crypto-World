package com.example.cryptoworld.web;

import com.example.cryptoworld.models.binding.LogDepositBindingModel;
import com.example.cryptoworld.models.entities.UserEntity;
import com.example.cryptoworld.models.service.LogDepositServiceModel;
import com.example.cryptoworld.service.CreditCartService;
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
    private final CreditCartService creditCartService;


    public LogDepositController(ModelMapper modelMapper,
                                LogDepositService logDepositService,
                                UserService userService, CreditCartService creditCartService) {
        this.modelMapper = modelMapper;
        this.logDepositService = logDepositService;
        this.userService = userService;
        this.creditCartService = creditCartService;
    }

    @GetMapping("/add")
    public String card(Model model) {

        if (!model.containsAttribute("logDepositBindingModel")) {
            model.addAttribute("logDepositBindingModel", new LogDepositBindingModel());
        }

        if (!model.containsAttribute("logDepositBindingModel")) {
            model.addAttribute("logDepositBindingModel", new LogDepositBindingModel());
            model.addAttribute("userCheckIfIsPresent", false);
        }

        if (!model.containsAttribute("logDepositBindingModel")) {
            model.addAttribute("logDepositBindingModel", new LogDepositBindingModel());
            model.addAttribute("depositCheck", false);
        }

        if (!model.containsAttribute("logDepositBindingModel")) {
            model.addAttribute("logDepositBindingModel", new LogDepositBindingModel());
            model.addAttribute("creditCardCheck", false);
        }

        if (!model.containsAttribute("logDepositBindingModel")) {
            model.addAttribute("logDepositBindingModel", new LogDepositBindingModel());
            model.addAttribute("findIfUserInsertPersonalUsernameCheck", false);
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



        if (!logDepositBindingModel.getUsernameConfirm()
                .equals(userService.checkUsernameOfLoggedUser())) {
            redirectAttributes.addFlashAttribute("logDepositBindingModel", logDepositBindingModel);
            redirectAttributes.addFlashAttribute("findIfUserInsertPersonalUsernameCheck", true);

            return "redirect:add";
        }



        if (!userService.creditCardCheckIfIsPresent(logDepositBindingModel.getUsernameConfirm())) {
            redirectAttributes.addFlashAttribute("logDepositBindingModel", logDepositBindingModel);
            redirectAttributes.addFlashAttribute("creditCardCheck", true);

            return "redirect:add";
        }


        UserEntity userEntity =
                userService.findByUsername(logDepositBindingModel.getUsernameConfirm());


        double check = userEntity.getCard().get(0).getBalance().doubleValue();


        if ( check <= logDepositBindingModel.getDeposit()) {

            redirectAttributes.addFlashAttribute("logDepositBindingModel", logDepositBindingModel);
            redirectAttributes.addFlashAttribute("depositCheck", true);

            return "redirect:add";
        }


        logDepositService.addLogDeposit(modelMapper.map(logDepositBindingModel, LogDepositServiceModel.class));


        return "redirect:/home";
    }
}
