-- 两个短横线表示注释 
-- 这里是对数据库创建语句的备份

-- 创建数据库 先删除后创建,便于我们多次执行
DROP DATABASE IF EXISTS `zy_crm`;
CREATE DATABASE IF NOT EXISTS `zy_crm`;

-- 使用数据库
USE `zy_crm`;
-- 创建表
DROP TABLE  IF EXISTS`role`;
CREATE TABLE IF NOT EXISTS `role`(
	`id` bigint unsigned  PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	`name` varchar(20) NOT NULL COMMENT '角色名称',
	`description` varchar(50) NOT NULL COMMENT '角色描述',
	`is_delete` tinyint unsigned DEFAULT 0 COMMENT '逻辑删除:1 删除,0 未删除',
	`gmt_create` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`gmt_modified` timestamp  NULL  DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
);
USE `zy_crm`;
-- 查询role表中的所有未删除数据
-- SELECT id,name,description,gmt_modified FROM role WHERE is_delete = 0;
-- USE `zy_crm`;
-- UPDATE role SET name = ?,description = ? where id = ?;
-- USE `zy_crm`;
-- INSERT INTO Role (name,description) values('张三','讲师');
-- USE `zy_crm`;
-- UPDATE  role SET is_delete=1 where id=1;


USE `zy_crm`;
DROP TABLE IF EXISTS `department`;
CREATE TABLE IF NOT EXISTS `department`(
`id` bigint unsigned PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
`name` varchar(20) NOT NULL COMMENT '部门名称',
`description` varchar(50) NOT NULL COMMENT '部门描述',
`is_delete` tinyint unsigned DEFAULT 0 COMMENT '逻辑删除:1 删除,0 未删除',
`gmt_create` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
);

USE `zy_crm`;
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint unsigned PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(20) not null comment '密码',
  `gender` varchar(2) not null comment '性别',
  `phone` char(11) NOT NULL COMMENT '手机号',
  `email` varchar(20) NOT NULL COMMENT '邮箱号',
  `department_id` bigint unsigned COMMENT '部门id',
  `role_id` bigint unsigned COMMENT '角色id',
  `description` varchar(50) not null comment '备注',
  `is_delete` tinyint unsigned DEFAULT 0 COMMENT '逻辑删除:1 删除,0 未删除',
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
);
INSERT INTO user (name,phone,email,department_id,role_id) values('张三','15617587262','adad@163.com',1,1);




