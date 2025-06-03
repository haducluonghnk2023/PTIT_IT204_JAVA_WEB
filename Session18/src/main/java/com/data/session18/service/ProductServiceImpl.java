package com.data.session18.service;

import com.data.session18.entity.Product;
import com.data.session18.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements  ProductService {
    @Autowired
    private ProductRepo productRepo;
    @Override
    public List<Product> findAll(int pageNumber, int pageSize) {
        return productRepo.findAll(pageNumber,pageSize);
    }

    @Override
    public int countProducts() {
        return productRepo.countProducts();
    }

    @Override
    public Product findById(Long id) {
        return productRepo.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepo.save(product);
    }

    @Override
    public void deleteById(Long id) {
        productRepo.deleteById(id);
    }

    @Override
    public List<Product> findByNameContaining(String name, int pageNumber, int pageSize) {
        return productRepo.findByNameContaining(name,pageNumber,pageSize);
    }

    @Override
    public long countByNameContaining(String name) {
        return productRepo.countByNameContaining(name);
    }
}
