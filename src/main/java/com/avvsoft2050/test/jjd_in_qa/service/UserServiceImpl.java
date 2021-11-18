package com.avvsoft2050.test.jjd_in_qa.service;


import com.avvsoft2050.test.jjd_in_qa.dao.UserDAO;
import com.avvsoft2050.test.jjd_in_qa.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public User getUser(String username, String password) {
        return userDAO.getUser(username, password);
    }
}
