create database product_manager;
use product_manager;
create table category(
    id int primary key auto_increment not null ,
    name nvarchar(100)
);
create table products(
    id int primary key auto_increment not null ,
    name nvarchar(100),
    price int,
    quantity int,
    color nvarchar(100),
    description nvarchar(255),
    category_id int,
    foreign key (category_id) references category(id)
);
insert into category(name) values ('Phone'),('Television'),('Air-Conditioner');
insert into products(name, price, quantity, color, description, category_id)
values ('IPhone13',1000,5,'Gold','Fastest smartphone ever',1),
       ('IPhoneXSMax',700,4,'Black,White','Face Id, Water proof',1),
       ('Toshiba x',3000,5,'Black','Bring world to home',2),
       ('Panasonic x',2900,5,'Black,Sivler','World open for you',2),
       ('Fujiki x',1500,5,'White','Summer is not hot',3);
select p.id,p.name,p.price,p.quantity,p.color,p.description,p.category_id,c.name from products p join category c on p.category_id = c.id;
select p.name,p.price,p.quantity,p.color,p.description,p.category_id,c.name from products p join category c on p.category_id = c.id where p.id = ?;
update products p join category c on p.category_id = c.id set p.name = ? ,p.price =?,p.quantity = ? ,p.color = ?,p.description = ? , p.category_id = ? ;
delete from products where id = ?;
insert into products (name, price, quantity, color, description, category_id) values (?,?,?,?,?,?);
select p.id,p.name,p.price,p.quantity,p.color,p.description,c.id,c.name from products p join category c on p.category_id = c.id where p.name = ?;
select * from category;
