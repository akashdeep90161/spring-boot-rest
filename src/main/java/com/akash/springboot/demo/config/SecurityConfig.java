package com.akash.springboot.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    @Override
    protected UserDetailsService userDetailsService()
    {
        PasswordEncoder passwordEncoder= PasswordEncoderFactories.createDelegatingPasswordEncoder();
        User.UserBuilder userBuilder=User.builder().passwordEncoder(passwordEncoder::encode); // I am getting default encoder
        UserDetails user1=userBuilder
                .username("user1")
                .password("12345")
                .roles("USER")
                .build();
        UserDetails user2=userBuilder
                .username("user2")
                .password("12345")
                .roles("USER","ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user1,user2);
    }
}
