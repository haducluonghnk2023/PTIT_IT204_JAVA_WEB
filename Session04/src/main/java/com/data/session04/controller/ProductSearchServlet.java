package com.data.session04.controller;

import com.data.session04.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/productSearch")
public class ProductSearchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Laptop", 15000000, "Máy tính xách tay"));
        products.add(new Product(2, "Điện thoại", 10000000, "Smartphone"));
        products.add(new Product(3, "Tablet", 5000000, "Máy tính bảng"));

        String productIdStr = request.getParameter("productId");
        Product product = null;

        if (productIdStr != null) {
            try {
                int productId = Integer.parseInt(productIdStr);
                // Tìm sản phẩm theo ID
                for (Product p : products) {
                    if (p.getId() == productId) {
                        product = p;
                        break;
                    }
                }
            } catch (NumberFormatException e) {
                // Nếu ID không hợp lệ, giữ product = null
            }
        }

        // Gửi danh sách sản phẩm và kết quả tìm kiếm đến JSP
        request.setAttribute("products", products);
        request.setAttribute("product", product);

        // Forward đến trang JSP
        request.getRequestDispatcher("/productSearch.jsp").forward(request, response);
    }
}
