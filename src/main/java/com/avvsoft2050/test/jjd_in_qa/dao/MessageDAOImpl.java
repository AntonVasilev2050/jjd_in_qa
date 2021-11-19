package com.avvsoft2050.test.jjd_in_qa.dao;

import com.avvsoft2050.test.jjd_in_qa.entity.Message;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class MessageDAOImpl implements MessageDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void saveMessage(Message message) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(message);
    }

    @Override
    public List<Message> getLastMessages(int number) {
        return null;
    }
}
