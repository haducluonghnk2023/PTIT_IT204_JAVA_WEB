package com.data.session09.repository.ex01;

import com.data.session09.model.ex01.Customer;

public interface CustomerRepo {
    Customer checkLogin(String userName, String password);
}
