package com.data.session08.controller.ex05;

import com.data.session08.model.ex05.User05;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController05 {

    @GetMapping("/users")
    public ModelAndView showUserList() {
        // Tạo dữ liệu giả
        List<User05> users = new ArrayList<>();

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            users.add(new User05("John Doe", 28, sdf.parse("1997-05-12"), "john.doe@example.com", "123456789"));
            users.add(new User05("Jane Smith", 32, sdf.parse("1993-03-20"), "jane.smith@example.com", "987654321"));
            users.add(new User05("Alice Johnson", 24, sdf.parse("2001-11-05"), "alice.johnson@example.com", "567890123"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        ModelAndView modelAndView = new ModelAndView("userList");
        modelAndView.addObject("users", users);

        return modelAndView;
    }
}
