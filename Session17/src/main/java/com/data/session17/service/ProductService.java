package com.data.session17.service;

import com.data.session17.entity.Customer;
import com.data.session17.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll(int pageNumber, int pageSize);
    Product findById(Long id);
    int count();
}
