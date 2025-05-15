package com.data.session08.controller;

import com.data.session08.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {

    private List<Employee> employees = new ArrayList<>();

    @GetMapping("/employees")
    public String showEmployeeList(Model model) {
        model.addAttribute("employees", employees);
        return "listEmployee";
    }

    @GetMapping("/employees/add")
    public String addEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee("", "", ""));
        return "addEmployee";
    }

    // Thêm nhân viên mới
    @PostMapping("/employees")
    public String addEmployee(@ModelAttribute("employee") Employee employee) {
        employees.add(employee);
        return "redirect:/employees";
    }
}
