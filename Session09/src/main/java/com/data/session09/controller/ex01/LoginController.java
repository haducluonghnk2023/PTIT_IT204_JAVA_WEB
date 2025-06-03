package com.data.session09.controller.ex01;

import com.data.session09.model.ex01.Customer;
import com.data.session09.service.ex01.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "ex01/login";
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute("customer") Customer customer, Model model) {
        Customer result = customerService.checkLogin(customer.getUserName(), customer.getPassword());
        if (result != null) {
            model.addAttribute("customer", result);
            return "ex01/home"; // chuyển sang trang home.jsp
        } else {
            model.addAttribute("error", "Sai tên đăng nhập hoặc mật khẩu!");
            return "ex01/login"; // quay lại login.jsp
        }
    }
}
