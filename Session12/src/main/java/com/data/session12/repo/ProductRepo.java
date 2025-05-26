package com.data.session12.repo;

import com.data.session12.model.Product;

import java.util.List;

public interface ProductRepo {
    boolean addProduct(Product product);
    boolean updateProduct(Product product);
    boolean deleteProduct(int id);
    Product getProductById(int id);
    List<Product> findAll();
}
