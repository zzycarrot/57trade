create table ToolGourd(
    id int unsigned primary key auto_increment comment '主键唯一编号',
    name varchar(100) not null comment '道具名称',
    price int unsigned not null comment '价格',
    qq varchar(20) not null comment '联系Q',
    image varchar(100) not null comment '图片名称',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '最后一次修改时间',
    weight int unsigned default 3 comment '热度',
    view int unsigned default 0 comment '浏览量'
) comment '葫芦道具专区';

insert into
    ToolGourd (name, price, qq, image, create_time, update_time)
values
('Tool1', 1, '1234', '1.jpg', now(), now());