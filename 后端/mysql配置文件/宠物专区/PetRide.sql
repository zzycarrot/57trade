create table PetRide(
    id int unsigned primary key auto_increment comment '主键唯一编号',
    name varchar(100) not null comment '宠物描述',
    price int unsigned not null comment '宠物价格',
    qq varchar(20) not null comment '联系QQ',
    description varchar(100) not null comment '养成情况',
    image varchar(100) not null comment '图片名称',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '最后一次修改时间',
    weight int unsigned default 3 comment '热度',
    view int unsigned default 0 comment '浏览量'
) comment '宠物：坐骑专区';

insert into
    PetRide (name, price, qq, description,image, create_time, update_time)
values
('Pet1', 1, '1234', '1.jpg', 'abc',now(), now());