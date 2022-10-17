create table departments (
	id serial primary key,
	name text
);

create table employees (
	id serial primary key,
	name text,
	department_id int references departments(id)
);

insert into departments (name) values ('Police'), ('Health care'), ('Migration'), ('Statistics'), ('Culture'), ('Education');
insert into employees (name, department_id) values ('Ivan Ivanov', 2),
					    	   ('Petr Petrov', 1),
						   ('Olga Mikhailova', 4),
						   ('Viktor Malikov', 3),
						   ('Vasiliy Lipov', 1),
						   ('Elena Grod', null),
						   ('Konstantin Belov', 5),
						   ('Ksenia Levshova', null),
						   ('Fedor Luksha', 2),
						   ('Irina Popova', 5);


select d.name, e.name from departments d 
left join employees e on e.department_id = d.id 
where e.department_id is null;

select d.name, e.name from departments d 
left join employees e on e.department_id = d.id;

select d.name, e.name from employees e 
right join departments d on e.department_id = d.id;

create table teens (
	id serial primary key,
	name text,
	gender text
);

insert into teens (name, gender) values ('Ivan', 'm'),
					('Petr', 'm'),
					('Elena', 'f'),
					('Olga', 'f'),
					('Fedor', 'm'),
					('Alex', 'm'),
					('Roman', 'm'),
					('Irina', 'f');
					
select t1.name, t2.name 
from teens as t1 cross join teens as t2
where t1.gender != t2.gender;
										
