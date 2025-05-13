package com.data.session06.controller.ex02;

import com.data.session06.model.ex02.User;
import com.data.session06.service.ex02.UserService;
import com.data.session06.service.ex02.UserServiceImpl;

import java.io.*;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("views/ex02/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));
        user.setPhone(request.getParameter("phone"));

        boolean success = userService.register(user);
        if (success) {
            response.sendRedirect("LoginController");
        } else {
            request.setAttribute("error", "Đăng ký thất bại");
            request.getRequestDispatcher("views/ex02/register.jsp").forward(request, response);
        }
    }
}
