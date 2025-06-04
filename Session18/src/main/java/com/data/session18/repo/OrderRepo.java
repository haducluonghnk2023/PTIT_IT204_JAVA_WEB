package com.data.session18.repo;

import com.data.session18.entity.Order;

import java.util.List;

public interface OrderRepo {
    List<Order> findAll();
    int countOrders();
    double getRevenueByMonth();
    double getRevenueByYear();
    void save(Order order);
    Order findById(Long id);
    void deleteById(Long id);
}
