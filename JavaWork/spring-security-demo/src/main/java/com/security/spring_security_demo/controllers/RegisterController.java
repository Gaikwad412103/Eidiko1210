package com.security.spring_security_demo.controllers;

import com.security.spring_security_demo.entities.MyUser;
import com.security.spring_security_demo.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    @Autowired
    private MyUserService myUserService;
    @PostMapping("/register")
    public ResponseEntity<MyUser> register(@RequestBody MyUser user){
        MyUser user1=myUserService.register(user);
        return ResponseEntity.ok(user1);
    }
}
