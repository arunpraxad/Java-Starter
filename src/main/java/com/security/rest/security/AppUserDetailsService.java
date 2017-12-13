package com.security.rest.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component("UserDetailsService")
public class AppUserDetailsService implements UserDetailsService {

    AuthenticationManagerBuilder authenticationManagerBuilder;

    public AppUserDetailsService(AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return authenticationManagerBuilder.getDefaultUserDetailsService().loadUserByUsername("admin");
    }
}
