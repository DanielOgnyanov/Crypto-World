package com.example.cryptoworld.service;

import com.example.cryptoworld.models.entities.UserEntity;
import com.example.cryptoworld.models.service.ChangeRoleServiceModel;

import java.util.List;

public interface AdminService {
    void changeRole(ChangeRoleServiceModel changeRoleServiceModel);

    List<UserEntity> getAllLoggedUser();
}
