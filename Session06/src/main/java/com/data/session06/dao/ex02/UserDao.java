package com.data.session06.dao.ex02;

import com.data.session06.model.ex02.User;

public interface UserDao {
    boolean save(User user);
    User findByUsernameAndPassword(String username, String password);
}
