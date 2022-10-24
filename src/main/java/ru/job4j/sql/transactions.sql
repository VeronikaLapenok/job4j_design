create table persons ()
id serial primary key,
name varchar(50),
surname varchar(50),
age int;

insert into persons (name, surname, age) values
('Ivan', 'Ivanov', 30),
('Petr', 'Petrov', 26),
('Elena', 'Mahova', 21);


--isolation level repeatable read
--first transaction
begin transaction isolation level repeatable read;
select * from persons;

--second transaction
begin transaction isolation level repeatable read;
select 

--first transaction
insert into persons (name, surname, age) values ('Olga', 'Lesova', 46);
delete from persons where age between 25 and 30;
update persons set age = 34 where name = 'Elena';
commit;

--second transaction
update persons set age = 34 where name = 'Elena';
--error



--isolation level serializable
--first transaction
begin transaction isolation level serializable;

--second transaction
begin transaction isolation level serializable;

--first transaction
select sum(age) from persons;
update persons set name = 'Viktor' where age = 21;

--second transaction
select sum(age) from persons;
update persons set name = 'Viktor' where age = 46;
commit;

--first transaction
commit;
--error

