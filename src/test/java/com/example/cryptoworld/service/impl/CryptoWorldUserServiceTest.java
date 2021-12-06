package com.example.cryptoworld.service.impl;

import com.example.cryptoworld.models.entities.RoleEntity;
import com.example.cryptoworld.models.entities.UserEntity;
import com.example.cryptoworld.models.enums.EnumRole;
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
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

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


    @Test
    void testExistingUser() {

        UserEntity userEntity = new UserEntity();

        userEntity.setUsername("Check");
        userEntity.setPassword("12345");

        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRole(EnumRole.USER);

        userEntity.setRoles(List.of(roleEntity));


        Mockito.when(userRepository.findByUsername("Check")).thenReturn(Optional.of(userEntity));


        UserDetails userDetails = cryptoWorldUserService.loadUserByUsername("Check");


        Assertions.assertEquals(userEntity.getUsername(), userDetails.getUsername());


    }

}
