package com.data.session05.controller;

import com.data.session05.model.Categories;
import com.data.session05.service.CategoriesService;
import com.data.session05.service.CategoriesServiceImpl;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "CategoriesController", value = "/CategoriesController")
public class CategoriesController extends HttpServlet {
    private final CategoriesService categoriesService;

    public CategoriesController() {
        categoriesService = new CategoriesServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("findAll")) {
            findAllCategories(request, response);
        }
    }

    public void findAllCategories(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Categories> listCategories = categoriesService.findAll();
        request.setAttribute("listCategories", listCategories);
        request.getRequestDispatcher("views/categories.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action.equals("Create")) {
            //Thêm danh mục
            //B1. Lấy dữ liệu trên form nhập
            Categories catalog = new Categories();
            catalog.setCatalogName(request.getParameter("catalogName"));
            catalog.setDescription(request.getParameter("description"));
            catalog.setStatus(Boolean.parseBoolean(request.getParameter("status")));
            //B2. Gọi sang service thực hiện thêm mới danh mục
            boolean result = categoriesService.save(catalog);
            //B3. Dựa vào kết quả trả về hiển thị kết quả
            if (result) {
                findAllCategories(request, response);
            } else {
                request.getRequestDispatcher("views/error.jsp").forward(request, response);
            }
        }
    }
}