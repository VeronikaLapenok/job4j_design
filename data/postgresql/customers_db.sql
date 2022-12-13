CREATE TABLE customers (
    id serial primary key,
    first_name text,
    last_name text,
    age int,
    country text
);

insert into customers (first_name, last_name, age, country) values ('Ivan', 'Ivanov', 34, 'Belarus');
insert into customers (first_name, last_name, age, country) values ('Mikhail', 'Mikhailov', 29, 'Russia');
insert into customers (first_name, last_name, age, country) values ('Petr', 'Morozov', 48, 'Belarus');
insert into customers (first_name, last_name, age, country) values ('Olga', 'Klimova', 30, 'Russia');

select * from customers as c
where c.age = (select min(age) from customers);

CREATE TABLE orders (
    id serial primary key,
    amount int,
    customer_id int references customers(id)
);

insert into orders (amount, customer_id) values (500, 1);
insert into orders (amount, customer_id) values (1278, 3);
insert into orders (amount, customer_id) values (678, 1);
insert into orders (amount, customer_id) values (190, 3);

select * from customers
where customers.id not in (select customer_id from orders);
