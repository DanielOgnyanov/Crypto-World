package com.example.cryptoworld.web;

import com.example.cryptoworld.models.dto.SellCryptoBindingModel;
import com.example.cryptoworld.models.service.SellCryptoServiceModel;
import com.example.cryptoworld.service.CreditCartService;
import com.example.cryptoworld.service.LogSellService;
import com.example.cryptoworld.service.UserService;
import com.example.cryptoworld.service.WalletService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/sell")
public class LogSellController {

    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CreditCartService creditCartService;
    private final LogSellService logSellService;
    private final WalletService walletService;

    public LogSellController(ModelMapper modelMapper,
                             UserService userService,
                             CreditCartService creditCartService,
                             LogSellService logSellService,
                             WalletService walletService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.creditCartService = creditCartService;
        this.logSellService = logSellService;
        this.walletService = walletService;
    }

    @PostMapping("/execute")
    public ResponseEntity<?> sellCrypto(@RequestBody @Valid SellCryptoBindingModel sellCryptoBindingModel,
                                        BindingResult bindingResult) {

        Map<String, Object> response = new HashMap<>();

        if (bindingResult.hasErrors()) {
            response.put("status", "error");
            response.put("message", "Validation failed");
            response.put("errors", bindingResult.getAllErrors());
            return ResponseEntity.badRequest().body(response);
        }

        String username = sellCryptoBindingModel.getUsernameConfirm();

        // Check if user exists
        if (!userService.existByUsername(username)) {
            response.put("status", "error");
            response.put("message", "User does not exist");
            return ResponseEntity.badRequest().body(response);
        }

        // Check if logged user matches
        if (!username.equals(userService.checkUsernameOfLoggedUser())) {
            response.put("status", "error");
            response.put("message", "Username confirmation mismatch");
            return ResponseEntity.badRequest().body(response);
        }

        // Check if wallet exists
        if (!walletService.findUsersWallet(username)) {
            response.put("status", "error");
            response.put("message", "User wallet not found");
            return ResponseEntity.badRequest().body(response);
        }

        // Check if sell amount is available
        double availableValue = walletService.sellValueCheck(username, sellCryptoBindingModel.getCrypto().name());
        if (availableValue < sellCryptoBindingModel.getSellValue()) {
            response.put("status", "error");
            response.put("message", "Insufficient crypto amount");
            return ResponseEntity.badRequest().body(response);
        }

        // Proceed with sell and save to DB
        SellCryptoServiceModel serviceModel = modelMapper.map(sellCryptoBindingModel, SellCryptoServiceModel.class);
        logSellService.sellLog(serviceModel);  // Logs sell and should update wallet/db

        response.put("status", "success");
        response.put("message", "Sell completed successfully");
        response.put("sellData", serviceModel);

        return ResponseEntity.ok(response);
    }
}
