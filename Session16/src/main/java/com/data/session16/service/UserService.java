package com.data.session16.service;

import com.data.session16.model.User;

public interface UserService {
    boolean save(User user);
    User findByUsername(String username);
}
