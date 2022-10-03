create table student (
	id serial primary key,
	name varchar,
	age smallint,
	address text
);
insert into student (name, age, address) values ('Ivan Ivanov', 10, 'Minsk, Belarus');
select * from student;
update student set age = 12;
select * from student;
delete from student;
select * from student;