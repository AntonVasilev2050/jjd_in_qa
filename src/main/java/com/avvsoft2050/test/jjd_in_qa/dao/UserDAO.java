package com.avvsoft2050.test.jjd_in_qa.dao;

import com.avvsoft2050.test.jjd_in_qa.entity.User;

import java.util.List;

public interface UserDAO {
    User getUserById(int id);

    List<User> getAllUsers();

    User getUser(String username, String password);

    User getUserByName(String username);


}
