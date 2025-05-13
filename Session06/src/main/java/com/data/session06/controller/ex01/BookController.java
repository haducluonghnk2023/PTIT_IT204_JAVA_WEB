package com.data.session06.controller.ex01;

import com.data.session06.model.ex01.Book;
import com.data.session06.service.ex01.BookService;
import com.data.session06.service.ex01.BookServiceImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "BookController", value = "/BookController")
public class BookController extends HttpServlet {
    private final BookService bookService;

    public BookController() {
        this.bookService = new BookServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loggedInUser") == null) {
            response.sendRedirect("LoginController");
            return;
        }

        String action = request.getParameter("action");
        if (action == null) action = "findAll";

        switch (action) {
            case "findAll":
                findAllBooks(request, response);
                break;
            case "delete":
                deleteBook(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "search":
                searchBooks(request, response);
                break;
            default:
                findAllBooks(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        if (action == null) action = "findAll";

        switch (action) {
            case "add":
                addBook(request, response);
                break;
            case "update":
                updateBook(request, response);
                break;
            default:
                findAllBooks(request, response);
                break;
        }
    }

    private void findAllBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = bookService.getAllBooks();
        request.setAttribute("books", books);
        request.getRequestDispatcher("views/ex01/listBook.jsp").forward(request, response);
    }

    private void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = new Book();
        book.setTitle(request.getParameter("title"));
        book.setAuthor(request.getParameter("author"));
        book.setCategory(request.getParameter("category"));
        book.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        boolean result = bookService.save(book);
        if (result) {
            response.sendRedirect("BookController?action=findAll");
        } else {
            request.getRequestDispatcher("views/error.jsp").forward(request, response);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Book book = bookService.findById(id);
        request.setAttribute("bookId", book.getId());
        request.setAttribute("title", book.getTitle());
        request.setAttribute("author", book.getAuthor());
        request.setAttribute("category", book.getCategory());
        request.setAttribute("quantity", book.getQuantity());
        request.getRequestDispatcher("views/ex01/formEdit.jsp").forward(request, response);
    }

    private void updateBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = new Book();
        book.setId(Integer.parseInt(request.getParameter("id")));
        book.setTitle(request.getParameter("title"));
        book.setAuthor(request.getParameter("author"));
        book.setCategory(request.getParameter("category"));
        book.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        boolean result = bookService.update(book);
        if (result) {
            response.sendRedirect("BookController?action=findAll");
        } else {
            request.getRequestDispatcher("views/error.jsp").forward(request, response);
        }
    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        bookService.delete(id);
        response.sendRedirect("BookController?action=findAll");
    }

    private void searchBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String keyword = request.getParameter("keyword");
        System.out.println("Search Keyword: " + keyword);

        List<Book> books;
        if (keyword == null || keyword.trim().isEmpty()) {
            books = bookService.getAllBooks();
        } else {
            books = bookService.searchByTitle(keyword);
        }

        request.setAttribute("books", books);
        request.setAttribute("keyword", keyword);
        request.getRequestDispatcher("views/ex01/listBook.jsp").forward(request, response);
    }


}
