package com.restApi.SpringBootRestApi.service;

import com.restApi.SpringBootRestApi.entity.User;

public interface UserService {



    public User registerUser(User user);

    public boolean login(User user);
}
