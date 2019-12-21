create table if not exists users
(
    id       INTEGER primary key autoincrement         NOT NULL,
    name     varchar(200) unique                       NOT NULL,
    password varchar(200) check (length(password) > 8) NOT NULL,
    email    varchar(200) unique                       NOT NULL
);

create table if not exists roles
(
    user_id          not null,
    role varchar(20) not null,
    foreign key (user_id) references users (id)
)
