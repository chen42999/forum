package com.example.demo.repository;

import com.example.demo.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserMapper {
    int selectByUsernameCount(String username);
    int addUser(User user);
    User selectByUsername(String username);
}
