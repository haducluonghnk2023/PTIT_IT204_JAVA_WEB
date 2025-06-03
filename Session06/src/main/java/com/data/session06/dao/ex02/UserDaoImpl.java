package com.data.session06.dao.ex02;

import com.data.session06.model.ex02.User;
import com.data.session06.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDaoImpl implements UserDao {
    @Override
    public boolean save(User user) {
        Connection conn = null;
        CallableStatement stmt = null;
        boolean result = false;

        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call insert_user(?, ?, ?, ?)}");
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPhone());

            int rowsAffected = stmt.executeUpdate();
            result = rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }

        return result;
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        Connection conn = null;
        CallableStatement stmt = null;
        ResultSet rs = null;
        User user = null;

        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call find_user(?, ?)}");
            stmt.setString(1, username);
            stmt.setString(2, password);

            rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
        return user;
    }
}
