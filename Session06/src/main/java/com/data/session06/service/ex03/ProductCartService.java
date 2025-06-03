package com.data.session06.service.ex03;

import com.data.session06.dao.ex03.ProductCartDAO;
import com.data.session06.model.ex03.Product;
import com.data.session06.model.ex03.ProductCart;

import java.util.List;

public interface ProductCartService {
    List<ProductCart> getAllProductCarts();
    boolean delete(int id);
    List<ProductCart> getCartByUser(int userId);
    boolean save(ProductCart cart);
}
