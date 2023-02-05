drop table if exists cities cascade;

drop table if exists students cascade;

create table cities
(
    id   bigint generated by default as identity
        constraint city_pk
            primary key,
    name varchar(50) not null
        constraint city_pk2
            unique,
    info varchar(1000)
);

alter table cities
    owner to postgres;

create table students
(
    id      bigint generated by default as identity
        constraint student_pk
            primary key,
    name    varchar(30) not null,
    surname varchar(50) not null,
    age     integer     not null,
    city_id integer,
    course  varchar(30)
);

comment on table students is 'students_db for lesson21';

alter table students
    owner to postgres;

INSERT INTO cities (name, info)
VALUES ('Minsk',
        'is the capital and the largest city of Belarus, located on the Svislach and the now subterranean Niamiha rivers.'),
       ('New York', 'is the most populous city in the United States.'),
       ('Warsaw', 'is the capital and largest city of Poland.');

INSERT INTO cities (name)
VALUES ('Boston');

INSERT INTO students (name, surname, age, city_id, course)
VALUES ('Jerry', 'Carpenter', 18, 1, '22onl'),
       ('Elizabeth', 'Sanders', 22, 2, '22onl'),
       ('Thelma', 'Anderson', 18, 1, '22onl'),
       ('Jeremy', 'Palmer', 20, 2, '22onl'),
       ('Harold', 'Mason', 35, 2, '22onl');