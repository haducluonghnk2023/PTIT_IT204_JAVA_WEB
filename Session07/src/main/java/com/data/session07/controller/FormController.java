package com.data.session07.controller;

import com.data.session07.model.FeedBack;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FormController {
    private final List<FeedBack> feedbackList = new ArrayList<>();

    @GetMapping("/form")
    public String showForm() {
        return "form";
    }

    @PostMapping("/submitForm")
    public String submitForm(@RequestParam String fullName,
                             @RequestParam String phone,
                             @RequestParam String address,
                             @RequestParam String content,
                             Model model) {

        List<String> errors = new ArrayList<>();

        if (!StringUtils.hasText(fullName)) {
            errors.add("Họ và tên không được để trống.");
        }

        if (!StringUtils.hasText(content)) {
            errors.add("Nội dung góp ý không được để trống.");
        }

        if (!phone.matches("\\d{9,11}")) {
            errors.add("Số điện thoại không hợp lệ (chỉ chứa số, độ dài 9-11 chữ số).");
        }

        if (!errors.isEmpty()) {
            model.addAttribute("errors", errors);
            return "form";
        }

        FeedBack feedback = new FeedBack(fullName, phone, address, content);
        feedbackList.add(feedback);

        model.addAttribute("feedback", feedback);
        return "result";
    }

    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("feedbackList", feedbackList);
        return "list";
    }
}
