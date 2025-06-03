package com.data.session03.controller;

import com.data.session03.model.User;
import com.data.session03.model.UserManager;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    private int userIdCounter = 1;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String name = request.getParameter("name");
            String email = request.getParameter("email");

            User user = new User(userIdCounter++, name, email);
            UserManager.addUser(user);

            request.setAttribute("message", "Thêm người dùng thành công!");
            request.getRequestDispatcher("listUser.jsp").forward(request, response);
        }

        if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            UserManager.removeUser(id);
            request.setAttribute("message", "Xóa người dùng thành công!");
            request.getRequestDispatcher("listUser.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = UserManager.getUsers();
        request.setAttribute("users", users);
        request.getRequestDispatcher("listUser.jsp").forward(request, response);
    }
}