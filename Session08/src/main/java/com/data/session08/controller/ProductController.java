package com.data.session08.controller;

import com.data.session08.model.Product;
import com.data.session08.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product";
    }

    @GetMapping("/product/add")
    public String addProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "addProduct";
    }

    @PostMapping("/product/add")
    public String submitProduct(@ModelAttribute("product") Product product, Model model) {
        productService.save(product);
        model.addAttribute("product", product);
        return "productDetail";
    }
}
