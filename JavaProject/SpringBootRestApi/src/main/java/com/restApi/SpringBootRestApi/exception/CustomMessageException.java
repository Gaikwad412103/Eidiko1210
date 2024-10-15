package com.restApi.SpringBootRestApi.exception;

public class CustomMessageException extends Exception{
    public CustomMessageException(String message){
        super(message);
    }
}
