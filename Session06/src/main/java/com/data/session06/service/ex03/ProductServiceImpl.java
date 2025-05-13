package com.data.session06.service.ex03;

import com.data.session06.dao.ex03.ProductDAO;
import com.data.session06.dao.ex03.ProductDAOImpl;
import com.data.session06.model.ex03.Product;

import java.util.List;

public class ProductServiceImpl implements  ProductService {
    public final ProductDAO productDAO;
    public ProductServiceImpl() {
        this.productDAO = new ProductDAOImpl();
    }
    @Override
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    @Override
    public Product getProduct(int id) {
        return productDAO.getProductById(id);
    }
}
