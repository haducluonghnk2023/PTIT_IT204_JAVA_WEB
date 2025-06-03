package com.data.session14.controller;

import com.data.session14.model.CartItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class CartController {

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("item", new CartItem());
        return "add";
    }

    @PostMapping("/add")
    public String addToCart(@ModelAttribute("item") CartItem item,
                            HttpSession session,
                            HttpServletResponse response) {
        // Lưu vào session
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }

        cart.add(item);
        session.setAttribute("cart", cart);

        // Lưu tên sản phẩm vào cookie (giả sử chỉ cần nhớ tên)
        Cookie cookie = new Cookie("product_" + UUID.randomUUID(), item.getName());
        cookie.setMaxAge(7 * 24 * 60 * 60); // 7 ngày
        cookie.setPath("/");
        response.addCookie(cookie);

        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String viewCart(Model model, HttpSession session, HttpServletRequest request) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) cart = new ArrayList<>();

        model.addAttribute("cart", cart);

        // Lấy sản phẩm từ cookie
        List<String> rememberedProducts = new ArrayList<>();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().startsWith("product_")) {
                    rememberedProducts.add(c.getValue());
                }
            }
        }
        model.addAttribute("rememberedProducts", rememberedProducts);

        return "cart";
    }

    @GetMapping("/delete")
    public String deleteItem(@RequestParam("index") int index, HttpSession session) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart != null && index >= 0 && index < cart.size()) {
            cart.remove(index);
            session.setAttribute("cart", cart);
        }
        return "redirect:/cart";
    }
}
