package com.security.spring_security_demo.service.implementation;

import com.security.spring_security_demo.entities.MyUser;
import com.security.spring_security_demo.repositories.MyUserRepository;
import com.security.spring_security_demo.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserServiceImplementation implements MyUserService {
    @Autowired
    private MyUserRepository myUserRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public MyUser register(MyUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        myUserRepository.save(user);
        return user;
    }
}
