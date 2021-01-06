package com.example.demo.spboot.service.impl;

import com.example.demo.spboot.dao.UserMapper;
import com.example.demo.spboot.domain.User;
import com.example.demo.spboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public List<User>  query(String aac002) {
        return userMapper.query(aac002);
    }
}
