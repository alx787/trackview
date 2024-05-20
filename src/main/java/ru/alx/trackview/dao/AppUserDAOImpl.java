package ru.alx.trackview.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.alx.trackview.model.AppUser;

import java.util.List;

@Repository
public class AppUserDAOImpl implements AppUserDAO {

    @Autowired
    private final SessionFactory sessionFactory;

    public AppUserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public AppUser findById(int id) {
        AppUser appUser;
        Session session = sessionFactory.openSession();
        appUser = session.find(AppUser.class, id);
        session.close();
        return appUser;
    }

    public void create(AppUser appUser) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(appUser);
        transaction.commit();
        session.close();
    }

    public void remove(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(findById(id));
        transaction.commit();
        session.close();
    }

    public void update(AppUser appUser) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(appUser);
        transaction.commit();
        session.close();
    }

    public List<AppUser> getAll() {
        Session session = sessionFactory.openSession();
        List<AppUser> userList = session.createQuery("from AppUser", AppUser.class).list();
        session.close();
        return userList;
    }
}
