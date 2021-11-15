package com.example.cryptoworld.service.Impl;

import com.example.cryptoworld.models.service.UserRegistrationServiceModel;
import com.example.cryptoworld.repository.UserRepository;
import com.example.cryptoworld.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public boolean userNameExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    @Override
    public void registerAndLoginUser(UserRegistrationServiceModel serviceModel) {

    }
}
