package com.data.session17.repository;

import com.data.session17.entity.ProductCart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ProductCartRepositoryImpl implements  ProductCartRepository {
    @Autowired
    private  SessionFactory sessionFactory;

    public ProductCartRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public ProductCart findByCustomerIdAndProductId(Long customerId, Long productId) {
        Session session = sessionFactory.openSession();
        // b2: tạo query dùng HQL
        String hql = "FROM ProductCart WHERE customerId = :customerId AND productId = :productId";
        ProductCart cart = session.createQuery(hql, ProductCart.class)
                .setParameter("customerId", customerId)
                .setParameter("productId", productId)
                .uniqueResult();
        // b3: trả về kết quả
        session.close();
        return cart;
    }

    @Override
    public void save(ProductCart cart) {
        Session session = sessionFactory.openSession();
        // b2: bắt đầu transaction
        session.beginTransaction();
        // b3: lưu cart
        session.saveOrUpdate(cart);
        // b4: commit transaction
        session.getTransaction().commit();
        // đóng session
        session.close();
    }

    @Override
    public List<ProductCart> findByCustomerId(Long customerId) {
        Session session = sessionFactory.openSession();
        String hql = "FROM ProductCart WHERE customerId = :customerId";
        List<ProductCart> cartList = session.createQuery(hql, ProductCart.class)
                .setParameter("customerId", customerId)
                .getResultList();
        session.close();
        return cartList;
    }

    @Override
    public ProductCart findById(Long id) {
        Session session = sessionFactory.openSession();
        // b2: tạo query dùng HQL
        String hql = "FROM ProductCart WHERE id = :id";
        ProductCart cart = session.createQuery(hql, ProductCart.class)
                .setParameter("id", id)
                .uniqueResult();
        // b3: trả về kết quả
        session.close();
        return cart;
    }

    @Override
    public void deleteById(Long id) {
        Session session = sessionFactory.openSession();
        // b2: bắt đầu transaction
        session.beginTransaction();
        // b3: tìm cart theo id
        ProductCart cart = session.get(ProductCart.class, id);
        if (cart != null) {
            // b4: xóa cart
            session.delete(cart);
        }
        // b5: commit transaction
        session.getTransaction().commit();
        // đóng session
        session.close();
    }

    @Override
    public void delete(ProductCart cart) {
        Session session = sessionFactory.openSession();
        // b2: bắt đầu transaction
        session.beginTransaction();
        // b3: xóa cart
        session.delete(cart);
        // b4: commit transaction
        session.getTransaction().commit();
        // đóng session
        session.close();
    }

}
