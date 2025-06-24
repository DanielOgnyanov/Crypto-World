package com.example.cryptoworld.service.Impl;

import com.example.cryptoworld.models.entities.CreditCardEntity;
import com.example.cryptoworld.models.entities.UserEntity;
import com.example.cryptoworld.models.service.AddCreditCardServiceModel;
import com.example.cryptoworld.models.view.CreditCardViewModel;
import com.example.cryptoworld.models.view.UserByCardBalanceView;
import com.example.cryptoworld.repository.CreditCardRepository;
import com.example.cryptoworld.repository.UserRepository;
import com.example.cryptoworld.service.CreditCartService;
import com.example.cryptoworld.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreditCardServiceImpl implements CreditCartService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CreditCardRepository creditCardRepository;
    private final UserService userService;

    public CreditCardServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CreditCardRepository creditCardRepository, UserService userService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.creditCardRepository = creditCardRepository;
        this.userService = userService;
    }


    @Override
    public void addCreditCard(AddCreditCardServiceModel addCreditCardServiceModel) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        UserEntity userEntity = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + username));

        CreditCardEntity cardEntity = new CreditCardEntity();
        cardEntity.setBalance(addCreditCardServiceModel.getBalance());
        cardEntity.setIban(addCreditCardServiceModel.getIban());
        cardEntity.setTypeCard(addCreditCardServiceModel.getTypeCard());
        cardEntity.setOwner(userEntity);

        // Parse expiration year from "YYYY-MM" string
        String expirationDate = addCreditCardServiceModel.getExpirationDate(); // e.g. "2027-12"
        if (expirationDate != null && expirationDate.matches("^20\\d{2}-[01]\\d$")) {
            try {
                int expirationYear = Integer.parseInt(expirationDate.substring(0, 4));
                cardEntity.setExpirationYear(expirationYear);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid expiration year format: " + expirationDate);
            }
        } else {
            throw new IllegalArgumentException("Expiration date must be in format YYYY-MM");
        }

        creditCardRepository.save(cardEntity);
    }


    @Override
    public CreditCardEntity getByOwner(String owner) {
        return creditCardRepository.findByOwner(owner);
    }

    @Override
    public List<CreditCardViewModel> getCardByOwner() {

        String username = userService.checkUsernameOfLoggedUser();

        return creditCardRepository
                .getCardByOwner(username)
                .stream()
                .map(card -> modelMapper.map(card, CreditCardViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserByCardBalanceView> getAllUserOrderedByBalance() {
        return creditCardRepository
                .getAllCardOrderedByBalance()
                .stream()
                .map(card -> modelMapper.map(card, UserByCardBalanceView.class))
                .collect(Collectors.toList());
    }


}
