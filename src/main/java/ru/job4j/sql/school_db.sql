create table school (
	id serial primary key,
    number int,
	kind text
);

create table student (
	id serial primary key,
	name text,
	class text,
	school_id int references school(id)
);

insert into school (number, kind) values (4, 'grammar');
insert into school (number, kind) values (10, 'private');
insert into school (number, kind) values (89, 'high');
insert into school (number, kind) values (34, 'private');
insert into school (number, kind) values (1, 'grammar');

insert into student (name, class, school_id) values ('Ivan Ivanov', '4A', 1);
insert into student (name, class, school_id) values ('Olga Petrova', '10B', 2);
insert into student (name, class, school_id) values ('Denis Kurochkin', '8A', 3);
insert into student (name, class, school_id) values ('Lina Mahova', '5G', 4);
insert into student (name, class, school_id) values ('Mila Chehova', '2A', 5);
insert into student (name, class) values ('Oleg Pavlov', '10A');
insert into student (name, class) values ('Sergei Melov', '8F');

select st.name, st.class, sc.number, sc.kind
from student as st join school as sc on school_id = sc.id;

select st.name as Name, st.class as Class, sc.number as Number, sc.kind as Kind
from student as st join school as sc on school_id = sc.id;

select st.name as "Student name", st.class Class, sc.number Number, sc.kind Kind
from student st join school sc on school_id = sc.id;

