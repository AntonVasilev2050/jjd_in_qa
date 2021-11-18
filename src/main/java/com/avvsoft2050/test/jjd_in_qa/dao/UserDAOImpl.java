package com.avvsoft2050.test.jjd_in_qa.dao;

import com.avvsoft2050.test.jjd_in_qa.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public User getUser(String username, String password) {
        Session session = entityManager.unwrap(Session.class);
        Query<User> query = session.createQuery("from User where User.userName = :username and User.password = :password");
        User user = query.getSingleResult();

        return user;
    }
}
