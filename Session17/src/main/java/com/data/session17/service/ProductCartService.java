package com.data.session17.service;

import com.data.session17.entity.Customer;
import com.data.session17.entity.ProductCart;

import java.util.List;

public interface ProductCartService {
    ProductCart findByCustomerIdAndProductId(Long customerId, Long productId);
    void save(ProductCart cart);
    List<ProductCart> findByCustomerId(Long customerId);
    ProductCart findById(Long id);
    void deleteById(Long id);
    void clearCartByCustomerId(Long customerId) ;
}
