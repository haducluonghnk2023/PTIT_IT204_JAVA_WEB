package com.data.session14.controller;

import com.data.session14.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class OrderController {
    @GetMapping("/orders")
    public String showOrders(HttpSession session, Model model) {
        List<Order> orders = (List<Order>) session.getAttribute("orders");
        if (orders == null) {
            orders = new ArrayList<>();
            session.setAttribute("orders", orders);
        }
        model.addAttribute("orders", orders);
        return "orderList";
    }

    @GetMapping("/orders/new")
    public String newOrderForm(Model model) {
        model.addAttribute("order", new Order());
        return "orderForm";
    }

    @PostMapping("/orders/save")
    public String saveOrder(@ModelAttribute("order") Order order, HttpSession session) {
        List<Order> orders = (List<Order>) session.getAttribute("orders");
        if (orders == null) {
            orders = new ArrayList<>();
        }

        // Kiểm tra nếu order đã tồn tại thì cập nhật
        Optional<Order> existing = orders.stream()
                .filter(o -> o.getOrderId().equals(order.getOrderId()))
                .findFirst();

        existing.ifPresent(orders::remove);
        orders.add(order);
        session.setAttribute("orders", orders);

        return "redirect:/orders";
    }

    @GetMapping("/orders/edit/{orderId}")
    public String editOrder(@PathVariable String orderId, HttpSession session, Model model) {
        List<Order> orders = (List<Order>) session.getAttribute("orders");
        if (orders != null) {
            for (Order o : orders) {
                if (o.getOrderId().equals(orderId)) {
                    model.addAttribute("order", o);
                    return "orderForm";
                }
            }
        }
        return "redirect:/orders";
    }

    @GetMapping("/orders/delete/{orderId}")
    public String deleteOrder(@PathVariable String orderId, HttpSession session) {
        List<Order> orders = (List<Order>) session.getAttribute("orders");
        if (orders != null) {
            orders.removeIf(o -> o.getOrderId().equals(orderId));
            session.setAttribute("orders", orders);
        }
        return "redirect:/orders";
    }
}
