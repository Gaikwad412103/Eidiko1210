package com.restApi.SpringBootRestApi.exception;

public class UserNotFoundException extends  Exception {
    public UserNotFoundException(String message){
        super(message);
    }
}
