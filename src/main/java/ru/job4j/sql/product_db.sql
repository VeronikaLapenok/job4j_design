create table type (
	id serial primary key,
	name varchar(50)
);

create table product (
	id serial primary key,
	name varchar(50),
	expired_date date,
	price float,
	type_id int references type(id)
);

insert into type (name) values ('СЫР'), ('МОЛОКО'), ('КЕФИР'), ('МОРОЖЕНОЕ'), ('ЙОГУРТ'), ('МАСЛО');

insert into product (name, expired_date, price, type_id) values ('Сыр плавленный', date '2022-10-29', 1.89, 1);
insert into product (name, expired_date, price, type_id) values ('Молоко 2.5%', date '2022-12-17', 0.77, 2);
insert into product (name, expired_date, price, type_id) values ('Мороженое "Алёнка"', date '2022-08-13', 1.43, 4);
insert into product (name, expired_date, price, type_id) values ('Масло "Коровка"', date '2022-11-29', 2.07, 6);
insert into product (name, expired_date, price, type_id) values ('Мороженое "Лакомка"', date '2023-04-10', 0.92, 4);
insert into product (name, expired_date, price, type_id) values ('Сыр Голландский', date '2022-09-30', 2.84, 1);
insert into product (name, expired_date, price, type_id) values ('Сыр моцарелла', date '2022-12-22', 1.29, 1);
insert into product (name, expired_date, price, type_id) values ('Кефир 3%', date '2022-10-17', 0.98, 3);
insert into product (name, expired_date, price, type_id) values ('Молоко 3%', date '2022-10-15', 0.80, 2);
insert into product (name, expired_date, price, type_id) values ('Йогурт малиновый', date '2023-03-13', 1.56, 5);
insert into product (name, expired_date, price, type_id) values ('Мороженое "Ягодное"', date '2023-05-11', 0.60, 4);
insert into product (name, expired_date, price, type_id) values ('Сыр с гол. плесенью', date '2022-12-14', 3.89, 1);
insert into product (name, expired_date, price, type_id) values ('Кефир 1.5%', date '2022-10-09', 0.76, 3);
insert into product (name, expired_date, price, type_id) values ('Масло "Полоцкое"', date '2023-01-16', 1.98, 6);
insert into product (name, expired_date, price, type_id) values ('Йогурт "Данон"', date '2023-02-02', 2.45, 5);

--1. get all products with type 'СЫР'
select p.name, p.expired_date, p.price
from product as p
join type as t on t.id = p.type_id
where t.name = 'СЫР';

--2. get all products that have the word "мороженое" in their name
select name, expired_date, price from product
where name like '%мороженое%';

--3. get all products that have already expired
select name, expired_date, price
from product
where expired_date < current_date;

--4. get the most expensive product
select name, expired_date, price
from product
where price = (select max(price) from product);

--5. get for each type the number of products belonging to it (type_name, number)
select t.name, count(p.name) as number
from type t
join product as p on p.type_id = t.id
group by t.name;

--6. get all products with types 'СЫР' and 'МОЛОКО'
select p.name, p.expired_date, p.price
from product as p
join type as t on t.id = p.type_id
where t.name = 'СЫР' or t.name = 'МОЛОКО';

--7. get the type of products that have less than 10
select t.name, count(p.name) as number
from type t
join product as p on p.type_id = t.id
group by t.name
having count(p.name) < 10;

--8. get all products and their type
select t.name, p.name, p.expired_date, p.price
from product as p
join type as t on t.id = p.type_id;

