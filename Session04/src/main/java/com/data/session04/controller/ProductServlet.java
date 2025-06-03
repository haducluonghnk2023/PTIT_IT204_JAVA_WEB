package com.data.session04.controller;

import com.data.session04.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    private List<Product> productList;

    @Override
    public void init() {
        productList = new ArrayList<>();
        productList.add(new Product(1, "Laptop", 1500.0, "Laptop cấu hình cao"));
        productList.add(new Product(2, "Smartphone", 900.0, "Điện thoại thông minh"));
        productList.add(new Product(3, "Headphones", 100.0, "Tai nghe chống ồn"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("products", productList);
        request.getRequestDispatcher("/productList.jsp").forward(request, response);

    }
}