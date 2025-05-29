package com.data.session14.service;

import com.data.session14.model.User;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    public boolean authenticate(User user) {
        return "admin".equals(user.getUsername()) && "123".equals(user.getPassword());
    }
}
