package com.data.session18.controller;

import com.data.session18.entity.Product;
import com.data.session18.entity.User;
import com.data.session18.service.OrderService;
import com.data.session18.service.ProductService;
import com.data.session18.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriUtils;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    // Trang dashboard chính
    @GetMapping
    public String adminDashboard(Model model) {
        model.addAttribute("userCount", userService.countUsers());
        model.addAttribute("productCount", productService.countProducts());
        model.addAttribute("orderCount", orderService.countOrders());
        model.addAttribute("monthlyRevenue", orderService.getRevenueByMonth());
        model.addAttribute("yearlyRevenue", orderService.getRevenueByYear());

        return "admin/dashboard"; // 👉 KHÔNG TRẢ VỀ layout trực tiếp
    }

    // Quản lý sản phẩm
    @GetMapping("/products")
    public String manageProducts(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(required = false) String name,
            Model model) {

        List<Product> products;
        long totalProducts;

        if (StringUtils.hasText(name)) {
            products = productService.findByNameContaining(name, page, size);
            totalProducts = productService.countByNameContaining(name);
        } else {
            products = productService.findAll(page, size);
            totalProducts = productService.countProducts();
        }

        int totalPages = (int) Math.ceil((double) totalProducts / size);

        model.addAttribute("products", products);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("pageSize", size);
        model.addAttribute("filterName", name);

        return "admin/products";
    }

    // Quản lý người dùng
    @GetMapping("/users")
    public String manageUsers(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(required = false) String keyword,
            Model model) {

        List<User> users;
        long totalUsers;

        if (StringUtils.hasText(keyword)) {
            users = userService.findUsers(keyword, page, size);
            totalUsers = userService.countUsers(keyword);
        } else {
            users = userService.findUsers(null, page, size);
            totalUsers = userService.countUsers(null);
        }

        int totalPages = (int) Math.ceil((double) totalUsers / size);

        model.addAttribute("users", users);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("pageSize", size);
        model.addAttribute("filterKeyword", keyword);

        return "admin/users";
    }

    @PostMapping("/users/lock/{id}")
    public String lockUser(@PathVariable("id") Long id,
                           @RequestParam(required = false) String keyword,
                           @RequestParam(defaultValue = "1") int page) {
        userService.lockUser(id);
        String encoded = keyword != null ? "&keyword=" + UriUtils.encode(keyword, StandardCharsets.UTF_8) : "";
        return "redirect:/admin/users?page=" + page + encoded;
    }

    @PostMapping("/users/unlock/{id}")
    public String unlockUser(@PathVariable("id") Long id,
                             @RequestParam(required = false) String keyword,
                             @RequestParam(defaultValue = "1") int page) {
        userService.unlockUser(id);
        String encoded = keyword != null ? "&keyword=" + UriUtils.encode(keyword, StandardCharsets.UTF_8) : "";
        return "redirect:/admin/users?page=" + page + encoded;
    }

    // Quản lý đơn hàng
    @GetMapping("/orders")
    public String manageOrders(Model model) {
        model.addAttribute("orders", orderService.findAll());
        return "admin/orders";
    }

    // Sửa sản phẩm
    @GetMapping("/products/edit/{id}")
    public String showEditProductForm(@PathVariable("id") Long id, Model model) {
        Product product = productService.findById(id);
        if (product == null) {
            return "redirect:/admin/products";
        }
        model.addAttribute("product", product);
        return "admin/editProduct";
    }

    @PostMapping("/products/edit")
    public String updateProduct(Product product) {
        productService.save(product);
        return "redirect:/admin/products";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteById(id);
        return "redirect:/admin/products";
    }
}
