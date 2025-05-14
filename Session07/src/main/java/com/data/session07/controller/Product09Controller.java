package com.data.session07.controller;

import com.data.session07.model.Category;
import com.data.session07.model.Product09;
import com.data.session07.repository.CategoryRepository;
import com.data.session07.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products09")
public class Product09Controller {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryRepository categoryRepository;

    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping
    public String listProducts(@RequestParam(name = "search", required = false) String search, Model model) {
        List<Product09> products = (search != null && !search.isEmpty())
                ? productService.search(search)
                : productService.getAll();
        model.addAttribute("products", products);
        return "productList";
    }

    @GetMapping("/{id}")
    public String showProductDetails(@PathVariable("id") Long id, Model model) {
        Product09 product = productService.getById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        model.addAttribute("product", product);
        return "productDetails";
    }

    @GetMapping("/add")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product09());
        return "addProduct";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Product09 product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("message", "Product added successfully!");
        return "redirect:/products09";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") Long id, Model model) {
        Product09 product = productService.getById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        model.addAttribute("product", product);
        return "editProduct";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Product09 product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("message", "Product updated successfully!");
        return "redirect:/products09";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        productService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Product deleted successfully!");
        return "redirect:/products09";
    }

}
