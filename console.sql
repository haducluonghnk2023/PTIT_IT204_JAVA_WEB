create database ss11;
use ss11;
CREATE TABLE category (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          category_name VARCHAR(50) NOT NULL UNIQUE,
                          status BIT DEFAULT 1
);

CREATE TABLE movie (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       title VARCHAR(100) NOT NULL,
                       director VARCHAR(50) NOT NULL,
                       release_date DATE NOT NULL,
                       genre VARCHAR(30) NOT NULL,
                       poster TEXT
);

INSERT INTO category (category_name, status) VALUES
                                                 ('Điện thoại', 1),
                                                 ('Máy tính xách tay', 1),
                                                 ('Phụ kiện', 1),
                                                 ('Thiết bị gia dụng', 1),
                                                 ('Sách', 1);

DELIMITER //
CREATE PROCEDURE get_all_categories()
BEGIN
    SELECT * FROM category;
END ;
DELIMITER //

DELIMITER //
CREATE PROCEDURE insert_category(IN cat_name VARCHAR(50), IN cat_status BIT)
BEGIN
    INSERT INTO category (category_name, status)
    VALUES (cat_name, cat_status);
END ;
DELIMITER ;

DELIMITER $$

CREATE PROCEDURE check_category_name_exists(IN p_name VARCHAR(50))
BEGIN
    SELECT COUNT(*) AS 'exists'
    FROM category
    WHERE category_name = p_name;
END$$

DELIMITER ;

-- Tìm theo ID
DELIMITER //
CREATE PROCEDURE get_category_by_id(IN cat_id INT)
BEGIN
    SELECT * FROM category WHERE id = cat_id;
END //
DELIMITER ;

-- Cập nhật
DELIMITER //
CREATE PROCEDURE update_category(IN cat_id INT, IN cat_name VARCHAR(50), IN cat_status BIT)
BEGIN
    UPDATE category
    SET category_name = cat_name,
        status = cat_status
    WHERE id = cat_id;
END //
DELIMITER ;

-- Xoá
DELIMITER //
CREATE PROCEDURE delete_category(IN cat_id INT)
BEGIN
    DELETE FROM category WHERE id = cat_id;
END //
DELIMITER ;
-- add movie
DELIMITER //

CREATE PROCEDURE add_movie(
    IN p_title VARCHAR(100),
    IN p_director VARCHAR(50),
    IN p_release_date DATE,
    IN p_genre VARCHAR(30),
    IN p_poster TEXT
)
BEGIN
    INSERT INTO movie (title, director, release_date, genre, poster)
    VALUES (p_title, p_director, p_release_date, p_genre, p_poster);
END //

DELIMITER ;


DELIMITER $$

CREATE PROCEDURE getAllMovies()
BEGIN
    SELECT id, title, director, release_date, genre, poster FROM movie;
END $$

DELIMITER ;


DELIMITER $$

CREATE PROCEDURE update_movie(
    IN p_id INT,
    IN p_title VARCHAR(100),
    IN p_director VARCHAR(50),
    IN p_release_date DATE,
    IN p_genre VARCHAR(30),
    IN p_poster TEXT
)
BEGIN
    UPDATE movie
    SET title = p_title,
        director = p_director,
        release_date = p_release_date,
        genre = p_genre,
        poster = p_poster
    WHERE id = p_id;
END $$

DELIMITER ;


DELIMITER $$

CREATE PROCEDURE get_movie_by_id(IN p_id INT)
BEGIN
    SELECT * FROM movie WHERE id = p_id;
END $$

DELIMITER ;


DELIMITER //
CREATE PROCEDURE delete_movie(IN movieId INT)
BEGIN
    DELETE FROM movie WHERE id = movieId;
END //
DELIMITER ;


