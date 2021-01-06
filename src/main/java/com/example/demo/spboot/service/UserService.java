package com.example.demo.spboot.service;

import com.example.demo.spboot.domain.User;

import java.util.List;

public interface UserService {

    void insert(User user);

    List<User>  query(String aac001);
}
