package com.data.session06.dao.ex01;

import com.data.session06.model.ex01.Book;
import com.data.session06.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements  BookDAO {

    @Override
    public List<Book> getAllBooks() {
        Connection conn = null;
        CallableStatement stmt = null;
        List<Book> books = null;
        try{
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call get_all_books()}");
            ResultSet rs = stmt.executeQuery();
            books = new ArrayList<>();
            while (rs.next()){
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setCategory(rs.getString("category"));
                book.setQuantity(rs.getInt("quantity"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.fillInStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
        return books;
    }

    @Override
    public boolean save(Book book) {
        Connection conn = null;
        CallableStatement stmt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call save_book(?, ?, ?, ?)}");
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setString(3, book.getCategory());
            stmt.setInt(4, book.getQuantity());
            int rowsAffected = stmt.executeUpdate();
            result = rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
        return result;
    }

    @Override
    public boolean update(Book book) {
        Connection conn = null;
        CallableStatement stmt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call update_book(?, ?, ?, ?, ?)}");
            stmt.setInt(1, book.getId());
            stmt.setString(2, book.getTitle());
            stmt.setString(3, book.getAuthor());
            stmt.setString(4, book.getCategory());
            stmt.setInt(5, book.getQuantity());
            result = stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        Connection conn = null;
        CallableStatement stmt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call delete_book(?)}");
            stmt.setInt(1, id);
            result = stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
        return result;
    }

    @Override
    public List<Book> searchByTitle(String keyword) {
        Connection conn = null;
        CallableStatement stmt = null;
        List<Book> books = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call search_books_by_title(?)}");
            stmt.setString(1, keyword);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setCategory(rs.getString("category"));
                book.setQuantity(rs.getInt("quantity"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
        return books;
    }

    @Override
    public Book findById(int id) {
        Connection conn = null;
        CallableStatement stmt = null;
        Book book = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call find_book_by_id(?)}");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                book = new Book();
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setCategory(rs.getString("category"));
                book.setQuantity(rs.getInt("quantity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
        return book;
    }

}
