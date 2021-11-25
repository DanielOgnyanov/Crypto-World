package com.example.cryptoworld.web;

import com.example.cryptoworld.models.binding.LogDepositBindingModel;
import com.example.cryptoworld.models.binding.SellCryptoBindingModel;
import com.example.cryptoworld.models.service.SellCryptoServiceModel;
import com.example.cryptoworld.service.CreditCartService;
import com.example.cryptoworld.service.LogSellService;
import com.example.cryptoworld.service.UserService;
import com.example.cryptoworld.service.WalletService;
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
    private final LogSellService logSellService;
    private final WalletService walletService;

    public LogSellController(ModelMapper modelMapper, UserService userService, CreditCartService creditCartService, LogSellService logSellService, WalletService walletService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.creditCartService = creditCartService;
        this.logSellService = logSellService;
        this.walletService = walletService;
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

        if (!model.containsAttribute("sellCryptoBindingModel")) {
            model.addAttribute("sellCryptoBindingModel", new LogDepositBindingModel());
            model.addAttribute("cryptoCheck", false);
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


        if (!walletService.findUsersWallet(sellCryptoBindingModel.getUsernameConfirm())) {
            redirectAttributes.addFlashAttribute("sellCryptoBindingModel", sellCryptoBindingModel);
            redirectAttributes.addFlashAttribute("sellValueCheck", true);

            return "redirect:add";
        }

        double sellValueCheck =
                walletService
                        .sellValueCheck(sellCryptoBindingModel.getUsernameConfirm(),
                                sellCryptoBindingModel.getCrypto().name());


        if (sellValueCheck < sellCryptoBindingModel.getSellValue()) {

            redirectAttributes.addFlashAttribute("sellCryptoBindingModel", sellCryptoBindingModel);
            redirectAttributes.addFlashAttribute("sellValueCheck", true);

            return "redirect:add";
        }

        logSellService.sellLog(modelMapper.map(sellCryptoBindingModel, SellCryptoServiceModel.class));


        return "redirect:/home";
    }
}
