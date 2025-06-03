package com.data.session15.repository;

import com.data.session15.dto.OrderRequest;

public interface OrderRepo {
    boolean addOrder(OrderRequest order);
}
