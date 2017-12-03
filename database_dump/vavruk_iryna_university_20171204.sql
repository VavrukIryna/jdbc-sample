-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: university
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `id_address` int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(45) DEFAULT NULL,
  `street` varchar(45) DEFAULT NULL,
  `home` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_address`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'Odessa','Вулиця_Транзакційна_1',1),(2,'Kyiv','Вулиця_Транзакційна_2',23),(3,'Lviv','Bandery',12),(4,'Lviv','Chornovola',42),(5,'Odessa','Derybasivska',42),(6,'Odessa','Derybasivska',42),(9,'Lviv','Chornovola',42),(10,'Lviv','Chornovola',42),(11,'Lviv','Chornovola',42),(12,'Lviv','Chornovola',42),(13,'Lviv','Chornovola',42),(14,'Lviv','Chornovola',42),(15,'Lviv','Chornovola',42),(18,'Lviv','Chornovola',42),(19,'Lviv','Chornovola',42),(20,'Lviv','Chornovola',42);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `id_dept` int(11) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(45) DEFAULT NULL,
  `institute_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_dept`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'PZ','IKNI'),(2,'SAPR','IKNI'),(3,'ASU','IKNI'),(4,'EK','EK5'),(5,'PL','IKNI');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam`
--

DROP TABLE IF EXISTS `exam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exam` (
  `id_exam` int(11) NOT NULL AUTO_INCREMENT,
  `exam_date` date DEFAULT NULL,
  `exam_subject_id` int(11) DEFAULT NULL,
  `exam_mark` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_exam`),
  KEY `id_subject_idx` (`exam_subject_id`),
  CONSTRAINT `id_subject` FOREIGN KEY (`exam_subject_id`) REFERENCES `subject` (`id_subject`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam`
--

LOCK TABLES `exam` WRITE;
/*!40000 ALTER TABLE `exam` DISABLE KEYS */;
INSERT INTO `exam` VALUES (1,'2017-01-05',1,57),(2,'2017-02-10',2,88),(3,'2018-01-15',3,90),(4,'2018-01-17',4,77),(5,'2018-01-21',5,55);
/*!40000 ALTER TABLE `exam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parents`
--

DROP TABLE IF EXISTS `parents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parents` (
  `id_parents` int(11) NOT NULL AUTO_INCREMENT,
  `father_name` varchar(45) DEFAULT NULL,
  `father_surname` varchar(45) DEFAULT NULL,
  `mother_name` varchar(45) DEFAULT NULL,
  `mother_surname` varchar(45) DEFAULT NULL,
  `id_address` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_parents`),
  KEY `id_address_idx` (`id_address`),
  CONSTRAINT `id_address_parents` FOREIGN KEY (`id_address`) REFERENCES `address` (`id_address`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parents`
--

LOCK TABLES `parents` WRITE;
/*!40000 ALTER TABLE `parents` DISABLE KEYS */;
INSERT INTO `parents` VALUES (1,'Oleh','Kuluk','Olha','Kuluk',1),(2,'Yurii','Bilas','Iryna','Bilas',2),(3,'Mychailo','Kruk','Maria','Kruk',3);
/*!40000 ALTER TABLE `parents` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `specialty`
--

DROP TABLE IF EXISTS `specialty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `specialty` (
  `id_speciality` int(11) NOT NULL AUTO_INCREMENT,
  `specialty_name` varchar(45) DEFAULT NULL,
  `specialty_describe` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_speciality`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `specialty`
--

LOCK TABLES `specialty` WRITE;
/*!40000 ALTER TABLE `specialty` DISABLE KEYS */;
INSERT INTO `specialty` VALUES (1,'Applied Mathematics','Department of applied mathematics'),(2,'Computer Science','Departmant of computer science'),(3,'Design','Design');
/*!40000 ALTER TABLE `specialty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id_student` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `surname` varchar(45) DEFAULT NULL,
  `book_number` int(11) DEFAULT NULL,
  `telephone` int(11) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `birthday_data` date DEFAULT NULL,
  `address_id` int(11) DEFAULT NULL,
  `subject_id` int(11) DEFAULT NULL,
  `specialty_id` int(11) DEFAULT NULL,
  `id_parents` int(11) DEFAULT NULL,
  `id_exam` int(11) DEFAULT NULL,
  `group_name` varchar(45) DEFAULT NULL,
  `learning_form` char(1) DEFAULT NULL,
  `dept_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_student`),
  KEY `id_address_idx` (`address_id`),
  KEY `id_parents_idx` (`id_parents`),
  KEY `id_subject_idx` (`subject_id`),
  KEY `id_specialty_idx` (`specialty_id`),
  KEY `id_exam_idx` (`id_exam`),
  KEY `id_dept_idx` (`dept_id`),
  CONSTRAINT `id_address_student` FOREIGN KEY (`address_id`) REFERENCES `address` (`id_address`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `id_dept_student` FOREIGN KEY (`dept_id`) REFERENCES `department` (`id_dept`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `id_exam_student` FOREIGN KEY (`id_exam`) REFERENCES `exam` (`id_exam`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `id_parents_student` FOREIGN KEY (`id_parents`) REFERENCES `parents` (`id_parents`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `id_specialty_student` FOREIGN KEY (`specialty_id`) REFERENCES `specialty` (`id_speciality`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `id_subject_student` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id_subject`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'1','1',1,1,'1','1970-01-01',1,1,1,1,1,'1','1',1),(2,'2','2',2,2,'2','1970-01-01',2,2,2,2,2,'2','2',1),(3,'3','3',3,3,'3','1970-01-01',3,3,3,3,3,'3','3',1);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject` (
  `id_subject` int(11) NOT NULL AUTO_INCREMENT,
  `subject_name` varchar(45) DEFAULT NULL,
  `subject_describe` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_subject`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,'MT','Mathematics'),(2,'CS','Computer'),(3,'MS','Mobile'),(4,'TS','Testing'),(5,'MM','Machinery');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'university'
--

--
-- Dumping routines for database 'university'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-04  0:52:16
