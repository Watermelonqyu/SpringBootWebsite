package com.example.springboot.services.impl;

import com.example.springboot.domain.AppUserDetails;
import com.example.springboot.domain.User;
import com.example.springboot.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
 * UserDetailsServiceImpl
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    /*
    * Logger
    */
    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    
    /*
    * userRepository
    */
    @Autowired
    private transient UserRepository userRepository;

    /*
    * loadUserByUsername
    */
    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found.");
        }
        log.info("loadUserByUsername() : {}", username);
        return new AppUserDetails(user);
    }
}
