package com.data.session05.dao;

import com.data.session05.model.Categories;
import com.data.session05.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDAOImpl implements  CategoriesDAO {
    @Override
    public List<Categories> findAll() {
        Connection connection = null;
        CallableStatement callableStatement = null;
        List<Categories> categoriesList = null;
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call find_all_categories()}");
            ResultSet resultSet = callableStatement.executeQuery();
            categoriesList = new ArrayList<>();
            while (resultSet.next()){
                Categories categories = new Categories();
                categories.setCatalogId(resultSet.getInt("catalog_id"));
                categories.setCatalogName(resultSet.getString("catalog_name"));
                categories.setDescription(resultSet.getString("catalog_description"));
                categories.setStatus(resultSet.getBoolean("catalog_status"));
                categoriesList.add(categories);
            }
        }catch (Exception e){
            e.fillInStackTrace();
        }finally {
            ConnectionDB.closeConnection(connection, callableStatement);
        }
        return categoriesList;
    }

    @Override
    public boolean save(Categories catalog) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call save_catalog(?,?,?)}");
            callSt.setString(1, catalog.getCatalogName());
            callSt.setString(2, catalog.getDescription());
            callSt.setBoolean(3, catalog.isStatus());
            callSt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }
}
