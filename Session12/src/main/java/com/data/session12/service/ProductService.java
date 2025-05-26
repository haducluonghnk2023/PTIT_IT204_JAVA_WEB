package com.data.session12.service;

import com.data.session12.model.Product;

import java.util.List;

public interface ProductService {
    boolean addProduct(Product product);
    boolean updateProduct(Product product);
    boolean deleteProduct(int id);
    Product getProductById(int id);
    List<Product> findAll();
}
