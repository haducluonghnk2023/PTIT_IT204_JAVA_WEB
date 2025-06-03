package com.data.session17.service;

import com.data.session17.entity.Customer;

import java.util.List;

public interface CustomerService {
    void save(Customer customer);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    List<Customer> getAll();
    Customer findByUsernameAndPassword(String username, String password);
}
