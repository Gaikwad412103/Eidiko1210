package com.restApi.SpringBootRestApi.controller;

import com.restApi.SpringBootRestApi.dto.UserDto;
import com.restApi.SpringBootRestApi.dto.Userlogin;
import com.restApi.SpringBootRestApi.entity.User;
import com.restApi.SpringBootRestApi.exception.RecordExistException;
import com.restApi.SpringBootRestApi.exception.UserNotFoundException;
import com.restApi.SpringBootRestApi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody @Valid UserDto userDto) throws RecordExistException {
        return new ResponseEntity<>(userService.registerUser(userDto), HttpStatus.CREATED);
    }
    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestBody Userlogin user) throws UserNotFoundException {
        boolean status=userService.login(user);
        if(status){
            return ResponseEntity.ok("Login SuccessFully");
        }
        return new ResponseEntity<>("Enter Valid Login Details",HttpStatus.NOT_ACCEPTABLE);
    }
}
