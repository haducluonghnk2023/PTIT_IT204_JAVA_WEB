package com.data.session07.service;

import com.data.session07.model.Product09;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product09> getAll();
    Optional<Product09> getById(Long id);
    void save(Product09 product);
    void delete(Long id);
    List<Product09> search(String keyword);
}
