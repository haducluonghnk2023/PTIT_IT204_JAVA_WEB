package com.data.session06.controller.ex03;

import com.data.session06.model.ex03.Product;
import com.data.session06.model.ex03.ProductCart;
import com.data.session06.service.ex03.ProductCartServiceImpl;
import com.data.session06.service.ex03.ProductServiceImpl;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ProductController", value = "/product")
public class ProductController extends HttpServlet {
    ProductServiceImpl productService = new ProductServiceImpl();
    ProductCartServiceImpl cartService = new ProductCartServiceImpl();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        try {
            List<Product> list = productService.getAllProducts();
            req.setAttribute("products", list);
            req.getRequestDispatcher("views/ex03/listProduct.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = 1;
        int productId = Integer.parseInt(req.getParameter("productId"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        try {
            ProductCart cartItem = new ProductCart();
            cartItem.setUserId(userId);
            cartItem.setProductId(productId);
            cartItem.setQuantity(quantity);

            cartService.save(cartItem);
            resp.sendRedirect("cart");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}