package com.data.session11.controller;

import com.data.session11.dto.RegisterDTO;
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
    public String showRegisterForm(Model model) {
        model.addAttribute("register", new RegisterDTO());
        return "registerForm";
    }

    @PostMapping("/register")
    public String handleRegister(@Valid @ModelAttribute("register") RegisterDTO registerDTO,
                                 BindingResult result) {
        if (result.hasErrors()) {
            return "registerForm";
        }
        return "registerSuccess";
    }
}
