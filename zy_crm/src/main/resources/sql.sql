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
-- INSERT INTO user (name,phone,email,department_id,role_id) values('张三','15617587262','adad@163.com',1,1);

DROP TABLE IF EXISTS `notice`;
CREATE TABLE IF NOT EXISTS `notice`(
	`id` bigint unsigned PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	`title` varchar(50) NOT NULL COMMENT '标题',
	`content` text NOT NULL COMMENT '内容',
	`begin_time` date NULL COMMENT '开始时间',
	`end_time` date NULL COMMENT '结束时间',
	`user_id` bigint unsigned NOT NULL COMMENT '创建人 id',
	`department_id` bigint unsigned COMMENT '部门 id',
	`is_delete` tinyint unsigned DEFAULT 0 COMMENT '逻辑删除：1 删除，0  未删除',
	`gmt_create` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`gmt_modified` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
);


-- 邮件表
DROP TABLE IF EXISTS `email`;
CREATE TABLE IF NOT EXISTS `email`(
	`id` bigint unsigned PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	`title` varchar(50) NOT NULL COMMENT '标题',
	`content` text NOT NULL COMMENT '内容',
	`send_user_id` bigint unsigned  NOT NULL COMMENT '发件人 id',
	`receive_user_id` bigint unsigned NOT NULL COMMENT '收件人 id',
	`send_time` timestamp NULL COMMENT '发送时间',
	`send_location` tinyint unsigned DEFAULT 0 COMMENT '邮件在发送方的状态：1 草稿箱，2  发件箱，3 垃圾箱，4 彻底删除',
	`receive_location` tinyint unsigned DEFAULT 0 COMMENT '邮件在接收方的状态：0 未收到，1  收件箱，2 垃圾箱 3 彻底删除',
	`is_delete` tinyint unsigned DEFAULT 0 COMMENT '逻辑删除：1 删除，0  未删除',
	`gmt_create` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`gmt_modified` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
);

-- 客户表
DROP TABLE IF EXISTS `client_status`;
CREATE TABLE `client_status` (
  `id` bigint unsigned PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
  `status_name` varchar(20) NOT NULL COMMENT '状态名称',
  `status_desc` varchar(20) not null comment '状态描述',
  `is_delete` tinyint unsigned DEFAULT 0 COMMENT '逻辑删除:1 删除,0 未删除',
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
);

DROP TABLE IF EXISTS `client_classify`;
CREATE TABLE `client_classify` (
  `id` bigint unsigned PRIMARY KEY AUTO_INCREMENT COMMENT '主键,客户id',
  `classify_name` varchar(20) NOT NULL COMMENT '分类名称',
  `classify_desc` varchar(20) not null comment '分类描述',
  `is_delete` tinyint unsigned DEFAULT 0 COMMENT '逻辑删除:1 删除,0 未删除',
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
);

DROP TABLE IF EXISTS `client_from`;
CREATE TABLE `client_from` (
  `id` bigint unsigned PRIMARY KEY AUTO_INCREMENT COMMENT '主键,客户id',
  `from_name` varchar(20) NOT NULL COMMENT '来源名称',
  `from_desc` varchar(20) not null comment '来源描述',
  `is_delete` tinyint unsigned DEFAULT 0 COMMENT '逻辑删除:1 删除,0 未删除',
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
);

