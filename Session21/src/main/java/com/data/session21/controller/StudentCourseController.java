package com.data.session21.controller;

import com.data.session21.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student-course")
public class StudentCourseController {
    @Autowired
    private StudentService studentService;
    @GetMapping
    public String studentCourse(Model model) {
        model.addAttribute("students", studentService.findAlls());
        return "student_registered";
    }
}
