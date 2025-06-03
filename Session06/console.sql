create database session06;
use session06;

-- Tạo bảng book
CREATE TABLE book (
     id INT AUTO_INCREMENT PRIMARY KEY,
     title VARCHAR(100) NOT NULL,
     author VARCHAR(100) NOT NULL,
     category VARCHAR(100) NOT NULL,
     quantity INT NOT NULL
);

CREATE TABLE users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       email VARCHAR(100),
                       phone VARCHAR(15)
);

CREATE TABLE products (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          name VARCHAR(255),
                          price DOUBLE,
                          imageUrl TEXT
);

CREATE TABLE productCarts (
                              id INT PRIMARY KEY AUTO_INCREMENT,
                              userId INT,
                              productId INT,
                              quantity INT
);



INSERT INTO book (title, author, category, quantity) VALUES
     ('The Great Gatsby', 'F. Scott Fitzgerald', 'Classic', 5),
     ('To Kill a Mockingbird', 'Harper Lee', 'Fiction', 8),
     ('1984', 'George Orwell', 'Dystopian', 10),
     ('Pride and Prejudice', 'Jane Austen', 'Romance', 7),
     ('The Catcher in the Rye', 'J.D. Salinger', 'Fiction', 6),
     ('Moby Dick', 'Herman Melville', 'Adventure', 4),
     ('The Hobbit', 'J.R.R. Tolkien', 'Fantasy', 9),
     ('Brave New World', 'Aldous Huxley', 'Science Fiction', 3),
     ('The Alchemist', 'Paulo Coelho', 'Philosophical', 12),
     ('The Book Thief', 'Markus Zusak', 'Historical', 5);

INSERT INTO products (name, price, imageUrl) VALUES
                                                 ('iPhone 14', 999.99, 'images/iphone14.jpg'),
                                                 ('Samsung Galaxy S22', 899.99, 'images/galaxy_s22.jpg'),
                                                 ('MacBook Air M2', 1199.00, 'images/macbook_air_m2.jpg'),
                                                 ('Dell XPS 13', 1099.00, 'images/dell_xps13.jpg'),
                                                 ('Apple Watch Series 8', 399.99, 'images/apple_watch_s8.jpg'),
                                                 ('Sony WH-1000XM5', 349.99, 'images/sony_xm5.jpg'),
                                                 ('iPad Pro 12.9"', 1299.00, 'images/ipad_pro.jpg'),
                                                 ('Logitech MX Master 3S', 99.99, 'images/logitech_mx3s.jpg'),
                                                 ('Kindle Paperwhite', 139.99, 'images/kindle_paperwhite.jpg'),
                                                 ('GoPro Hero 11', 499.99, 'images/gopro_hero11.jpg');


DELIMITER &&
create procedure get_all_books()
begin
    select * from book;
end ;
DELIMITER &&

DELIMITER &&
create procedure save_book(
    title_in varchar(100) ,
    author_in varchar(100),
    category_in varchar(100),
    quantity_in int
)
begin
    insert into book(title, author, category, quantity)
        values (title_in,author_in,category_in,quantity_in);
end ;
DELIMITER &&

DELIMITER &&
CREATE PROCEDURE update_book(
    IN id_in INT,
    IN title_in VARCHAR(100),
    IN author_in VARCHAR(100),
    IN category_in VARCHAR(100),
    IN quantity_in INT
)
BEGIN
    UPDATE book
    SET title = title_in,
        author = author_in,
        category = category_in,
        quantity = quantity_in
    WHERE id = id_in;
END &&
DELIMITER ;

DELIMITER &&
CREATE PROCEDURE search_books_by_title(
    IN keyword VARCHAR(100)
)
BEGIN
    SELECT * FROM book
    WHERE title LIKE CONCAT('%', keyword, '%');
END &&
DELIMITER ;

DELIMITER &&
CREATE PROCEDURE delete_book(
    IN id_in INT
)
BEGIN
    DELETE FROM book WHERE id = id_in;
END &&
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE find_book_by_id(IN book_id INT)
BEGIN
    SELECT * FROM book WHERE id = book_id;
END$$
DELIMITER ;

-- Procedure thêm user
DELIMITER //
CREATE PROCEDURE insert_user(
    IN p_username VARCHAR(50),
    IN p_password VARCHAR(255),
    IN p_email VARCHAR(100),
    IN p_phone VARCHAR(15)
)
BEGIN
    INSERT INTO users(username, password, email, phone)
    VALUES (p_username, p_password, p_email, p_phone);
END;
//
DELIMITER ;

-- Procedure tìm user theo username và password
DELIMITER //
CREATE PROCEDURE find_user(
    IN p_username VARCHAR(50),
    IN p_password VARCHAR(255)
)
BEGIN
    SELECT * FROM users WHERE username = p_username AND password = p_password;
END;
//
DELIMITER ;

DELIMITER &&
CREATE PROCEDURE get_all_products()
BEGIN
    SELECT * FROM products;
END &&
DELIMITER &&


DELIMITER //

CREATE PROCEDURE insert_product_cart(
    IN p_userId INT,
    IN p_productId INT,
    IN p_quantity INT
)
BEGIN
    INSERT INTO productCarts(userId, productId, quantity)
    VALUES (p_userId, p_productId, p_quantity);
END //

DELIMITER ;

DELIMITER &&
CREATE PROCEDURE get_all_product_carts()
BEGIN
    SELECT * FROM productCarts;
END &&
DELIMITER &&

DELIMITER //
CREATE PROCEDURE delete_product(
    IN id_in INT
)
BEGIN
    DELETE FROM productCarts WHERE id = id_in;
END ;
DELIMITER //

DELIMITER //
CREATE PROCEDURE get_cart_by_user(IN userId_in INT)
BEGIN
    SELECT id, userId AS user_id, productId AS product_id, quantity
    FROM productCarts
    WHERE userId = userId_in;
END;
DELIMITER //

DELIMITER //
CREATE PROCEDURE get_product_by_id(IN productId INT)
BEGIN
    SELECT * FROM products WHERE id = productId;
END;
DELIMITER //

