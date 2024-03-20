create table Substitute(
    id int unsigned primary key auto_increment comment '主键唯一编号',
    name varchar(100) not null comment '项目',
    reward varchar(100) not null comment '奖励',
    price int unsigned not null comment '价格',
    time varchar(100) not null comment '时间',
    qq varchar(20) not null comment '联系QQ',
    info varchar(20) not null comment '提示信息',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '最后一次修改时间',
    weight int unsigned default 3 comment '热度',
    view int unsigned default 0 comment '浏览量'
) comment '代练专区';

insert into
    Substitute (name, reward,price,time, qq, info ,create_time, update_time)
values
('Tool1','reward', 1, 'noon','1234',"提示" now(), now());