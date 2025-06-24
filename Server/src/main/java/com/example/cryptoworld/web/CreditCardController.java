package com.example.cryptoworld.web;

import com.example.cryptoworld.models.dto.AddCreditCardBindingModel;
import com.example.cryptoworld.models.service.AddCreditCardServiceModel;
import com.example.cryptoworld.service.CreditCartService;
import com.example.cryptoworld.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/card")
public class CreditCardController {

    private final ModelMapper modelMapper;
    private final CreditCartService creditCartService;
    private final UserService userService;

    public CreditCardController(ModelMapper modelMapper, CreditCartService creditCartService, UserService userService) {
        this.modelMapper = modelMapper;
        this.creditCartService = creditCartService;
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCardFromFrontend(
            @Valid @RequestBody AddCreditCardBindingModel addCreditCardBindingModel,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity
                    .badRequest()
                    .body(Map.of("error", "Invalid card data."));
        }

        String username = userService.checkUsernameOfLoggedUser();

        if (userService.creditCardCheckIfIsPresent(username)) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(Map.of("error", "User already has a credit card."));
        }

        AddCreditCardServiceModel serviceModel =
                modelMapper.map(addCreditCardBindingModel, AddCreditCardServiceModel.class);

        creditCartService.addCreditCard(serviceModel);

        return ResponseEntity
                .ok(Map.of("message", "Card added successfully."));
    }

}
