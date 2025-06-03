package com.data.session12.service;

import com.data.session12.model.Product;
import com.data.session12.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements  ProductService{

    @Autowired
    private ProductRepo productRepo;

    @Override
    public boolean addProduct(Product product) {
        return productRepo.addProduct(product);
    }

    @Override
    public boolean updateProduct(Product product) {
        return productRepo.updateProduct(product);
    }

    @Override
    public boolean deleteProduct(int id) {
        return productRepo.deleteProduct(id);
    }

    @Override
    public Product getProductById(int id) {
        return productRepo.getProductById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }
}
