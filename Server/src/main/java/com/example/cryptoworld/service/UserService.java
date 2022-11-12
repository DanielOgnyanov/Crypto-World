package com.example.cryptoworld.service;

import com.example.cryptoworld.models.dto.ChangeRoleBindingModel;
import com.example.cryptoworld.models.entities.UserEntity;
import com.example.cryptoworld.models.service.UserRegistrationServiceModel;
import com.example.cryptoworld.models.view.UserView;

import java.util.List;

public interface UserService {
    void initializeUsers();

    boolean existByUsername(String username);

    boolean existByEmail(String email);

    void register(UserRegistrationServiceModel userRegistrationServiceModel);

    UserEntity findByUsername(String username);


    boolean creditCardCheckIfIsPresent(String usernameConfirm);

    String checkUsernameOfLoggedUser();

    boolean checkIfUserHasRoleOrNot(ChangeRoleBindingModel changeRoleBindingModel);


    List<UserView> getAllUsersOrderedByUsername();
}
