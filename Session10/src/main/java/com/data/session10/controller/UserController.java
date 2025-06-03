package com.data.session10.controller;

import com.data.session10.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("userForm")
    public String showUserForm(Model model) {
        model.addAttribute("user", new User());
        return "userForm";
    }
    @PostMapping("userSave")
    public String saveUser(@ModelAttribute("user") User user) {
        return "userDetail";
    }
}
