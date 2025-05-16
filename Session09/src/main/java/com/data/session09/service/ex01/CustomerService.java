package com.data.session09.service.ex01;

import com.data.session09.model.ex01.Customer;

public interface CustomerService {
    Customer checkLogin(String userName, String password);
}
