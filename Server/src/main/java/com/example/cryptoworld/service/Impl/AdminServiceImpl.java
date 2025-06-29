package com.example.cryptoworld.service.Impl;

import com.example.cryptoworld.models.entities.RoleEntity;
import com.example.cryptoworld.models.entities.UserEntity;
import com.example.cryptoworld.models.service.ChangeRoleServiceModel;
import com.example.cryptoworld.repository.UserRepository;
import com.example.cryptoworld.service.AdminService;
import com.example.cryptoworld.service.RoleService;
import com.example.cryptoworld.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {


    private final UserService userService;
    private final UserRepository userRepository;
    private final RoleService roleService;

    public AdminServiceImpl(UserService userService, UserRepository userRepository, RoleService roleService) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.roleService = roleService;
    }


    @Override
    public void changeRole(ChangeRoleServiceModel changeRoleServiceModel) {

        UserEntity userEntity = userService.findByUsername(changeRoleServiceModel.getUsername());

        // Fetch the role entity by name
        RoleEntity roleEntity = roleService.findByRoleName(changeRoleServiceModel.getRoleName());

        if (roleEntity == null) {
            throw new IllegalArgumentException("Invalid role name: " + changeRoleServiceModel.getRoleName());
        }

        // Clear all current roles and assign the new one (if that's what you want)
        userEntity.getRoles().clear();
        userEntity.addRole(roleEntity);

        // Save the updated user
        userRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> getAllLoggedUser() {
        return userRepository.getLoggedUsers();
    }
}
