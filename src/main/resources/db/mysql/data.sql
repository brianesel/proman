insert into APP_USER (USER_ID, USER_NAME, encrypted_password, enabled)
values (2, 'dbuser1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);
 
insert into APP_USER (USER_ID, USER_NAME, encrypted_password, enabled)
values (1, 'dbadmin1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);

insert into APP_ROLE (ROLE_ID, ROLE_NAME)
values (1, 'ROLE_ADMIN');
 
insert into APP_ROLE (ROLE_ID, ROLE_NAME)
values (2, 'ROLE_USER');
 
insert into USER_ROLE (ID, USER_ID, ROLE_ID)
values (1, 1, 1);
 
insert into USER_ROLE (ID, USER_ID, ROLE_ID)
values (2, 1, 2);
 
insert into USER_ROLE (ID, USER_ID, ROLE_ID)
values (3, 2, 2);
