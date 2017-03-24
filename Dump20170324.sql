-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: cloud_storage
-- ------------------------------------------------------
-- Server version	5.7.10

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `message_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `text` varchar(45) DEFAULT NULL,
  `username` varchar(45) NOT NULL,
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,1,5,'啥玩意啊','啊222'),(2,2,5,'固','啊222'),(3,1,5,'恢复特福芬','啊222'),(4,1,5,'以UIUI','啊222'),(5,1,4,'哈哈哈','啊啊啊');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `file`
--

DROP TABLE IF EXISTS `file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `file` (
  `file_id` int(11) NOT NULL AUTO_INCREMENT,
  `filename` varchar(45) NOT NULL,
  `file_path` varchar(100) NOT NULL,
  `nums` int(11) NOT NULL,
  `size` varchar(45) NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  `provider_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file`
--

LOCK TABLES `file` WRITE;
/*!40000 ALTER TABLE `file` DISABLE KEYS */;
INSERT INTO `file` VALUES (2,'14级形势政策讲座上课通知.docx','E:/user_files/5_14级形势政策讲座上课通知.docx',1,'13036','类型不太清楚',5),(59,'第二个','E:/user_files/5_1.txt',1,'72','类型不太清楚',5);
/*!40000 ALTER TABLE `file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `file_share`
--

DROP TABLE IF EXISTS `file_share`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `file_share` (
  `user_id` int(11) NOT NULL,
  `target_id` int(11) NOT NULL,
  `file_id` int(11) NOT NULL,
  `is_valid` int(11) NOT NULL,
  `date` varchar(50) NOT NULL,
  PRIMARY KEY (`user_id`,`target_id`,`file_id`,`is_valid`,`date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file_share`
--

LOCK TABLES `file_share` WRITE;
/*!40000 ALTER TABLE `file_share` DISABLE KEYS */;
INSERT INTO `file_share` VALUES (1,5,1,0,'0000-00-00'),(2,5,2,0,'0000-00-00'),(4,5,8,0,'0000-00-00'),(5,4,4,0,'0000-00-00'),(5,4,4,0,'Thu Mar 02 10:58:44 CST 2017'),(5,4,5,0,'0000-00-00'),(5,4,5,0,'Thu Mar 02 11:51:18 CST 2017'),(5,4,7,0,'0000-00-00'),(5,4,58,0,'Fri Mar 24 12:59:56 CST 2017'),(5,6,7,0,'0000-00-00'),(5,11,10,0,'Wed Mar 01 23:01:09 CST 2017');
/*!40000 ALTER TABLE `file_share` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friend_apply`
--

DROP TABLE IF EXISTS `friend_apply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `friend_apply` (
  `applier_id` int(11) NOT NULL,
  `target_id` int(11) NOT NULL,
  `is_valid` int(11) NOT NULL,
  `date` varchar(50) NOT NULL,
  PRIMARY KEY (`applier_id`,`target_id`,`is_valid`,`date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friend_apply`
--

LOCK TABLES `friend_apply` WRITE;
/*!40000 ALTER TABLE `friend_apply` DISABLE KEYS */;
INSERT INTO `friend_apply` VALUES (4,5,0,'0000-00-00'),(5,4,0,'0000-00-00'),(5,4,1,'Thu Mar 02 11:53:38 CST 2017'),(5,11,0,'2017-03-01'),(5,11,0,'Wed Mar 01 22:55:53 CST 2017'),(5,12,1,'Thu Mar 02 00:07:34 CST 2017'),(5,13,1,'Thu Mar 02 11:51:42 CST 2017'),(5,21,1,'Fri Mar 10 11:46:16 CST 2017'),(6,5,0,'0000-00-00'),(11,12,1,'Thu Mar 02 00:05:34 CST 2017'),(19,4,1,'Thu Mar 09 22:25:51 CST 2017'),(19,5,0,'Thu Mar 09 22:11:27 CST 2017'),(19,5,0,'Thu Mar 09 22:11:37 CST 2017');
/*!40000 ALTER TABLE `friend_apply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friends`
--

DROP TABLE IF EXISTS `friends`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `friends` (
  `user_id1` int(11) NOT NULL,
  `user_id2` int(11) NOT NULL,
  PRIMARY KEY (`user_id1`,`user_id2`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friends`
--

LOCK TABLES `friends` WRITE;
/*!40000 ALTER TABLE `friends` DISABLE KEYS */;
INSERT INTO `friends` VALUES (4,5),(5,4),(5,6),(5,19),(11,5);
/*!40000 ALTER TABLE `friends` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `publisher_id` int(11) NOT NULL,
  `text` varchar(100) DEFAULT NULL,
  `time` date NOT NULL,
  `message_id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_num` int(11) NOT NULL,
  `publisher_name` varchar(45) NOT NULL,
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (5,'吼吼吼','2017-01-25',1,3,'啊222'),(5,'别别别','2017-01-25',2,1,'啊222'),(5,'HHH','2017-03-24',3,0,'啊222');
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tpa`
--

DROP TABLE IF EXISTS `tpa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tpa` (
  `tpa_id` int(11) NOT NULL AUTO_INCREMENT,
  `token` varchar(45) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`tpa_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tpa`
--

LOCK TABLES `tpa` WRITE;
/*!40000 ALTER TABLE `tpa` DISABLE KEYS */;
INSERT INTO `tpa` VALUES (1,'888','fffff');
/*!40000 ALTER TABLE `tpa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(20) NOT NULL,
  `introduction` varchar(100) DEFAULT NULL,
  `pic_path` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'å»å»å»','123456','ä¸°å¯å¶äºvv',NULL),(2,'æ??ç??æ??æ¡£','1234567','è¶£å??æ??',NULL),(3,'è½¦æ? å®?è½¦','12345','23456',NULL),(4,'啊啊啊','123456','申请书担当、方法、d','E:/user_pics/4_jimifan.png'),(5,'啊222','111','申请书担当、方法、d','E:/user_pics/5_201492385.png'),(6,'啊234','444','申请书担当、方法、d',NULL),(7,'的地位234','5','申请书担当、方法、d',NULL),(8,'玫瑰','123456','我很漂亮',NULL),(9,'qq','123','3211',NULL),(10,'abc','123456','迟迟未财务处',NULL),(11,'啊啊啊333','qqq','111',NULL),(12,'啊啊啊33345','qqq','111',NULL),(13,'啊啊啊444','aa','啊啊',NULL),(14,'我问问','ttt','去去去',NULL),(15,'我问问2','111','1111111',NULL),(16,'谁谁谁','11','11',NULL),(17,'谁谁谁2','3','11',NULL),(18,'谁谁谁3','1','11',NULL),(19,'zjw','123','zzzzzz',NULL),(20,'xm8','111','谁谁谁',NULL),(21,'xm81','111','谁谁谁',NULL),(22,'XM82','11','AA',NULL),(23,'XM83','11','AA',NULL),(24,'方法','11','日日日',NULL),(25,'方法2','Q','日日日',NULL),(26,'方法5','1','日日日1',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_file`
--

DROP TABLE IF EXISTS `user_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_file` (
  `user_id` int(11) NOT NULL,
  `file_id` int(11) NOT NULL,
  `filename` varchar(45) NOT NULL,
  `authority` int(11) NOT NULL,
  `date` varchar(45) DEFAULT NULL,
  `size` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`,`file_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_file`
--

LOCK TABLES `user_file` WRITE;
/*!40000 ALTER TABLE `user_file` DISABLE KEYS */;
INSERT INTO `user_file` VALUES (5,2,'嘿嘿',0,'Fri Mar 24 13:28:02 CST 2017','13036'),(5,59,'第二个',1,'Fri Mar 24 12:48:59 CST 2017','72');
/*!40000 ALTER TABLE `user_file` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-24 13:34:40
