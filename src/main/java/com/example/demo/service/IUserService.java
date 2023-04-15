package com.example.demo.service;

import com.example.demo.bean.User;

public interface IUserService {

    int selectByUsernameCount(String username);
    int addUser(User user);
    User selectByUsername(String username);
}
