package com.data.session11.controller;

import com.data.session11.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("user", new UserDTO());
        return "userForm";
    }

    @PostMapping("/submitForm")
    public String submitForm(@Valid @ModelAttribute("user") UserDTO user,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "userForm";
        }
        return "result";
    }
}
