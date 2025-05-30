package com.data.session15.controller;

import com.data.session15.dto.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ProductController {
    private List<Product> productList = new ArrayList<>();

    public ProductController() {
        productList.add(new Product("P001", "Laptop"));
        productList.add(new Product("P002", "Mouse"));
        productList.add(new Product("P003", "Keyboard"));
    }

    @GetMapping("/search")
    public String showSearchForm(Model model) {
        model.addAttribute("keyword", "");
        return "search";
    }

    @PostMapping("/search")
    public String processSearch(@RequestParam("keyword") String keyword, Model model) {
        if (keyword == null || keyword.trim().isEmpty()) {
            model.addAttribute("error", "Vui lòng nhập từ khóa tìm kiếm!");
            return "search";
        }

        List<Product> result = productList.stream()
                .filter(p -> p.getCode().toLowerCase().contains(keyword.toLowerCase())
                        || p.getName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());

        model.addAttribute("result", result);
        model.addAttribute("keyword", keyword);
        return "search";
    }
}
