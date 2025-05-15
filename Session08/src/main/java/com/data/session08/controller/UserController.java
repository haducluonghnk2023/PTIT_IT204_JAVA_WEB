package com.data.session08.controller;

import com.data.session08.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

//    @Autowired
//    private UserService userService;

    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/register")
    public String submitForm(@ModelAttribute("user") User user, Model model) {
        Map<String, String> errors = new HashMap<>();

        if (user.getName() == null || user.getName().trim().isEmpty()) {
            errors.put("nameError", "Vui lòng nhập tên.");
        }

        if (user.getEmail() == null || !user.getEmail().matches("^\\S+@\\S+\\.\\S+$")) {
            errors.put("emailError", "Email không hợp lệ.");
        }

        if (user.getPhone() == null || !user.getPhone().matches("\\d{10,11}")) {
            errors.put("phoneError", "Số điện thoại phải từ 10–11 chữ số.");
        }

        if (!errors.isEmpty()) {
            model.addAttribute("errors", errors);
            return "registration";
        }

//        userService.save(user);
        model.addAttribute("user", user);
        return "result";
    }
}
