package com.data.session08.repository;

import com.data.session08.model.Product;
import com.data.session08.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class ProductRepositoryImpl implements  ProductRepository {
    @Override
    public List<Product> findAll() {
        Connection conn = null;
        CallableStatement stmt = null;
        List<Product> products = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call get_all_products()}");
            ResultSet rs = stmt.executeQuery();
            products = new ArrayList<>();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getInt("price"));
                product.setQuantity(rs.getInt("quantity"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
        return products;
    }

    @Override
    public boolean save(Product product) {
        Connection conn = null;
        CallableStatement stmt = null;
        boolean result = false;

        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call insert_product(?, ?, ?)}");

            stmt.setString(1, product.getName());
            stmt.setInt(2, product.getPrice());
            stmt.setInt(3, product.getQuantity());

            int rowsAffected = stmt.executeUpdate();

            result = rowsAffected > 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return result;
    }

}
