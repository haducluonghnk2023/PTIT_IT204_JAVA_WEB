package com.data.session07.service;

import com.data.session07.model.Product09;
import com.data.session07.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceImpl implements  ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product09> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product09> getById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product09 product) {
        productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product09> search(String keyword) {
        return productRepository.search(keyword);
    }
}
