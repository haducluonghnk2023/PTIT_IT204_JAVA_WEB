package com.data.session07.repository;

import com.data.session07.model.Product09;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product09> findAll();
    Optional<Product09> findById(Long id);
    void save(Product09 product);
    void deleteById(Long id);
    List<Product09> search(String keyword);
}
