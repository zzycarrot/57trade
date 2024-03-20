create table Account(
    id int unsigned primary key auto_increment comment '主键唯一编号',
    name varchar(100) not null comment '账号描述',
    price int unsigned not null comment '账号价格',
    qq varchar(20) not null comment '联系QQ',
    image varchar(100) not null comment '图片名称',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '最后一次修改时间',
    weight int unsigned default 3 comment '热度',
    view int unsigned default 0 comment '浏览量'
) comment '人物道具专区';

insert into
    Account (name, price, qq, image, create_time, update_time)
values
('Account1', 101, '1234', '1.jpg', now(), now());