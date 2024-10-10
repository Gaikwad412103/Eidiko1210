package com.restApi.SpringBootRestApi.exception;

public class RecordExistException extends Exception{
    public RecordExistException(String message){
        super(message);
    }
}
