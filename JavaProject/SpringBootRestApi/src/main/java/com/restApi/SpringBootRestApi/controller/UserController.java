package com.restApi.SpringBootRestApi.controller;

import com.restApi.SpringBootRestApi.dto.UserDto;
import com.restApi.SpringBootRestApi.dto.Userlogin;
import com.restApi.SpringBootRestApi.entity.User;
import com.restApi.SpringBootRestApi.exception.RecordExistException;
import com.restApi.SpringBootRestApi.exception.UserNotFoundException;
import com.restApi.SpringBootRestApi.service.UserService;
import com.restApi.SpringBootRestApi.service.implementation.JwtService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody @Valid User user) throws RecordExistException {
        UserDto saveUser=userService.registerUser(user);
        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
    }
    @GetMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody Userlogin user) throws UserNotFoundException {
        try {
            // Authenticate the user with the provided email and password
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
            );

            // If authentication is successful, generate the JWT token
            String token = jwtService.generateToken(user.getEmail());

            // Retrieve user details (this could also be part of the UserService)
            UserDto userDto = userService.login(user);
            userDto.setToken(token); // Add the token to the UserDto

            return new ResponseEntity<>(userDto, HttpStatus.ACCEPTED);
        } catch (BadCredentialsException e) {
            // Handle incorrect credentials
            throw new UsernameNotFoundException("Invalid email or password!");
        } catch (Exception e) {
            // Handle any other exceptions that might occur
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
