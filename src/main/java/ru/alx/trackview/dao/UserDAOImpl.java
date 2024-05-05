package ru.alx.trackview.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.alx.trackview.model.User;

import java.util.List;

public class UserDAOImpl implements UserDAO {

    private final SessionFactory sessionFactory;

    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public User get(int id) {
        User user;
        Session session = sessionFactory.openSession();
        user = session.find(User.class, id);
        session.close();
        return user;
    }

    public void create(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(user);
        transaction.commit();
        session.close();
    }

    public void remove(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(get(id));
        transaction.commit();
        session.close();
    }

    public void update(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(user);
        transaction.commit();
        session.close();
    }

    public List<User> getAll() {
        Session session = sessionFactory.openSession();
        List<User> userList = session.createQuery("from User", User.class).list();
        session.close();
        return userList;
    }
}
