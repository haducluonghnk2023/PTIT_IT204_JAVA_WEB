package com.data.session06.dao.ex01;

import com.data.session06.model.ex01.Book;

import java.util.List;

public interface BookDAO {
    List<Book> getAllBooks();
    boolean save(Book book);
    boolean update(Book book);
    boolean delete(int id);
    List<Book> searchByTitle(String keyword);
    Book findById(int id);

}
