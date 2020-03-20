CREATE DATABASE  IF NOT EXISTS `hospital` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `hospital`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: hospital
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `username` varchar(16) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(32) NOT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `id` varchar(45) NOT NULL,
  PRIMARY KEY (`id`,`username`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('akhila','akhila.franklin@edu','akhi123','2020-02-24 21:30:28',''),('testing1','testing','testing','2020-03-05 20:25:15','1'),('JohnMike','test123','joke.mike@gmail.com','2020-18-12 01:18:08','10'),('JohnMike6','joke.mike@gmail.com','test123','2020-51-12 01:51:26','21'),('sunny','testing1','sunny@gmail.com','2020-03-05 20:25:15','3'),('JohnMike5','joke.mike@gmail.com','test123','2020-47-12 01:47:11','31'),('testing99','testing99','sunny@gmail.com','2020-35-12 01:35:27','37'),('JohnMike115','joke.mike@gmail.com','test123','2020-30-19 09:30:48','45'),('JohnMike4','test123','joke.mike@gmail.com','2020-42-12 01:42:20','48'),('JohnMike2','test123','joke.mike@gmail.com','2020-26-12 01:26:38','49'),('username1','email1','password1','2020-59-15 10:59:49','5'),('JohnMike1','test123','joke.mike@gmail.com','2020-23-12 01:23:20','52'),('JohnMike15','joke.mike@gmail.com','test123','2020-05-12 02:05:08','52'),('JohnMike3','test123','joke.mike@gmail.com','2020-34-12 01:34:51','62'),('sunny12','testing12','sunny@gmail.com','2020-15-05 10:15:01','74'),('Bunny1','bunny123','sunny.bunny@gmail.com','2020-24-12 01:24:20','75'),('username','email','password','2020-49-15 10:49:56','81'),('testing1234','testing1234','sunny@gmail.com','2020-02-05 11:02:10','83'),('JohnMike10','joke.mike@gmail.com','test123','2020-54-12 01:54:37','84'),('sunny1','testing1','sunny@gmail.com','2020-13-05 10:13:07','89'),('Bunny','bunny123','sunny.bunny@gmail.com','2020-18-12 01:18:08','91'),('testing111234','sunny@gmail.com','testing111234','2020-04-17 10:04:18','96'),('Bunny2','bunny123','sunny.bunny@gmail.com','2020-37-12 01:37:05','98');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-19 23:42:46
