package com.example.cryptoworld.service.Impl;

import com.example.cryptoworld.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {









    @Override
    public boolean userNameExists(String username) {
        return false;
    }
}
