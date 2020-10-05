create table language
(
    id          bigint auto_increment
        primary key,
    description varchar(255) null,
    name        varchar(255) null,
    rating      bigint       null
);

