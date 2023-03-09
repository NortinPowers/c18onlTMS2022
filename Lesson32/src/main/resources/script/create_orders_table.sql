create table public.orders
(
    id      varchar(50) not null
        constraint orders_pk
            primary key,
    date    date        not null,
    user_id bigint      not null
        constraint orders_users_id_fk
            references public.users
            on update cascade on delete cascade
);

alter table public.orders
    owner to postgres;