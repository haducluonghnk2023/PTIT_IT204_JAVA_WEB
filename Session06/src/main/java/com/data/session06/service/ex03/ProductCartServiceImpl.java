package com.data.session06.service.ex03;

import com.data.session06.dao.ex03.ProductCartDAO;
import com.data.session06.dao.ex03.ProductCartDAOImpl;
import com.data.session06.model.ex03.Product;
import com.data.session06.model.ex03.ProductCart;

import java.util.List;

public class ProductCartServiceImpl implements  ProductCartService {
    public final ProductCartDAO productCartDAO;
    public ProductCartServiceImpl() {
        this.productCartDAO = new ProductCartDAOImpl();
    }
    @Override
    public List<ProductCart> getAllProductCarts() {
        return productCartDAO.getAllProductCarts();
    }

    @Override
    public boolean delete(int id) {
        return productCartDAO.delete(id);
    }

    @Override
    public List<ProductCart> getCartByUser(int userId) {
        return productCartDAO.getCartByUser(userId);
    }

    @Override
    public boolean save(ProductCart cart) {
        return productCartDAO.save(cart);
    }
}
