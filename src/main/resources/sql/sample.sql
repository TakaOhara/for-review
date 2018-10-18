-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: spring
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authorities`
--

LOCK TABLES `authorities` WRITE;
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` VALUES ('john','ROLE_EMPLOYEE'),('mary','ROLE_EMPLOYEE'),('mary','ROLE_MANAGER'),('susan','ROLE_ADMIN'),('susan','ROLE_EMPLOYEE');
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instructor`
--

DROP TABLE IF EXISTS `instructor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `instructor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `instructor_detail_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_DETAIL_idx` (`instructor_detail_id`),
  CONSTRAINT `FK_DETAIL` FOREIGN KEY (`instructor_detail_id`) REFERENCES `instructor_detail` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructor`
--

LOCK TABLES `instructor` WRITE;
/*!40000 ALTER TABLE `instructor` DISABLE KEYS */;
INSERT INTO `instructor` VALUES (1,'Madhu','Patel','madhu@luv2code.com',1),(2,'Yoshiki','Yamada','sample@sample.com',2),(4,'Yuji','Kojima','newemail@email.com',3),(5,'Yuji','Kojima','newemail@email.com',4),(9,'yoshiki','Xjapan','x@x.com',12),(12,'gugu','hhk','uuy',17),(16,'','','cdta13167@gmail.com',22),(17,'','','cdta13167@gmail.co',23),(18,'','','cdta13167@gmail.com2',24),(19,'Miki','Ota','abc@abc.com',25),(20,'eyuey','iyoyo','yui@yui.com',26),(21,'yoyo','yoyo','yoyo@yoyo.com',36),(22,'sguww','dgu','dgu@dgu.com',44),(23,'hu','hu','hu@hu.com',30),(24,'toshio5','aaa5','aaa@aaa.com',40);
/*!40000 ALTER TABLE `instructor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instructor_detail`
--

DROP TABLE IF EXISTS `instructor_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `instructor_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `youtube_channel` varchar(128) DEFAULT NULL,
  `hobby` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructor_detail`
--

LOCK TABLES `instructor_detail` WRITE;
/*!40000 ALTER TABLE `instructor_detail` DISABLE KEYS */;
INSERT INTO `instructor_detail` VALUES (1,'http://www.youtube.com','Guitar'),(2,'https://www.sample.com','Soccer'),(3,'ActiveChannel','cooking'),(4,'ActiveChannel','cooking'),(6,'doc','jamp'),(7,'doc','jamp'),(8,'doc','jamp'),(9,'doc','jamp'),(12,'xjapan','music'),(17,'gkky','gkuku'),(22,'fgess',''),(23,'cdta13167@gmail.co',''),(24,'cdta13167@gmail.com2',''),(25,'abc@abc.com','flkds'),(26,'yui@yui.com','kjh'),(27,'yoyo@yoyo.com','yui'),(28,'dgu@dgu.com','iii'),(29,'hu@hu.com','hu'),(30,'hu@hu.com','hu2'),(31,'aaa@aaa.com','aaa'),(32,'aaa@aaa.com','aaa2'),(33,'aaa@aaa.com','aaa3'),(34,'aaa@aaa.com','aaa4'),(35,'aaa@aaa.com','aaa4'),(36,'yoyo@yoyo.com','yui'),(37,'aaa@aaa.com','aaa5'),(38,'aaa@aaa.com','afjdse'),(39,'aaa@aaa.com','afjdse2'),(40,'aaa@aaa.com','afjdse2'),(41,'dgu@dgu.com','iii2'),(42,'dgu@dgu.com','iii2'),(43,'dgu@dgu.com','iii4'),(44,'dgu@dgu.com','iii4');
/*!40000 ALTER TABLE `instructor_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task_type`
--

DROP TABLE IF EXISTS `task_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `task_type` (
  `id` int(2) NOT NULL,
  `type` varchar(20) NOT NULL,
  `comment` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_type`
--

LOCK TABLES `task_type` WRITE;
/*!40000 ALTER TABLE `task_type` DISABLE KEYS */;
INSERT INTO `task_type` VALUES (1,'緊急','最優先で取り掛かるべきタスク'),(2,'重要','期限に間に合わせるべきタスク'),(3,'できれば','やってみたいアイデア');
/*!40000 ALTER TABLE `task_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tasks`
--

DROP TABLE IF EXISTS `tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tasks` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `type_id` int(2) NOT NULL,
  `title` varchar(50) NOT NULL,
  `detail` text,
  `deadline` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `type_id` (`type_id`),
  CONSTRAINT `tasks_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `task_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasks`
--

LOCK TABLES `tasks` WRITE;
/*!40000 ALTER TABLE `tasks` DISABLE KEYS */;
INSERT INTO `tasks` VALUES (1,1,'wash dishes2','Sometimes to understand a word\'s meaning you need more than a definition. ','2018-10-12 11:00:00'),(2,2,'Complete coding','At YourDictionary we try to give you all of the tools you need to really understand what the word means.','2018-10-11 12:23:00'),(9,1,'Go back home','Seeing the word in a sentence can provide more context and relevance.','2018-10-19 13:00:00');
/*!40000 ALTER TABLE `tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_info` (
  `username` varchar(50) NOT NULL,
  `email` varchar(70) NOT NULL,
  `password` varchar(60) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `authority` varchar(50) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_info`
--

LOCK TABLES `user_info` WRITE;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` VALUES ('sample','sample@sample.com','$2a$10$oeobcca8HLATCWQ4TjCwOuOYpKHFfOFCmosvIAWhTdV4fmCyf8WoW',1,'ROLE_USER');
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('john','{noop}test123',1),('mary','{noop}test123',1),('susan','{noop}test123',1);
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

-- Dump completed on 2018-10-18 14:14:54
