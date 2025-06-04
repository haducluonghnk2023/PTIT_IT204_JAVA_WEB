package com.data.session18.repo;

import com.data.session18.entity.Product;
import com.data.session18.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepoImpl implements  UserRepo {
    private SessionFactory sessionFactory;

    public UserRepoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> findAll(int pageNumber, int pageSize) {
        Session session = sessionFactory.openSession();
        try {
            Query<User> query = session.createQuery("FROM User", User.class);
            int firstResult = (pageNumber - 1) * pageSize;
            query.setFirstResult(firstResult);
            query.setMaxResults(pageSize);
            return query.getResultList();
        } finally {
            session.close();
        }
    }

    @Override
    public List<User> findAll() {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("FROM User", User.class).list();
        } finally {
            session.close();
        }
    }

    @Override
    public int countUsers() {
        Session session = sessionFactory.openSession();
        Long count = (Long) session.createQuery("select count(u) from User u").uniqueResult();
        session.close();
        return count != null ? count.intValue() : 0;
    }

    @Override
    public List<User> findUsers(String keyword, int pageNumber, int pageSize) {
        Session session = sessionFactory.openSession();
        String hql = "from User u where u.username like :keyword or u.email like :keyword";
        List<User> users = session.createQuery(hql, User.class)
                .setParameter("keyword", "%" + keyword + "%")
                .setFirstResult((pageNumber - 1) * pageSize)
                .setMaxResults(pageSize)
                .list();
        session.close();
        return users;
    }

    @Override
    public long countUsers(String keyword) {
        Session session = sessionFactory.openSession();
        String hql = "select count(u) from User u where u.username like :keyword or u.email like :keyword";
        Long count = (Long) session.createQuery(hql)
                .setParameter("keyword", "%" + keyword + "%")
                .uniqueResult();
        session.close();
        return count != null ? count : 0;
    }

    @Override
    public void lockUser(Long userId) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, userId);
        if (user != null) {
            user.setLocked(true);
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        }
        session.close();
    }

    @Override
    public void unlockUser(Long userId) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, userId);
        if (user != null) {
            user.setLocked(false);
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        }
        session.close();
    }
}
