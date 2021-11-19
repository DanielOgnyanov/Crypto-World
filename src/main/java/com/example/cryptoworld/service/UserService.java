package com.example.cryptoworld.service;

import com.example.cryptoworld.models.entities.UserEntity;
import com.example.cryptoworld.models.service.UserRegistrationServiceModel;

public interface UserService {

    boolean existByUsername(String username);

    void register(UserRegistrationServiceModel userRegistrationServiceModel);
}
