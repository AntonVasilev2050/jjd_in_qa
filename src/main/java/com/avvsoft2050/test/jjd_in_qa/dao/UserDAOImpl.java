package com.avvsoft2050.test.jjd_in_qa.dao;

import com.avvsoft2050.test.jjd_in_qa.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public User getUserById(int id) {
        Session session = entityManager.unwrap(Session.class);
        User user = session.get(User.class, id);

        return user;
    }

    @Override
    public List<User> getAllUsers() {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("from User");
        List<User> userList = query.getResultList();
        return session.createQuery("from User ", User.class).getResultList();
    }

    @Override
    public User getUser(String username, String password) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("from User u where (u.userName = :username) and (u.password = :password)");
        query.setParameter("username", username);
        query.setParameter("password", password);

        return (User) query.getSingleResult();
    }

    @Override
    public User getUserByName(String username) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("from User u where u.userName = :username");
        query.setParameter("username", username);
        return (User) query.getSingleResult();
    }
}
