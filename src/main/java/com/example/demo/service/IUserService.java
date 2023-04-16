package com.example.demo.service;

import com.example.demo.bean.Role;
import com.example.demo.bean.User;
import com.example.demo.bean.UserRole;

import java.util.List;

public interface IUserService {

    int selectByUsernameCount(String username);
    int addUser(User user);
    User selectByUsername(String username);
    List<UserRole> selectRoleIdByUserId(Integer userId);
    String selectRolesByRoleId(Integer roleId);
}
