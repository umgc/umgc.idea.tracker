package com.example.projecttracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.projecttracker.model.Account;
import com.example.projecttracker.repository.AccountRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
 
    @Autowired
    private AccountRepository accountRepository;
 
    @Override
    public UserDetails loadUserByUsername(String username) {
    	Account user = accountRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserPrincipal(user);
    }
}
