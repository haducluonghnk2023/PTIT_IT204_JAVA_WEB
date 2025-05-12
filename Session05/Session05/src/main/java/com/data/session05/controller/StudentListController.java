package com.data.session05.controller;


import com.data.session05.model.Student04;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "StudentListController", value = "/StudentListController")
public class StudentListController extends HttpServlet {
    public static List<Student04> studentDB = new ArrayList<>();

    static {
        studentDB.add(new Student04(1, "An", 20, "Hà Nội"));
        studentDB.add(new Student04(2, "Bình", 21, "Phú Thọ"));
        studentDB.add(new Student04(3, "Công", 22, "Hải Phòng"));
        studentDB.add(new Student04(4, "Duy", 23, "Hà Nội"));
        studentDB.add(new Student04(5, "Hải", 20, "Bắc Ninh"));
        studentDB.add(new Student04(6, "Quân", 21, "Hà Nam"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        int pageSize = 2;

        int page = 1;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        // Tính toán số lượng sinh viên cần hiển thị
        int start = (page - 1) * pageSize;
        int end = Math.min(start + pageSize, studentDB.size());

        // Lấy danh sách sinh viên cho trang hiện tại
        List<Student04> studentsOnPage = studentDB.subList(start, end);

        // Tính tổng số trang
        int totalPages = (int) Math.ceil((double) studentDB.size() / pageSize);

        // Đặt các thuộc tính vào request để gửi dữ liệu vào JSP
        request.setAttribute("studentList", studentsOnPage);
        request.setAttribute("currentPage", page);
        request.setAttribute("totalPages", totalPages);

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("views/login.jsp");
            return;
        }

        request.getRequestDispatcher("views/studentList.jsp").forward(request, response);
    }
}