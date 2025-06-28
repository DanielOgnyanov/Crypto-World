package com.example.cryptoworld.config;

import com.example.cryptoworld.service.Impl.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final CustomUserDetailsService userDetailsService;
    private final JwtTokenProvider jwtTokenProvider;

    public ApplicationSecurityConfiguration(PasswordEncoder passwordEncoder,
                                            CustomUserDetailsService userDetailsService,
                                            JwtTokenProvider jwtTokenProvider) {
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter(jwtTokenProvider, userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
                // Public endpoints
                .antMatchers("/api/user/login").permitAll()
                .antMatchers("/api/user/register").permitAll()
                .antMatchers("/api/user/username/check").permitAll()
                .antMatchers("/api/user/email/check").permitAll()
                .antMatchers("/api/home/cryptoPrice").permitAll()
                .antMatchers("/api/index/popular/crypto").permitAll()
                .antMatchers("/api/crypto/marketCap4Hour").permitAll()
                .antMatchers("/api/crypto/marketCapDifferenceInPercentage").permitAll()
                .antMatchers("/api/crypto/prices").permitAll()
                .antMatchers("/api/price/history/list").permitAll()
                .antMatchers("/api/crypto/logos").permitAll()


                .antMatchers("/css/**", "/js/**", "/images/**").permitAll()


                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()


                .antMatchers("/api/user/logout").permitAll()


                .antMatchers("/card/add").permitAll()

                .antMatchers("/api/admin/logged").permitAll()


                .anyRequest().authenticated();

        // Add JWT filter before Spring Security's UsernamePasswordAuthenticationFilter
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedOrigins("*")
                        .allowedHeaders("*");
            }
        };
    }
}
