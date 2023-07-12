create table role
(
    id        varchar(36)  not null
        primary key,
    role_name varchar(255) null
);

create table user
(
    id       varchar(36)  not null
        primary key,
    email    varchar(255) null,
    name     varchar(255) null,
    password varchar(255) null
);

create table user_roles
(
    user_id varchar(36) not null,
    role_id varchar(36) not null,
    constraint FK55itppkw3i07do3h7qoclqd4k
        foreign key (user_id) references user (id),
    constraint FKrhfovtciq1l558cw6udg0h0d3
        foreign key (role_id) references role (id)
);