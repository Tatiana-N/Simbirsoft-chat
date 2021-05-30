create table if not exists users
(
    id
    int
    primary
    key
    auto_increment,
    login
    VARCHAR
(
    255
) NOT NULL UNIQUE,
    password VARCHAR
(
    255
) NOT NULL,
    role_id integer NOT NULL

    );


create table if not exists actions
(
    id
    int
    primary
    key
    auto_increment,
    name
    VARCHAR
(
    200
) NOT NULL UNIQUE,
    CONSTRAINT actions_pk PRIMARY KEY
(
    id
)
    );

create table if not exists roles
(
    id
    int
    primary
    key
    auto_increment,
    name
    varchar
(
    50
) DEFAULT 'Пользователь',
    constraint roles_pk primary key
(
    id
)
    );

create table if not exists actions_roles
(
    id
    int
    primary
    key
    auto_increment,
    role_id
    integer
    NOT
    NULL,
    action_id
    integer
    NOT
    NULL,
    CONSTRAINT
    actions_roles_pk
    PRIMARY
    KEY
(
    id
)
    );



create table if not exists messages
(
    id
    int
    primary
    key
    auto_increment,
    user_id
    int
    NOT
    NULL,
    text
    TEXT
    NOT
    NULL,
    date
    TIMESTAMP
    NOT
    NULL,
    CONSTRAINT
    messages_pk
    PRIMARY
    KEY
(
    id
)
    );



create table if not exists rooms
(
    id
    int
    primary
    key
    auto_increment,
    name
    VARCHAR
(
    255
) NOT NULL UNIQUE,
    owner integer NOT NULL,
    CONSTRAINT rooms_pk PRIMARY KEY
(
    id
)
    );



create table if not exists rooms_users
(
    id
    int
    primary
    key
    auto_increment,

    user_id
    int
    NOT
    NULL,
    room_id
    int
    NOT
    NULL,
    CONSTRAINT
    rooms_users_pk
    PRIMARY
    KEY
(
    id
)

    );



ALTER TABLE users
    ADD CONSTRAINT users_fk0 FOREIGN KEY (role_id) REFERENCES roles (id);

ALTER TABLE actions_roles
    ADD CONSTRAINT actions_roles_fk0 FOREIGN KEY (role_id) REFERENCES roles (id);
ALTER TABLE actions_roles
    ADD CONSTRAINT actions_roles_fk1 FOREIGN KEY (action_id) REFERENCES actions (id);

ALTER TABLE messages
    ADD CONSTRAINT messages_fk0 FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE rooms
    ADD CONSTRAINT rooms_fk0 FOREIGN KEY (owner) REFERENCES users (id);

ALTER TABLE rooms_users
    ADD CONSTRAINT rooms_users_fk0 FOREIGN KEY (user_id) REFERENCES users (id);
ALTER TABLE rooms_users
    ADD CONSTRAINT rooms_users_fk1 FOREIGN KEY (room_id) REFERENCES rooms (id);

