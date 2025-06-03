package com.data.session17.repository;

import com.data.session17.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public class CustomerRepositoryImpl implements CustomerRepository{
    @Autowired
    private final SessionFactory sessionFactory;

    public CustomerRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Customer customer) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(customer);
        tx.commit();
        session.close();
    }

    @Override
    public boolean existsByUsername(String username) {
        Session session = sessionFactory.openSession();
        Query<Long> query = session.createQuery(
                "SELECT COUNT(c) FROM Customer c WHERE c.username = :username", Long.class);
        query.setParameter("username", username);
        boolean exists = query.uniqueResult() > 0;
        session.close();
        return exists;
    }

    @Override
    public boolean existsByEmail(String email) {
        Session session = sessionFactory.openSession();
        Query<Long> query = session.createQuery(
                "SELECT COUNT(c) FROM Customer c WHERE c.email = :email", Long.class);
        query.setParameter("email", email);
        boolean exists = query.uniqueResult() > 0;
        session.close();
        return exists;
    }

    @Override
    public List<Customer> getAll() {
        Session session = sessionFactory.openSession();
        List<Customer> list = session.createQuery("FROM Customer", Customer.class).getResultList();
        session.close();
        return list;
    }

    @Override
    public Customer findByUsernameAndPassword(String username, String password) {
        Session session = sessionFactory.openSession();
        Query<Customer> query = session.createQuery(
                "FROM Customer WHERE username = :username AND password = :password", Customer.class);
        query.setParameter("username", username);
        query.setParameter("password", password);

        Customer customer = query.uniqueResult();
        session.close();
        return customer;
    }

}
