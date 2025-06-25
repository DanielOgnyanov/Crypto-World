package com.example.cryptoworld.web;

import com.example.cryptoworld.models.dto.LogDepositBindingModel;
import com.example.cryptoworld.models.entities.UserEntity;
import com.example.cryptoworld.models.service.LogDepositServiceModel;
import com.example.cryptoworld.service.CreditCartService;
import com.example.cryptoworld.service.LogDepositService;
import com.example.cryptoworld.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/api/deposit")
public class LogDepositController {

    private final ModelMapper modelMapper;
    private final LogDepositService logDepositService;
    private final UserService userService;
    private final CreditCartService creditCartService;

    public LogDepositController(ModelMapper modelMapper,
                                LogDepositService logDepositService,
                                UserService userService,
                                CreditCartService creditCartService) {
        this.modelMapper = modelMapper;
        this.logDepositService = logDepositService;
        this.userService = userService;
        this.creditCartService = creditCartService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addDeposit(@Valid @RequestBody LogDepositBindingModel logDepositBindingModel,
                                        BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity
                    .badRequest()
                    .body(Map.of("error", "Validation failed.", "details", bindingResult.getAllErrors()));
        }

        String requestedUsername = logDepositBindingModel.getUsernameConfirm();
        String loggedUsername = userService.checkUsernameOfLoggedUser();

        // Check if user exists
        if (!userService.existByUsername(requestedUsername)) {
            return ResponseEntity
                    .badRequest()
                    .body(Map.of("error", "User does not exist."));
        }

        // Check if it's the logged-in user
        if (!requestedUsername.equals(loggedUsername)) {
            return ResponseEntity
                    .badRequest()
                    .body(Map.of("error", "You can only deposit to your own account."));
        }

        // Check if user has a credit card
        if (!userService.creditCardCheckIfIsPresent(requestedUsername)) {
            return ResponseEntity
                    .badRequest()
                    .body(Map.of("error", "User does not have a credit card."));
        }

        // Check if balance is enough
        UserEntity userEntity = userService.findByUsername(requestedUsername);
        BigDecimal cardBalance = userEntity.getCard().get(0).getBalance();

        if (cardBalance.compareTo(BigDecimal.valueOf(logDepositBindingModel.getDeposit())) < 0) {
            return ResponseEntity
                    .badRequest()
                    .body(Map.of("error", "Insufficient credit card balance."));
        }

        // Proceed with deposit
        LogDepositServiceModel serviceModel =
                modelMapper.map(logDepositBindingModel, LogDepositServiceModel.class);

        logDepositService.addLogDeposit(serviceModel);

        return ResponseEntity
                .ok(Map.of("message", "Deposit successful."));
    }
}
