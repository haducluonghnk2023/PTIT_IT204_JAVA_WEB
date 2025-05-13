package com.data.session06.utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/session06";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "new_password";
    public static Connection openConnection(){
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        }catch (Exception e){
            e.fillInStackTrace();
        }
        return conn;
    }
    public static void closeConnection(Connection conn, CallableStatement callSt){
        if (conn != null){
            try {
                conn.close();
            }catch (Exception e){
                e.fillInStackTrace();
            }
        }
        if (callSt != null){
            try {
                callSt.close();
            }catch (Exception e){
                e.fillInStackTrace();
            }
        }
    }
}
