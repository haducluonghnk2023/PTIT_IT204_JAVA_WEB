package com.data.session17.controller;

import com.data.session17.entity.Customer;
import com.data.session17.entity.Order;
import com.data.session17.entity.Product;
import com.data.session17.entity.ProductCart;
import com.data.session17.service.ProductCartService;
import com.data.session17.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class OrderController {

    @Autowired
    private ProductCartService productCartService;

    @Autowired
    private ProductService productService;

    @GetMapping("/order/checkout")
    public String checkoutForm(HttpSession session, Model model) {
        Customer customer = (Customer) session.getAttribute("loggedInUser");
        if (customer == null) {
            return "redirect:/login";
        }

        List<ProductCart> cartItems = productCartService.findByCustomerId(Long.valueOf(customer.getId()));

        // Tính tổng bằng cách lấy Product từ ProductService
        double total = cartItems.stream()
                .mapToDouble(item -> {
                    Product product = productService.findById(item.getProductId());
                    return (product != null ? product.getPrice() : 0.0) * item.getQuantity();
                })
                .sum();

        Order order = new Order();
        order.setTotalMoney(total);
        model.addAttribute("order", order);
        model.addAttribute("total", total);
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("productService", productService);
        return "checkout"; // checkout.html
    }

    @PostMapping("/order/checkout")
    public String handleCheckout(@ModelAttribute("order") Order order, HttpSession session) {
        Customer customer = (Customer) session.getAttribute("loggedInUser");
        if (customer == null) {
            return "redirect:/login";
        }

        order.setCustomerId(Long.valueOf(customer.getId()));
        order.setStatus("Pending");

        // Lấy danh sách sản phẩm và đảm bảo product không null
        List<ProductCart> cartItems = productCartService.findByCustomerId(Long.valueOf(customer.getId())).stream()
                .peek(item -> item.setProduct(productService.findById(item.getProductId())))
                .collect(Collectors.toList());

        order.setListProduct(cartItems);

        // TODO: Lưu đơn hàng vào DB nếu có repository

        // Xóa giỏ hàng
        productCartService.clearCartByCustomerId(Long.valueOf(customer.getId()));

        return "redirect:/order/success";
    }

    @GetMapping("/order/success")
    public String successPage() {
        return "success"; // success.html
    }
}
