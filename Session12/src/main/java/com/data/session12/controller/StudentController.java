package com.data.session12.controller;

import com.data.session12.model.Status;
import com.data.session12.model.Student;
import com.data.session12.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ServletContext servletContext;

    @GetMapping("/student")
    public String student(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "studentList";
    }

    @GetMapping("/student/add")
    public String addStudent(Model model) {
        model.addAttribute("student", new Student());
        return "formAddStudent";
    }

    @PostMapping("/student/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        MultipartFile file = student.getAvatarFile();
        if (file != null && !file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            String safeFileName = fileName.replaceAll("\\s+", "_"); // bỏ khoảng trắng

            // Đường dẫn upload trong thư mục Tomcat (ROOT/uploads)
            String uploadPath = servletContext.getRealPath("/uploads");
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }
            try {
                File destFile = new File(uploadDir, safeFileName);
                file.transferTo(destFile);
                student.setAvatar("uploads/" + safeFileName); // dùng tên đã xử lý
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // Nếu không chọn ảnh mới, giữ lại ảnh cũ
            if (student.getId() != null) {
                Student existingStudent = studentService.findById(student.getId());
                if (existingStudent != null) {
                    student.setAvatar(existingStudent.getAvatar());
                }
            }
        }

        if (student.getStatus() != null) {
            student.setStatus(Status.fromString(student.getStatus().toString()));
        }

        // Thêm mới hay cập nhật
        if (student.getId() == null || studentService.findById(student.getId()) == null) {
            studentService.save(student);
        } else {
            studentService.update(student);
        }

        return "redirect:/student";
    }


    @GetMapping("/student/edit/{id}")
    public String editStudent(@PathVariable("id") int id, Model model) {
        Student student = studentService.findById(id);
        if (student == null) {
            // Optional: xử lý khi không tìm thấy sinh viên
            return "redirect:/student";
        }
        model.addAttribute("student", student);
        return "formAddStudent"; // Dùng lại form thêm để sửa
    }



    @GetMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        studentService.delete(id);
        return "redirect:/student";
    }
}
