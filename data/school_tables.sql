/*many-to-one*/

create table class(
    id serial primary key,
    name varchar(255)
);

create table student(
    id serial primary key,
    name varchar(255),
    class_id int references student(id)
);

/*many-to-many*/
create table student(
     id serial primary key,
     name varchar(255)
 );
 
 create table teacher(
     id serial primary key,
     name varchar(255)
 );
 
 create table student_teacher(
     id serial primary key,
     student_id int references student(id),
     teacher_id int references teacher(id)
 );
 
 /*one-to-one*/
 create table record_book(
    id serial primary key,
    number smallint
);

create table student(
    id serial primary key,
    name varchar(255),
    record_book_id int references record_book(id) unique
);
