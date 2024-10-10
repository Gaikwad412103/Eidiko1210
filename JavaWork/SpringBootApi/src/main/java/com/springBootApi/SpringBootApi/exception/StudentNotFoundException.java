package com.springBootApi.SpringBootApi.exception;

public class StudentNotFoundException extends Exception{
    public StudentNotFoundException(long id){
        super("Student Not Present "+id);
    }
}
