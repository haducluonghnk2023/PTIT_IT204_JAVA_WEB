package com.data.session18.repo;

import com.data.session18.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepoImpl implements  ProductRepo {
    private SessionFactory sessionFactory;

    public ProductRepoImpl(SessionFactory sessionFactory) {
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
    public int countProducts() {
        Session session = sessionFactory.openSession();
        Long count = (Long) session.createQuery("select count(p) from Product p").uniqueResult();
        session.close();
        return count != null ? count.intValue() : 0;
    }

    @Override
    public Product findById(Long id) {
        Session session = sessionFactory.openSession();
        Product product = session.get(Product.class, id);
        session.close();
        return product;
    }

    @Override
    public void save(Product product) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        if (product.getId() == null) {
            session.save(product);
        } else {
            session.update(product);
        }
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteById(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        if (product != null) {
            session.delete(product);
        }
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Product> findByNameContaining(String name, int pageNumber, int pageSize) {
        Session session = sessionFactory.openSession();
        Query<Product> query = session.createQuery("FROM Product p WHERE p.name LIKE :name", Product.class);
        query.setParameter("name", "%" + name + "%");

        int firstResult = (pageNumber - 1) * pageSize;
        query.setFirstResult(firstResult);
        query.setMaxResults(pageSize);
        List<Product> list = query.getResultList();
        session.close();
        return list;
    }

    @Override
    public long countByNameContaining(String name) {
    Session session = sessionFactory.openSession();
        Long count = (Long) session.createQuery("select count(p) from Product p WHERE p.name LIKE :name")
                .setParameter("name", "%" + name + "%")
                .uniqueResult();
        session.close();
        return count != null ? count : 0;
    }
}
