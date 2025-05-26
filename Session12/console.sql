create database on_hackathon;
use on_hackathon;

create table student (
    id int primary key auto_increment,
    name varchar(50) not null,
    email varchar(200) not null,
    phone varchar(15) not null unique,
    sex bit ,
    birthday datetime,
    avatar text,
    status enum('active', 'inactive') default 'active'
);

CREATE TABLE product (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         price DECIMAL(10, 2) NOT NULL,
                         quantity INT NOT NULL,
                         image VARCHAR(255)
);

CREATE TABLE bus (
                     id INT AUTO_INCREMENT PRIMARY KEY,
                     license_plate VARCHAR(50) NOT NULL,
                     bus_type ENUM('NORMAL', 'VIP', 'LUXURY') NOT NULL,
                     row_seat INT NOT NULL,
                     col_seat INT NOT NULL,
                     total_seat INT GENERATED ALWAYS AS (row_seat * col_seat) STORED,
                     image VARCHAR(255)
);

CREATE TABLE seat (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      name_seat VARCHAR(10) NOT NULL,
                      price DECIMAL(10,2) NOT NULL,
                      bus_id INT NOT NULL,
                      status ENUM('còn trống', 'đã đặt') NOT NULL DEFAULT 'còn trống',
                      FOREIGN KEY (bus_id) REFERENCES bus(id) ON DELETE CASCADE
);


INSERT INTO student (name, email, phone, sex, birthday, avatar, status) VALUES
                                                                            ('Nguyen Van A', 'a@gmail.com', '0900000001', 1, '2000-01-01', 'avatar1.jpg', 'active'),
                                                                            ('Tran Thi B', 'b@gmail.com', '0900000002', 0, '2001-02-02', 'avatar2.jpg', 'active'),
                                                                            ('Le Van C', 'c@gmail.com', '0900000003', 1, '1999-03-03', 'avatar3.jpg', 'inactive'),
                                                                            ('Pham Thi D', 'd@gmail.com', '0900000004', 0, '2002-04-04', 'avatar4.jpg', 'active'),
                                                                            ('Hoang Van E', 'e@gmail.com', '0900000005', 1, '2000-05-05', 'avatar5.jpg', 'active'),
                                                                            ('Do Thi F', 'f@gmail.com', '0900000006', 0, '2003-06-06', 'avatar6.jpg', 'inactive'),
                                                                            ('Bui Van G', 'g@gmail.com', '0900000007', 1, '2001-07-07', 'avatar7.jpg', 'active'),
                                                                            ('Ngo Thi H', 'h@gmail.com', '0900000008', 0, '1998-08-08', 'avatar8.jpg', 'active'),
                                                                            ('Dang Van I', 'i@gmail.com', '0900000009', 1, '2002-09-09', 'avatar9.jpg', 'inactive'),
                                                                            ('Mai Thi J', 'j@gmail.com', '0900000010', 0, '2000-10-10', 'avatar10.jpg', 'active');

INSERT INTO product (name, price, quantity, image) VALUES
                                                       ('Laptop Dell Inspiron', 15000000.00, 10, 'uploads/dell_inspiron.jpg'),
                                                       ('Điện thoại iPhone 14', 25000000.00, 5, 'uploads/iphone14.jpg'),
                                                       ('Tai nghe Bluetooth Sony', 250000.00, 20, 'uploads/sony_headset.jpg'),
                                                       ('Chuột Logitech M331', 350000.00, 15, 'uploads/logitech_mouse.jpg'),
                                                       ('Bàn phím cơ AKKO', 1200000.00, 8, 'uploads/akko_keyboard.jpg');

INSERT INTO bus (license_plate, bus_type, row_seat, col_seat, image) VALUES
                                                                         ('29A-12345', 'NORMAL', 10, 4, 'bus1.jpg'),
                                                                         ('30B-67890', 'VIP', 8, 4, 'bus2.jpg'),
                                                                         ('31C-11223', 'LUXURY', 6, 4, 'bus3.jpg'),
                                                                         ('32D-44556', 'NORMAL', 12, 5, 'bus4.jpg'),
                                                                         ('33E-77889', 'VIP', 9, 3, 'bus5.jpg');

INSERT INTO seat (name_seat, price, bus_id, status) VALUES
                                                        ('A1', 100000.00, 1, 'còn trống'),
                                                        ('B1', 200000.00, 2, 'còn trống'),
                                                        ('C1', 300000.00, 3, 'đã đặt'),
                                                        ('D1', 100000.00, 4, 'còn trống'),
                                                        ('E1', 200000.00, 5, 'đã đặt');

DELIMITER $$
create procedure find_all_students()
begin
    select * from student order by name;
end ;
DELIMITER $$;

DELIMITER &&
create procedure insert_student(
    name_in varchar(50),
    email_in varchar(200),
    phone_in varchar(15),
    sex_in bit,
    birthday_in datetime,
    avatar_in text,
    status_in varchar(10)
)
BEGIN
    INSERT INTO student (name, email, phone, sex, birthday, avatar, status)
    VALUES (name_in, email_in, phone_in, sex_in, birthday_in, avatar_in, status_in);
END &&
DELIMITER &&

DELIMITER //
CREATE PROCEDURE find_student_by_id(IN student_id INT)
BEGIN
    SELECT
        id,
        name,
        email,
        phone,
        sex,
        birthday,
        avatar,
        status
    FROM student
    WHERE id = student_id;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE delete_student(IN student_id INT)
BEGIN
    DELETE FROM student WHERE id = student_id;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE update_student(
    IN p_id INT,
    IN p_name VARCHAR(100),
    IN p_email VARCHAR(100),
    IN p_phone VARCHAR(20),
    IN p_sex BOOLEAN,
    IN p_birthday DATE,
    IN p_avatar VARCHAR(255),
    IN p_status VARCHAR(20)
)
BEGIN
    UPDATE student
    SET
        name = p_name,
        email = p_email,
        phone = p_phone,
        sex = p_sex,
        birthday = p_birthday,
        avatar = p_avatar,
        status = p_status
    WHERE id = p_id;
END //
DELIMITER ;

-- product
DELIMITER //
CREATE PROCEDURE insert_product(
    IN p_name VARCHAR(255),
    IN p_price DECIMAL(10,2),
    IN p_quantity INT,
    IN p_image VARCHAR(255)
)
BEGIN
    INSERT INTO product (name, price, quantity, image)
    VALUES (p_name, p_price, p_quantity, p_image);
END //
DELIMITER ;
-- update product
DELIMITER //
CREATE PROCEDURE update_product(
    IN p_id INT,
    IN p_name VARCHAR(255),
    IN p_price DECIMAL(10,2),
    IN p_quantity INT,
    IN p_image VARCHAR(255)
)
BEGIN
    UPDATE product
    SET name = p_name,
        price = p_price,
        quantity = p_quantity,
        image = p_image
    WHERE id = p_id;
END //
DELIMITER ;
-- delete product
DELIMITER //
CREATE PROCEDURE delete_product(IN p_id INT)
BEGIN
    DELETE FROM product WHERE id = p_id;
END //
DELIMITER ;
-- find by id
DELIMITER //
CREATE PROCEDURE find_product_by_id(IN p_id INT)
BEGIN
    SELECT * FROM product WHERE id = p_id;
END //
DELIMITER ;
-- find all products
DELIMITER //
CREATE PROCEDURE find_all_products()
BEGIN
    SELECT * FROM product;
END //
DELIMITER ;

-- bus
DELIMITER //

CREATE PROCEDURE add_new_bus(
    IN p_license_plate VARCHAR(50),
    IN p_bus_type ENUM('NORMAL', 'VIP', 'LUXURY'),
    IN p_row_seat INT,
    IN p_col_seat INT,
    IN p_image VARCHAR(255)
)
BEGIN
    DECLARE v_bus_id INT;
    DECLARE r INT DEFAULT 1;
    DECLARE c INT;
    DECLARE seat_name VARCHAR(10);
    DECLARE price DECIMAL(10,2);

    -- Thêm xe
    INSERT INTO bus(license_plate, bus_type, row_seat, col_seat, image)
    VALUES (p_license_plate, p_bus_type, p_row_seat, p_col_seat, p_image);

    SET v_bus_id = LAST_INSERT_ID();

    -- Xác định giá ghế theo loại xe
    IF p_bus_type = 'NORMAL' THEN
        SET price = 100000;
    ELSEIF p_bus_type = 'VIP' THEN
        SET price = 150000;
    ELSE
        SET price = 200000;
    END IF;

    -- Tạo ghế theo hàng (r) và cột (c)
    WHILE r <= p_row_seat DO
            SET c = 1;
            WHILE c <= p_col_seat DO
                    SET seat_name = CONCAT(CHAR(64 + r), c); -- A1, A2,...
                    INSERT INTO seat(name_seat, price, bus_id)
                    VALUES (seat_name, price, v_bus_id);
                    SET c = c + 1;
                END WHILE;
            SET r = r + 1;
        END WHILE;
END //

DELIMITER ;
-- update
DELIMITER //

CREATE PROCEDURE update_bus(
    IN p_id INT,
    IN p_license_plate VARCHAR(50),
    IN p_bus_type ENUM('NORMAL', 'VIP', 'LUXURY'),
    IN p_row_seat INT,
    IN p_col_seat INT,
    IN p_image VARCHAR(255)
)
BEGIN
    UPDATE bus
    SET license_plate = p_license_plate,
        bus_type = p_bus_type,
        row_seat = p_row_seat,
        col_seat = p_col_seat,
        image = p_image
    WHERE id = p_id;
END //

DELIMITER ;
-- delete
DELIMITER //

CREATE PROCEDURE delete_bus(IN p_id INT)
BEGIN
    DELETE FROM bus WHERE id = p_id;
    -- Ghế tự động xóa do ON DELETE CASCADE
END //

DELIMITER ;
-- find all
DELIMITER //

CREATE PROCEDURE get_all_buses()
BEGIN
    SELECT * FROM bus;
END //

DELIMITER ;
-- bus detail
DELIMITER //

CREATE PROCEDURE get_bus_detail(IN p_id INT)
BEGIN
    -- Chi tiết xe
    SELECT * FROM bus WHERE id = p_id;

    -- Danh sách ghế của xe
    SELECT name_seat, price, status
    FROM seat
    WHERE bus_id = p_id
    ORDER BY name_seat;
END //

DELIMITER ;
