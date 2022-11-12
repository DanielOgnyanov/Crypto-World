package com.example.cryptoworld.web;


import com.example.cryptoworld.models.dto.*;
import com.example.cryptoworld.models.entities.UserEntity;
import com.example.cryptoworld.models.entities.WalletEntity;
import com.example.cryptoworld.models.service.UserRegistrationServiceModel;
import com.example.cryptoworld.service.LoginService;
import com.example.cryptoworld.service.UserService;
import com.example.cryptoworld.service.WalletService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {


    private final ModelMapper modelMapper;
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final WalletService walletService;
    private final LoginService loginService;

    public UserController(ModelMapper modelMapper, UserService userService, AuthenticationManager authenticationManager, WalletService walletService, LoginService loginService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.walletService = walletService;
        this.loginService = loginService;
    }


    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto){

        Authentication authentication =
                authenticationManager
                        .authenticate
                                (new UsernamePasswordAuthenticationToken
                                        (loginDto.getUsername(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        loginService.setUserLoginInDb(loginDto.getUsername(),true);

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


    @GetMapping("/username/check")
    public ResponseEntity<String> findIfUsernameIsTaken(@RequestBody UsernameDto usernameDto){

        if (userService.existByUsername(usernameDto.getUsername())){
            return new ResponseEntity<>("Username already exist", HttpStatus.CONFLICT);
        }


        return new ResponseEntity<>("Username is free", HttpStatus.OK);
    }

    @GetMapping("/email/check")
    public ResponseEntity<String> findIfEmailIsTaken(@RequestBody EmailDto emailDto){

        if (userService.existByUsername(emailDto.getEmail())){
            return new ResponseEntity<>("This email is used by another person", HttpStatus.CONFLICT);
        }


        return new ResponseEntity<>("Email is free", HttpStatus.OK);
    }




    


    @PostMapping("/register")
    public ResponseEntity<String> createUserAccount(@RequestBody UserRegistrationDto userRegistrationDto){

        if (userService.existByEmail(userRegistrationDto.getEmail())){
            return new ResponseEntity<>("Email already exist", HttpStatus.BAD_REQUEST);


        }

        userService.register
                (modelMapper.map(userRegistrationDto, UserRegistrationServiceModel.class));

        Authentication authentication =
                authenticationManager
                        .authenticate
                                (new UsernamePasswordAuthenticationToken
                                        (userRegistrationDto.getUsername(), userRegistrationDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);


        loginService.setUserLoginInDb(userRegistrationDto.getUsername(),true);

        return new ResponseEntity<>("New user registered", HttpStatus.OK);

    }



    // OLD CODE

    // Model Attribute

    // @ModelAttribute("registrationBindingModel")
    //    public UserRegistrationBindingModel createBindingModel() {
    //        return new UserRegistrationBindingModel();
    //    }
    //
    //    // END
    //
    //
    //    // GetMapping
    //
    //    @GetMapping("/create")
    //    public String create(Model model) {
    //
    //        if (!model.containsAttribute("registrationBindingModel")) {
    //            model.addAttribute("registrationBindingModel", new UserRegistrationBindingModel());
    //        }
    //
    //        if (!model.containsAttribute("registrationBindingModel")) {
    //            model.addAttribute("registrationBindingModel", new UserRegistrationBindingModel());
    //            model.addAttribute("userNameExist", false);
    //        }
    //
    //        if (!model.containsAttribute("registrationBindingModel")) {
    //            model.addAttribute("registrationBindingModel", new UserRegistrationBindingModel());
    //            model.addAttribute("emailExist", false);
    //        }
    //
    //        if (!model.containsAttribute("registrationBindingModel")) {
    //            model.addAttribute("registrationBindingModel", new UserRegistrationBindingModel());
    //            model.addAttribute("passwordIsNotEqual", false);
    //        }
    //
    //        return "create-account";
    //    }
    //
    //    @GetMapping("/login")
    //    public String sign(Model model) {
    //
    //        if (!model.containsAttribute("notLogged")) {
    //            model.addAttribute("notLogged", false);
    //        }
    //
    //
    //        return "login";
    //    }
    //
    //    // END
    //
    //
    //    //PostMapping
    //
    //    @PostMapping("/create")
    //    public String createAccount(@Valid UserRegistrationBindingModel registrationBindingModel,
    //                                BindingResult bindingResult,
    //                                RedirectAttributes redirectAttributes) {
    //
    //
    //        if (bindingResult.hasErrors()) {
    //            redirectAttributes.addFlashAttribute("registrationBindingModel", registrationBindingModel);
    //            redirectAttributes.addFlashAttribute(
    //                    "org.springframework.validation.BindingResult.registrationBindingModel", bindingResult);
    //
    //            return "redirect:create";
    //        }
    //
    //
    //        if (userService.existByUsername(registrationBindingModel.getUsername())) {
    //            redirectAttributes.addFlashAttribute("registrationBindingModel", registrationBindingModel);
    //            redirectAttributes.addFlashAttribute("userNameExist", true);
    //
    //            return "redirect:create";
    //        }
    //
    //
    //        if (userService.existByEmail(registrationBindingModel.getEmail())) {
    //            redirectAttributes.addFlashAttribute("registrationBindingModel", registrationBindingModel);
    //            redirectAttributes.addFlashAttribute("emailExist", true);
    //            return "redirect:create";
    //        }
    //
    //        if (!registrationBindingModel.getPassword().equals(registrationBindingModel.getConfirmPassword())) {
    //            redirectAttributes.addFlashAttribute("registrationBindingModel", registrationBindingModel);
    //            redirectAttributes.addFlashAttribute("passwordIsNotEqual", true);
    //            return "redirect:create";
    //        }
    //
    //
    //        userService.register
    //                (modelMapper.map(registrationBindingModel, UserRegistrationServiceModel.class));
    //
    //
    //        return "redirect:login";
    //
    //
    //    }
    //
    //
    //    @PostMapping("/login-error")
    //    public String failedLogin(@ModelAttribute("username")
    //                                      String username,
    //                              RedirectAttributes attributes) {
    //
    //        attributes.addFlashAttribute("username", username);
    //        attributes.addFlashAttribute("notLogged", true);
    //        return "redirect:login";
    //
    //
    //    }
}
