create table products(
    id int primary key auto_increment,
    productName varchar(100) not null,
    description text,
    price numeric(10, 2) not null,
    stock int not null,
    image varchar(255)
)