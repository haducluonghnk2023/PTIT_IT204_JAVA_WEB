package com.data.session05.controller;

import com.data.session05.model.Student;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "StudentController03", value = "/submitStudent03")
public class StudentController03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.sendRedirect("views/studentForm03.jsp");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String ageStr = request.getParameter("age");
        String address = request.getParameter("address");

        String error = null;
        int age = 0;

        // Kiểm tra dữ liệu
        if (name == null || name.trim().isEmpty() ||
                ageStr == null || address == null || address.trim().isEmpty()) {
            error = "Vui lòng nhập đầy đủ thông tin!";
        } else {
            try {
                age = Integer.parseInt(ageStr);
                if (age <= 0) {
                    error = "Tuổi phải lớn hơn 0!";
                }
            } catch (NumberFormatException e) {
                error = "Tuổi phải là số nguyên!";
            }
        }

        if (error != null) {
            request.setAttribute("error", error);
            request.getRequestDispatcher("views/studentForm03.jsp").forward(request, response);
        } else {
            Student student = new Student(name, age, address);
            request.setAttribute("student", student);
            request.getRequestDispatcher("views/confirmation.jsp").forward(request, response);
        }
    }
}