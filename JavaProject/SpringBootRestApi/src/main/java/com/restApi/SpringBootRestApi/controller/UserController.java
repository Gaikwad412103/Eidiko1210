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
    public ResponseEntity<UserDto> registerUser(@RequestBody @Valid UserDto userDto) throws RecordExistException {
        UserDto saveUser=userService.registerUser(userDto);
        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
    }
    @GetMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody Userlogin user) throws UserNotFoundException {
        UserDto userDto=userService.login(user);
        return new ResponseEntity<>(userDto,HttpStatus.ACCEPTED);
    }
}
