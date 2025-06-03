package com.data.session08.repository;

import com.data.session08.model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAllCustomers();
}
