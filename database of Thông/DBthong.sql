-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: springboottest
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `assignmentbuilding`
--

DROP TABLE IF EXISTS `assignmentbuilding`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `assignmentbuilding` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `staffid` bigint(20) NOT NULL,
  `buildingid` bigint(20) NOT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_building` (`staffid`),
  KEY `fk_building_user` (`buildingid`),
  CONSTRAINT `FKf4ibbod44h32ao1o6pb4yq98p` FOREIGN KEY (`staffid`) REFERENCES `user` (`id`),
  CONSTRAINT `FKkk3mdegrmfcdlsxqds1m6q238` FOREIGN KEY (`buildingid`) REFERENCES `building` (`id`),
  CONSTRAINT `fk_building_user` FOREIGN KEY (`buildingid`) REFERENCES `building` (`id`),
  CONSTRAINT `fk_user_building` FOREIGN KEY (`staffid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignmentbuilding`
--

LOCK TABLES `assignmentbuilding` WRITE;
/*!40000 ALTER TABLE `assignmentbuilding` DISABLE KEYS */;
INSERT INTO `assignmentbuilding` VALUES (2,2,3,NULL,NULL,NULL,NULL),(4,3,4,NULL,NULL,NULL,NULL),(14,3,43,'2021-12-23 12:59:57','2021-12-23 12:59:57','admin','admin'),(16,4,43,'2021-12-23 13:00:02','2021-12-23 13:00:02','admin','admin');
/*!40000 ALTER TABLE `assignmentbuilding` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assignmentcustomer`
--

DROP TABLE IF EXISTS `assignmentcustomer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `assignmentcustomer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `staffid` bigint(20) NOT NULL,
  `customerid` bigint(20) NOT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_customer` (`staffid`),
  KEY `fk_customer_user` (`customerid`),
  CONSTRAINT `FK4sygo3a6twd6tkay7em8f1lgg` FOREIGN KEY (`customerid`) REFERENCES `customer` (`id`),
  CONSTRAINT `FKco26n95l1hpuq1suv0briljor` FOREIGN KEY (`staffid`) REFERENCES `user` (`id`),
  CONSTRAINT `fk_customer_user` FOREIGN KEY (`customerid`) REFERENCES `customer` (`id`),
  CONSTRAINT `fk_user_customer` FOREIGN KEY (`staffid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignmentcustomer`
--

LOCK TABLES `assignmentcustomer` WRITE;
/*!40000 ALTER TABLE `assignmentcustomer` DISABLE KEYS */;
INSERT INTO `assignmentcustomer` VALUES (11,2,3,NULL,NULL,NULL,NULL),(12,3,4,NULL,NULL,NULL,NULL),(14,3,8,NULL,NULL,NULL,NULL),(16,1,9,NULL,NULL,NULL,NULL),(19,4,10,NULL,NULL,NULL,NULL),(20,1,1,NULL,NULL,NULL,NULL),(21,2,2,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `assignmentcustomer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `building`
--

DROP TABLE IF EXISTS `building`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `building` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `street` varchar(255) DEFAULT NULL,
  `ward` varchar(255) DEFAULT NULL,
  `district` varchar(255) DEFAULT NULL,
  `structure` varchar(255) DEFAULT NULL,
  `numberofbasement` int(11) DEFAULT NULL,
  `floorarea` int(11) DEFAULT NULL,
  `direction` varchar(255) DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  `rentprice` int(11) DEFAULT NULL,
  `rentpricedescription` text,
  `servicefee` varchar(255) DEFAULT NULL,
  `carfee` varchar(255) DEFAULT NULL,
  `motofee` varchar(255) DEFAULT NULL,
  `overtimefee` varchar(255) DEFAULT NULL,
  `waterfee` varchar(255) DEFAULT NULL,
  `electricityfee` varchar(255) DEFAULT NULL,
  `deposit` varchar(255) DEFAULT NULL,
  `payment` varchar(255) DEFAULT NULL,
  `renttime` varchar(255) DEFAULT NULL,
  `decorationtime` varchar(255) DEFAULT NULL,
  `brokeragetee` decimal(13,2) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `linkofbuilding` varchar(255) DEFAULT NULL,
  `map` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `managerphone` varchar(255) DEFAULT NULL,
  `managername` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `building`
--

LOCK TABLES `building` WRITE;
/*!40000 ALTER TABLE `building` DISABLE KEYS */;
INSERT INTO `building` VALUES (1,'Nguyên Tower','187/12 NguyễnTrãi','Phường 2','QUAN_1','',2,NULL,'','',15,'15 triệu/m2','','','','','','','','','','',NULL,'TANG_TRET,NGUYEN_CAN',NULL,NULL,NULL,NULL,NULL,'2022-05-12 13:14:39',NULL,'admin','0395131916','hiaia'),(2,'ACM Tower','96 cao thắng','Phường 4','QUAN_2','',2,650,'','',18,'18 triệu/m2','','','','','','','','','','',NULL,'NGUYEN_CAN',NULL,NULL,NULL,NULL,NULL,'2022-06-03 00:42:18',NULL,'admin','0234523','SDFSDfff'),(3,'Alpha 2 Building Tower','153 nguyễn đình chiểu','Phường 6','QUAN_1','',1,200,'','',20,'20 triệu/m2','','','','','','','','','','',NULL,'NOI_THAT',NULL,NULL,NULL,NULL,NULL,'2022-05-28 21:44:04',NULL,'admin','056756','SDFS'),(4,'IDD 1 Building','111 Lý Chính Thắng','Phường 7','QUAN_4','',1,200,'','',12,'12 triệu/m2','','','','','','','','','','',NULL,'TANG_TRET,NGUYEN_CAN,NOI_THAT',NULL,NULL,NULL,NULL,NULL,'2021-12-23 12:07:19',NULL,'admin','0456674','SDFSD'),(43,'Minh Tiến Building','904/42 Nguyễn Kiệm','',NULL,'',NULL,NULL,'','',NULL,'','','','','','','','','','','',NULL,'',NULL,NULL,NULL,NULL,'2021-12-23 12:57:23','2021-12-23 12:57:23','admin','admin','0395131916',''),(46,'Ninh Hiệp Building','12','Thanh Trì','QUAN_2','',3,16,'','',100000,'','','','','','','','','','','',NULL,'TANG_TRET,NGUYEN_CAN',NULL,NULL,NULL,NULL,'2022-04-25 14:50:06','2022-04-25 14:50:06','admin','admin','',''),(47,'KMA Building','Chiến Thắng','Hà Đông','QUAN_1','',5,78,'12','',100000000,'Gía thuê siêu rẻ','100000','1500000','500000','','','','','','','',NULL,'NGUYEN_CAN,NOI_THAT',NULL,NULL,NULL,NULL,'2022-04-25 15:32:30','2022-04-25 15:32:30','admin','admin','012345678','Hoàng Trung Thông'),(51,'nguyên vũ','123','asd','QUAN_2','',NULL,NULL,'','',NULL,'','','','','','','','','','','',NULL,'TANG_TRET,NOI_THAT',NULL,NULL,NULL,NULL,NULL,'2022-05-12 12:28:57',NULL,'admin','12345','trần hải'),(59,'thongbem','123','quang trung',NULL,'',NULL,NULL,'','',NULL,'','','','','','','','','','','',NULL,'TANG_TRET,NGUYEN_CAN',NULL,NULL,NULL,NULL,'2022-06-03 00:57:25','2022-06-03 00:57:25','admin','admin','12345','Hoàng Trung Thông'),(60,'nguyen a','222','333','QUAN_2','',NULL,NULL,'14','',NULL,'','','','','','','','','','','',NULL,'TANG_TRET',NULL,NULL,NULL,NULL,NULL,'2022-06-03 16:46:39',NULL,'admin','','');
/*!40000 ALTER TABLE `building` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `needs` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'thong','0362435782','thonghaha@gmail.com',NULL,'2022-07-08 18:15:24',NULL,'nguyenvana','kma','',''),(2,'minh','123456','thong65@gmail.com','2022-06-26 00:41:20','2022-06-30 12:36:19','admin','admin',NULL,NULL,NULL),(3,'ahi','0123567','kaka@gmail.com','2022-06-26 00:47:12','2022-06-29 10:40:02','admin','admin',NULL,NULL,NULL),(4,'tứ hiệp','982921','cokogiu12@gmail.com','2022-06-27 16:22:37','2022-06-29 10:40:50',NULL,'admin',NULL,NULL,NULL),(8,'nguyen van ahihi','235678','hoangthong@gmail.com','2022-06-27 17:44:11','2022-06-29 10:40:35','admin','admin',NULL,NULL,NULL),(9,'lam lam','2356688','lam@gmail.com','2022-06-28 13:38:00','2022-06-29 11:09:23','admin','admin','sapo','15m2','ok nhé'),(10,'Bích Nguyễn','787264828','bichabc@gmail.com','2022-06-29 10:44:06','2022-06-29 22:31:54','admin','admin',NULL,NULL,NULL);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rentarea`
--

DROP TABLE IF EXISTS `rentarea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `rentarea` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `value` int(11) DEFAULT NULL,
  `buildingid` bigint(20) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `rentarea_building` (`buildingid`),
  CONSTRAINT `FKqhqoxlvm1iblaew5s0v8n3ut4` FOREIGN KEY (`buildingid`) REFERENCES `building` (`id`),
  CONSTRAINT `rentarea_building` FOREIGN KEY (`buildingid`) REFERENCES `building` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=232 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rentarea`
--

LOCK TABLES `rentarea` WRITE;
/*!40000 ALTER TABLE `rentarea` DISABLE KEYS */;
INSERT INTO `rentarea` VALUES (9,100,4,NULL,NULL,NULL,NULL),(98,400,4,'2021-12-23 12:07:20','2021-12-23 12:07:20','admin','admin'),(99,250,4,'2021-12-23 12:07:20','2021-12-23 12:07:20','admin','admin'),(100,300,4,'2021-12-23 12:07:20','2021-12-23 12:07:20','admin','admin'),(121,100,43,'2021-12-23 12:57:23','2021-12-23 12:57:23','admin','admin'),(122,400,43,'2021-12-23 12:57:23','2021-12-23 12:57:23','admin','admin'),(123,300,43,'2021-12-23 12:57:23','2021-12-23 12:57:23','admin','admin'),(124,200,43,'2021-12-23 12:57:23','2021-12-23 12:57:23','admin','admin'),(166,200,1,'2021-12-23 14:45:38','2021-12-23 14:45:38','admin','admin'),(167,100,1,'2021-12-23 14:45:38','2021-12-23 14:45:38','admin','admin'),(195,200,51,'2022-05-12 12:28:57','2022-05-12 12:28:57','admin','admin'),(211,300,3,'2022-05-28 21:44:04','2022-05-28 21:44:04','admin','admin'),(212,400,3,'2022-05-28 21:44:04','2022-05-28 21:44:04','admin','admin'),(213,500,3,'2022-05-28 21:44:04','2022-05-28 21:44:04','admin','admin'),(214,600,3,'2022-05-28 21:44:04','2022-05-28 21:44:04','admin','admin'),(217,200,2,'2022-06-03 00:42:18','2022-06-03 00:42:18','admin','admin'),(218,300,2,'2022-06-03 00:42:18','2022-06-03 00:42:18','admin','admin'),(219,400,2,'2022-06-03 00:42:18','2022-06-03 00:42:18','admin','admin'),(220,NULL,2,'2022-06-03 00:42:18','2022-06-03 00:42:18','admin','admin'),(223,200,59,'2022-06-03 00:57:25','2022-06-03 00:57:25','admin','admin'),(224,300,59,'2022-06-03 00:57:25','2022-06-03 00:57:25','admin','admin'),(229,200,60,'2022-06-03 16:46:39','2022-06-03 16:46:39','admin','admin'),(230,300,60,'2022-06-03 16:46:39','2022-06-03 16:46:39','admin','admin'),(231,500,60,'2022-06-03 16:46:39','2022-06-03 16:46:39','admin','admin');
/*!40000 ALTER TABLE `rentarea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Quản lý','MANAGER',NULL,NULL,NULL,NULL),(2,'Nhân viên','STAFF',NULL,NULL,NULL,NULL),(3,'Quản trị hệ thống','ADMIN',NULL,NULL,NULL,NULL),(4,'người dùng','USER',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `transaction` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `customerid` bigint(20) NOT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `staffid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_customer_transaction` (`customerid`),
  CONSTRAINT `FKldobv9jeuxje0fjqnhrw6e23v` FOREIGN KEY (`customerid`) REFERENCES `customer` (`id`),
  CONSTRAINT `fk_customer_transaction` FOREIGN KEY (`customerid`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES (1,'DANDIXEM','',1,'2022-06-26 00:42:43','2022-06-26 00:42:43','admin','admin',NULL),(2,'DUADIXASTRESS','đi bay lak',1,'2022-06-27 16:12:40','2022-06-27 16:12:40','admin','admin',NULL),(3,'QT_CSKH','',1,'2022-06-28 13:06:26','2022-06-28 13:06:26','admin','admin',NULL),(4,'DUADIXASTRESS','',1,'2022-06-28 13:06:49','2022-06-28 13:06:49','admin','admin',NULL);
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'nguyenvana','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','nguyễn văn a',NULL,NULL,1,NULL,NULL,NULL,NULL),(2,'nguyenvanb','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','nguyễn văn b',NULL,NULL,1,NULL,NULL,NULL,NULL),(3,'nguyenvanc','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','nguyễn văn c',NULL,NULL,1,NULL,NULL,NULL,NULL),(4,'nguyenvand','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','nguyễn văn d',NULL,NULL,1,NULL,NULL,NULL,NULL),(5,'hoangtrungthong','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','hoàng trung thông',NULL,NULL,1,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `roleid` bigint(20) NOT NULL,
  `userid` bigint(20) NOT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_role` (`userid`),
  KEY `fk_role_user` (`roleid`),
  CONSTRAINT `FKbo5ik0bthje7hum554xb17ry6` FOREIGN KEY (`roleid`) REFERENCES `role` (`id`),
  CONSTRAINT `FKd0xwi6psywvnj59btfns0alnm` FOREIGN KEY (`userid`) REFERENCES `user` (`id`),
  CONSTRAINT `fk_role_user` FOREIGN KEY (`roleid`) REFERENCES `role` (`id`),
  CONSTRAINT `fk_user_role` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (4,2,4,NULL,NULL,NULL,NULL),(5,3,5,NULL,NULL,NULL,NULL),(8,1,1,NULL,NULL,NULL,NULL),(9,2,2,NULL,NULL,NULL,NULL),(12,2,3,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-08 18:38:27
