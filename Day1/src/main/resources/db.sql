create table tbl_users(
                          user_no varchar(100) primary key comment '用户账号',
                          user_pwd varchar(500) comment '密码',
                          user_name varchar(500) comment '用户名称'
)engine=innodb default charset=utf8;

insert into tbl_users values('000101','123456','一号测试员');
insert into tbl_users values('000102','123456','二号测试员');