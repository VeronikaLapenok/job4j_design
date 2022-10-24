create table books()
id serial primary key,
title varchar(100),
author varchar(50),
pages int;

insert into books (title, author, pages) values ('Идиот', 'Достоевский Ф.М.', 434);
insert into books (title, author, pages) values ('Мастер и Маргарита', 'Булгаков М.А.', 278);
insert into books (title, author, pages) values ('Черный человек', 'Есенин С.А.', 208);

--first transaction
begin transaction;
insert into books (title, author, pages) values ('Лирика', 'Пастернак Б.Л.', 357);
commit transaction; 
select * from books;

--second transaction
begin transaction; 
insert into books (title, author, pages) values ('Иностранка', 'Довлатов С.А.', 163);
savepoint first_savepoint;
delete from books where pages = 208;
update books set pages = 1000 where title = 'Идиот';
select * from books;
rollback to first_savepoint;
select * from books;
commit;

