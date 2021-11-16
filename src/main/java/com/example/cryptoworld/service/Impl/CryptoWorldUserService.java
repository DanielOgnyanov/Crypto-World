package com.example.cryptoworld.service.Impl;

import com.example.cryptoworld.models.entities.UserEntity;
import com.example.cryptoworld.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CryptoWorldUserService implements UserDetailsService {


    private final UserRepository userRepository;

    public CryptoWorldUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        UserEntity userEntity = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with name " + username + " was not found!"));


        return null;
    }
}
