package com.data.session06.service.ex02;

import com.data.session06.model.ex02.User;

public interface UserService {
    boolean register(User user);
    User login(String username, String password);
}
