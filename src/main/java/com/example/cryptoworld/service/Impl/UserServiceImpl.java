package com.example.cryptoworld.service.Impl;

import com.example.cryptoworld.models.entities.UserEntity;
import com.example.cryptoworld.models.enums.EnumRole;
import com.example.cryptoworld.models.service.UserRegistrationServiceModel;
import com.example.cryptoworld.repository.RoleRepository;
import com.example.cryptoworld.repository.UserRepository;
import com.example.cryptoworld.service.RoleService;
import com.example.cryptoworld.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final CryptoWorldUserService cryptoWorldUserService;
    private final RoleService roleService;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, RoleRepository roleRepository, CryptoWorldUserService cryptoWorldUserService, RoleService roleService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.cryptoWorldUserService = cryptoWorldUserService;
        this.roleService = roleService;
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
            userEntity.addRole(roleService.getRole(EnumRole.ADMIN.name()));
        } else {
            userEntity.addRole(roleService.getRole(EnumRole.USER.name()));
        }

        userRepository.save(userEntity);

    }


}
