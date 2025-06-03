package com.data.session05.controller;

import com.data.session05.model.Student04;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "UpdateStudentController", value = "/UpdateStudentController")
public class UpdateStudentController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String address = request.getParameter("address");

        for (Student04 s : StudentListController05.studentDB) {
            if (s.getId() == id) {
                s.setName(name);
                s.setAge(age);
                s.setAddress(address);
                break;
            }
        }

        response.sendRedirect("StudentListController05");
    }
}