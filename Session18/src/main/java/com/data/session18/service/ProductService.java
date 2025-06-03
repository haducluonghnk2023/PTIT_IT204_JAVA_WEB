package com.data.session18.service;

import com.data.session18.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll(int pageNumber, int pageSize);
    int countProducts();
    Product findById(Long id);
    void save(Product product);
    void deleteById(Long id);
    List<Product> findByNameContaining(String name, int pageNumber, int pageSize);
    long countByNameContaining(String name);
}
