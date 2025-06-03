package com.data.session10.controller;

import com.data.session10.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {

    @GetMapping("bookForm")
    public String showBookForm(Model model) {
        Book book = new Book();
//        book.setTitle("Spring in Action");
//        book.setPublishDate(new Date());
        model.addAttribute("book", book);
        return "bookForm";
    }

    @PostMapping("bookSave")
    public String saveBook(@ModelAttribute("book") Book book,Model model) {
//        System.out.println("Book Title: " + book.getTitle());
        model.addAttribute("book", book);
        return "bookDetail";
    }

}
