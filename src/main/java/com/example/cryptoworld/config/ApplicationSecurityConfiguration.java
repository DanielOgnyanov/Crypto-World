package com.example.cryptoworld.config;


import com.example.cryptoworld.models.enums.EnumRole;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

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

                .antMatchers("/", "/users/sign", "/users/create").permitAll()
                .antMatchers("/admin/general").hasRole(EnumRole.ADMIN.name())
                .antMatchers("/**").authenticated()
                .and()
                .formLogin()
                .loginPage("/users/login")
                .usernameParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY)
                .passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY)
                .defaultSuccessUrl("/")
                .failureForwardUrl("/users/login-error")
                .and()
                .logout()
                .logoutUrl("/users/logout")
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");


    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.
                userDetailsService(userDetailsService).
                passwordEncoder(passwordEncoder);

    }
}
