package com.avvsoft2050.test.jjd_in_qa.service;

import com.avvsoft2050.test.jjd_in_qa.entity.Message;
import com.avvsoft2050.test.jjd_in_qa.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface MainService {
    User getUserById(int id);

    List<User> getAllUsers();

    User getUser(String username, String password);

    User getUserByName(String username);

    void saveMessage(Message message);

    List<Message> getLastMessages();

    boolean tokenIsValid(HttpServletRequest request);
}
