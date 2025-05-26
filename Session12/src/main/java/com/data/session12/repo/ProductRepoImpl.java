package com.data.session12.repo;

import com.data.session12.model.Product;
import com.data.session12.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepoImpl implements  ProductRepo {
    @Override
    public boolean addProduct(Product product) {
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call insert_product(?,?,?,?)}");
            stmt.setString(1, product.getName());
            stmt.setDouble(2, product.getPrice());
            stmt.setInt(3, product.getQuantity());
            stmt.setString(4, product.getImage());

            return stmt.executeUpdate() > 0;

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,stmt);
        }
        return false;
    }

    @Override
    public boolean updateProduct(Product product) {
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call update_product(?,?,?,?)}");
            stmt.setString(1, product.getName());
            stmt.setDouble(2, product.getPrice());
            stmt.setInt(3, product.getQuantity());
            stmt.setString(4, product.getImage());
            stmt.setInt(5, product.getId());
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn,stmt);
        }
        return false;
    }

    @Override
    public boolean deleteProduct(int id) {
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call delete_product(?)}");
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,stmt);
        }
        return false;
    }

    @Override
    public Product getProductById(int id) {
        Connection conn = null;
        CallableStatement stmt = null;
        ResultSet rs = null;
        Product product = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call find_product_by_id(?)}");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()){
                product = new Product();
                product.setId(id);
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setQuantity(rs.getInt("quantity"));
                product.setImage(rs.getString("image"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(conn,stmt);
        }
        return product;
    }

    @Override
    public List<Product> findAll() {
        Connection conn = null;
        CallableStatement stmt = null;
        List<Product> list = new ArrayList<>();
        ResultSet rs = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call find_all_products()}");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setQuantity(rs.getInt("quantity"));
                product.setImage(rs.getString("image"));
                list.add(product);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
