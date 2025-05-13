package com.data.session06.service.ex01;

import com.data.session06.dao.ex01.BookDAO;
import com.data.session06.dao.ex01.BookDAOImpl;
import com.data.session06.model.ex01.Book;

import java.util.List;

public class BookServiceImpl implements BookService {
    private final BookDAO bookDAO;

    public BookServiceImpl() {
        this.bookDAO = new BookDAOImpl();
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    @Override
    public boolean save(Book book) {
        return bookDAO.save(book);
    }

    @Override
    public boolean update(Book book) {
        return bookDAO.update(book);
    }

    @Override
    public boolean delete(int id) {
        return bookDAO.delete(id);
    }

    @Override
    public List<Book> searchByTitle(String keyword) {
        return bookDAO.searchByTitle(keyword);
    }

    @Override
    public Book findById(int id) {
        return bookDAO.findById(id);
    }
}
