create table PetBorrow(
    id int unsigned primary key auto_increment comment '主键唯一编号',
    name varchar(100) not null comment '宠物描述',
    week_price int unsigned not null comment '周价格',
    month_price int unsigned not null comment '月价格',
    deposit int unsigned not null comment '租金',
    qq varchar(20) not null comment '联系Q',
    image varchar(100) not null comment '图片名称',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '最后一次修改时间',
    weight int unsigned default 3 comment '热度',
    view int unsigned default 0 comment '浏览量'
) comment '宠物租借专区';

insert into
    PetBorrow (name, week_price, month_price,deposit,qq, image, create_time, update_time)
values
('Pet1', 85,260,6600, '1234', '1.jpg', now(), now());