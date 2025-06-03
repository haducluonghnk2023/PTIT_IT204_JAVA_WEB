package com.data.session15.repository;

import com.data.session15.dto.OrderRequest;
import com.data.session15.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;

@Repository
public class OrderRepoImpl implements OrderRepo {

    public boolean addOrder(OrderRequest request) {
        Connection conn = null;
        CallableStatement stmt = null;

        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{CALL add_order(?, ?, ?, ?, ?, ?, ?)}");

            stmt.setInt(1, request.getUserId());
            stmt.setString(2, request.getRecipientName());
            stmt.setString(3, request.getAddress());
            stmt.setString(4, request.getPhoneNumber());
            stmt.setInt(5, request.getProductId());
            stmt.setInt(6, request.getQuantity());
            stmt.setBigDecimal(7, request.getCurrentPrice());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }

        return false;
    }
}
