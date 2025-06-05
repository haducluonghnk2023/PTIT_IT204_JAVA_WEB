package com.data.session19.service;

import com.data.session19.entity.User;

import java.util.List;

public interface UserService {
    /**
     * Retrieves all users.
     *
     * @return a list of all users, or an empty list if no users are found
     */
    List<User> findAll(int pageNumber, int pageSize);
    long countUsers();
    void toggleUserStatus(Long id);
}
