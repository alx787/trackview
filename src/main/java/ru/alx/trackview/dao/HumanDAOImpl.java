package ru.alx.trackview.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.alx.trackview.model.Human;

import java.util.List;

public class HumanDAOImpl implements HumanDAO {

    private final SessionFactory sessionFactory;

    public HumanDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Human findById(int id) {
        Human human;
        Session session = sessionFactory.openSession();
        human = session.find(Human.class, id);
        session.close();
        return human;
    }

    public void create(Human human) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(human);
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

    public void update(Human human) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(human);
        transaction.commit();
        session.close();
    }

    public List<Human> findByUserId(int userid) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM Human T WHERE T.id = :paramid");
        query.setParameter("paramid", userid);
        List<Human> humans = query.list();
        session.close();
        return  humans;
    }
}
