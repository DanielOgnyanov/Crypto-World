package com.example.cryptoworld.web;


import com.example.cryptoworld.models.binding.LoginCheckDto;
import com.example.cryptoworld.models.binding.LoginDto;
import com.example.cryptoworld.models.binding.UserRegistrationBindingModel;
import com.example.cryptoworld.models.entities.UserEntity;
import com.example.cryptoworld.models.entities.WalletEntity;
import com.example.cryptoworld.models.service.UserRegistrationServiceModel;
import com.example.cryptoworld.service.UserService;
import com.example.cryptoworld.service.WalletService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {


    private final ModelMapper modelMapper;
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final WalletService walletService;

    public UserController(ModelMapper modelMapper, UserService userService, AuthenticationManager authenticationManager, WalletService walletService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.walletService = walletService;
    }


    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto){

        Authentication authentication =
                authenticationManager
                        .authenticate
                                (new UsernamePasswordAuthenticationToken
                                        (loginDto.getUsername(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);

    }

    @GetMapping("/wallet")
    public ResponseEntity<WalletEntity> getUserWallet(@RequestBody LoginCheckDto loginCheckDto) {

        UserEntity user = userService.findByUsername(loginCheckDto.getUsername());
        WalletEntity wallet = walletService.getUserWallet(loginCheckDto.getUsername());

        if(!user.isLogged()) {
            return new ResponseEntity<>(wallet, HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(wallet, HttpStatus.OK);
    }



    // OLD CODE

    // Model Attribute

    @ModelAttribute("registrationBindingModel")
    public UserRegistrationBindingModel createBindingModel() {
        return new UserRegistrationBindingModel();
    }

    // END


    // GetMapping

    @GetMapping("/create")
    public String create(Model model) {

        if (!model.containsAttribute("registrationBindingModel")) {
            model.addAttribute("registrationBindingModel", new UserRegistrationBindingModel());
        }

        if (!model.containsAttribute("registrationBindingModel")) {
            model.addAttribute("registrationBindingModel", new UserRegistrationBindingModel());
            model.addAttribute("userNameExist", false);
        }

        if (!model.containsAttribute("registrationBindingModel")) {
            model.addAttribute("registrationBindingModel", new UserRegistrationBindingModel());
            model.addAttribute("emailExist", false);
        }

        if (!model.containsAttribute("registrationBindingModel")) {
            model.addAttribute("registrationBindingModel", new UserRegistrationBindingModel());
            model.addAttribute("passwordIsNotEqual", false);
        }

        return "create-account";
    }

    @GetMapping("/login")
    public String sign(Model model) {

        if (!model.containsAttribute("notLogged")) {
            model.addAttribute("notLogged", false);
        }


        return "login";
    }

    // END


    //PostMapping

    @PostMapping("/create")
    public String createAccount(@Valid UserRegistrationBindingModel registrationBindingModel,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes) {


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


        return "redirect:login";


    }


    @PostMapping("/login-error")
    public String failedLogin(@ModelAttribute("username")
                                      String username,
                              RedirectAttributes attributes) {

        attributes.addFlashAttribute("username", username);
        attributes.addFlashAttribute("notLogged", true);
        return "redirect:login";


    }
}
