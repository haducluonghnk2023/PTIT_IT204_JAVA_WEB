package com.data.session03.controller;

import com.data.session03.model.Book;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "BookServlet", value = "/book")
public class BookServlet extends HttpServlet {
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        ArrayList<Book> books = (ArrayList<Book>) session.getAttribute("books");

        if (books == null) {
            books = new ArrayList<>();
        }

        if ("add".equals(action)) {
            String title = request.getParameter("title");
            String author = request.getParameter("author");
            int year = Integer.parseInt(request.getParameter("year"));
            books.add(new Book(title, author, year));
        }

        if ("search".equals(action)) {
            String keyword = request.getParameter("keyword");
            ArrayList<Book> results = new ArrayList<>();
            for (Book b : books) {
                if (b.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                    results.add(b);
                }
            }
            request.setAttribute("searchResults", results);
        }

        session.setAttribute("books", books);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}