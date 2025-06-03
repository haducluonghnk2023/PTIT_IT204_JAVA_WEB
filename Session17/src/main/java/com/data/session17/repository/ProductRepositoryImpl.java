package com.data.session17.repository;

import com.data.session17.entity.Customer;
import com.data.session17.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ProductRepositoryImpl implements  ProductRepository {

    @Autowired
    private final SessionFactory sessionFactory;

    public ProductRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Product> findAll(int pageNumber, int pageSize) {
        Session session = sessionFactory.openSession();
        Query<Product> query = session.createQuery("FROM Product", Product.class);

        int firstResult = (pageNumber - 1) * pageSize;
        query.setFirstResult(firstResult);
        query.setMaxResults(pageSize);

        List<Product> list = query.getResultList();
        session.close();
        return list;
    }

    @Override
    public Product findById(Long id) {
        Session session = sessionFactory.openSession();

        // b2: tạo query dùng HQL
        Query<Product> query = session.createQuery("FROM Product WHERE id=:id", Product.class);
        query.setParameter("id", id);

        // b3: thực thi query
        Product product = query.uniqueResult();

        // đóng session
        session.close();

        return product;
    }

    @Override
    public int count() {
        Session session = sessionFactory.openSession();
        Query<Long> query = session.createQuery("SELECT COUNT(p) FROM Product p", Long.class);
        Long count = query.uniqueResult();
        session.close();
        return count != null ? count.intValue() : 0;
    }

}
