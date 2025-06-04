package com.data.practice19.repo;

import com.data.practice19.entity.Account;

import java.util.List;

public interface AccountRepo {
    List<Account> findAll();
    void save(Account account);
    Account findById(int id);
    void deleteById(int id);
    void update(Account account);
}
