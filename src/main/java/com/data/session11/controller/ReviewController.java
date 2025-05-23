package com.data.session11.controller;

import com.data.session11.dto.ProductReviewDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ReviewController {
    @GetMapping("/review")
    public String showReviewForm(Model model) {
        model.addAttribute("review", new ProductReviewDto());
        return "reviewForm";
    }

    @PostMapping("/review")
    public String submitReview(@ModelAttribute("review") @Valid ProductReviewDto reviewDto,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "reviewForm";
        }
        model.addAttribute("message", "Đánh giá đã được gửi thành công!");
        return "reviewSuccess";
    }
}
