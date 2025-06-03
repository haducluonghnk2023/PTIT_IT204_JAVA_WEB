package com.data.session17.service;

import com.data.session17.entity.Customer;
import com.data.session17.entity.Product;
import com.data.session17.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements  ProductService {
    @Autowired
    private ProductRepository productRepo;

    @Override
    public List<Product> findAll(int pageNumber, int pageSize) {
        return productRepo.findAll(pageNumber, pageSize);
    }

    @Override
    public Product findById(Long id) {
        return productRepo.findById(id);
    }

    @Override
    public int count() {
        return productRepo.count();
    }

}
