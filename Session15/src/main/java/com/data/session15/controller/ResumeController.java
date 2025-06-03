package com.data.session15.controller;

import com.data.session15.dto.Resume;
import com.data.session15.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/resumes")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @GetMapping
    public String getAllResumes(Model model) {
        model.addAttribute("resumes", resumeService.findAll());
        return "resumes_list";
    }

    @GetMapping("/form")
    public String showForm(@RequestParam(value = "id", required = false) Long id, Model model) {
        Resume resume;
        if (id != null) {
            resume = resumeService.findById(id);
            if (resume == null) {
                resume = new Resume();
            }
        } else {
            resume = new Resume();
        }
        model.addAttribute("resume", resume);
        return "resume_form";
    }


    // Lưu CV
    @PostMapping("/save")
    public String saveResume(@ModelAttribute("resume") @Valid Resume resume,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "resume_form";
        }
        resumeService.save(resume);
        return "redirect:/resumes";
    }

    @GetMapping("/delete/{id}")
    public String deleteResume(@PathVariable("id") Long id) {
        resumeService.delete(id);
        return "redirect:/resumes";
    }
}
