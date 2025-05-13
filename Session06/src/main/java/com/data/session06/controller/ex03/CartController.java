package com.data.session06.controller.ex03;

import com.data.session06.model.ex03.Product;
import com.data.session06.model.ex03.ProductCart;
import com.data.session06.service.ex03.ProductCartServiceImpl;
import com.data.session06.service.ex03.ProductServiceImpl;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "CartController", value = "/cart")
public class CartController extends HttpServlet {
    ProductCartServiceImpl cartService = new ProductCartServiceImpl();
    ProductServiceImpl productService = new ProductServiceImpl();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        int userId = 1;
        try {
            List<ProductCart> cartList = cartService.getCartByUser(userId);
            Map<Integer, Product> productMap = new HashMap<>();
            for (ProductCart c : cartList) {
                productMap.put(c.getProductId(), productService.getProduct(c.getProductId()));
            }
            System.out.println("CartController - cartList size: " + (cartList != null ? cartList.size() : "null"));
            System.out.println("CartController - productMap size: " + (productMap != null ? productMap.size() : "null"));
            req.setAttribute("cartList", cartList);
            req.setAttribute("productMap", productMap);
            req.getRequestDispatcher("views/ex03/cart.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int cartId = Integer.parseInt(req.getParameter("cartId"));
        try {
            cartService.delete(cartId);
            resp.sendRedirect("cart");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}