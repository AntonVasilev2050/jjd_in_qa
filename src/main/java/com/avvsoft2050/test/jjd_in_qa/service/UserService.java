package com.avvsoft2050.test.jjd_in_qa.service;

import com.avvsoft2050.test.jjd_in_qa.entity.User;

public interface UserService {
    User getUser(String username, String password);
}
