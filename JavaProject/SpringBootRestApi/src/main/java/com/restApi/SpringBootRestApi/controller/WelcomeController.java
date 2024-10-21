package com.restApi.SpringBootRestApi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/home/welcome")
    public String welcome(){
        return "This Is A Welcome Page!!";
    }
}
