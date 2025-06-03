package com.data.session06.service.ex03;

import com.data.session06.model.ex03.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProduct(int id);
}
