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