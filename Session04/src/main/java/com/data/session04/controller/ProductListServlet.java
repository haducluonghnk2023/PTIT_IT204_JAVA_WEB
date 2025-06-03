package com.data.session04.controller;

import com.data.session04.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ProductListServlet", value = "/ProductList07")
public class ProductListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Sản phẩm A", 100," Mô tả A"));
        products.add(new Product(2, "Sản phẩm B", 200, "Mô tả B"));
        products.add(new Product(3, "Sản phẩm C", 300, "Mô tả C"));
        products.add(new Product(4, "Sản phẩm D", 150, "Mô tả D"));

        double minPrice = 0;
        double maxPrice = Double.MAX_VALUE;

        // Lấy giá tối thiểu và tối đa từ request
        String minPriceStr = request.getParameter("minPrice");
        String maxPriceStr = request.getParameter("maxPrice");

        if (minPriceStr != null && !minPriceStr.isEmpty()) {
            minPrice = Double.parseDouble(minPriceStr);
        }
        if (maxPriceStr != null && !maxPriceStr.isEmpty()) {
            maxPrice = Double.parseDouble(maxPriceStr);
        }

        // Lọc sản phẩm theo giá
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                filteredProducts.add(product);
            }
        }

        // Đưa danh sách sản phẩm đã lọc vào request
        request.setAttribute("filteredProducts", filteredProducts);

        // Chuyển tiếp đến trang JSP
        request.getRequestDispatcher("/productList07.jsp").forward(request, response);
    }
}