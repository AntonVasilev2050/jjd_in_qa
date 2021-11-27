package com.avvsoft2050.test.jjd_in_qa.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "message")
    private String messageText;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username_id")
    private User user;

    public Message(String messageText, User user) {
        this.messageText = messageText;
        this.user = user;
    }

    public Message() {
    }
}
