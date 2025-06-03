package com.data.session17.repository;

import com.data.session17.entity.Book;

import java.util.List;

public interface BookRepository {
    List<Book> getAll();

    void delete(int id);

    void save(Book book);
    Book findById(int id);
    void add(Book book);
    void update(Book book);
}
