package com.data.session08.utils;

import java.sql.CallableStatement;
import java.sql.Connection;

public class ConnectionDB {
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/session08";
    private static String USER_NAME = "root";
    private static String PASSWORD = "new_password";

    public static Connection openConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = java.sql.DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void closeConnection(Connection connection, CallableStatement callableStatement) {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (callableStatement != null) {
            try {
                callableStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
