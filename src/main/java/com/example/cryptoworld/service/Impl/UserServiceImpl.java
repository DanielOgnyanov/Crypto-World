package com.example.cryptoworld.service.Impl;

import com.example.cryptoworld.models.entities.UserEntity;
import com.example.cryptoworld.models.enums.EnumCountry;
import com.example.cryptoworld.models.service.UserRegistrationServiceModel;
import com.example.cryptoworld.repository.RoleRepository;
import com.example.cryptoworld.repository.UserRepository;
import com.example.cryptoworld.service.CountryService;
import com.example.cryptoworld.service.RoleService;
import com.example.cryptoworld.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final CryptoWorldUserService cryptoWorldUserService;
    private final RoleService roleService;
    private final CountryService countryService;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, RoleRepository roleRepository, CryptoWorldUserService cryptoWorldUserService, RoleService roleService, CountryService countryService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.cryptoWorldUserService = cryptoWorldUserService;
        this.roleService = roleService;
        this.countryService = countryService;
    }


    @Override
    public boolean userNameExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    @Override
    public void register(UserRegistrationServiceModel userRegistrationServiceModel) {

        UserEntity userEntity = modelMapper.map(userRegistrationServiceModel , UserEntity.class);

        userEntity.setPassword(passwordEncoder.encode(userRegistrationServiceModel.getPassword()));


        if (userRepository.count() == 0) {
            userEntity.addRole(roleService.getRole(1L));
        } else {
            userEntity.addRole(roleService.getRole(2L));
        }


        userEntity
                .setCountry(countryService.getCountryByName
                (EnumCountry.valueOf(userRegistrationServiceModel.getCountry())));

        userRepository.save(userEntity);

    }
    
    
    private String generateWalletAddress() {

        String allChar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom random = new SecureRandom();
        int lenAddress = 10;
        StringBuilder sb = new StringBuilder(lenAddress);

        for (int i = 0; i < lenAddress; i++) {
            sb.append(allChar.charAt(random.nextInt(allChar.length())));
        }

        return sb.toString();
    }


}
