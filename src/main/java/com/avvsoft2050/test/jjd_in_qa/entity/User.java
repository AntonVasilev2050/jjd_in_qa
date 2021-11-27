package com.avvsoft2050.test.jjd_in_qa.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String userName;

    @Column(name = "user_password")
    private String password;


//    public User(String userName, String password) {
//        this.userName = userName;
//        this.password = password;
//    }
//
//    public User() {
//    }

}
