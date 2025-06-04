package com.data.practice19.repo;

import com.data.practice19.entity.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountRepoImpl implements  AccountRepo {
    private SessionFactory sessionFactory;

    public AccountRepoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Account> findAll() {
        Session session = sessionFactory.openSession();
        List<Account> accounts = session.createQuery("from Account").list();
        session.close();
        return accounts;
    }

    @Override
    public void save(Account account) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        if (account != null && account.getId() > 0) {
            session.update(account);
        } else {
            session.save(account);
        }
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Account findById(int id) {
        Session session = sessionFactory.openSession();
        Account account = session.get(Account.class, id);
        session.close();
        return account;
    }

    @Override
    public void deleteById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Account account = session.get(Account.class, id);
        if (account != null) {
            session.delete(account);
        }
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Account account) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        if (account != null && account.getId() > 0) {
            session.update(account);
        } else {
            throw new IllegalArgumentException("Account must have a valid ID for update.");
        }
        session.getTransaction().commit();
        session.close();
    }
}
