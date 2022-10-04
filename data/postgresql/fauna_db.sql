create database fauna_db;

create table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

insert into fauna (name, avg_age, discovery_date) values ('Ornithorhynchus anatinus', 10, date '1799-09-13');
insert into fauna (name, avg_age, discovery_date) values ('Macropus', 12, date '1770-01-22');
insert into fauna (name, avg_age, discovery_date) values ('Ursus arctos horribilis', 25, date '1815-04-06');
insert into fauna (name, avg_age, discovery_date) values ('Pteromys volans', 5, date '1758-12-30');
insert into fauna (name, avg_age, discovery_date) values ('Serrasalmus rhombeus fish', 7, date '1920-10-16');
insert into fauna (name, avg_age, discovery_date) values ('Nyctereutes procyonoides', 15, null);
insert into fauna (name, avg_age, discovery_date) values ('Nautilus pompilius', 3, date '1758-05-13');
insert into fauna (name, avg_age, discovery_date) values ('Hexactinellida', 11000, date '1870-05-27');
insert into fauna (name, avg_age, discovery_date) values ('Soricidae', 1, null);

select * from fauna where name like '%fish%';

select * from fauna where avg_age between 10000 and 21000;

select * from fauna where discovery_date is null;

select * from fauna where discovery_date < '1950-01-01'

