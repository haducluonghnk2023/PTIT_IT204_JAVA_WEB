package com.data.session08.service;

import com.data.session08.model.Customer;
import com.data.session08.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements  CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAllCustomers();
    }
}
