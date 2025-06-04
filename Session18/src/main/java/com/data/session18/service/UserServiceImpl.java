package com.data.session18.service;

import com.data.session18.entity.User;
import com.data.session18.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements  UserService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public List<User> findAll(int pageNumber, int pageSize) {
        return userRepo.findAll(pageNumber, pageSize);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public int countUsers() {
        return userRepo.countUsers();
    }

    @Override
    public List<User> findUsers(String keyword, int pageNumber, int pageSize) {
        return userRepo.findUsers(keyword, pageNumber, pageSize);
    }

    @Override
    public long countUsers(String keyword) {
        return userRepo.countUsers(keyword);
    }

    @Override
    public void lockUser(Long userId) {
        userRepo.lockUser(userId);
    }

    @Override
    public void unlockUser(Long userId) {
        userRepo.unlockUser(userId);
    }
}
