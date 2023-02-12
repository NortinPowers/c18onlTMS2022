create table public.products
(
    id    bigserial
        constraint products_pk
            primary key,
    name  varchar(50) not null,
    price numeric     not null,
    type  varchar(20) not null,
    info  varchar(150)
);

alter table public.products
    owner to postgres;

insert into products (name, price, type, info)
values ('Apple iphone 14', 999.99, 'phone', 'stylish ios phone'),
       ('Samsung S22', 799.99, 'phone', 'android  phone'),
       ('Xiaomi 13', 650, 'phone', 'android phone with miua'),
       ('Samsung S23', 950, 'phone', 'android flagman phone'),
       ('Xiaomi 13pro', 850, 'phone', 'global android phone with miua'),
       ('LG 55NAN', 459.99, 'tv', 'lg TV 55d'),
       ('LG 49S', 320, 'tv', 'lg TV 49d'),
       ('Sony KD-55', 540, 'tv', 'sony TV 55d');

create table public.customers
(
    id       bigserial
        constraint customers_pk
            primary key,
    login    varchar(30) not null,
    password varchar(30)
);

alter table public.customers
    owner to postgres;

alter table public.customers
    owner to postgres;

insert into customers (login, password)
VALUES ('test', 'test');

create table public.carts
(
    id         bigserial
        constraint carts_pk
            primary key,
    user_id    bigint            not null
        constraint carts_customers_id_fk
            references public.customers
            on update cascade on delete cascade,
    product_id bigint            not null
        constraint carts_products_id_fk
            references public.products
            on update cascade on delete cascade,
    cart       boolean,
    favorite   boolean,
    count      integer default 1 not null
);

alter table public.carts
    owner to postgres;
