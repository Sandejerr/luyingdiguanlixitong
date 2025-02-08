/*
SQLyog Ultimate v11.3 (64 bit)
MySQL - 5.7.32-log : Database - luyingdiguanlixitong
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`luyingdiguanlixitong` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `luyingdiguanlixitong`;

/*Table structure for table `chujiguanli` */

DROP TABLE IF EXISTS `chujiguanli`;

CREATE TABLE `chujiguanli` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(200) DEFAULT NULL COMMENT '账户',
  `password` varchar(200) DEFAULT NULL COMMENT '密码',
  `chujiguanli_name` varchar(200) DEFAULT NULL COMMENT '初级管理姓名 Search111 ',
  `chujiguanli_phone` varchar(200) DEFAULT NULL COMMENT '初级管理手机号',
  `chujiguanli_id_number` varchar(200) DEFAULT NULL COMMENT '初级管理身份证号',
  `chujiguanli_photo` varchar(200) DEFAULT NULL COMMENT '初级管理头像',
  `sex_types` int(11) DEFAULT NULL COMMENT '性别',
  `chujiguanli_email` varchar(200) DEFAULT NULL COMMENT '电子邮箱',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='初级管理';

/*Data for the table `chujiguanli` */

insert  into `chujiguanli`(`id`,`username`,`password`,`chujiguanli_name`,`chujiguanli_phone`,`chujiguanli_id_number`,`chujiguanli_photo`,`sex_types`,`chujiguanli_email`,`create_time`) values (1,'a1','123456','初级管理姓名1','17703786901','410224199010102001','upload/chujiguanli1.jpg',2,'1@qq.com','2023-03-06 10:26:01'),(2,'a2','123456','初级管理姓名2','17703786902','410224199010102002','upload/chujiguanli2.jpg',2,'2@qq.com','2023-03-06 10:26:01'),(3,'a3','123456','初级管理姓名3','17703786903','410224199010102003','upload/chujiguanli3.jpg',1,'3@qq.com','2023-03-06 10:26:01');

/*Table structure for table `config` */

DROP TABLE IF EXISTS `config`;

CREATE TABLE `config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) DEFAULT NULL COMMENT '配置参数值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='配置文件';

/*Data for the table `config` */

insert  into `config`(`id`,`name`,`value`) values (1,'轮播图1','upload/config1.jpg'),(2,'轮播图2','upload/config2.jpg'),(3,'轮播图3','upload/config3.jpg');

/*Table structure for table `dictionary` */

DROP TABLE IF EXISTS `dictionary`;

CREATE TABLE `dictionary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dic_code` varchar(200) DEFAULT NULL COMMENT '字段',
  `dic_name` varchar(200) DEFAULT NULL COMMENT '字段名',
  `code_index` int(11) DEFAULT NULL COMMENT '编码',
  `index_name` varchar(200) DEFAULT NULL COMMENT '编码名字  Search111 ',
  `super_id` int(11) DEFAULT NULL COMMENT '父字段id',
  `beizhu` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='字典';

/*Data for the table `dictionary` */

insert  into `dictionary`(`id`,`dic_code`,`dic_name`,`code_index`,`index_name`,`super_id`,`beizhu`,`create_time`) values (1,'sex_types','性别类型',1,'男',NULL,NULL,'2023-03-06 10:25:43'),(2,'sex_types','性别类型',2,'女',NULL,NULL,'2023-03-06 10:25:43'),(3,'yingdi_types','营地类型',1,'营地类型1',NULL,NULL,'2023-03-06 10:25:43'),(4,'yingdi_types','营地类型',2,'营地类型2',NULL,NULL,'2023-03-06 10:25:43'),(5,'yingdi_types','营地类型',3,'营地类型3',NULL,NULL,'2023-03-06 10:25:43'),(6,'yingdi_types','营地类型',4,'营地类型4',NULL,NULL,'2023-03-06 10:25:43'),(7,'yingdi_zhuangtai_types','营地状态',1,'已预约',NULL,NULL,'2023-03-06 10:25:43'),(8,'yingdi_zhuangtai_types','营地状态',2,'未预约',NULL,NULL,'2023-03-06 10:25:43'),(9,'yingdi_order_types','营地类型',101,'已预约',NULL,NULL,'2023-03-06 10:25:43'),(10,'yingdi_order_types','营地类型',102,'已取消预约',NULL,NULL,'2023-03-06 10:25:43'),(11,'yingdi_order_types','营地类型',103,'已同意预约',NULL,NULL,'2023-03-06 10:25:43'),(12,'yingdi_order_types','营地类型',106,'已接待',NULL,NULL,'2023-03-06 10:25:43'),(13,'jiedai_types','接待类型',1,'接待类型1',NULL,NULL,'2023-03-06 10:25:43'),(14,'jiedai_types','接待类型',2,'接待类型2',NULL,NULL,'2023-03-06 10:25:43'),(15,'jiedai_types','接待类型',3,'接待类型3',NULL,NULL,'2023-03-06 10:25:43'),(16,'jiedai_types','接待类型',4,'接待类型4',NULL,NULL,'2023-03-06 10:25:43'),(17,'jiedai_zhuangtai_types','接待状态',1,'正在接待',NULL,NULL,'2023-03-06 10:25:43'),(18,'jiedai_zhuangtai_types','接待状态',2,'接待完成',NULL,NULL,'2023-03-06 10:25:43'),(19,'jiesuan_zhuangtai_types','结算状态',1,'未结算',NULL,NULL,'2023-03-06 10:25:43'),(20,'jiesuan_zhuangtai_types','结算状态',2,'已结算',NULL,NULL,'2023-03-06 10:25:43');

/*Table structure for table `jiedai` */

DROP TABLE IF EXISTS `jiedai`;

CREATE TABLE `jiedai` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键 ',
  `yingdi_id` int(11) DEFAULT NULL COMMENT '营地',
  `yonghu_id` int(11) DEFAULT NULL COMMENT '用户',
  `jiedai_name` varchar(200) DEFAULT NULL COMMENT '接待名称  Search111 ',
  `jiedai_uuid_number` varchar(200) DEFAULT NULL COMMENT '接待编号',
  `jiedai_photo` varchar(200) DEFAULT NULL COMMENT '接待照片',
  `jiedai_types` int(11) DEFAULT NULL COMMENT '接待类型 Search111',
  `jiedai_new_money` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `jiedai_zhuangtai_types` int(11) DEFAULT NULL COMMENT '接待状态 Search111',
  `jiedai_content` text COMMENT '接待介绍 ',
  `jiedai_delete` int(11) DEFAULT NULL COMMENT '逻辑删除',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '录入时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间  show3 listShow',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='接待';

/*Data for the table `jiedai` */

insert  into `jiedai`(`id`,`yingdi_id`,`yonghu_id`,`jiedai_name`,`jiedai_uuid_number`,`jiedai_photo`,`jiedai_types`,`jiedai_new_money`,`jiedai_zhuangtai_types`,`jiedai_content`,`jiedai_delete`,`insert_time`,`create_time`) values (1,1,1,'接待名称1','1678069561044','upload/jiedai1.jpg',4,'140.39',1,'接待介绍1',2,'2023-03-06 10:26:01','2023-03-06 10:26:01'),(2,2,1,'接待名称2','1678069561016','upload/jiedai2.jpg',4,'325.45',1,'接待介绍2',2,'2023-03-06 10:26:01','2023-03-06 10:26:01'),(3,3,1,'接待名称3','1678069561028','upload/jiedai3.jpg',1,'353.82',1,'接待介绍3',2,'2023-03-06 10:26:01','2023-03-06 10:26:01'),(4,4,3,'接待名称4','1678069561079','upload/jiedai4.jpg',2,'19.13',1,'接待介绍4',2,'2023-03-06 10:26:01','2023-03-06 10:26:01'),(5,5,2,'接待名称5','1678069561086','upload/jiedai5.jpg',2,'40.81',2,'接待介绍5',2,'2023-03-06 10:26:01','2023-03-06 10:26:01'),(6,6,3,'接待名称6','1678069561054','upload/jiedai6.jpg',1,'219.56',2,'接待介绍6',2,'2023-03-06 10:26:01','2023-03-06 10:26:01'),(7,7,1,'接待名称7','1678069561076','upload/jiedai7.jpg',3,'101.25',1,'接待介绍7',2,'2023-03-06 10:26:01','2023-03-06 10:26:01'),(8,8,1,'接待名称8','1678069561039','upload/jiedai8.jpg',4,'288.87',2,'接待介绍8',2,'2023-03-06 10:26:01','2023-03-06 10:26:01'),(9,9,1,'接待名称9','1678069561055','upload/jiedai9.jpg',3,'28.84',2,'接待介绍9',2,'2023-03-06 10:26:01','2023-03-06 10:26:01'),(10,10,2,'接待名称10','1678069561107','upload/jiedai10.jpg',3,'243.14',2,'接待介绍10',2,'2023-03-06 10:26:01','2023-03-06 10:26:01'),(11,11,3,'接待名称11','1678069561017','upload/jiedai11.jpg',1,'478.15',1,'接待介绍11',2,'2023-03-06 10:26:01','2023-03-06 10:26:01'),(12,12,1,'接待名称12','1678069561036','upload/jiedai12.jpg',1,'150.76',1,'接待介绍12',2,'2023-03-06 10:26:01','2023-03-06 10:26:01'),(13,13,3,'接待名称13','1678069561069','upload/jiedai13.jpg',3,'81.21',1,'接待介绍13',2,'2023-03-06 10:26:01','2023-03-06 10:26:01'),(14,14,2,'接待名称14','1678069561011','upload/jiedai14.jpg',2,'142.52',1,'接待介绍14',2,'2023-03-06 10:26:01','2023-03-06 10:26:01'),(15,1,1,'11','1678070440508','/upload/1678070466795.jpg',2,'556.00',1,'<p>453</p>',2,'2023-03-06 10:41:14','2023-03-06 10:41:14'),(16,2,2,'22','1678070524004','/upload/1678070539112.jpg',1,'22.00',1,'<p>453</p>',2,'2023-03-06 10:42:21','2023-03-06 10:42:21'),(17,14,1,'666','1678071910622','/upload/1678071937642.jpg',1,'666.00',1,'<p>666</p>',2,'2023-03-06 11:05:40','2023-03-06 11:05:40'),(18,14,1,'888','1678072063763','/upload/1678072077287.jpg',1,'666.00',2,'<p>888</p>',2,'2023-03-06 11:07:59','2023-03-06 11:07:59'),(19,14,1,'999','1678074441902','/upload/1678074460239.jpg',1,'989.00',1,'<p>99</p>',2,'2023-03-06 11:47:43','2023-03-06 11:47:43'),(20,5,1,'55','1678080884464','/upload/1678080891761.jpg',1,'66.00',2,'<p>666</p>',1,'2023-03-06 13:35:04','2023-03-06 13:35:04'),(21,5,1,'666','1678081097538','/upload/1678081117730.jpg',1,'500.00',2,'<p>666</p>',1,'2023-03-06 13:38:41','2023-03-06 13:38:41'),(22,14,1,'22','1678081696763','/upload/1678081713461.jpg',2,'22.00',2,'<p>22</p>',1,'2023-03-06 13:48:36','2023-03-06 13:48:36'),(23,14,1,'88','1678082265597','/upload/1678082277857.jpg',1,'800.00',2,'<p>88</p>',1,'2023-03-06 13:57:59','2023-03-06 13:57:59'),(24,5,1,'丫丫','1678082921182','/upload/1678082940274.jpg',1,'500.00',2,'<p>丫丫</p>',2,'2023-03-06 14:09:03','2023-03-06 14:09:03');

/*Table structure for table `jiesuan` */

DROP TABLE IF EXISTS `jiesuan`;

CREATE TABLE `jiesuan` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键 ',
  `jiedai_id` int(11) DEFAULT NULL COMMENT '营地',
  `yonghu_id` int(11) DEFAULT NULL COMMENT '用户',
  `jiesuan_name` varchar(200) DEFAULT NULL COMMENT '结算名称  Search111 ',
  `jiesuan_uuid_number` varchar(200) DEFAULT NULL COMMENT '结算编号',
  `jiesuan_photo` varchar(200) DEFAULT NULL COMMENT '结算照片',
  `jiesuan_new_money` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `jiesuan_zhuangtai_types` int(11) DEFAULT NULL COMMENT '结算状态 Search111',
  `jiesuan_content` text COMMENT '备注 ',
  `jiesuan_delete` int(11) DEFAULT NULL COMMENT '逻辑删除',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '录入时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间 show3 listShow',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='结算';

/*Data for the table `jiesuan` */

insert  into `jiesuan`(`id`,`jiedai_id`,`yonghu_id`,`jiesuan_name`,`jiesuan_uuid_number`,`jiesuan_photo`,`jiesuan_new_money`,`jiesuan_zhuangtai_types`,`jiesuan_content`,`jiesuan_delete`,`insert_time`,`create_time`) values (1,1,2,'结算名称1','1678069561078','upload/jiesuan1.jpg','495.30',2,'备注1',2,'2023-03-06 10:26:01','2023-03-06 10:26:01'),(2,2,1,'结算名称2','1678069561035','upload/jiesuan2.jpg','473.72',2,'备注2',2,'2023-03-06 10:26:01','2023-03-06 10:26:01'),(3,3,3,'结算名称3','1678069561070','upload/jiesuan3.jpg','305.28',1,'备注3',2,'2023-03-06 10:26:01','2023-03-06 10:26:01'),(4,4,1,'结算名称4','1678069561088','upload/jiesuan4.jpg','267.58',2,'备注4',2,'2023-03-06 10:26:01','2023-03-06 10:26:01'),(5,5,1,'结算名称5','1678069561105','upload/jiesuan5.jpg','351.07',2,'备注5',2,'2023-03-06 10:26:01','2023-03-06 10:26:01'),(6,6,1,'结算名称6','1678069561037','upload/jiesuan6.jpg','131.34',2,'备注6',2,'2023-03-06 10:26:01','2023-03-06 10:26:01'),(7,7,1,'结算名称7','1678069561103','upload/jiesuan7.jpg','403.43',2,'备注7',2,'2023-03-06 10:26:01','2023-03-06 10:26:01'),(8,8,3,'结算名称8','1678069561045','upload/jiesuan8.jpg','216.29',2,'备注8',2,'2023-03-06 10:26:01','2023-03-06 10:26:01'),(9,9,3,'结算名称9','1678069561086','upload/jiesuan9.jpg','166.87',2,'备注9',2,'2023-03-06 10:26:01','2023-03-06 10:26:01'),(10,10,3,'结算名称10','1678069561091','upload/jiesuan10.jpg','67.47',1,'备注10',2,'2023-03-06 10:26:01','2023-03-06 10:26:01'),(11,11,3,'结算名称11','1678069561095','upload/jiesuan11.jpg','45.39',2,'备注11',2,'2023-03-06 10:26:01','2023-03-06 10:26:01'),(12,12,3,'结算名称12','1678069561045','upload/jiesuan12.jpg','308.84',1,'备注12',2,'2023-03-06 10:26:01','2023-03-06 10:26:01'),(13,13,3,'结算名称13','1678069561012','upload/jiesuan13.jpg','265.61',2,'备注13',2,'2023-03-06 10:26:01','2023-03-06 10:26:01'),(14,14,1,'结算名称14','1678069561095','upload/jiesuan14.jpg','90.87',2,'备注14',2,'2023-03-06 10:26:01','2023-03-06 10:26:01'),(15,15,1,'11','1678070482836','/upload/1678070503838.jpg','11.00',2,'<p>444</p>',2,'2023-03-06 10:41:47','2023-03-06 10:41:47'),(16,16,2,'122','1678070551796','/upload/1678070563859.jpg','22.00',2,'<p>4535</p>',2,'2023-03-06 10:42:46','2023-03-06 10:42:46'),(17,18,1,'8888','1678073048884','/upload/1678073096703.jpg','66.00',2,'<p>66</p>',2,'2023-03-06 11:25:00','2023-03-06 11:25:00'),(18,20,1,'55','1678080911438','/upload/1678080920925.jpg','66.00',2,'<p>555</p>',1,'2023-03-06 13:35:23','2023-03-06 13:35:23'),(19,21,1,'55','1678081362439','/upload/1678081373475.jpg','500.00',2,'<p>66</p>',1,'2023-03-06 13:42:57','2023-03-06 13:42:57'),(20,22,1,'500','1678081722367','/upload/1678081732003.jpg','500.00',2,'<p>256</p>',1,'2023-03-06 13:48:55','2023-03-06 13:48:55'),(21,23,1,'870','1678082285911','/upload/1678082293978.jpg','50.00',2,'<p>5402</p>',1,'2023-03-06 13:58:16','2023-03-06 13:58:16'),(22,24,1,'添加接待时的消费','1678082959054','/upload/1678082982468.jpg','500.00',2,'<p>丫丫</p>',1,'2023-03-06 14:09:48','2023-03-06 14:09:48');

/*Table structure for table `token` */

DROP TABLE IF EXISTS `token`;

CREATE TABLE `token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '儿童id',
  `username` varchar(100) NOT NULL COMMENT '儿童名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(200) NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='token表';

/*Data for the table `token` */

insert  into `token`(`id`,`userid`,`username`,`tablename`,`role`,`token`,`addtime`,`expiratedtime`) values (1,1,'a1','yonghu','用户','z34ib77n3egh6sqdwagr68w8x7xvyzgm','2023-03-06 10:27:26','2023-03-06 15:07:27'),(2,1,'admin','users','管理员','5i9ylr59ptp5gj8m3m0vym7ump4j5tas','2023-03-06 10:28:47','2023-03-06 15:10:22'),(3,1,'a1','chujiguanli','初级管理','khrixwjoc7vbzihcjlgfhcgb2gtoxq95','2023-03-06 13:55:06','2023-03-06 15:08:17');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) NOT NULL COMMENT '儿童名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `role` varchar(100) DEFAULT '管理员' COMMENT '角色',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='管理员';

/*Data for the table `users` */

insert  into `users`(`id`,`username`,`password`,`role`,`addtime`) values (1,'admin','admin','管理员','2023-03-06 10:25:43');

/*Table structure for table `yingdi` */

DROP TABLE IF EXISTS `yingdi`;

CREATE TABLE `yingdi` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键 ',
  `yingdi_name` varchar(200) DEFAULT NULL COMMENT '营地名称  Search111 ',
  `yingdi_uuid_number` varchar(200) DEFAULT NULL COMMENT '营地编号',
  `yingdi_photo` varchar(200) DEFAULT NULL COMMENT '营地照片',
  `yingdi_address` varchar(200) DEFAULT NULL COMMENT '营地地点',
  `yingdi_types` int(11) DEFAULT NULL COMMENT '营地类型 Search111',
  `yingdi_new_money` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `yingdi_zhuangtai_types` int(11) DEFAULT NULL COMMENT '营地状态 Search111',
  `yingdi_clicknum` int(11) DEFAULT NULL COMMENT '营地热度',
  `yingdi_content` text COMMENT '营地介绍 ',
  `yingdi_delete` int(11) DEFAULT NULL COMMENT '逻辑删除',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '录入时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间  show1 show2 photoShow',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='营地';

/*Data for the table `yingdi` */

insert  into `yingdi`(`id`,`yingdi_name`,`yingdi_uuid_number`,`yingdi_photo`,`yingdi_address`,`yingdi_types`,`yingdi_new_money`,`yingdi_zhuangtai_types`,`yingdi_clicknum`,`yingdi_content`,`yingdi_delete`,`insert_time`,`create_time`) values (1,'营地名称1','1678069561109','upload/yingdi1.jpg','营地地点1',2,'237.49',1,328,'营地介绍1',1,'2023-03-06 10:26:01','2023-03-06 10:26:01'),(2,'营地名称2','1678069561021','upload/yingdi2.jpg','营地地点2',1,'127.58',2,243,'营地介绍2',1,'2023-03-06 10:26:01','2023-03-06 10:26:01'),(3,'营地名称3','1678069561057','upload/yingdi3.jpg','营地地点3',1,'475.12',2,171,'营地介绍3',1,'2023-03-06 10:26:01','2023-03-06 10:26:01'),(4,'营地名称4','1678069561013','upload/yingdi4.jpg','营地地点4',3,'45.51',1,196,'营地介绍4',1,'2023-03-06 10:26:01','2023-03-06 10:26:01'),(5,'营地名称5','1678069561017','upload/yingdi5.jpg','营地地点5',2,'369.57',2,502,'营地介绍5',1,'2023-03-06 10:26:01','2023-03-06 10:26:01'),(6,'营地名称6','1678069561031','upload/yingdi6.jpg','营地地点6',4,'78.32',1,212,'营地介绍6',1,'2023-03-06 10:26:01','2023-03-06 10:26:01'),(7,'营地名称7','1678069561095','upload/yingdi7.jpg','营地地点7',4,'176.51',2,364,'营地介绍7',1,'2023-03-06 10:26:01','2023-03-06 10:26:01'),(8,'营地名称8','1678069561056','upload/yingdi8.jpg','营地地点8',2,'328.51',2,206,'营地介绍8',1,'2023-03-06 10:26:01','2023-03-06 10:26:01'),(9,'营地名称9','1678069561016','upload/yingdi9.jpg','营地地点9',4,'43.33',2,322,'营地介绍9',1,'2023-03-06 10:26:01','2023-03-06 10:26:01'),(10,'营地名称10','1678069561014','upload/yingdi10.jpg','营地地点10',1,'432.46',2,121,'营地介绍10',2,'2023-03-06 10:26:01','2023-03-06 10:26:01'),(11,'营地名称11','1678069561027','upload/yingdi11.jpg','营地地点11',3,'230.76',2,87,'<p>营地介绍11</p>',1,'2023-03-06 10:26:01','2023-03-06 10:26:01'),(12,'营地名称12','1678069561105','upload/yingdi12.jpg','营地地点12',4,'77.41',2,2,'营地介绍12',1,'2023-03-06 10:26:01','2023-03-06 10:26:01'),(13,'营地名称13','1678069561032','upload/yingdi13.jpg','营地地点13',1,'85.10',2,273,'营地介绍13',1,'2023-03-06 10:26:01','2023-03-06 10:26:01'),(14,'营地名称14','1678069561078','upload/yingdi14.jpg','营地地点14',1,'283.02',2,453,'营地介绍14',1,'2023-03-06 10:26:01','2023-03-06 10:26:01');

/*Table structure for table `yingdi_order` */

DROP TABLE IF EXISTS `yingdi_order`;

CREATE TABLE `yingdi_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `yingdi_id` int(11) DEFAULT NULL COMMENT '营地',
  `yonghu_id` int(11) DEFAULT NULL COMMENT '用户',
  `yingdi_order_time` timestamp NULL DEFAULT NULL COMMENT '预约时间',
  `yingdi_order_true_price` decimal(10,2) DEFAULT NULL COMMENT '实付价格',
  `yingdi_order_types` int(11) DEFAULT NULL COMMENT '营地类型 Search111 ',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '订单创建时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间 show3 listShow',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='营地预约';

/*Data for the table `yingdi_order` */

insert  into `yingdi_order`(`id`,`yingdi_id`,`yonghu_id`,`yingdi_order_time`,`yingdi_order_true_price`,`yingdi_order_types`,`insert_time`,`create_time`) values (4,5,1,'2023-03-06 13:38:01','369.57',106,'2023-03-06 13:38:04','2023-03-06 13:38:04'),(5,14,1,'2023-03-06 13:47:58','283.02',106,'2023-03-06 13:48:00','2023-03-06 13:48:00'),(6,14,1,'2023-03-06 13:55:21','283.02',106,'2023-03-06 13:55:23','2023-03-06 13:55:23'),(7,3,1,'2023-03-16 14:06:32','475.12',102,'2023-03-06 14:06:36','2023-03-06 14:06:36'),(8,5,1,'2023-03-17 14:07:46','369.57',102,'2023-03-06 14:07:50','2023-03-06 14:07:50');

/*Table structure for table `yonghu` */

DROP TABLE IF EXISTS `yonghu`;

CREATE TABLE `yonghu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(200) DEFAULT NULL COMMENT '账户',
  `password` varchar(200) DEFAULT NULL COMMENT '密码',
  `yonghu_name` varchar(200) DEFAULT NULL COMMENT '用户姓名 Search111 ',
  `yonghu_phone` varchar(200) DEFAULT NULL COMMENT '用户手机号',
  `yonghu_id_number` varchar(200) DEFAULT NULL COMMENT '用户身份证号',
  `yonghu_photo` varchar(200) DEFAULT NULL COMMENT '用户头像',
  `sex_types` int(11) DEFAULT NULL COMMENT '性别',
  `yonghu_email` varchar(200) DEFAULT NULL COMMENT '电子邮箱',
  `new_money` decimal(10,2) DEFAULT NULL COMMENT '余额 ',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户';

/*Data for the table `yonghu` */

insert  into `yonghu`(`id`,`username`,`password`,`yonghu_name`,`yonghu_phone`,`yonghu_id_number`,`yonghu_photo`,`sex_types`,`yonghu_email`,`new_money`,`create_time`) values (1,'a1','123456','用户姓名1','17703786901','410224199010102001','upload/yonghu1.jpg',1,'1@qq.com','7343.36','2023-03-06 10:26:01'),(2,'a2','123456','用户姓名2','17703786902','410224199010102002','upload/yonghu2.jpg',1,'2@qq.com','457.40','2023-03-06 10:26:01'),(3,'a3','123456','用户姓名3','17703786903','410224199010102003','upload/yonghu3.jpg',2,'3@qq.com','473.23','2023-03-06 10:26:01');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
