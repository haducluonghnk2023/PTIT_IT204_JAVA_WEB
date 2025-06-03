package com.data.session12.controller;

import com.data.session12.model.Product;
import com.data.session12.model.Student;
import com.data.session12.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public String student(Model model) {
        model.addAttribute("products", productService.findAll());
        return "productList";
    }

    @GetMapping("/product/add")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "formAddProduct";
    }

    @PostMapping("/product/save")
    public String saveProduct(@Valid @ModelAttribute("product") Product product) {
        if (product.getId() == 0) {
            productService.addProduct(product);
        } else {
            productService.updateProduct(product);
        }
        return "redirect:/product";
    }

    @GetMapping("/product/edit/{id}")
    public String editProduct(@PathVariable("id") int id, Model model) {
        Product product = productService.getProductById(id);
        if (product == null) {
            return "redirect:/product";
        }
        model.addAttribute("product", product);
        return "formAddProduct";
    }



    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        productService.deleteProduct(id);
        return "redirect:/product";
    }
}
