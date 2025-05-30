package com.data.session15.controller;

import com.data.session15.dto.Cart;
import com.data.session15.dto.Product06;
import com.data.session15.dto.Review;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class ProductController06 {
    private List<Product06> productList = new ArrayList<>();
    private List<Review> reviewList = new ArrayList<>();
    private int reviewIdCounter = 1;
    private List<Cart> cartList = new ArrayList<>();
    private int cartIdCounter = 1;
    private final int currentUserId = 1;

    public ProductController06() {
        productList.add(new Product06(1, "Laptop", "Laptop cao cấp", 1500.0));
        productList.add(new Product06(2, "Mouse", "Chuột không dây", 25.0));
    }

    @GetMapping("/products")
    public String showProducts(Model model) {
        model.addAttribute("products", productList);
        return "list-product";
    }

    @GetMapping("/products/{id}")
    public String productDetail(@PathVariable int id, Model model) {
        Product06 product = productList.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
        if (product == null) return "redirect:/products";

        List<Review> reviews = new ArrayList<>();
        for (Review r : reviewList) {
            if (r.getIdProduct() == id) reviews.add(r);
        }

        model.addAttribute("product", product);
        model.addAttribute("reviews", reviews);
        model.addAttribute("review", new Review()); // form đánh giá
        return "product-detail";
    }

    @PostMapping("/products/{id}/review")
    public String addReview(@PathVariable int id,
                            @ModelAttribute("review") Review review) {
        review.setId(reviewIdCounter++);
        review.setIdProduct(id);
        review.setIdUser(1); // mặc định user id 1
        reviewList.add(review);
        return "redirect:/products/" + id;
    }

    @PostMapping("/cart/add/{productId}")
    public String addToCart(@PathVariable int productId,
                            @RequestParam(defaultValue = "1") int quantity) {
        Optional<Cart> existingCart = cartList.stream()
                .filter(c -> c.getIdProduct() == productId && c.getIdUser() == currentUserId)
                .findFirst();

        if (existingCart.isPresent()) {
            existingCart.get().setQuantity(existingCart.get().getQuantity() + quantity);
        } else {
            Cart cart = new Cart(cartIdCounter++, currentUserId, productId, quantity);
            cartList.add(cart);
        }
        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String viewCart(Model model) {
        List<Map<String, Object>> cartItems = new ArrayList<>();
        double total = 0.0;

        for (Cart c : cartList) {
            if (c.getIdUser() == currentUserId) {
                Product06 product = productList.stream()
                        .filter(p -> p.getId() == c.getIdProduct()).findFirst().orElse(null);

                if (product != null) {
                    Map<String, Object> item = new HashMap<>();
                    item.put("product", product);
                    item.put("quantity", c.getQuantity());
                    item.put("totalPrice", product.getPrice() * c.getQuantity());
                    total += product.getPrice() * c.getQuantity();
                    cartItems.add(item);
                }
            }
        }

        model.addAttribute("cartItems", cartItems);
        model.addAttribute("total", total);
        return "cart";
    }

}
