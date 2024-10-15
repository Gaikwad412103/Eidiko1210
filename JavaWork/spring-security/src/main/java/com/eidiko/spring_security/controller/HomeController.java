package com.eidiko.spring_security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/home")
    public ResponseEntity<String> home(){
        return ResponseEntity.ok("Welcome To The Home Page!!!");
    }
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public ResponseEntity<String> users(){
        return ResponseEntity.ok("Hello User!!");
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public ResponseEntity<String> admin(){
        return ResponseEntity.ok("Hello Admin!!");
    }
}
