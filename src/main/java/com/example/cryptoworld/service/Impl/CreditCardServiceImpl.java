package com.example.cryptoworld.service.Impl;

import com.example.cryptoworld.models.entities.CreditCardEntity;
import com.example.cryptoworld.models.entities.UserEntity;
import com.example.cryptoworld.models.service.AddCreditCardServiceModel;
import com.example.cryptoworld.models.view.CreditCardViewModel;
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


        UserEntity userEntity = userRepository.findByUsername(username).orElse(null);


        CreditCardEntity cardEntity = new CreditCardEntity();

        cardEntity.setBalance(addCreditCardServiceModel.getBalance());
        cardEntity.setExpirationYear(addCreditCardServiceModel.getExpirationYear());
        cardEntity.setIban(addCreditCardServiceModel.getIban());
        cardEntity.setTypeCard(addCreditCardServiceModel.getTypeCard());
        cardEntity.setOwner(userEntity);


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


}
