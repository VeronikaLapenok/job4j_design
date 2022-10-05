create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices (name, price) values ('laptop Asus', 1340.5);
insert into devices (name, price) values ('smartphone iPhone 13 mini', 899.9);
insert into devices (name, price) values ('monitor LG', 439.8);
insert into devices (name, price) values ('keyboard Logitech', 346.7);
insert into devices (name, price) values ('keyboard Apple', 567.9);
insert into devices (name, price) values ('monitor HP', 137.3);
insert into devices (name, price) values ('laptop Aser', 964.8);
insert into devices (name, price) values ('smartphone Samnsung A64', 264.1);
insert into devices (name, price) values ('laptop Asus ZenBook', 1500.6);


insert into people (name) values ('Ivan'), ('Oleg'), ('Petr'), ('Pavel');

insert into devices_people (device_id, people_id) values (1, 1);
insert into devices_people (device_id, people_id) values (2, 2);
insert into devices_people (device_id, people_id) values (3, 3);
insert into devices_people (device_id, people_id) values (4, 4);
insert into devices_people (device_id, people_id) values (5, 2);
insert into devices_people (device_id, people_id) values (6, 1);
insert into devices_people (device_id, people_id) values (7, 2);
insert into devices_people (device_id, people_id) values (8, 3);
insert into devices_people (device_id, people_id) values (9, 4);

select avg(price) from devices;

select p.name, avg(d.price)
from people as p
join devices_people as dp on dp.people_id = p.id
join devices as d on dp.device_id = d.id
group by p.name
having avg(d.price) > 5000;



