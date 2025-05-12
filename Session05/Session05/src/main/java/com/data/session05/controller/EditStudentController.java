package com.data.session05.controller;

import com.data.session05.model.Student04;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "EditStudentController", value = "/EditStudentController")
public class EditStudentController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));

        Student04 student = null;
        for (Student04 s : StudentListController.studentDB) {
            if (s.getId() == id) {
                student = s;
                break;
            }
        }

        request.setAttribute("student", student);
        request.getRequestDispatcher("views/editStudent.jsp").forward(request, response);
    }
}