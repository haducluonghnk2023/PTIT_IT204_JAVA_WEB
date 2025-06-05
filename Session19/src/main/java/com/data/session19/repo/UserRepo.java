package com.data.session19.repo;

import com.data.session19.entity.User;

import java.util.List;

public interface UserRepo {
    List<User> findAll(int pageNumber, int pageSize);
    long countUsers();
    void toggleUserStatus(Long id);
}
