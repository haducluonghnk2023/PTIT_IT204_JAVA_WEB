create database JSP_Servlet_DB;
use JSP_Servlet_DB;

create table Categories(
    catalog_id int auto_increment primary key,
    catalog_name varchar(50) not null,
    catalog_description varchar(255) not null,
    catalog_status bit
);

DELIMITER
$$
create procedure find_all_categories()
begin
    select * from Categories;
end$$
DELIMITER ;

DELIMITER &&
create procedure save_catalog(
    name_in varchar(200),
    des_in text,
    status_in bit
)
begin
    insert into Categories(catalog_name, catalog_description, catalog_status)
    values (name_in, des_in, status_in);
end;
DELIMITER &&
