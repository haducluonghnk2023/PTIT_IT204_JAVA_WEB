package com.data.session15.service;

import com.data.session15.dto.OrderRequest;
import com.data.session15.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OrderServiceImpl implements  OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Override
    public boolean addOrder(OrderRequest orderRequest) {
        return orderRepo.addOrder(orderRequest);
    }
}
