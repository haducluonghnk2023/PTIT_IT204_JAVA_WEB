package com.data.session18.repo;

import com.data.session18.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepoImpl implements  OrderRepo {
    private SessionFactory sessionFactory;

    public OrderRepoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Order> findAll() {
       Session session = sessionFactory.openSession();
       List<Order> orders = session.createQuery("from Order", Order.class).list();
       session.close();
       return orders;
    }

    @Override
    public int countOrders() {
        Session session = sessionFactory.openSession();
        Long count = (Long) session.createQuery("select count(o) from Order o").uniqueResult();
        session.close();
        return count != null ? count.intValue() : 0;
    }

    @Override
    public double getRevenueByMonth() {
        Session session = sessionFactory.openSession();
        Double revenue = session.createQuery("select sum(o.totalPrice) from Order o where month(o.orderDate) = month(current_date()) and year(o.orderDate) = year(current_date())", Double.class)
                .getSingleResult();
        session.close();
        return revenue != null ? revenue : 0.0;
    }

    @Override
    public double getRevenueByYear() {
        Session session = sessionFactory.openSession();
        Double revenue = session.createQuery("select sum(o.totalPrice) from Order o where year(o.orderDate) = year(current_date())", Double.class)
                .getSingleResult();
        session.close();
        return revenue != null ? revenue : 0.0;
    }
}
