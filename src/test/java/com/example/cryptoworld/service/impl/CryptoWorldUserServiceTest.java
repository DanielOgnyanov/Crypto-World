package com.example.cryptoworld.service.impl;

import com.example.cryptoworld.repository.UserRepository;
import com.example.cryptoworld.service.Impl.CryptoWorldUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@ExtendWith(MockitoExtension.class)
public class CryptoWorldUserServiceTest {

    private CryptoWorldUserService cryptoWorldUserService;

    @Mock
    private UserRepository userRepository;


    @BeforeEach
    public void setUp() {

        cryptoWorldUserService = new CryptoWorldUserService(userRepository, new ModelMapper());
    }

    @Test
    void testUserNotFound() {
        Assertions.assertThrows(
                UsernameNotFoundException.class, () -> {
                    cryptoWorldUserService.loadUserByUsername("user_does_not_exits");
                }
        );
    }

}
