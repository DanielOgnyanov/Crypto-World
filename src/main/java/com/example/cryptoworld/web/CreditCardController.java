package com.example.cryptoworld.web;

import com.example.cryptoworld.models.binding.AddCreditCardBindingModel;
import com.example.cryptoworld.models.service.AddCreditCardServiceModel;
import com.example.cryptoworld.service.CreditCartService;
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
@RequestMapping("/card")
public class CreditCardController {

    private final ModelMapper modelMapper;
    private final CreditCartService creditCartService;

    public CreditCardController(ModelMapper modelMapper, CreditCartService creditCartService) {
        this.modelMapper = modelMapper;
        this.creditCartService = creditCartService;
    }

    @GetMapping("/add")
    public String card(Model model) {
        if (!model.containsAttribute("addCreditCardBindingModel")) {
            model.addAttribute("addCreditCardBindingModel", new AddCreditCardBindingModel());
        }
        return "card";
    }


    @PostMapping("/add")
    public String addCardConfirm(@Valid AddCreditCardBindingModel addCreditCardBindingModel,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {


        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addCreditCardBindingModel", addCreditCardBindingModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.addCreditCardBindingModel", bindingResult);

            return "redirect:add";
        }


        creditCartService.addCreditCard(modelMapper.map(addCreditCardBindingModel, AddCreditCardServiceModel.class));


        return "redirect:/home";
    }


}
