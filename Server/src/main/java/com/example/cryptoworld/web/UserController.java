package com.example.cryptoworld.web;


import com.example.cryptoworld.models.dto.*;
import com.example.cryptoworld.models.entities.UserEntity;
import com.example.cryptoworld.models.entities.WalletEntity;
import com.example.cryptoworld.models.service.UserRegistrationServiceModel;
import com.example.cryptoworld.service.LoginService;
import com.example.cryptoworld.service.UserService;
import com.example.cryptoworld.service.WalletService;
import com.example.cryptoworld.utils.CustomMessage;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Security;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
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
    public ResponseEntity<CustomMessage> authenticateUser(@RequestBody LoginDto loginDto) {

        CustomMessage customMessage = new CustomMessage();
        customMessage.setMessage("User is logged.");

        try {

            Authentication authentication =
                    authenticationManager
                            .authenticate
                                    (new UsernamePasswordAuthenticationToken
                                            (loginDto.getUsername(), loginDto.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            loginService.setUserLoginInDb(loginDto.getUsername(), true);

        } catch (Exception e){

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }


        return new ResponseEntity<CustomMessage>(customMessage, HttpStatus.OK);

    }

    @GetMapping("/wallet")
    public ResponseEntity<WalletEntity> getUserWallet(@RequestBody LoginCheckDto loginCheckDto) {

        UserEntity user = userService.findByUsername(loginCheckDto.getUsername());
        WalletEntity wallet = walletService.getUserWallet(loginCheckDto.getUsername());

        if (!user.isLogged()) {
            return new ResponseEntity<>(wallet, HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(wallet, HttpStatus.OK);
    }


    @PostMapping("/username/check")
    public ResponseEntity<CustomMessage> findIfUsernameIsTaken(@RequestBody UsernameDto usernameDto) {

        if (userService.existByUsername(usernameDto.getUsername())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already exist.");
        }

        CustomMessage customMessage = new CustomMessage();
        customMessage.setMessage("Username is free.");


        return new ResponseEntity<CustomMessage>(customMessage, HttpStatus.OK);
    }

    @PostMapping("/email/check")
    public ResponseEntity<CustomMessage> findIfEmailIsTaken(@RequestBody EmailDto emailDto) {

        if (userService.existByEmail(emailDto.getEmail())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "This email is used by another person");
        }

        CustomMessage customMessage = new CustomMessage();
        customMessage.setMessage("Email is free.");


        return new ResponseEntity<CustomMessage>(customMessage, HttpStatus.OK);
    }


    @PostMapping("/register")
    public ResponseEntity<CustomMessage> createUserAccount(@RequestBody UserRegistrationDto userRegistrationDto) {

        CustomMessage customMessage = new CustomMessage();
        customMessage.setMessage("New user added.");

        try {
            userService.register
                    (modelMapper.map(userRegistrationDto, UserRegistrationServiceModel.class));
        } catch (Exception e) {

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

        return new ResponseEntity<CustomMessage>(customMessage, HttpStatus.OK);

    }


    @PostMapping("/logout")
    ResponseEntity<CustomMessage> logout (@RequestBody LogoutDto logoutDto){

        CustomMessage customMessage = new CustomMessage();
        customMessage.setMessage("Logout success.");


        try{
            SecurityContextHolder.getContext().getAuthentication().setAuthenticated(false);
            loginService.setUserLoginInDb(logoutDto.getUsername(), true);

        }catch (Exception e){

        }

        return new ResponseEntity<CustomMessage>(customMessage, HttpStatus.OK);
    }

}
