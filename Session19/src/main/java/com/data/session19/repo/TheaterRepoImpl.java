package com.data.session19.repo;

import com.data.session19.entity.Theater;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TheaterRepoImpl implements TheaterRepo {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Theater> findAll(int pageNumber, int pageSize) {
        Session session = sessionFactory.openSession();
        List<Theater> theaters = session.createQuery("FROM Theater", Theater.class)
                .setFirstResult((pageNumber - 1) * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
        session.close();
        return theaters;
    }

    @Override
    public Theater findById(Long id) {
        Session session = sessionFactory.openSession();
        Theater theater = session.get(Theater.class, id);
        session.close();
        return theater;
    }

    @Override
    public Theater save(Theater theater) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(theater);
        session.getTransaction().commit();
        session.close();
        return theater;
    }

    @Override
    public void deleteById(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Theater theater = session.get(Theater.class, id);
        if (theater != null) {
            session.delete(theater);
        }
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Theater theater) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(theater);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public long countTheaters() {
        Session session = sessionFactory.openSession();
        long count = (long) session.createQuery("SELECT COUNT(t) FROM Theater t").uniqueResult();
        session.close();
        return count;
    }
}
