package com.data.session18.service;

import com.data.session18.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll(int pageNumber, int pageSize);
    int countUsers();
    List<User> findUsers(String keyword, int pageNumber, int pageSize);

    long countUsers(String keyword);

    void lockUser(Long userId);

    void unlockUser(Long userId);
}
