package com.data.session06.service.ex02;

import com.data.session06.dao.ex02.UserDao;
import com.data.session06.dao.ex02.UserDaoImpl;
import com.data.session06.model.ex02.User;

public class UserServiceImpl implements UserService{
    private final UserDao userDao;

    public UserServiceImpl() {
        this.userDao = new UserDaoImpl();
    }

    @Override
    public boolean register(User user) {
        return userDao.save(user);
    }

    @Override
    public User login(String username, String password) {
        return userDao.findByUsernameAndPassword(username, password);
    }
}
