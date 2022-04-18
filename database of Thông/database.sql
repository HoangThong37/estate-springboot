-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: springbootweb122021
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
  `createdby` varchar(255) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `buildingid` bigint(20) DEFAULT NULL,
  `staffid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkk3mdegrmfcdlsxqds1m6q238` (`buildingid`),
  KEY `FK5ml77mpq20c7cktnaayqyndi` (`staffid`),
  CONSTRAINT `FK5ml77mpq20c7cktnaayqyndi` FOREIGN KEY (`staffid`) REFERENCES `users` (`id`),
  CONSTRAINT `FKkk3mdegrmfcdlsxqds1m6q238` FOREIGN KEY (`buildingid`) REFERENCES `building` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignmentbuilding`
--

LOCK TABLES `assignmentbuilding` WRITE;
/*!40000 ALTER TABLE `assignmentbuilding` DISABLE KEYS */;
INSERT INTO `assignmentbuilding` VALUES (1,NULL,NULL,NULL,NULL,1,2),(2,NULL,NULL,NULL,NULL,2,1),(3,NULL,NULL,NULL,NULL,3,3);
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
  `createdby` varchar(255) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `customerid` bigint(20) NOT NULL,
  `staffid` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4sygo3a6twd6tkay7em8f1lgg` (`customerid`),
  KEY `FKqjgn6avtjckryyksmwrjn474o` (`staffid`),
  CONSTRAINT `FK4sygo3a6twd6tkay7em8f1lgg` FOREIGN KEY (`customerid`) REFERENCES `customer` (`id`),
  CONSTRAINT `FKqjgn6avtjckryyksmwrjn474o` FOREIGN KEY (`staffid`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignmentcustomer`
--

LOCK TABLES `assignmentcustomer` WRITE;
/*!40000 ALTER TABLE `assignmentcustomer` DISABLE KEYS */;
INSERT INTO `assignmentcustomer` VALUES (1,NULL,NULL,NULL,NULL,123,1),(2,NULL,NULL,NULL,NULL,431,2),(3,NULL,NULL,NULL,NULL,563,3);
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
  `createdby` varchar(255) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `carfee` varchar(255) DEFAULT NULL,
  `decorationtime` varchar(255) DEFAULT NULL,
  `deposit` varchar(255) DEFAULT NULL,
  `direction` varchar(255) DEFAULT NULL,
  `district` varchar(255) DEFAULT NULL,
  `electricityfee` varchar(255) DEFAULT NULL,
  `floorarea` int(11) DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  `managername` varchar(255) DEFAULT NULL,
  `managerphone` varchar(255) DEFAULT NULL,
  `motofee` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `numberofbasement` varchar(255) DEFAULT NULL,
  `overtimefee` varchar(255) DEFAULT NULL,
  `payment` varchar(255) DEFAULT NULL,
  `rentprice` int(11) DEFAULT NULL,
  `rentpricedescription` int(11) DEFAULT NULL,
  `renttime` varchar(255) DEFAULT NULL,
  `servicefee` int(11) DEFAULT NULL,
  `street` varchar(255) NOT NULL,
  `structure` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `ward` varchar(255) NOT NULL,
  `waterfee` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `building`
--

LOCK TABLES `building` WRITE;
/*!40000 ALTER TABLE `building` DISABLE KEYS */;
INSERT INTO `building` VALUES (1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'QUAN_4',NULL,455,NULL,NULL,NULL,NULL,' Trung Minh Building Tower','2',NULL,NULL,24,12,NULL,NULL,'134 nguyễn đình chiểu',NULL,'TANG_TRET,NOI_THAT','Phường 1',NULL),(2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'QUAN_1',NULL,394,NULL,NULL,NULL,NULL,'Nam Giao Building Tower','3',NULL,NULL,22,18,NULL,NULL,'59 phan xích long',NULL,'TANG_TRET,NGUYEN_CAN,NOI_THAT','Phường 2',NULL),(3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'QUAN_3',NULL,422,NULL,NULL,NULL,NULL,'Nguyễn Trãi  Building ','2',NULL,NULL,11,38,NULL,NULL,'153 nguyễn đình chiểu',NULL,'NGUYEN_CAN,NOI_THAT','Phường 3',NULL),(4,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'QUAN_2',NULL,242,NULL,NULL,NULL,NULL,'Keangnam Hanoi Landmark Tower','1',NULL,NULL,64,22,NULL,NULL,'Phạm Hùng',NULL,'TANG_TRET,NGUYEN_CAN,NOI_THAT','Phường 2',NULL),(5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'QUAN_2',NULL,211,NULL,NULL,NULL,NULL,'Bitexco Finacial Tower','2',NULL,NULL,32,33,NULL,NULL,'Số 14 Liễu Giai',NULL,'TANG_TRET,NOI_THAT','Phường 7',NULL),(6,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'QUAN_1',NULL,525,NULL,NULL,NULL,NULL,'Vietcombank Tower','5',NULL,NULL,21,42,NULL,NULL,'Số 02 Hải Triều',NULL,'TANG_TRET,NGUYEN_CAN','Phường 3',NULL),(7,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'QUAN_4',NULL,622,NULL,NULL,NULL,NULL,'Saigon One Tower','3',NULL,NULL,52,77,NULL,NULL,'332 Đường Hàm nghi',NULL,'NGUYEN_CAN,NOI_THAT','Phường 2',NULL),(8,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'QUAN_5',NULL,632,NULL,NULL,NULL,NULL,'Discovery Complex A','4',NULL,NULL,23,42,NULL,NULL,'124 Cầu Giấy',NULL,'TANG_TRET','Phường 4',NULL),(9,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'QUAN_7',NULL,234,NULL,NULL,NULL,NULL,'Saigon Center 2','3',NULL,NULL,54,21,NULL,NULL,'22 Đại lộ Lê Lợi',NULL,'TANG_TRET','Phường 1',NULL),(10,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'QUAN_6',NULL,456,NULL,NULL,NULL,NULL,'HPC Landmark 105   ','2',NULL,NULL,61,11,NULL,NULL,'145 yên xá',NULL,'NGUYEN_CAN,NOI_THAT','Phường 2',NULL);
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
  `createdby` varchar(255) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,NULL,NULL,NULL,NULL,NULL,'Nguyễn Văn Linh','123456'),(2,NULL,NULL,NULL,NULL,NULL,'Nguyễn Nhật Anh','247484'),(3,NULL,NULL,NULL,NULL,NULL,'Hoàng Trung Thông','576222');
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
  `createdby` varchar(255) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `value` int(11) DEFAULT NULL,
  `buildingid` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqhqoxlvm1iblaew5s0v8n3ut4` (`buildingid`),
  CONSTRAINT `FKqhqoxlvm1iblaew5s0v8n3ut4` FOREIGN KEY (`buildingid`) REFERENCES `building` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rentarea`
--

LOCK TABLES `rentarea` WRITE;
/*!40000 ALTER TABLE `rentarea` DISABLE KEYS */;
INSERT INTO `rentarea` VALUES (1,NULL,NULL,NULL,NULL,100,1),(2,NULL,NULL,NULL,NULL,223,2),(3,NULL,NULL,NULL,NULL,445,3);
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
  `createdby` varchar(255) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `code` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_c36say97xydpmgigg38qv5l2p` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,NULL,NULL,NULL,NULL,'ADMIN','Quản trị hệ thống'),(2,NULL,NULL,NULL,NULL,'USER','người dùng');
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
  `createdby` varchar(255) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `staffid` bigint(20) DEFAULT NULL,
  `customerid` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKldobv9jeuxje0fjqnhrw6e23v` (`customerid`),
  CONSTRAINT `FKldobv9jeuxje0fjqnhrw6e23v` FOREIGN KEY (`customerid`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  KEY `FKj345gk1bovqvfame88rcx7yyx` (`user_id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FKj345gk1bovqvfame88rcx7yyx` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdby` varchar(255) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fullname` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `status` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,NULL,NULL,NULL,NULL,NULL,'admin','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG',1,'admin'),(2,NULL,NULL,NULL,NULL,NULL,'nguyen van a','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG',1,'nguyenvana');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-18 18:20:48
