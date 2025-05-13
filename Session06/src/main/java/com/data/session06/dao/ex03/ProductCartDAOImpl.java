package com.data.session06.dao.ex03;

import com.data.session06.model.ex03.Product;
import com.data.session06.model.ex03.ProductCart;
import com.data.session06.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductCartDAOImpl implements  ProductCartDAO {
    @Override
    public List<ProductCart> getAllProductCarts() {
        Connection conn = null;
        CallableStatement stmt = null;
        List<ProductCart> productCart = null;
        try{
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call get_all_product_cart()}");
            ResultSet rs = stmt.executeQuery();
            productCart = new ArrayList<>();
            while (rs.next()){
                ProductCart productCarts = new ProductCart();
                productCarts.setId(rs.getInt("id"));
                productCarts.setUserId(rs.getInt("user_id"));
                productCarts.setProductId(rs.getInt("product_id"));
                productCarts.setQuantity(rs.getInt("quantity"));
                productCart.add(productCarts);
            }
        } catch (SQLException e) {
            e.fillInStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
        return productCart;
    }

    @Override
    public boolean delete(int id) {
        Connection conn = null;
        CallableStatement stmt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call delete_product(?)}");
            stmt.setInt(1, id);
            result = stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
        return result;
    }

   @Override
   public List<ProductCart> getCartByUser(int userId) {
       Connection conn = null;
       CallableStatement stmt = null;
       List<ProductCart> productCartList = null;
       try {
           conn = ConnectionDB.openConnection();
           stmt = conn.prepareCall("{call get_cart_by_user(?)}");
           stmt.setInt(1, userId);
           ResultSet rs = stmt.executeQuery();
           productCartList = new ArrayList<>();
           while (rs.next()) {
               ProductCart productCart = new ProductCart();
               productCart.setId(rs.getInt("id"));
               productCart.setUserId(rs.getInt("user_id"));
               productCart.setProductId(rs.getInt("product_id"));
               productCart.setQuantity(rs.getInt("quantity"));
               productCartList.add(productCart);
           }
       } catch (SQLException e) {
           e.printStackTrace();
       } finally {
           ConnectionDB.closeConnection(conn, stmt);
       }
       return productCartList;
   }

    @Override
    public boolean save(ProductCart cart) {
        Connection conn = null;
        CallableStatement stmt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call insert_product_cart(?, ?, ?)}");
            stmt.setInt(1, cart.getUserId());
            stmt.setInt(2, cart.getProductId());
            stmt.setInt(3, cart.getQuantity());

            int rowsAffected = stmt.executeUpdate();
            result = rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
        return result;
    }

}
