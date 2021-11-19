package com.avvsoft2050.test.jjd_in_qa.dao;

import com.avvsoft2050.test.jjd_in_qa.entity.Message;

import java.util.List;

public interface MessageDAO {
    void saveMessage(Message message);

    List<Message> getLastMessages();
}
