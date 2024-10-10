package com.springBootApi.SpringBootApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<String> studentNotFoundException(StudentNotFoundException ex){
        String message=ex.getMessage();
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> methodArgumentNotValidException(MethodArgumentNotValidException ex){
        Map<String,String > errors=new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(e->{
            String message=e.getDefaultMessage();
            String error=e.getField();
            errors.put(error,message);

        });
        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }
}
