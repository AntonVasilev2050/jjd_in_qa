package com.avvsoft2050.test.jjd_in_qa.dao;

import com.avvsoft2050.test.jjd_in_qa.entity.User;

public interface UserDAO {
    User getUser(String username, String password);


}
