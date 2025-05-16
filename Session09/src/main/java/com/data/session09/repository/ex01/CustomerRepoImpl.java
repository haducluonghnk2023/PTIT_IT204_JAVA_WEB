package com.data.session09.repository.ex01;

import com.data.session09.model.ex01.Customer;
import com.data.session09.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
@Repository
public class CustomerRepoImpl implements  CustomerRepo {
    @Override
    public Customer checkLogin(String username, String password) {
        Connection con = null;
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConnectionDB.openConnection();
            String sql = "{call select_customer(?, ?)}";
            stmt = con.prepareCall(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getLong("id"));
                customer.setUserName(rs.getString("username"));
                customer.setPhone(rs.getString("phone"));
                customer.setAddress(rs.getString("address"));
                customer.setGender(rs.getString("gender"));
                customer.setEmail(rs.getString("email"));
                customer.setPassword(rs.getString("password"));
                return customer;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(con, stmt);
        }
        return null;
    }
}
