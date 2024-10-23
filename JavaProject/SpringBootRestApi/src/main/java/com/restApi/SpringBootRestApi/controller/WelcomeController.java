package com.restApi.SpringBootRestApi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @Operation(
            summary = "This Is A Home Page",
            description = "This Is A Welcome Page!!"
            )
    @ApiResponses(
            value = @ApiResponse(responseCode = "200", description = "successful operation")
    )
    @GetMapping("/home/welcome")
    public String welcome(){
        return "This Is A Welcome Page!!";
    }
}
