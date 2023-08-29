CREATE DATABASE StoreEcommerce;

CREATE TABLE "user" (
    id serial primary key,
    firts_name varchar(150),
    last_name varcher(150),
    adress  varchar(150),
    email varchar(150),
    phone varchar(150) not null,
    creation_date date not null
);

CREATE TABLE orders (
    id serial primary key,
    order_date date,
    payment varchar(150) not null,
    id_user int REFERENCES "user"(id)
);

CREATE TABLE article_type (
    id serial primary key,
    name varchar(150) not null
);

CREATE TABLE articles (
    id serial primary key,
    article_name varchar(150) not null,
    price float not null,
    stock int,
    id_article_type int references article_type(id)
);

CREATE TABLE contain (
    id int primary key,
    quantity int not null,
    id_order int references orders(id),
	id_article int references articles(id)
);