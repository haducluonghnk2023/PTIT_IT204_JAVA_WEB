create database ss16;
use ss16;

create table users(
    id int auto_increment primary key,
    username varchar(50) not null unique,
    password varchar(255) not null,
    email varchar(100) not null unique,
    role enum('admin', 'user') not null ,
    status enum('active', 'inactive') not null
);

create table trip(
    id int auto_increment primary key,
    departure varchar(100) not null,
    destination varchar(100) not null,
    departure_time datetime not null,
    price decimal(15, 2) not null
);

CREATE TABLE bus (
                     id INT AUTO_INCREMENT PRIMARY KEY,
                     license_plate VARCHAR(20) NOT NULL UNIQUE,
                     bus_type ENUM('NORMAL', 'VIP', 'LUXURY') NOT NULL,
                     row_seat INT NOT NULL,
                     col_seat INT NOT NULL,
                     total_seat INT AS (row_seat * col_seat) STORED,
                     image VARCHAR(255) NOT NULL
);

CREATE TABLE seat (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      nameSeat VARCHAR(50) NOT NULL,
                      seat_type ENUM('NORMAL', 'VIP', 'LUXURY') NOT NULL,
                      price INT NOT NULL,
                      busId INT NOT NULL,
                      status VARCHAR(20) NOT NULL DEFAULT 'available',
                      FOREIGN KEY (busId) REFERENCES bus(id)
);


CREATE TABLE bustrip (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         departure_point VARCHAR(100) NOT NULL,
                         destination VARCHAR(100) NOT NULL,
                         departure_time DATETIME NOT NULL,
                         arrival_time DATETIME NOT NULL,
                         bus_id INT NOT NULL,
                         seats_available INT NOT NULL CHECK (seats_available >= 0),
                         image VARCHAR(255)
);

CREATE TABLE ticket (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        user_id INT NOT NULL,
                        trip_id INT NOT NULL,
                        seat_list VARCHAR(255) NOT NULL,
                        total_money DECIMAL(10,2) NOT NULL,
                        departure_date DATE NOT NULL,
                        FOREIGN KEY (trip_id) REFERENCES bustrip(id)
);


INSERT INTO trip (departure, destination, departure_time, price) VALUES
                                                                     ('Hà Nội', 'Đà Nẵng', '2025-06-01 07:00:00', 350000.00),
                                                                     ('Hồ Chí Minh', 'Nha Trang', '2025-06-01 09:30:00', 300000.00),
                                                                     ('Huế', 'Quảng Bình', '2025-06-01 06:00:00', 150000.00),
                                                                     ('Cần Thơ', 'Đà Lạt', '2025-06-01 13:15:00', 320000.00),
                                                                     ('Vinh', 'Hải Phòng', '2025-06-01 16:45:00', 280000.00);

INSERT INTO bus (license_plate, bus_type, row_seat, col_seat, image)
VALUES
    ('51A-12345', 'VIP', 4, 10, 'bus1.jpg'),
    ('51B-67890', 'NORMAL', 5, 9, 'bus2.jpg'),
    ('51C-11223', 'LUXURY', 4, 8, 'bus3.jpg'),
    ('51D-44556', 'VIP', 3, 10, 'bus4.jpg'),
    ('51E-77889', 'NORMAL', 5, 8, 'bus5.jpg');


INSERT INTO bustrip (departure_point, destination, departure_time, arrival_time, seats_available, bus_id, image) VALUES
                                                                                                                     ('Hà Nội', 'Hải Phòng', '2025-06-05 08:00:00', '2025-06-05 11:00:00', 40, 1, '/images/bus1.jpg'),
                                                                                                                     ('Hà Nội', 'Quảng Ninh', '2025-06-06 07:30:00', '2025-06-06 12:30:00', 35, 2, '/images/bus2.jpg'),
                                                                                                                     ('Hà Nội', 'Thanh Hóa', '2025-06-07 09:00:00', '2025-06-07 13:30:00', 30, 3, '/images/bus3.jpg'),
                                                                                                                     ('Hà Nội', 'Vinh', '2025-06-08 06:00:00', '2025-06-08 12:00:00', 25, 4, '/images/bus4.jpg'),
                                                                                                                     ('Hà Nội', 'Đà Nẵng', '2025-06-09 05:00:00', '2025-06-09 18:00:00', 20, 5, '/images/bus5.jpg');

-- save
DELIMITER //
create procedure add_user(
    in p_username varchar(50),
    in p_password varchar(255),
    in p_email varchar(100),
    in p_role enum('admin', 'user'),
    in p_status enum('active', 'inactive')
)
begin
    insert into users (username, password, email, role, status)
    values (p_username, p_password, p_email, p_role, p_status);
end ;
DELIMITER //
-- find by username
DELIMITER //
create procedure find_user_by_username(
    in p_username varchar(50)
)
begin
    select * from users where username = p_username;
end ;
DELIMITER //
-- find all trip
DELIMITER //
create procedure find_all_trip()
begin
    select * from trip;
end ;
DELIMITER //
--
DELIMITER //
CREATE PROCEDURE search_trips(
    IN p_departure VARCHAR(100),
    IN p_destination VARCHAR(100),
    IN p_offset INT,
    IN p_limit INT
)
BEGIN
    SELECT * FROM trip
    WHERE departure LIKE CONCAT('%', p_departure, '%')
      AND destination LIKE CONCAT('%', p_destination, '%')
    ORDER BY departure_time ASC
    LIMIT p_offset, p_limit;
END //
DELIMITER ;
-- b3
-- find all
DELIMITER //

CREATE PROCEDURE FindAllBuses()
BEGIN
    SELECT * FROM bus;
END //

DELIMITER ;
-- find by id
DELIMITER //

CREATE PROCEDURE FindSeatsByBusId(IN BusId INT)
BEGIN
    SELECT
        id,
        license_plate,
        bus_type,
        row_seat,
        col_seat,
        (row_seat * col_seat) AS total_seat,
        image
    FROM Bus
    WHERE id = BusId;
END //

DELIMITER ;

-- add
DELIMITER //

CREATE PROCEDURE AddBus(
    IN p_licensePlate VARCHAR(50),
    IN p_busType VARCHAR(20),
    IN p_rowSeats INT,
    IN p_columnSeats INT,
    IN p_imageUrl VARCHAR(255)
)
BEGIN
    INSERT INTO Bus (license_plate, bus_type, row_seat, col_seat, image)
    VALUES (p_licensePlate, p_busType, p_rowSeats, p_columnSeats, p_imageUrl);
END //

DELIMITER ;

-- update
DELIMITER //

CREATE PROCEDURE UpdateBus(
    IN p_id INT,
    IN p_license_plate VARCHAR(20),
    IN p_bus_type VARCHAR(50),
    IN p_row_seat INT,
    IN p_col_seat INT,
    IN p_image VARCHAR(255)
)
BEGIN
    UPDATE bus SET
                   license_plate = p_license_plate,
                   bus_type = p_bus_type,
                   row_seat = p_row_seat,
                   col_seat = p_col_seat,
                   image = p_image
    WHERE id = p_id;
END //

DELIMITER ;
-- delete
DELIMITER //

CREATE PROCEDURE DeleteBus(
    IN p_id INT
)
BEGIN
    -- Xóa ghế trước vì có ràng buộc khóa ngoại
    DELETE FROM seat WHERE busId = p_id;

    -- Xóa xe
    DELETE FROM bus WHERE id = p_id;
END //

DELIMITER ;
-- trip


DELIMITER //
CREATE PROCEDURE sp_findAllBusTrips()
BEGIN
    SELECT * FROM bustrip;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_findBusTripById(IN p_id INT)
BEGIN
    SELECT * FROM bustrip WHERE id = p_id;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_saveBusTrip(
    IN p_departure_point VARCHAR(100),
    IN p_destination VARCHAR(100),
    IN p_departure_time DATETIME,
    IN p_arrival_time DATETIME,
    IN p_bus_id INT,
    IN p_seats_available INT,
    IN p_image VARCHAR(255)
)
BEGIN
    INSERT INTO bustrip (departure_point, destination, departure_time, arrival_time, bus_id, seats_available, image)
    VALUES (p_departure_point, p_destination, p_departure_time, p_arrival_time, p_bus_id, p_seats_available, p_image);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_updateBusTrip(
    IN p_id INT,
    IN p_departure_point VARCHAR(100),
    IN p_destination VARCHAR(100),
    IN p_departure_time DATETIME,
    IN p_arrival_time DATETIME,
    IN p_bus_id INT,
    IN p_seats_available INT,
    IN p_image VARCHAR(255)
)
BEGIN
    UPDATE bustrip
    SET
        departure_point = p_departure_point,
        destination = p_destination,
        departure_time = p_departure_time,
        arrival_time = p_arrival_time,
        bus_id = p_bus_id,
        seats_available = p_seats_available,
        image = p_image
    WHERE id = p_id;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_deleteBusTrip(IN p_id INT)
BEGIN
    DELETE FROM bustrip WHERE id = p_id;
END //
DELIMITER ;
-- ticket
SET NAMES utf8mb4;
DELIMITER //

CREATE PROCEDURE insert_ticket_proc (
    IN p_user_id INT,
    IN p_trip_id INT,
    IN p_seat_list VARCHAR(255),
    IN p_total_money DECIMAL(10,2),
    IN p_departure_date DATE
)
BEGIN
    -- Khai báo biến trước khi dùng
    DECLARE seat_count INT;

    -- Đếm số ghế đã đặt
    SET seat_count = LENGTH(p_seat_list) - LENGTH(REPLACE(p_seat_list, ',', '')) + 1;

    -- Thêm vé mới
    INSERT INTO ticket (user_id, trip_id, seat_list, total_money, departure_date)
    VALUES (p_user_id, p_trip_id, p_seat_list, p_total_money, p_departure_date);

    -- Trừ số ghế trống trong chuyến xe
    UPDATE bustrip
    SET seats_available = seats_available - seat_count
    WHERE id = p_trip_id;
END //

DELIMITER //

CREATE PROCEDURE get_booked_seats_proc (
    IN p_trip_id INT,
    IN p_departure_date DATE
)
BEGIN
    SELECT seat_list
    FROM ticket
    WHERE trip_id = p_trip_id AND departure_date = p_departure_date;
END //

DELIMITER ;
