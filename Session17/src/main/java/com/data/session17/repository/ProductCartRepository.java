package com.data.session17.repository;

import com.data.session17.entity.ProductCart;

import java.util.List;

public interface ProductCartRepository {
    ProductCart findByCustomerIdAndProductId(Long customerId, Long productId);
    void save(ProductCart cart);
    List<ProductCart> findByCustomerId(Long customerId);
    ProductCart findById(Long id);
    void deleteById(Long id);
    void delete(ProductCart cart);
}
