package com.data.session18.service;

import com.data.session18.entity.Order;
import com.data.session18.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements  OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Override
    public List<Order> findAll() {
        return orderRepo.findAll();
    }

    @Override
    public int countOrders() {
        return orderRepo.countOrders();
    }

    @Override
    public double getRevenueByMonth() {
        return orderRepo.getRevenueByMonth();
    }

    @Override
    public double getRevenueByYear() {
        return orderRepo.getRevenueByYear();
    }
}
