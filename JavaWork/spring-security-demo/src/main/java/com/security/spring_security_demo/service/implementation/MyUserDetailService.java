package com.security.spring_security_demo.service.implementation;

import com.security.spring_security_demo.entities.MyUser;
import com.security.spring_security_demo.repositories.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private MyUserRepository myUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MyUser> user=myUserRepository.findByUserName(username);

        if(user.isPresent()){
            MyUser myUser=user.get();
            return User.builder()
                    .username(myUser.getUserName())
                    .password(myUser.getPassword())
                    .roles(getRoles(myUser))
                    .build();
        }
        else{
            throw new UsernameNotFoundException(username);
        }

    }

    private String[] getRoles(MyUser myUser) {
        if(myUser.getRoles()==null){
            return new String[]{"USER"};
        }
        return myUser.getRoles().split(",");
    }
}
