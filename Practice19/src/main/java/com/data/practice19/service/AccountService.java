package com.data.practice19.service;

import com.data.practice19.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll();
    void save(Account account);
    Account findById(int id);
    void deleteById(int id);
    void update(Account account);
}
