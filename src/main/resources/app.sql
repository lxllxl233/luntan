-- MySQL dump 10.13  Distrib 5.7.30, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: blog
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
-- Table structure for table `tb_blog`
--

DROP TABLE IF EXISTS `tb_blog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_blog` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '博客id',
  `user_id` int(8) DEFAULT NULL COMMENT '用户id',
  `v2_id` int(8) DEFAULT NULL COMMENT '所属二级分类下的id',
  `title` varchar(225) DEFAULT NULL COMMENT '博客标题',
  `text` text COMMENT '博客正文',
  `version` int(8) DEFAULT NULL COMMENT '乐观锁',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_blog`
--


--
-- Table structure for table `tb_blog_catalog_v1`
--

DROP TABLE IF EXISTS `tb_blog_catalog_v1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_blog_catalog_v1` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '博客的id',
  `name` varchar(32) DEFAULT NULL COMMENT '博客的分类名称',
  `version` int(8) DEFAULT NULL COMMENT '乐观锁',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_blog_catalog_v1`
--


--
-- Table structure for table `tb_blog_catalog_v2`
--

DROP TABLE IF EXISTS `tb_blog_catalog_v2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_blog_catalog_v2` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '博客二级分类的id',
  `v1_id` int(8) DEFAULT NULL COMMENT '所属一级分类 id',
  `name` varchar(32) DEFAULT NULL COMMENT '二级分类名称',
  `version` int(8) DEFAULT NULL COMMENT '乐观锁',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_blog_catalog_v2`
--


--
-- Table structure for table `tb_blog_comment`
--

DROP TABLE IF EXISTS `tb_blog_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_blog_comment` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '博客评论id',
  `p_id` int(2) DEFAULT NULL COMMENT '层级',
  `blog_id` int(8) DEFAULT NULL COMMENT '博客的id',
  `user_id` int(8) DEFAULT NULL COMMENT '用户的id',
  `b_user_id` int(8) DEFAULT NULL COMMENT '被回复的userId',
  `text` varchar(1024) DEFAULT NULL COMMENT '评论的正文',
  `version` int(8) DEFAULT NULL COMMENT '乐观锁',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_blog_comment`
--


--
-- Table structure for table `tb_forum`
--

DROP TABLE IF EXISTS `tb_forum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_forum` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '论坛的id',
  `v2_id` int(8) DEFAULT NULL COMMENT '论坛所属二级分类id',
  `user_id` int(8) DEFAULT NULL COMMENT '创建者的id',
  `title` varchar(255) DEFAULT NULL COMMENT '论坛标题',
  `text` text COMMENT '论坛正文',
  `version` int(8) DEFAULT NULL COMMENT '乐观锁',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_forum`
--


--
-- Table structure for table `tb_forum_catalog_v1`
--

DROP TABLE IF EXISTS `tb_forum_catalog_v1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_forum_catalog_v1` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '论坛一级分类的id',
  `name` varchar(32) DEFAULT NULL COMMENT '博客的分类名称',
  `version` int(8) DEFAULT NULL COMMENT '乐观锁',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_forum_catalog_v1`
--


--
-- Table structure for table `tb_forum_catalog_v2`
--

DROP TABLE IF EXISTS `tb_forum_catalog_v2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_forum_catalog_v2` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '论坛二级分类的id',
  `v1_id` int(8) DEFAULT NULL COMMENT '所属一级分类 id',
  `name` varchar(32) DEFAULT NULL COMMENT '二级分类名称',
  `version` int(8) DEFAULT NULL COMMENT '乐观锁',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_forum_catalog_v2`
--


--
-- Table structure for table `tb_forum_commit`
--

DROP TABLE IF EXISTS `tb_forum_commit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_forum_commit` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '论坛讨论 id',
  `p_id` int(2) DEFAULT NULL COMMENT '评论的层级',
  `forum_id` int(8) DEFAULT NULL COMMENT '论坛的 id',
  `user_id` int(8) DEFAULT NULL COMMENT '评论用户的id',
  `b_user_id` int(8) DEFAULT NULL COMMENT '被回复用户的 id',
  `text` text COMMENT '回复正文',
  `version` int(8) DEFAULT NULL COMMENT '乐观锁',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_forum_commit`
--


--
-- Table structure for table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_user` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `nickname` varchar(32) DEFAULT NULL COMMENT '用户',
  `username` varchar(32) DEFAULT NULL COMMENT '用户姓名',
  `user_phone` varchar(32) DEFAULT NULL COMMENT '用户手机号',
  `user_password` varchar(32) DEFAULT NULL COMMENT '用户密码',
  `user_introduction` varchar(1024) DEFAULT NULL COMMENT '用户自我介绍',
  `identity` int(2) DEFAULT NULL COMMENT '用户身份标识',
  `user_experience` int(8) DEFAULT NULL COMMENT '用户当前所具有的经验值',
  `version` int(8) DEFAULT NULL COMMENT '乐观锁',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--


--
-- Table structure for table `tb_user_level`
--

DROP TABLE IF EXISTS `tb_user_level`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_user_level` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '等级名称 id',
  `lv` int(8) DEFAULT NULL COMMENT '等级名称',
  `lv_name` varchar(64) DEFAULT NULL COMMENT '等级称号',
  `lv_experience` int(8) DEFAULT NULL COMMENT '到达该等级需要的经验',
  `version` int(8) DEFAULT NULL COMMENT '乐观锁',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user_level`
--

/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-22 22:42:28
