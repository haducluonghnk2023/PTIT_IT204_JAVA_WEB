package com.data.session20.repository;

import com.data.session20.entity.Seed;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class SeedRepositoryImpl implements  SeedRepository {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Seed> findAll() {
        Session session = sessionFactory.openSession();
        Query<Seed> query = session.createQuery("from Seed", Seed.class);
        List<Seed> seeds = query.getResultList();
        session.close();
        return seeds;
    }

    @Override
    public void save(Seed seed) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(seed);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteById(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Seed seed = session.get(Seed.class, id);
        if (seed != null) {
            session.delete(seed);
        }
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Seed findById(Long id) {
        Session session = sessionFactory.openSession();
        Seed seed = session.get(Seed.class, id);
        session.close();
        return seed;
    }

    @Override
    public void update(Seed seed) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(seed);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Seed> searchByKeyword(String keyword) {
        Session session = sessionFactory.openSession();
        Query<Seed> query = session.createQuery("from Seed where seedName like :keyword", Seed.class);
        query.setParameter("keyword", "%" + keyword + "%");
        List<Seed> seeds = query.getResultList();
        session.close();
        return seeds;
    }
}
