package com.data.session17.service;

import com.data.session17.entity.ProductCart;
import com.data.session17.repository.ProductCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCartServiceImpl implements  ProductCartService {
    @Autowired
    private ProductCartRepository productCartRepository;
    @Override
    public ProductCart findByCustomerIdAndProductId(Long customerId, Long productId) {
        return productCartRepository.findByCustomerIdAndProductId(customerId, productId);
    }

    @Override
    public void save(ProductCart cart) {
        productCartRepository.save(cart);
    }

    @Override
    public List<ProductCart> findByCustomerId(Long customerId) {
        return productCartRepository.findByCustomerId(customerId);
    }

    @Override
    public ProductCart findById(Long id) {
        return productCartRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        productCartRepository.deleteById(id);
    }

    @Override
    public void clearCartByCustomerId(Long customerId) {
        List<ProductCart> cartItems = productCartRepository.findByCustomerId(customerId);
        for (ProductCart item : cartItems) {
            productCartRepository.delete(item);
        }
    }

}
