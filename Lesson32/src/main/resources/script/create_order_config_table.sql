create table public.order_configurations
(
    id         bigserial
        constraint order_configurations_pk
            primary key,
    order_id   varchar(50) not null
        constraint order_configurations_orders_id_fk
            references public.orders
            on update cascade on delete cascade,
    product_id bigint      not null
        constraint order_configurations_products_id_fk
            references public.products
            on update cascade on delete cascade
);

alter table public.order_configurations
    owner to postgres;