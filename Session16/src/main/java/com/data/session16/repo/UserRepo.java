package com.data.session16.repo;

import com.data.session16.model.User;

public interface UserRepo {
    boolean save(User user);
    User findByUsername(String username);
}
