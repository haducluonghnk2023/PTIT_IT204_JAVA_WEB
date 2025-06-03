package com.data.session10.controller;

import com.data.session10.model.Account;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {
    @GetMapping("/account")
    public String account(Model model) {
        model.addAttribute("account", new Account());
        return "registerForm";
    }

    @PostMapping("/register")
    public String accountPost(@ModelAttribute("account") Account account, Model model) {
        model.addAttribute("account", account);
        return "accountDetail";
    }
}
