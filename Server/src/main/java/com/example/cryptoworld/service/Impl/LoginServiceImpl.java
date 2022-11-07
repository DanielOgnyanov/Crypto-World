package com.example.cryptoworld.service.Impl;

import com.example.cryptoworld.models.entities.UserEntity;
import com.example.cryptoworld.repository.UserRepository;
import com.example.cryptoworld.service.LoginService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    private final UserRepository userRepository;

    public LoginServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void setUserLoginInDb(String username) {

        Optional<UserEntity> currUserInfo = userRepository.findByUsername(username);


        currUserInfo.get().setLogged(true);


    }
}
