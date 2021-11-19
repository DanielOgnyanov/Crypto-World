package com.example.cryptoworld.web;


import com.example.cryptoworld.models.binding.UserRegistrationBindingModel;
import com.example.cryptoworld.models.entities.UserEntity;
import com.example.cryptoworld.models.service.UserRegistrationServiceModel;
import com.example.cryptoworld.repository.UserRepository;
import com.example.cryptoworld.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {


    private final ModelMapper modelMapper;
    private final UserService userService;

    public UserController(ModelMapper modelMapper, UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }


    // Model Attribute

    @ModelAttribute("registrationBindingModel")
    public UserRegistrationBindingModel createBindingModel() {
        return new UserRegistrationBindingModel();
    }



    // GetMapping

    @GetMapping("/create")
    public String create(Model model) {

        if (!model.containsAttribute("registrationBindingModel")) {
            model.addAttribute("registrationBindingModel", new UserRegistrationBindingModel());
        }

        if(!model.containsAttribute("registrationBindingModel")) {
            model.addAttribute("registrationBindingModel", new UserRegistrationBindingModel());
            model.addAttribute("userNameExist", false);
        }

        if(!model.containsAttribute("registrationBindingModel")) {
            model.addAttribute("registrationBindingModel", new UserRegistrationBindingModel());
            model.addAttribute("emailExist", false);
        }

        if(!model.containsAttribute("registrationBindingModel")) {
            model.addAttribute("registrationBindingModel", new UserRegistrationBindingModel());
            model.addAttribute("passwordIsNotEqual", false);
        }

        return "create-account";
    }

    @GetMapping("/sign")
    public String sign(@ModelAttribute("username") String username, Model model) {

        if(!model.containsAttribute("notLogged")){
            model.addAttribute("notLogged", false);
        }
        return "sign-in";
    }




    //PostMapping

    @PostMapping("/create")
    public String createAccount(@Valid UserRegistrationBindingModel registrationBindingModel,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes){


        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("registrationBindingModel", registrationBindingModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.registrationBindingModel", bindingResult);

            return "redirect:create";
        }



        if (userService.existByUsername(registrationBindingModel.getUsername())) {
            redirectAttributes.addFlashAttribute("registrationBindingModel", registrationBindingModel);
            redirectAttributes.addFlashAttribute("userNameExist", true);

            return "redirect:create";
        }


        if (userService.existByEmail(registrationBindingModel.getEmail())) {
            redirectAttributes.addFlashAttribute("registrationBindingModel", registrationBindingModel);
            redirectAttributes.addFlashAttribute("emailExist", true);
            return "redirect:create";
        }

        if (!registrationBindingModel.getPassword().equals(registrationBindingModel.getConfirmPassword())) {
            redirectAttributes.addFlashAttribute("registrationBindingModel", registrationBindingModel);
            redirectAttributes.addFlashAttribute("passwordIsNotEqual", true);
            return "redirect:create";
        }


        userService.register
                (modelMapper.map(registrationBindingModel, UserRegistrationServiceModel.class));


        return "redirect:sign";


    }


    @PostMapping("/login-error")
    public String failedLogin(@ModelAttribute("username")
                                      String username,
                              RedirectAttributes attributes) {

        attributes.addFlashAttribute("bad_credentials", true);
        attributes.addFlashAttribute("username", username);

        return "redirect:/users/sing-in";
    }


}
