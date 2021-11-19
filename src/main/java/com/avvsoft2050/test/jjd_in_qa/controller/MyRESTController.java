package com.avvsoft2050.test.jjd_in_qa.controller;

import com.avvsoft2050.test.jjd_in_qa.entity.Token;
import com.avvsoft2050.test.jjd_in_qa.entity.User;
import com.avvsoft2050.test.jjd_in_qa.service.JwtProvider;
import com.avvsoft2050.test.jjd_in_qa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtProvider jwtProvider;

    @GetMapping("users/{id}")
    public User getUser(@PathVariable int id){
        User user = userService.getUserById(id);
//        if(user==null){
//            throw new NoSuchUserExeption("There is no user with ID = " + id + " in database");
//        }
        return user;
    }

    @GetMapping("/users")
    public List<User> showAllUsers(){
        List<User> allUsers = userService.getAllUsers();
        return allUsers;
    }

    @PostMapping("/users/get-token")
    public Token createTokenForUser(@RequestBody User user) {
        User userFromDB = userService.getUser(user.getUserName(), user.getPassword());
        if(userFromDB == null){
            return null;
        }
        Token token = new Token();
        token.setToken(jwtProvider.generateToken(userFromDB.getUserName()));
        return token;
    }

}
