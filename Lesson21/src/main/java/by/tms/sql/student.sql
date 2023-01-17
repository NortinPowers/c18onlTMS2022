create table public.students
(
    id      integer generated by default as identity
        constraint student_pk
            primary key,
    name    varchar(30) not null,
    surname varchar(50) not null,
    age     integer     not null,
    city    varchar(50)
        constraint student_city_name_fk
            references public.cities (name),
    course  varchar(30)
);