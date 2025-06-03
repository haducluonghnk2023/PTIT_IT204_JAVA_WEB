create database session08;
use session08;

create table if not exists customer(
    id int auto_increment primary key,
    name varchar(50) not null,
    email varchar(50) not null,
    gender enum('Male', 'Female','Other') not null,
    customer_type enum('STANDARD', 'VIP') not null
);

create table if not exists products(
    id int auto_increment primary key,
    name varchar(50) not null,
    price decimal(10,2) not null,
    quantity int not null
);

INSERT INTO customer (name, email, gender, customer_type) VALUES
                                                              ('Nguyen Van A', 'vana@example.com', 'Male', 'STANDARD'),
                                                              ('Tran Thi B', 'thib@example.com', 'Female', 'VIP'),
                                                              ('Le Van C', 'vanc@example.com', 'Male', 'STANDARD'),
                                                              ('Pham Thi D', 'thid@example.com', 'Female', 'VIP'),
                                                              ('Do Minh E', 'minhe@example.com', 'Other', 'STANDARD');


INSERT INTO products (name, price, quantity) VALUES
                                                 ('Laptop Dell XPS 13', 25000000.00, 10),
                                                 ('Điện thoại iPhone 14', 22000000.00, 15),
                                                 ('Máy in Canon LBP2900', 3500000.00, 5),
                                                 ('Chuột Logitech MX Master 3', 1500000.00, 20),
                                                 ('Màn hình LG UltraWide 34', 9000000.00, 8);
DELIMITER &&
    create procedure get_all_customers()
        begin
            select * from customer;
        end ;
DELIMITER &&

DELIMITER &&
    create procedure get_all_products()
        begin
            select * from products;
        end ;
DELIMITER &&

DELIMITER &&
create procedure insert_product(
    in p_name varchar(50),
    in p_price decimal(10,2),
    in p_quantity int)
    begin
        insert into products (name, price, quantity) values (p_name, p_price, p_quantity);
    end ;
DELIMITER &&