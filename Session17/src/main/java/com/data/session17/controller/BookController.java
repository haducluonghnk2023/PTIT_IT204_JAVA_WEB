package com.data.session17.controller;

import com.data.session17.entity.Book;
import com.data.session17.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("book")
    public String getAll(Model model) {
        List<Book> books = bookService.getAll();
        model.addAttribute("books", books);

        return "book_list";
    }

    @GetMapping("book-delete/{id}")
    public String delete(@PathVariable int id) {
        bookService.delete(id);

        return "redirect:/book";
    }

    @GetMapping("book-add")
    public String save(Model model) {
        model.addAttribute("book", new Book());
        return "book_form";
    }

    @GetMapping("book-edit/{id}")
    public String save(@PathVariable int id, Model model) {
        Book book = bookService.getById(id);
        model.addAttribute("book", book);
        return "book_form";
    }

    @PostMapping("book-save")
    public String save(Book book) {
        bookService.save(book);
        return "redirect:/book";
    }

    @GetMapping("book-detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        Book book = bookService.getById(id);
        model.addAttribute("book", book);
        return "book_list";
    }
}