package com.data.session19.repo;

import com.data.session19.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserRepoImpl implements  UserRepo {
    @Autowired
    private SessionFactory sessionFactory;

    public UserRepoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public List<User> findAll(int pageNumber, int pageSize) {
        Session session = sessionFactory.openSession();
        Query<User> query = session.createQuery("from User", User.class);
        query.setFirstResult((pageNumber - 1) * pageSize);
        query.setMaxResults(pageSize);
        List<User> users = query.getResultList();
        session.close();
        return users;
    }

    @Override
    public long countUsers() {
        Session session = sessionFactory.openSession();
        Query<Long> query = session.createQuery("select count(u) from User u", Long.class);
        long count = query.uniqueResult();
        session.close();
        return count;
    }

    @Override
    public void toggleUserStatus(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        if (user != null) {
            user.setActive(!user.isActive());
            session.update(user);
        }
        session.getTransaction().commit();
        session.close();
    }
}
