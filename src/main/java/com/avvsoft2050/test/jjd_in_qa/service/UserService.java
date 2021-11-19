package com.avvsoft2050.test.jjd_in_qa.service;

import com.avvsoft2050.test.jjd_in_qa.entity.User;

import java.util.List;

public interface UserService {
    User getUserById(int id);

    List<User> getAllUsers();

    User getUser(String username, String password);
}
