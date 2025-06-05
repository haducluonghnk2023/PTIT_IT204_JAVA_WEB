package com.data.session19.service;

import com.data.session19.entity.User;
import com.data.session19.repo.UserRepo;
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
    public long countUsers() {
        return userRepo.countUsers();
    }

    @Override
    public void toggleUserStatus(Long id) {
        userRepo.toggleUserStatus(id);
    }
}
