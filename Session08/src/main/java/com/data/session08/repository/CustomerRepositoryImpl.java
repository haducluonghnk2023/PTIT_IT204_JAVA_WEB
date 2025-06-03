package com.data.session08.repository;

import com.data.session08.model.Customer;
import com.data.session08.model.CustomerType;
import com.data.session08.model.Gender;
import com.data.session08.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class CustomerRepositoryImpl implements  CustomerRepository {
    @Override
    public List<Customer> findAllCustomers() {
        Connection connection = null;
        CallableStatement callableStatement = null;
        List<Customer> customers = null;
        try{
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call get_all_customers()}");
            customers = new ArrayList<>();
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customer.setEmail(resultSet.getString("email"));
                customer.setGender(Gender.fromString(resultSet.getString("gender")));
                customer.setCustomerType(CustomerType.fromString(resultSet.getString("customer_type")));
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(connection, callableStatement);
        }
        return customers;
    }
}
