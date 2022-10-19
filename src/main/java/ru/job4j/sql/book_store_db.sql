create table buyers (
    id serial primary key,
    name varchar(50)
);

insert into buyers (name) values ('Иван Иванов');
insert into buyers (name) values ('Петр Петров');
insert into buyers (name) values ('Федор Федоров');
insert into buyers (name) values ('Ольга Михайлова');
insert into buyers (name) values ('Ирина Белова');

create table authors (
    id serial primary key,
    name varchar(50)
);

insert into authors (name) values ('Александр Пушкин');
insert into authors (name) values ('Николай Гоголь');
insert into authors (name) values ('Сергей Есенин');
insert into authors (name) values ('Лев Толстой');
insert into authors (name) values ('Михаил Булгаков');

create table books (
    id serial primary key,
    name varchar(200),
    price float,
    amount int,
    author_id integer references authors(id)
);

insert into books (name, price, amount, author_id) values ('Евгений Онегин', 12.5, 7, 1);
insert into books (name, price, amount, author_id) values ('Капитанская дочка', 45.6, 2, 1);
insert into books (name, price, amount, author_id) values ('Дубровский', 33.0, 4, 1);
insert into books (name, price, amount, author_id) values ('Мертвые души', 21.9, 1, 2);
insert into books (name, price, amount, author_id) values ('Мастер и Маргарита', 65.8, 3, 5);
insert into books (name, price, amount, author_id) values ('Сборник стихотворений', 76.8, 7, 3);
insert into books (name, price, amount, author_id) values ('Собачье сердце', 75.9, 2, 5);
insert into books (name, price, amount, author_id) values ('Морфий', 35.3, 2, 5);
insert into books (name, price, amount, author_id) values ('Война и мир', 78.9, 10, 4);

create table orders (
    id serial primary key,
    book_id integer references books(id),
    buyer_id integer references buyers(id)
);

insert into orders (book_id, buyer_id) values (1, 1);
insert into orders (book_id, buyer_id) values (3, 1);
insert into orders (book_id, buyer_id) values (5, 2);
insert into orders (book_id, buyer_id) values (4, 1);
insert into orders (book_id, buyer_id) values (1, 5);
insert into orders (book_id, buyer_id) values (6, 4);
insert into orders (book_id, buyer_id) values (9, 4);
insert into orders (book_id, buyer_id) values (8, 2);
insert into orders (book_id, buyer_id) values (2, 2);
insert into orders (book_id, buyer_id) values (7, 2);
insert into orders (book_id, buyer_id) values (3, 3);
insert into orders (book_id, buyer_id) values (1, 4);
insert into orders (book_id, buyer_id) values (6, 4);
insert into orders (book_id, buyer_id) values (8, 5);

create view show_books_amount_more_5_sorted_by_price_asc
	as select a.name author, b.name book, br.name buyer, price
	from books b
	left join authors a on b.author_id = a.id
	left join orders o on o.book_id = b.id
	left join buyers br on o.buyer_id = br.id
	where amount > 5
	order by price asc;

select * from show_books_amount_more_5_sorted_by_price_asc;

