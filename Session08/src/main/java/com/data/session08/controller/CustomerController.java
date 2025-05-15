package com.data.session08.controller;

import com.data.session08.model.Customer;
import com.data.session08.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("customer")
    public String getAllCustomers(Model model) {
        List<Customer> customers = customerService.getAllCustomers();
        System.out.println("Customers size: " + customers.size());
        model.addAttribute("customers", customers);
        return "customer"; // file customer.jsp
    }
}
