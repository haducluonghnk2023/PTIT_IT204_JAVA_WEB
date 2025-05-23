package com.data.session11.repository;

import com.data.session11.model.Category;
import com.data.session11.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepositoryImpl implements  CategoryRepository {
    @Override
    public List<Category> findAll() {
        Connection connection = null;
        CallableStatement callableStatement = null;
        List<Category> categoryList = new ArrayList<>();
        try{
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call get_all_categories()}");
            boolean hasResultSet = callableStatement.execute();
            if (hasResultSet) {
                ResultSet resultSet = callableStatement.getResultSet();
                while (resultSet.next()) {
                    Category category = new Category();
                    category.setId(resultSet.getInt("id"));
                    category.setCategoryName(resultSet.getString("category_name"));
                    category.setStatus(resultSet.getBoolean("status"));
                    categoryList.add(category);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }

    @Override
    public boolean save(Category category) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        boolean rowInserted = false;

        try {
            connection = ConnectionDB.openConnection();

            callableStatement = connection.prepareCall("{call insert_category(?, ?)}");

            callableStatement.setString(1, category.getCategoryName());
            callableStatement.setBoolean(2, category.isStatus());

            rowInserted = callableStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
           ConnectionDB.closeConnection(connection,callableStatement);
        }

        return rowInserted;
    }


    @Override
    public boolean existsByCategoryName(String categoryName) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;
        boolean exists = false;

        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call check_category_name_exists(?)}");
            callableStatement.setString(1, categoryName);

            resultSet = callableStatement.executeQuery();
            if (resultSet.next()) {
                exists = resultSet.getInt("exists") > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection,callableStatement);
        }

        return exists;
    }

    @Override
    public Category findById(int id) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;
        Category category = null;

        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call get_category_by_id(?)}");
            callableStatement.setInt(1, id);

            resultSet = callableStatement.executeQuery();
            if (resultSet.next()) {
                category = new Category();
                category.setId(resultSet.getInt("id"));
                category.setCategoryName(resultSet.getString("category_name"));
                category.setStatus(resultSet.getBoolean("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection, callableStatement);
        }

        return category;
    }

    @Override
    public void update(Category category) {
        Connection connection = null;
        CallableStatement callableStatement = null;

        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call update_category(?, ?, ?)}");
            callableStatement.setInt(1, category.getId());
            callableStatement.setString(2, category.getCategoryName());
            callableStatement.setBoolean(3, category.isStatus());

            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection, callableStatement);
        }
    }

    @Override
    public void deleteById(int id) {
        Connection connection = null;
        CallableStatement callableStatement = null;

        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call delete_category(?)}");
            callableStatement.setInt(1, id);

            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection, callableStatement);
        }
    }
}
