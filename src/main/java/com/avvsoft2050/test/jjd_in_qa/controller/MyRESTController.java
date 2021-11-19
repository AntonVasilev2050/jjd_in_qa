package com.avvsoft2050.test.jjd_in_qa.controller;

import com.avvsoft2050.test.jjd_in_qa.entity.Message;
import com.avvsoft2050.test.jjd_in_qa.pojo.MessageFromUser;
import com.avvsoft2050.test.jjd_in_qa.pojo.Token;
import com.avvsoft2050.test.jjd_in_qa.entity.User;
import com.avvsoft2050.test.jjd_in_qa.jwt.JwtProvider;
import com.avvsoft2050.test.jjd_in_qa.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.StringUtils.hasText;

@RestController
@RequestMapping("/api")
public class MyRESTController {
    public static final String AUTHORIZATION = "Authorization";

    @Autowired
    private MainService mainService;

    @Autowired
    private JwtProvider jwtProvider;

    @GetMapping("users/{id}")
    public User getUser(@PathVariable int id) {
        User user = mainService.getUserById(id);
//        if(user==null){
//            throw new NoSuchUserExeption("There is no user with ID = " + id + " in database");
//        }
        return user;
    }

    @GetMapping("/users")
    public List<User> showAllUsers() {
        List<User> allUsers = mainService.getAllUsers();
        return allUsers;
    }

    @PostMapping("/users/get-token")
    public Token createTokenForUser(@RequestBody User user) {
        User userFromDB = mainService.getUser(user.getUserName(), user.getPassword());
        if (userFromDB == null) {
            return null;
        }
        Token token = new Token();
        token.setToken(jwtProvider.generateToken(userFromDB.getUserName()));
        return token;
    }

    @PostMapping("/users/message")
    public List<Message> getMessageFromUser(
            @RequestBody MessageFromUser messageFromUser,
            HttpServletRequest request) {

        List<Message> messageList = new ArrayList<>();
        String userName;
        Message message = null;
        if (messageFromUser.getMessage().equals("history 10")) {
            if(tokenIsValid(messageFromUser, request)){
                messageList = mainService.getLastMessages(10);
            }
        } else {
            if (tokenIsValid(messageFromUser, request)) {
                String token = request.getHeader(AUTHORIZATION).substring(7);
                userName = jwtProvider.getLoginFromToken(token);
                User user = mainService.getUserByName(userName);
                message = new Message(messageFromUser.getMessage(), user);
                mainService.saveMessage(message);
            }
        }
        messageList.add(message);
        return messageList;
    }

    private boolean tokenIsValid(MessageFromUser messageFromUser, HttpServletRequest request) {
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
