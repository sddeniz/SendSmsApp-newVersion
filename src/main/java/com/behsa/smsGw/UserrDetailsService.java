package com.behsa.smsGw;

import com.behsa.smsGw.Entity.UserLogin;
import com.behsa.smsGw.Repository.UserRepository;
import com.behsa.smsGw.Repository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserrDetailsService implements UserDetailsService {

    @Autowired
    private UserRepositoryImpl userRepository;
    @Autowired
    private PasswordEncoder bcryptEncoder;


    public UserDetails loadUserByUserpass(String username,String password) throws UsernameNotFoundException {

      UserLogin  user = userRepository.findByUserPass(username,password);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getP_USERNAME(), user.getP_PASSWORD(),
                new ArrayList<>());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
