insert into actions (name)
values ('create room'),
       ('send message'),
       ('delete message'),
       ('delete room'),
       ('block user'),
       ('unblock user'),
       ('set moderator'),
       ('delete moderator'),
       ('add user'),
       ('delete user'),
       ('rename room');
insert into ROLES (id,name)
values (1,'user'),
       (2,'moderator');
       ('administrator'),
       ('blocked_user'),
       ('room owner');

insert into ACTIONS_ROLES (ROLE_ID, ACTION_ID)
values (1, 1),
       (1, 2),
       (2, 1),
       (2, 2),
       (2, 3),
       (2, 4),
       (2, 5),
       (2, 6),
       (3, 2),
       (3, 3),
       (3, 4),
       (3, 5),
       (3, 6),
       (3, 7),
       (3, 8),
       (5, 9),
       (5, 10),
       (5, 11),
       (5, 2),
       (5, 4);
