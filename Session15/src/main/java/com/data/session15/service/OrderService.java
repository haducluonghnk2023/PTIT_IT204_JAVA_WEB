package com.data.session15.service;

import com.data.session15.dto.OrderRequest;

public interface OrderService {
    boolean addOrder(OrderRequest orderRequest);
}
