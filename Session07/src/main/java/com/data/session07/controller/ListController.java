package com.data.session07.controller;

import com.data.session07.model.CartItem;
import com.data.session07.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ListController {
    private List<Product> productList;

    public ListController() {
        productList = getProductList();
    }

    // Tạo danh sách sản phẩm mẫu
    public List<Product> getProductList() {
        List<Product> list = new ArrayList<>();
        list.add(new Product(1L, "Laptop Dell", 1500.0, 10, "Laptop hiệu năng cao", "https://via.placeholder.com/150"));
        list.add(new Product(2L, "iPhone 14", 999.0, 5, "Điện thoại Apple thế hệ mới", "https://via.placeholder.com/150"));
        list.add(new Product(3L, "Tai nghe Sony", 199.0, 15, "Chống ồn chủ động", "https://via.placeholder.com/150"));
        return list;
    }

    // Hiển thị danh sách sản phẩm
    @RequestMapping("/products")
    public String showProductList(Model model) {
        model.addAttribute("products", productList);
        return "product_list";
    }

    // Hiển thị chi tiết sản phẩm theo ID
    @RequestMapping("/product/details")
    public String showProductDetails(@RequestParam("id") Long id, Model model) {
        for (Product p : productList) {
            if (p.getId().equals(id)) {
                model.addAttribute("product", p);
                return "product_details";
            }
        }
        model.addAttribute("error", "Không tìm thấy sản phẩm");
        return "error";
    }

    @PostMapping("/addToCart")
    public String addToCart(@RequestParam int productId,
                            @RequestParam int quantity,
                            HttpSession session,
                            Model model) {

        if (quantity <= 0) {
            model.addAttribute("error", "Số lượng phải lớn hơn 0");
            model.addAttribute("products", productList);
            return "product_list";
        }

        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }

        Optional<Product> optProduct = productList.stream()
                .filter(p -> p.getId() == productId)
                .findFirst();

        if (optProduct.isPresent()) {
            Product product = optProduct.get();
            boolean found = false;
            for (CartItem item : cart) {
                if (item.getProduct().getId() == productId) {
                    item.setQuantity(item.getQuantity() + quantity);
                    found = true;
                    break;
                }
            }

            if (!found) {
                cart.add(new CartItem(product, quantity));
            }
        }

        session.setAttribute("cart", cart);
        return "redirect:/products";
    }

    @GetMapping("/cart")
    public String showCart(HttpSession session, Model model) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) cart = new ArrayList<>();

        double total = cart.stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();

        model.addAttribute("cart", cart);
        model.addAttribute("total", total);
        return "cart";
    }

    @GetMapping("/increase")
    public String increaseQuantity(@RequestParam int id, HttpSession session) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart != null) {
            for (CartItem item : cart) {
                if (item.getProduct().getId() == id) {
                    item.setQuantity(item.getQuantity() + 1);
                    break;
                }
            }
        }
        return "redirect:/cart";
    }

    @GetMapping("/decrease")
    public String decreaseQuantity(@RequestParam int id, HttpSession session) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart != null) {
            for (CartItem item : cart) {
                if (item.getProduct().getId() == id && item.getQuantity() > 1) {
                    item.setQuantity(item.getQuantity() - 1);
                    break;
                }
            }
        }
        return "redirect:/cart";
    }

    @GetMapping("/remove")
    public String removeFromCart(@RequestParam int id, HttpSession session) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart != null) {
            cart.removeIf(item -> item.getProduct().getId() == id);
        }
        return "redirect:/cart";
    }
}
