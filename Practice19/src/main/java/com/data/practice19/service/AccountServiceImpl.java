package com.data.practice19.service;

import com.data.practice19.entity.Account;
import com.data.practice19.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountServiceImpl implements  AccountService {
    @Autowired
    private AccountRepo accountRepo;

    @Override
    public List<Account> findAll() {
        return accountRepo.findAll();
    }

    @Override
    public void save(Account account) {
        accountRepo.save(account);
    }

    @Override
    public Account findById(int id) {
        return accountRepo.findById(id);
    }

    @Override
    public void deleteById(int id) {
        accountRepo.deleteById(id);
    }

    @Override
    public void update(Account account) {
        accountRepo.update(account);
    }

    @Override
    public List<Account> findByNameContaining(String keyword) {
        return accountRepo.findByNameContaining(keyword);
    }
}
