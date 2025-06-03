package com.data.session17.controller;

import com.data.session17.dto.CustomerLoginDTO;
import com.data.session17.entity.Customer;
import com.data.session17.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class AuthController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "register";
    }

    @PostMapping("/register")
    public String registerCustomer(@ModelAttribute("customer") @Valid Customer customer,
                                   BindingResult result, Model model) {

        if (customerService.existsByUsername(customer.getUsername())) {
            result.rejectValue("username", null, "Username already exists");
        }

        if (customerService.existsByEmail(customer.getEmail())) {
            result.rejectValue("email", null, "Email already exists");
        }

        if (result.hasErrors()) {
            return "register";
        }

        customerService.save(customer);
        model.addAttribute("message", "Registration successful!");
        return "login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("customer", new CustomerLoginDTO());
        return "login";
    }

    // Xử lý đăng nhập
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("customer") CustomerLoginDTO customer,
                        BindingResult result,
                        Model model,
                        HttpSession session) {
        if (result.hasErrors()) {
            return "login";
        }

        Customer existing = customerService.findByUsernameAndPassword(
                customer.getUsername(), customer.getPassword()
        );

        if (existing == null) {
            model.addAttribute("error", "Sai tên đăng nhập hoặc mật khẩu");
            return "login";
        }

        session.setAttribute("loggedInUser", existing);

        if ("ADMIN".equalsIgnoreCase(existing.getRole())) {
            return "redirect:/admin";
        } else {
            return "redirect:/home";
        }
    }
}
