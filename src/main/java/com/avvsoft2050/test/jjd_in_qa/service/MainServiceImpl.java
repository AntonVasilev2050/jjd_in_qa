package com.avvsoft2050.test.jjd_in_qa.service;


import com.avvsoft2050.test.jjd_in_qa.dao.MessageDAO;
import com.avvsoft2050.test.jjd_in_qa.dao.UserDAO;
import com.avvsoft2050.test.jjd_in_qa.entity.Message;
import com.avvsoft2050.test.jjd_in_qa.entity.User;
import com.avvsoft2050.test.jjd_in_qa.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.List;

import static org.springframework.util.StringUtils.hasText;

@Service
public class MainServiceImpl implements MainService {
    public static final String AUTHORIZATION = "Authorization";

    @Autowired
    private JwtProvider jwtProvider;

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
    public List<Message> getLastMessages() {
        return messageDAO.getLastMessages();
    }

    @Override
    public boolean tokenIsValid(HttpServletRequest request) {
        String bearer = request.getHeader(AUTHORIZATION);
        String token = null;
        if (hasText(bearer) && bearer.startsWith("Bearer ")) {
            token = bearer.substring(7);
        } else {
            System.out.println("token is missing");
        }
        return token != null && jwtProvider.validateToken(token);
    }
}
