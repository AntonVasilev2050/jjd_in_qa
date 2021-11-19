package com.avvsoft2050.test.jjd_in_qa.pojo;

public class MessageFromUser {
    String userName;
    String message;

    public MessageFromUser(String userName, String message) {
        this.userName = userName;
        this.message = message;
    }

    public MessageFromUser() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
