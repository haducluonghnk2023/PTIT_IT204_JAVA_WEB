package com.data.session09.service.ex01;

import com.data.session09.model.ex01.Customer;
import com.data.session09.repository.ex01.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements  CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public Customer checkLogin(String userName, String password) {
        return customerRepo.checkLogin(userName, password);
    }
}
