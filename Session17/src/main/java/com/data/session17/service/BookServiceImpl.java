package com.data.session17.service;

import com.data.session17.entity.Book;
import com.data.session17.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements  BookService {
    private BookRepository bookRepo;

    public BookServiceImpl(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public List<Book> getAll() {
        return bookRepo.getAll();
    }

    @Override
    public void delete(int id) {
        bookRepo.delete(id);
    }

    @Override
    public void save(Book book) {
        if (book.getId() == 0) {
            bookRepo.add(book);
        } else {
            bookRepo.update(book);
        }
    }

    @Override
    public Book getById(int id) {
        return bookRepo.findById(id);
    }
}
