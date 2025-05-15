package com.data.session08.service;

import com.data.session08.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    boolean save(Product product);
}
