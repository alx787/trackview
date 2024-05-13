package ru.alx.trackview.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.alx.trackview.model.Track;

import java.time.LocalDateTime;
import java.util.List;

public class TrackDAOImpl implements TrackDAO {

    private final SessionFactory sessionFactory;

    public TrackDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Track findById(int id) {
        Track track;
        Session session = sessionFactory.openSession();
        track = session.find(Track.class, id);
        session.close();
        return track;
    }

    public List<Track> findByHumanIdAndPeriod(int humanid, LocalDateTime datebeg, LocalDateTime dateend) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM Track T WHERE T.human = :paramhumanid AND T.datetime >= :paramdatebeg AND T.datetime <= :paramdateend order by T.datetime");
        query.setParameter("paramhumanid", humanid);
        query.setParameter("paramdatebeg", datebeg);
        query.setParameter("paramdateend", dateend);
        List<Track> tracks = query.list();
        session.close();
        return tracks;
    }

    public void create(Track track) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(track);
        transaction.commit();
        session.close();

    }
}
