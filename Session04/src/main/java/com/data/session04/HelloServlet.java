package com.data.session04;

import com.data.session04.model.Product;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Product product = new Product(101, "Chuột gaming", 399.0, "Chuột RGB dành cho game thủ");

        request.setAttribute("product", product);

        RequestDispatcher dispatcher = request.getRequestDispatcher("productDetail.jsp");
        dispatcher.forward(request, response);
    }

    public void destroy() {
    }
}