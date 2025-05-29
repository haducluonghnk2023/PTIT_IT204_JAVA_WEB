package com.data.session14.controller;

import com.data.session14.model.OrderItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrdersController {
    @GetMapping("/order")
    public String showOrderForm(Model model) {
        return "order-form";
    }

    @PostMapping("/order")
    public String submitOrder(@RequestParam String username,
                              @RequestParam String product,
                              @RequestParam int quantity,
                              HttpSession session,
                              Model model) {
        List<OrderItem> orderList = (List<OrderItem>) session.getAttribute("orders");
        if (orderList == null) {
            orderList = new ArrayList<>();
        }
        orderList.add(new OrderItem(username, product, quantity));
        session.setAttribute("orders", orderList);

        model.addAttribute("successMessage", "Đặt hàng thành công!");
        return "order-form";
    }

    @GetMapping("/order8")
    public String viewOrders(HttpSession session, Model model) {
        List<OrderItem> orderList = (List<OrderItem>) session.getAttribute("orders");
        if (orderList == null) {
            orderList = new ArrayList<>();
        }
        model.addAttribute("orders", orderList);
        return "order-list";
    }


}
