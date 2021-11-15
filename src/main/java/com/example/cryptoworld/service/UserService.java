package com.example.cryptoworld.service;

import com.example.cryptoworld.models.service.UserRegistrationServiceModel;

public interface UserService {

    boolean userNameExists(String username);
    void registerAndLoginUser(UserRegistrationServiceModel serviceModel);
}
