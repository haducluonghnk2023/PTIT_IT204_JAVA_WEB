package com.data.session06.dao.ex03;

import com.data.session06.model.ex03.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> getAllProducts();
    Product getProductById(int id);
}
