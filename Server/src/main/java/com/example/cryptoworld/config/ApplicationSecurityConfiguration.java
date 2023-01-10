package com.example.cryptoworld.config;


import com.example.cryptoworld.models.enums.EnumRole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {


    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;

    public ApplicationSecurityConfiguration(PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) {

        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors().disable();
        http.csrf().disable();
        http
                .authorizeRequests()
                .antMatchers("/api/user/login").permitAll()
                .antMatchers("/api/user/register").permitAll()
                .antMatchers("/api/user/username/check").permitAll()
                .antMatchers("/api/user/email/check").permitAll()
                .antMatchers("/api/home/cryptoPrice").permitAll()
                .antMatchers("/css/**","/js/**","/images/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();


    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.
                userDetailsService(userDetailsService).
                passwordEncoder(passwordEncoder);


    }


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public void addCorsMapping(CorsRegistry registry) {

        registry.addMapping()
    }


}
