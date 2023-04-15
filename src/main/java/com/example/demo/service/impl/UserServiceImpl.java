package com.example.demo.service.impl;

import com.example.demo.bean.User;
import com.example.demo.repository.IUserMapper;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserMapper iUserMapper;

    @Override
    public int selectByUsernameCount(String username) {

        return iUserMapper.selectByUsernameCount(username);
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @Override
    public int addUser(User user) {
        return iUserMapper.addUser(user);
    }

    @Override
    public User selectByUsername(String username) {
        return iUserMapper.selectByUsername(username);
    }
}
