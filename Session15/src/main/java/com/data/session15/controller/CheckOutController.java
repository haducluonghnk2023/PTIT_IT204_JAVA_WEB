package com.data.session15.controller;

import com.data.session15.dto.CartItem;
import com.data.session15.dto.OrderRequest;
import com.data.session15.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

@Controller
public class CheckOutController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/checkout")
    public String checkout(OrderRequest orderRequest, HttpSession session) {
        List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cartItems");
        Integer userId = (Integer) session.getAttribute("userId");

        if (cartItems == null || cartItems.isEmpty() || userId == null) {
            return "redirect:/cart?error=empty";
        }

        // Set userId cho orderRequest
        orderRequest.setUserId(userId);

        // Lặp từng sản phẩm và lưu đơn hàng, sử dụng thông tin orderRequest người nhận từ form
        for (CartItem item : cartItems) {
            OrderRequest order = new OrderRequest();
            order.setUserId(userId);
            order.setRecipientName(orderRequest.getRecipientName());
            order.setAddress(orderRequest.getAddress());
            order.setPhoneNumber(orderRequest.getPhoneNumber());

            order.setProductId(item.getProduct().getId());
            order.setQuantity(item.getQuantity());
            order.setCurrentPrice(BigDecimal.valueOf(item.getProduct().getPrice()));

            orderService.addOrder(order);
        }

        // Xoá giỏ hàng sau khi đặt
        session.removeAttribute("cartItems");

        return "redirect:/success";
    }
}
