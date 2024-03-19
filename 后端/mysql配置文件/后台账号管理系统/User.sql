create table User(
    username varchar(20) primary key comment '唯一主键',
    password varchar(50) comment '密码',
    role varchar(20) comment '角色权限'
) comment '账号管理系统';

insert into
    User (username, password ,role)
values
    ('root','1234','admin'),
    ('emp1','5678','emp');