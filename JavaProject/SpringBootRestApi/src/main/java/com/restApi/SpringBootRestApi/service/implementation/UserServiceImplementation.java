package com.restApi.SpringBootRestApi.service.implementation;

import com.restApi.SpringBootRestApi.entity.User;
import com.restApi.SpringBootRestApi.repository.UserRepository;
import com.restApi.SpringBootRestApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean login(User user) {
        Optional<User> user1 = userRepository.findById(user.getUserId());
        return user1.isPresent() && user1.get().getPassword().equals(user.getPassword());
    }

}
