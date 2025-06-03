package com.data.session16.service;

import com.data.session16.dto.UserDTO;
import com.data.session16.model.User;
import com.data.session16.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements  UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public boolean save(User user) {
        return userRepo.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}
