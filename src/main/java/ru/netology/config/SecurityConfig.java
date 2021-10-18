package ru.netology.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        auth.inMemoryAuthentication()
            .withUser("user")
            .password(encoder.encode("password"))
            .roles("AUTHORIZED");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().and()
            .authorizeRequests().antMatchers("/persons/by-city").permitAll().and()
            .authorizeRequests().anyRequest().authenticated();
    }
}
