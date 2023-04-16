package com.example.demo.repository;

import com.example.demo.bean.Role;
import com.example.demo.bean.User;
import com.example.demo.bean.UserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IUserMapper {
    int selectByUsernameCount(String username);
    int addUser(User user);
    User selectByUsername(String username);
    List<UserRole> selectRoleIdByUserId(Integer userId);
    String selectRolesByRoleId(Integer roleId);
}
