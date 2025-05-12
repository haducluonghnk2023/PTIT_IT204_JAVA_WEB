package com.data.session05.controller;

import com.data.session05.model.Student;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "StudentController", value = "/submitStudent")
public class StudentController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.sendRedirect("views/studentForm.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        // Nhận dữ liệu từ form
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String address = request.getParameter("address");

        // Tạo đối tượng Student
        Student student = new Student(name, age, address);

        // Lưu vào request để gửi đến view xác nhận
        request.setAttribute("student", student);

        // Chuyển tiếp đến trang xác nhận
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/confirmation.jsp");
        dispatcher.forward(request, response);
    }

}