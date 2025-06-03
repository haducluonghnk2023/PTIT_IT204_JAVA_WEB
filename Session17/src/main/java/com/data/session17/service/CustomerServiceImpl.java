package com.data.session17.service;

import com.data.session17.entity.Customer;
import com.data.session17.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements  CustomerService {
    @Autowired
    private CustomerRepository customerRepo;

    @Override
    public void save(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public boolean existsByUsername(String username) {
        return customerRepo.existsByUsername(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return customerRepo.existsByEmail(email);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepo.getAll();
    }

    @Override
    public Customer findByUsernameAndPassword(String username, String password) {
        return customerRepo.findByUsernameAndPassword(username, password);
    }
}
