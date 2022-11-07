package com.example.cryptoworld.service.Impl;

import com.example.cryptoworld.models.binding.ChangeRoleBindingModel;
import com.example.cryptoworld.models.entities.RoleEntity;
import com.example.cryptoworld.models.entities.UserEntity;
import com.example.cryptoworld.models.entities.WalletEntity;
import com.example.cryptoworld.models.enums.EnumCountry;
import com.example.cryptoworld.models.enums.EnumRole;
import com.example.cryptoworld.models.service.UserRegistrationServiceModel;
import com.example.cryptoworld.models.view.UserView;
import com.example.cryptoworld.repository.RoleRepository;
import com.example.cryptoworld.repository.UserRepository;
import com.example.cryptoworld.repository.WalletRepository;
import com.example.cryptoworld.service.CountryService;
import com.example.cryptoworld.service.LoginService;
import com.example.cryptoworld.service.RoleService;
import com.example.cryptoworld.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final CryptoWorldUserService cryptoWorldUserService;
    private final RoleService roleService;
    private final CountryService countryService;
    private final WalletRepository walletRepository;
    private final LoginService loginService;

    public UserServiceImpl(UserRepository userRepository,
                           ModelMapper modelMapper,
                           PasswordEncoder passwordEncoder,
                           RoleRepository roleRepository,
                           CryptoWorldUserService cryptoWorldUserService, RoleService roleService,
                           CountryService countryService, WalletRepository walletRepository, LoginService loginService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.cryptoWorldUserService = cryptoWorldUserService;

        this.roleService = roleService;
        this.countryService = countryService;
        this.walletRepository = walletRepository;
        this.loginService = loginService;
    }


    @Override
    public boolean existByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean existByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public void register(UserRegistrationServiceModel userRegistrationServiceModel) {

        // User init

        RoleEntity userRole = roleRepository.findByRole(EnumRole.USER).orElse(null);

        UserEntity userEntity = modelMapper.map(userRegistrationServiceModel, UserEntity.class);

        userEntity.setPassword(passwordEncoder.encode(userRegistrationServiceModel.getPassword()));


        userEntity.addRole(userRole);


        userEntity.setCountry(userRegistrationServiceModel.getCountry());

        userEntity.setWalletAddress(generateWalletAddress());

        userRepository.save(userEntity);


        // wallet init


        WalletEntity  walletInitWhenUserRegister = new WalletEntity();

        walletInitWhenUserRegister.setOwner(userEntity);
        walletInitWhenUserRegister.setUsername(userEntity.getUsername());


        walletRepository.save(walletInitWhenUserRegister);


        loginService.setUserLoginInDb(userEntity.getUsername(), true);

    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public boolean creditCardCheckIfIsPresent(String usernameConfirm) {

        UserEntity userEntity =
                userRepository.findByUsername(usernameConfirm).orElse(null);



       if (userEntity.getCard().size() == 0 || userEntity.getCard() == null){
           return false;
       }

        return true;
    }

    @Override
    public String checkUsernameOfLoggedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();
        return username;
    }

    @Override
    public boolean checkIfUserHasRoleOrNot(ChangeRoleBindingModel changeRoleBindingModel) {

        UserEntity userEntity =
                userRepository.findByUsername(changeRoleBindingModel.getUsername()).orElse(null);

        RoleEntity roleEntity = roleService.getRole(1L);


        for (RoleEntity role : userEntity.getRoles()) {
            if(role.getRole().name().equals("ADMIN")) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<UserView> getAllUsersOrderedByUsername() {
        return userRepository
                .findAllOrderedByUsername()
                .stream()
                .map(user -> modelMapper.map(user, UserView.class))
                .collect(Collectors.toList());
    }


    private String generateWalletAddress() {

        String allChar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom random = new SecureRandom();
        int lenAddress = 20;
        StringBuilder sb = new StringBuilder(lenAddress);

        for (int i = 0; i < lenAddress; i++) {
            sb.append(allChar.charAt(random.nextInt(allChar.length())));
        }

        return sb.toString();
    }


    public void initializeUsers() {
        if (userRepository.count() == 0) {

            RoleEntity adminRole = roleRepository.findByRole(EnumRole.ADMIN).orElse(null);
            RoleEntity userRole = roleRepository.findByRole(EnumRole.USER).orElse(null);

            UserEntity admin = new UserEntity();


            admin.setUsername("admin");
            admin.setFullName("Admin Adminov");
            admin.setPassword(passwordEncoder.encode("test_2021"));
            admin.setEmail("admin@test.bg");
            admin.setCountry(EnumCountry.Bulgaria);
            admin.setRoles(List.of(adminRole, userRole));
            admin.setWalletAddress("test");
            admin.setDepositSet(null);

            userRepository.save(admin);

            WalletEntity adminWallet = new WalletEntity();

            adminWallet.setOwner(admin);
            adminWallet.setUsername(admin.getUsername());

            walletRepository.save(adminWallet);

            UserEntity user = new UserEntity();

            user.setUsername("ivan");
            user.setFullName("Ivan Cekov");
            user.setPassword(passwordEncoder.encode("12345"));
            user.setEmail("ivan@a.bg");
            user.setCountry(EnumCountry.Bulgaria);
            user.setRoles(List.of(userRole));
            user.setWalletAddress(generateWalletAddress());
            user.setDepositSet(new ArrayList<>());

            userRepository.save(user);

            WalletEntity userWallet = new WalletEntity();

            userWallet.setOwner(user);
            userWallet.setUsername(user.getUsername());

            walletRepository.save(userWallet);
        }
    }
}
