select r.name, a.name
from roles as r
         join actions_roles as ar on ar.role_id = r.id
         join actions as a on ar.action_id = a.id;
select * from users;