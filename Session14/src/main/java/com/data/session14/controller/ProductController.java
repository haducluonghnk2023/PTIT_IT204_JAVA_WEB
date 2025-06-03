package com.data.session14.controller;

import com.data.session14.model.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    private static final String COOKIE_NAME = "productList";

    private List<Product> getProductListFromCookie(HttpServletRequest request) {
        try {
            for (Cookie cookie : request.getCookies()) {
                if (COOKIE_NAME.equals(cookie.getName())) {
                    String json = URLDecoder.decode(cookie.getValue(), "UTF-8");
                    ObjectMapper mapper = new ObjectMapper();
                    return mapper.readValue(json, new TypeReference<List<Product>>() {});
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    private void saveProductListToCookie(List<Product> products, HttpServletResponse response) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(products);
            String encoded = URLEncoder.encode(json, "UTF-8");
            Cookie cookie = new Cookie(COOKIE_NAME, encoded);
            cookie.setPath("/");
            cookie.setMaxAge(60 * 60);
            response.addCookie(cookie);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/products")
    public String showProducts(Model model, HttpServletRequest request) {
        model.addAttribute("product", new Product());
        model.addAttribute("products", getProductListFromCookie(request));
        return "product";
    }

    @PostMapping("/products")
    public String addProduct(@ModelAttribute Product product,
                             HttpServletRequest request,
                             HttpServletResponse response) {
        List<Product> products = getProductListFromCookie(request);
        products.add(product);
        saveProductListToCookie(products, response);
        return "redirect:/products";
    }

    @GetMapping("/products/delete")
    public String deleteProduct(@RequestParam String id,
                                HttpServletRequest request,
                                HttpServletResponse response) {
        List<Product> products = getProductListFromCookie(request);
        products.removeIf(p -> p.getId().equals(id));
        saveProductListToCookie(products, response);
        return "redirect:/products";
    }
}
