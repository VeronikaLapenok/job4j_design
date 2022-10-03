insert into role (name) values ('Admin');
insert into users (name, role_id) values ('Ivan Ivanov', 1);
insert into rules (name) values ('bla-bla-bla');
insert into role_rules (role_id, rules_id) values (1, 1);
insert into category (name) values ('High');
insert into state (name) values ('Off');
insert into item (name, users_id, category_id, state_id) values ('laptop', 1, 1, 1);
insert into comments (comment, item_id) values ('Fix bags', 1);
insert into attachs (name, item_id) values ('Instruction', 1);
