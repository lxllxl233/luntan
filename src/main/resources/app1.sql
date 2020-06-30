-- MySQL dump 10.13  Distrib 5.7.30, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: xinli
-- ------------------------------------------------------
-- Server version	5.7.30-0ubuntu0.18.04.1

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
-- Table structure for table `tb_advisory`
--

DROP TABLE IF EXISTS `tb_advisory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_advisory` (
  `ad_id` int(64) NOT NULL AUTO_INCREMENT,
  `user_id` int(64) NOT NULL,
  `master_consultant_id` int(64) NOT NULL,
  `master_supervisor_id` int(64) DEFAULT NULL,
  `ad_time` datetime DEFAULT NULL,
  `ad_user_evaluation` varchar(1024) DEFAULT NULL,
  `ad_consultant_evaluation` varchar(1024) DEFAULT NULL,
  `ad_consultant_recording` varchar(1024) DEFAULT NULL,
  `ad_img_url1` varchar(255) DEFAULT NULL,
  `ad_img_url2` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ad_id`) USING HASH,
  UNIQUE KEY `ad_id` (`ad_id`),
  KEY `user_id` (`user_id`),
  KEY `master_consultant_id` (`master_consultant_id`),
  KEY `master_supervisor_id` (`master_supervisor_id`),
  CONSTRAINT `tb_advisory_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`user_id`),
  CONSTRAINT `tb_advisory_ibfk_2` FOREIGN KEY (`master_consultant_id`) REFERENCES `tb_master` (`master_id`),
  CONSTRAINT `tb_advisory_ibfk_3` FOREIGN KEY (`master_supervisor_id`) REFERENCES `tb_master` (`master_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_advisory`
--


--
-- Table structure for table `tb_application`
--

DROP TABLE IF EXISTS `tb_application`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_application` (
  `app_id` int(64) NOT NULL AUTO_INCREMENT,
  `user_id` int(64) NOT NULL,
  `master_consultant_id` int(64) NOT NULL,
  `app_time` datetime DEFAULT NULL,
  `app_optime` datetime DEFAULT NULL,
  `app_begin_time` datetime DEFAULT NULL,
  `app_duration` int(8) NOT NULL,
  `app_description` varchar(1024) DEFAULT NULL,
  `app_status` int(64) NOT NULL DEFAULT '0',
  PRIMARY KEY (`app_id`) USING HASH,
  UNIQUE KEY `app_id` (`app_id`),
  KEY `user_id` (`user_id`),
  KEY `master_consultant_id` (`master_consultant_id`),
  CONSTRAINT `tb_application_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`user_id`),
  CONSTRAINT `tb_application_ibfk_2` FOREIGN KEY (`master_consultant_id`) REFERENCES `tb_master` (`master_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_application`
--


--
-- Table structure for table `tb_authority`
--

DROP TABLE IF EXISTS `tb_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_authority` (
  `au_character` int(64) NOT NULL,
  `au_view_records` tinyint(1) DEFAULT NULL,
  `au_view_img` tinyint(1) DEFAULT NULL,
  `au_view_history` tinyint(1) DEFAULT NULL,
  `au_place_model` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`au_character`),
  UNIQUE KEY `au_character` (`au_character`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_authority`
--


--
-- Table structure for table `tb_catalog_v1`
--

DROP TABLE IF EXISTS `tb_catalog_v1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_catalog_v1` (
  `v1_id` int(64) NOT NULL AUTO_INCREMENT,
  `v1_name` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`v1_id`) USING HASH,
  UNIQUE KEY `v1_id` (`v1_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_catalog_v1`
--

INSERT INTO `tb_catalog_v1` VALUES (1,'机车');

--
-- Table structure for table `tb_catalog_v2`
--

DROP TABLE IF EXISTS `tb_catalog_v2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_catalog_v2` (
  `v2_id` int(64) NOT NULL AUTO_INCREMENT,
  `v1_id` int(64) DEFAULT NULL,
  `v2_name` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`v2_id`) USING HASH,
  UNIQUE KEY `v2_id` (`v2_id`),
  KEY `v1_id` (`v1_id`),
  CONSTRAINT `tb_catalog_v2_ibfk_1` FOREIGN KEY (`v1_id`) REFERENCES `tb_catalog_v1` (`v1_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_catalog_v2`
--

INSERT INTO `tb_catalog_v2` VALUES (2,1,'大汽车');

--
-- Table structure for table `tb_master`
--

DROP TABLE IF EXISTS `tb_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_master` (
  `master_id` int(64) NOT NULL AUTO_INCREMENT,
  `master_name` varchar(64) DEFAULT NULL,
  `master_password` varchar(64) DEFAULT NULL,
  `master_age` varchar(64) DEFAULT NULL,
  `master_head_img` varchar(255) DEFAULT NULL,
  `master_phone` varchar(64) DEFAULT NULL,
  `master_qualification` varchar(1024) DEFAULT NULL,
  `master_experience` varchar(1024) DEFAULT NULL,
  `master_authority` int(10) NOT NULL,
  `master_deadline` datetime DEFAULT NULL,
  PRIMARY KEY (`master_id`) USING HASH,
  UNIQUE KEY `master_id` (`master_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_master`
--

INSERT INTO `tb_master` VALUES (1,'测试1','qwertyui','30','https://tse2-mm.cn.bing.net/th/id/OIP.RFJqRtBzos_ql6XrN-_iEgHaKg?w=144&h=205&c=7&o=5&pid=1.7','11132343','心理学','多年从业经历',0,NULL);
INSERT INTO `tb_master` VALUES (2,'测试2','qwertyui','30','https://tse2-mm.cn.bing.net/th/id/OIP.RFJqRtBzos_ql6XrN-_iEgHaKg?w=144&h=205&c=7&o=5&pid=1.7','11132343','心理学','多年从业经历',0,NULL);
INSERT INTO `tb_master` VALUES (3,'string','string','25','string','string','string','string',1,NULL);

--
-- Table structure for table `tb_model`
--

DROP TABLE IF EXISTS `tb_model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_model` (
  `md_id` int(64) NOT NULL AUTO_INCREMENT,
  `v2_id` int(64) DEFAULT NULL,
  `md_name` varchar(64) DEFAULT NULL,
  `md_description` varchar(255) DEFAULT NULL,
  `md_small_url` varchar(255) DEFAULT NULL,
  `md_big_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`md_id`) USING HASH,
  UNIQUE KEY `md_id` (`md_id`),
  KEY `v2_id` (`v2_id`),
  CONSTRAINT `tb_model_ibfk_1` FOREIGN KEY (`v2_id`) REFERENCES `tb_catalog_v2` (`v2_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_model`
--

INSERT INTO `tb_model` VALUES (2,2,'图片测试1','图片','https://tse3-mm.cn.bing.net/th/id/OIP.gJMiYZF0O79Q1Tk5xyHtXgHaFj?w=273&h=205&c=7&o=5&pid=1.7','https://tse3-mm.cn.bing.net/th/id/OIP.gJMiYZF0O79Q1Tk5xyHtXgHaFj?w=273&h=205&c=7&o=5&pid=1.7');

--
-- Table structure for table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_user` (
  `user_id` int(64) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(64) DEFAULT NULL,
  `user_password` varchar(64) DEFAULT NULL,
  `user_age` varchar(64) DEFAULT NULL,
  `user_head_img` varchar(255) DEFAULT NULL,
  `user_phone` varchar(64) DEFAULT NULL,
  `user_frequency` varchar(64) DEFAULT NULL,
  `user_deadline` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--

INSERT INTO `tb_user` VALUES (1,'string','string','15','https://tse3-mm.cn.bing.net/th/id/OIP.gJMiYZF0O79Q1Tk5xyHtXgHaFj?w=273&h=205&c=7&o=5&pid=1.7','111111','string',NULL);
INSERT INTO `tb_user` VALUES (2,'string','string','string','string','string','string','2020-11-09 10:00:00');
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-07 19:41:23
