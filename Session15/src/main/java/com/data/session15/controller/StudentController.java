package com.data.session15.controller;

import com.data.session15.dto.StudentDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class StudentController {

    @GetMapping("/students")
    public String getStudents(Model model) {
        List<StudentDto> students = Arrays.asList(
                new StudentDto("SV001", "Nguyễn Văn A", 20, "CTK42", "a@gmail.com", "Hà Nội", "0123456789"),
                new StudentDto("SV002", "Trần Thị B", 21, "CTK43", "b@gmail.com", "TP.HCM", "0987654321"),
                new StudentDto("SV003", "Lê Văn C", 22, "CTK44", "c@gmail.com", "Đà Nẵng", "0111222333")
        );

        model.addAttribute("students", students);
        return "student-list";
    }
}
