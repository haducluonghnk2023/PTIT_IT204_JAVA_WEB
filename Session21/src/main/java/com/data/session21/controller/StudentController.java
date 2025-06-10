package com.data.session21.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.data.session21.dto.StudentDto;
import com.data.session21.entity.Course;
import com.data.session21.entity.Student;
import com.data.session21.service.CourseService;
import com.data.session21.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private Cloudinary cloudinary;

    @GetMapping
    public String listStudents(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(name = "keyword", required = false) String keyword,
            Model model) {

        List<Student> students;
        long totalStudents;

        if (keyword != null && !keyword.trim().isEmpty()) {
            students = studentService.findByName(keyword);
            totalStudents = students.size();
        } else {
            students = studentService.findAll(page, size);
            totalStudents = studentService.findByName("").size(); // hoặc studentService.findAll(1, Integer.MAX_VALUE).size()
        }

        int totalPages = (int) Math.ceil((double) totalStudents / size);

        model.addAttribute("students", students);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("pageSize", size);
        model.addAttribute("keyword", keyword);

        return "list_student";
    }


    @GetMapping("/add")
    public String addStudentForm(Model model) {
        model.addAttribute("student", new StudentDto());
        model.addAttribute("courses", courseService.findAll());
        return "student_form";
    }

    @PostMapping("/save")
    public String saveStudent(@Valid @ModelAttribute("student") StudentDto studentDto,
                              BindingResult bindingResult,
                              Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("courses", courseService.findAll());
            return "student_form";
        }

        try {
            MultipartFile file = studentDto.getImageFile();
            String uploadedImageUrl = null;

            boolean isNewStudent = (studentDto.getId() == null);
            Student student = isNewStudent ? new Student() : studentService.findById(studentDto.getId());

            if (student == null) {
                model.addAttribute("error", "Không tìm thấy sinh viên để cập nhật.");
                return "redirect:/students";
            }

            if (isNewStudent || (file != null && !file.isEmpty())) {
                if (file == null || file.isEmpty()) {
                    model.addAttribute("error", "Vui lòng chọn ảnh.");
                    model.addAttribute("courses", courseService.findAll());
                    return "student_form";
                }
                Map<?, ?> uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
                uploadedImageUrl = (String) uploadResult.get("secure_url");
                student.setAvatar(uploadedImageUrl);
            }

            // Gán dữ liệu từ DTO sang Entity
            student.setName(studentDto.getName());
            student.setEmail(studentDto.getEmail());
            student.setPhone(studentDto.getPhone());
            student.setSex(studentDto.getSex());
            student.setBod(studentDto.getBod());
            student.setStatus(studentDto.getStatus());

            // Gán course
            if (studentDto.getCourseIds() != null && !studentDto.getCourseIds().isEmpty()) {
                List<Course> selectedCourses = courseService.findByIds(studentDto.getCourseIds());
                student.setCourses(new HashSet<>(selectedCourses));
            } else {
                student.setCourses(new HashSet<>());
            }

            studentService.save(student);
            return "redirect:/students";

        } catch (Exception e) {
            model.addAttribute("error", "Lỗi khi lưu sinh viên: " + e.getMessage());
            model.addAttribute("courses", courseService.findAll());
            return "student_form";
        }
    }


    @GetMapping("/edit/{id}")
    public String editStudentForm(@PathVariable("id") Integer id, Model model) {
        Student student = studentService.findById(id);
        if (student == null) {
            model.addAttribute("error", "Không tìm thấy sinh viên với ID: " + id);
            return "redirect:/students";
        }

        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setEmail(student.getEmail());
        studentDto.setPhone(student.getPhone());
        studentDto.setSex(student.getSex());
        studentDto.setBod(student.getBod());
        studentDto.setStatus(student.getStatus());
        studentDto.setAvatar(student.getAvatar());
        if (student.getCourses() != null) {
            List<Integer> selectedCourseIds = student.getCourses()
                    .stream()
                    .map(Course::getId)
                    .collect(Collectors.toList());
            studentDto.setCourseIds(selectedCourseIds);
        }


        model.addAttribute("student", studentDto);
        model.addAttribute("courses", courseService.findAll());
        return "student_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        try {
            studentService.deleteById(id);
            redirectAttributes.addFlashAttribute("success", "Xóa sinh viên thành công!");
        } catch (IllegalStateException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Đã xảy ra lỗi khi xóa sinh viên.");
        }
        return "redirect:/students";
    }

}
