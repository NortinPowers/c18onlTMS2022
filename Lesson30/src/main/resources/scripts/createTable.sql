create table public.users
(
    id       bigserial
        constraint users_pk
            primary key,
    login    varchar(30) not null,
    password varchar(30) not null,
    name     varchar(30) not null,
    surname  varchar(30) not null,
    email    varchar(50) not null,
    birthday date        not null
);

alter table public.users
    owner to postgres;