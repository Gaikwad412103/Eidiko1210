package com.restApi.SpringBootRestApi.service;

import com.restApi.SpringBootRestApi.dto.UserDto;
import com.restApi.SpringBootRestApi.dto.Userlogin;
import com.restApi.SpringBootRestApi.entity.User;
import com.restApi.SpringBootRestApi.exception.RecordExistException;
import com.restApi.SpringBootRestApi.exception.UserNotFoundException;

public interface UserService {



    public UserDto registerUser(UserDto userDto) throws RecordExistException;

    public UserDto login(Userlogin user) throws UserNotFoundException;
}
