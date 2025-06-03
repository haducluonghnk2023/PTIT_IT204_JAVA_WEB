package com.data.session17.service;

import com.data.session17.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAll();

    void delete(int id);

     void save(Book book);

    Book getById(int id);
}
