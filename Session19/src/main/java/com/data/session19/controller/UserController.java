package com.data.session19.controller;

import com.data.session19.entity.User;
import com.data.session19.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String listUsers(Model model,
                            @RequestParam(defaultValue = "1") int page,
                            @RequestParam(defaultValue = "5") int size) {

        List<User> users = userService.findAll(page, size);
        long totalUsers = userService.countUsers();
        int totalPages = (int) Math.ceil((double) totalUsers / size);

        model.addAttribute("users", users);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);

        return "user-list";
    }

    @PostMapping("/{id}/toggle")
    public String toggleUserStatus(@PathVariable Long id,
                                   @RequestParam(defaultValue = "1") int page) {
        userService.toggleUserStatus(id);
        return "redirect:/users?page=" + page;
    }
}
