package com.data.session05.controller;

import com.data.session05.model.Student04;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "StudentListController05", value = "/StudentListController05")
public class StudentListController05 extends HttpServlet {
    public static List<Student04> studentDB = new ArrayList<>();

    static {
        studentDB.add(new Student04(1, "An", 20, "Hà Nội"));
        studentDB.add(new Student04(2, "Bình", 21, "Phú Thọ"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        request.setAttribute("studentLists", studentDB);
        request.getRequestDispatcher("views/studentList05.jsp").forward(request, response);
    }
}