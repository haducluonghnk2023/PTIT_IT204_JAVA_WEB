package com.data.session08.repository;

import com.data.session08.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    boolean save(Product product);
}
