package com.data.session05.controller;

import com.data.session05.model.Product;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ProductController", value = "/ProductController")
public class ProductController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ArrayList<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "Laptop", 1500, "Laptop cao cấp"));
        productList.add(new Product(2, "Smartphone", 800, "Điện thoại thông minh"));
        request.setAttribute("productList", productList);
        request.getRequestDispatcher("views/productList.jsp").forward(request, response);
    }

    public  void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

}