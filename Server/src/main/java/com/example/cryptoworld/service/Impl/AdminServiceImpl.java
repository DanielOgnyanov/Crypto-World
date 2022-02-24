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

        UserEntity userEntity =
                userService.findByUsername(changeRoleServiceModel.getUsername());

        RoleEntity roleEntity = roleService.getRole(1L);

        if (changeRoleServiceModel.getAddOrRemove().name().equals("ADD")) {
            userEntity.addRole(roleEntity);
            userRepository.save(userEntity);
        } else {
            for (RoleEntity role : userEntity.getRoles()) {
                if(role.getRole().name().equals("ADMIN")) {
                    userEntity.removeRole(role);
                    userRepository.save(userEntity);
                    return;
                }
            }

        }
    }

    @Override
    public List<UserEntity> getAllLoggedUser() {
        return null;
    }
}
