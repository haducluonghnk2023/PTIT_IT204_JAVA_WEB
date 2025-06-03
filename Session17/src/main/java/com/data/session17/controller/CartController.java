package com.data.session17.controller;

import com.data.session17.entity.Customer;
import com.data.session17.entity.Product;
import com.data.session17.entity.ProductCart;
import com.data.session17.service.ProductCartService;
import com.data.session17.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    private final ProductCartService productCartService;
    private final ProductService productService;

    public CartController(ProductCartService productCartService, ProductService productService) {
        this.productCartService = productCartService;
        this.productService = productService;
    }

    // ✅ 1. Thêm sản phẩm vào giỏ
    @PostMapping("/add/{productId}")
    public String addToCart(@PathVariable Long productId, HttpSession session) {
        Customer customer = (Customer) session.getAttribute("loggedInUser");

        if (customer == null) {
            return "redirect:/login";
        }

        Long customerId = Long.valueOf(customer.getId());

        ProductCart existingCart = productCartService.findByCustomerIdAndProductId(customerId, productId);

        if (existingCart != null) {
            existingCart.setQuantity(existingCart.getQuantity() + 1);
        } else {
            ProductCart newCart = new ProductCart();
            newCart.setCustomerId(customerId);
            newCart.setProductId(productId);
            newCart.setQuantity(1);
            existingCart = newCart;
        }

        productCartService.save(existingCart);

        return "redirect:/cart/view";
    }

    // ✅ 2. Xem giỏ hàng
    @GetMapping("/view")
    public String viewCart(HttpSession session, Model model) {
        Customer customer = (Customer) session.getAttribute("loggedInUser");
        if (customer == null) {
            return "redirect:/login";
        }

        Long customerId = Long.valueOf(customer.getId());
        List<ProductCart> cartItems = productCartService.findByCustomerId(customerId);

        double total = cartItems.stream()
                .mapToDouble(item -> {
                    Product product = productService.findById(item.getProductId());
                    return product.getPrice() * item.getQuantity();
                })
                .sum();

        model.addAttribute("cartItems", cartItems);
        model.addAttribute("productService", productService);
        model.addAttribute("total", total);

        return "cart"; // -> cart.html
    }


    // ✅ 3. Cập nhật số lượng sản phẩm
    @PostMapping("/update")
    public String updateCart(@RequestParam Long cartId,
                             @RequestParam int quantity) {
        ProductCart cartItem = productCartService.findById(cartId);
        if (cartItem != null && quantity > 0) {
            cartItem.setQuantity(quantity);
            productCartService.save(cartItem);
        }
        return "redirect:/cart/view";
    }

    // ✅ 4. Xóa sản phẩm khỏi giỏ
    @PostMapping("/remove")
    public String removeItem(@RequestParam Long cartId) {
        productCartService.deleteById(cartId);
        return "redirect:/cart/view";
    }
}
