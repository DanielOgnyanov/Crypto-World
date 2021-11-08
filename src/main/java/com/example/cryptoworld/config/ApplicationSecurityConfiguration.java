package com.example.cryptoworld.config;


import com.example.cryptoworld.models.enums.EnumRole;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {


    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;


    public ApplicationSecurityConfiguration(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()

                .antMatchers("/", "/users/login", "/users/register").permitAll()
                .antMatchers("/admin/general").hasRole(EnumRole.ADMIN.name())
                .antMatchers("/**").authenticated()
                .and()
                .formLogin()
                .loginPage("/users/login")
                .



    }
}
