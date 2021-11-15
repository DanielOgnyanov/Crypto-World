package com.example.cryptoworld.service.Impl;

import com.example.cryptoworld.models.entities.RoleEntity;
import com.example.cryptoworld.models.entities.UserEntity;
import com.example.cryptoworld.models.enums.EnumRole;
import com.example.cryptoworld.models.service.UserRegistrationServiceModel;
import com.example.cryptoworld.repository.RoleRepository;
import com.example.cryptoworld.repository.UserRepository;
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

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }


    @Override
    public boolean userNameExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    @Override
    public void registerAndLoginUser(UserRegistrationServiceModel serviceModel) {

        UserEntity currUser = modelMapper.map(serviceModel, UserEntity.class);

        currUser.setPassword(passwordEncoder.encode(serviceModel.getPassword()));


        RoleEntity roleUser = roleRepository
                .findByRole(EnumRole.USER).orElseThrow(
                        () -> new IllegalStateException("USER role not found. Please seed the roles."));



        currUser.addRole(roleUser);


        userRepository.save(currUser);





    }
}
