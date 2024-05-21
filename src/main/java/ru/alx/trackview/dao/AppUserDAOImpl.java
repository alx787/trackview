package ru.alx.trackview.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
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
        AppUser appuser;
        Session session = sessionFactory.openSession();
        appuser = session.find(AppUser.class, id);
        session.close();
        return appuser;
    }

    @Override
    public AppUser findByName(String username) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM AppUser A WHERE A.username = :paramusername");
        query.setParameter("paramusername", username);
        List<AppUser> appUserList = query.list();
        if (appUserList.size() != 1) {
            return null;
        }

        return appUserList.get(0);
    }

    public void create(AppUser appuser) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(appuser);
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

    public void update(AppUser appuser) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(appuser);
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
