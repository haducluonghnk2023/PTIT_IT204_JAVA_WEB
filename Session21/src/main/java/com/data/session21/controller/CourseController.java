package com.data.session21.controller;

import com.data.session21.dto.CourseDto;
import com.data.session21.entity.Course;
import com.data.session21.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public String listCourses(Model model) {
        model.addAttribute("courses", courseService.findAll());
        return "list_courses";
    }

    @GetMapping("/add")
    public String addCourseForm(Model model) {
        model.addAttribute("course", new CourseDto());
        return "course_form";
    }

    @PostMapping("/save")
    public String saveCourse(@Valid @ModelAttribute("course") CourseDto courseDto,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("course", courseDto);
            return "course_form";
        }

        if (courseService.isDuplicateName(courseDto.getName(), courseDto.getId())) {
            result.rejectValue("name", "error.course", "Tên khóa học đã tồn tại");
            model.addAttribute("course", courseDto);
            return "course_form";
        }

        Course course = new Course();
        course.setId(courseDto.getId());
        course.setName(courseDto.getName());
        course.setDescription(courseDto.getDescription());

        courseService.save(course);
        return "redirect:/courses";
    }


    @GetMapping("/edit/{id}")
    public String editCourseForm(@PathVariable("id") int id, Model model) {
        Course course = courseService.findById(id);
        if (course != null) {
            CourseDto dto = new CourseDto();
            dto.setId(course.getId());
            dto.setName(course.getName());
            dto.setDescription(course.getDescription());
            model.addAttribute("course", dto);
            return "course_form";
        } else {
            return "redirect:/courses";
        }
    }


    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        Course course = courseService.findById(id);
        if (course == null) {
            redirectAttributes.addFlashAttribute("error", "Không tìm thấy khóa học với ID: " + id);
            return "redirect:/courses";
        }

        if (course.getStudents() != null && !course.getStudents().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Không thể xóa khóa học vì còn sinh viên đăng ký.");
            return "redirect:/courses";
        }

        courseService.deleteById(id);
        redirectAttributes.addFlashAttribute("success", "Xóa khóa học thành công!");
        return "redirect:/courses";
    }

}
