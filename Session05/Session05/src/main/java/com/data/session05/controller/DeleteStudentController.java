package com.data.session05.controller;

import com.data.session05.model.Student04;

import java.io.*;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "DeleteStudentController", value = "/DeleteStudentController")
public class DeleteStudentController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));

        Student04 toRemove = null;
        for (Student04 s : StudentListController05.studentDB) {
            if (s.getId() == id) {
                toRemove = s;
                break;
            }
        }

        if (toRemove != null) {
            StudentListController05.studentDB.remove(toRemove);
        }

        int currentPage = Integer.parseInt(request.getParameter("page"));
        int totalPages = (int) Math.ceil((double) StudentListController.studentDB.size() / 5);
        if (currentPage > totalPages) {
            currentPage = totalPages;
        }

        response.sendRedirect("StudentListController?page=" + currentPage);
    }
}