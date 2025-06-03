package com.data.session15.controller;

import com.data.session15.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String handleRegister(@ModelAttribute("user") @Valid User user,
                                 BindingResult result,
                                 Model model) {
        if (result.hasErrors()) {
            return "register";
        }
        model.addAttribute("message", "Đăng ký thành công!");
        return "result";
    }
}
