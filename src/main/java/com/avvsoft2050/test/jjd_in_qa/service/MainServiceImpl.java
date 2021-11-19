package com.avvsoft2050.test.jjd_in_qa.service;


import com.avvsoft2050.test.jjd_in_qa.dao.MessageDAO;
import com.avvsoft2050.test.jjd_in_qa.dao.UserDAO;
import com.avvsoft2050.test.jjd_in_qa.entity.Message;
import com.avvsoft2050.test.jjd_in_qa.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MainServiceImpl implements MainService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private MessageDAO messageDAO;

    @Override
    @Transactional
    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    @Transactional
    public User getUser(String username, String password) {
        return userDAO.getUser(username, password);
    }

    @Override
    @Transactional
    public User getUserByName(String username) {
        return userDAO.getUserByName(username);
    }

    @Override
    @Transactional
    public void saveMessage(Message message) {
        messageDAO.saveMessage(message);
    }

    @Override
    @Transactional
    public List<Message> getLastMessages(int number) {
        return null;
    }
}
