create table delivery_persons (
    id bigint generated by default as identity,
    name varchar(255),
    status varchar(50),
    active boolean,
    primary key (id)
);

create table items (
    id bigint generated by default as identity,
    quantity_available int,
    description varchar(255),
    name varchar(50) not null,
    price decimal(19,2) not null,
    primary key (id)
);

create table orders (
    id bigint generated by default as identity,
    address varchar(255) not null,
    status varchar(255),
    duration_in_mins int,
    delivery_person_id bigint,
    customer_id bigint,
    delivery_start_date_time timestamp,
    delivery_end_date_time timestamp,
    create_date_time timestamp,
    update_date_time timestamp,
    primary key (id),
    FOREIGN KEY (delivery_person_id) REFERENCES delivery_persons(id)
);

create table order_items (
    id bigint generated by default as identity,
    order_id bigint,
    item_id bigint,
    quantity int,
    primary key (id),
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (item_id) REFERENCES items(id)
);


insert into items values (1,'100','McDonalds AlooTikki burger','BurgerAlooTikki',30);
insert into items values (2,'100','McDonalds Maharaja burger','BurgerMaharaja',100.70);

insert into delivery_persons values(1,'Ankit',0,1);
insert into delivery_persons values(2,'Niketan',0,1);
insert into delivery_persons values(3,'Sanjana',0,1);


