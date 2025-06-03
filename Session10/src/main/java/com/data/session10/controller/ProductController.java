package com.data.session10.controller;

import com.data.session10.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @GetMapping("productForm")
    public String getProducts(Model model) {
        model.addAttribute("product", new Product());
        return "productForm";
    }

    @PostMapping("productSave")
    public String getProductDetail(@ModelAttribute("product") Product product) {
        return "productDetail";
    }
}
