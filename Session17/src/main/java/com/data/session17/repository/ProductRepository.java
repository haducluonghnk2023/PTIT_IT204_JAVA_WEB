package com.data.session17.repository;

import com.data.session17.entity.Customer;
import com.data.session17.entity.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll(int pageNumber, int pageSize);
    Product findById(Long id);
    int count();

}
