package com.data.session17.controller;

import com.data.session17.entity.Product;
import com.data.session17.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {

    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping( "/home")
    public String home(@RequestParam(defaultValue = "1") int page, Model model) {
        int size = 5;
        List<Product> products = productService.findAll(page, size);
        int totalItems = productService.count();
        int totalPages = (int) Math.ceil((double) totalItems / size);

        model.addAttribute("products", products);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);

        return "home";
    }

    @GetMapping("/product/{id}")
    public String viewProduct(@PathVariable Long id, Model model) {
        Product product = productService.findById(id);
        if (product == null) {
            return "redirect:/home";
        }

        model.addAttribute("product", product);
        return "product_detail";
    }

}
