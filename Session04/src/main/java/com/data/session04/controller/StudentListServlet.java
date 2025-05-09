package com.data.session04.controller;

import com.data.session04.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "StudentListServlet", value = "/StudentListServlet")
public class StudentListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Nguyễn Văn A", 20, 7.5));
        students.add(new Student(2, "Trần Thị B", 21, 6.8));
        students.add(new Student(3, "Phạm Minh C", 22, 8.2));
        students.add(new Student(4, "Lê Thị D", 23, 7.1));

        // Đưa danh sách sinh viên vào request
        request.setAttribute("students", students);

        // Chuyển tiếp đến trang JSP
        request.getRequestDispatcher("/studentList.jsp").forward(request, response);
    }
}