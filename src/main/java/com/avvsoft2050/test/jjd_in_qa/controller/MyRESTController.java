package com.avvsoft2050.test.jjd_in_qa.controller;

import com.avvsoft2050.test.jjd_in_qa.entity.User;
import com.avvsoft2050.test.jjd_in_qa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private UserService userService;

    public String createToken(@RequestBody User user){



        return null;
    }

}
