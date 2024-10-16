package com.xxxd.community.service;

import com.xxxd.community.dao.UserMapper;
import com.xxxd.community.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserById(int id) {
        return userMapper.selectById(id);
    }

}
