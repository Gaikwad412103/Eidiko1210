package com.restApi.SpringBootRestApi.controller;

import com.restApi.SpringBootRestApi.entity.User;
import com.restApi.SpringBootRestApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/register")
    public User registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }
    @GetMapping("/user/login")
    public String login(@RequestBody User user){
        boolean status=userService.login(user);
        if(status){
            return "Login SuccessFully";
        }
        return "Enter Valid Login Details";
    }
}
