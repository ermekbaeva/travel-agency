-- MySQL dump 10.13  Distrib 8.0.26, for Linux (x86_64)
--
-- Host: localhost    Database: travelagency
-- ------------------------------------------------------
-- Server version	8.0.26-0ubuntu0.20.04.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clients` (
  `Id_client` int NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(20) DEFAULT NULL,
  `LastName` varchar(20) DEFAULT NULL,
  `Email` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`Id_client`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` VALUES (23,'MARIA','IVANOVA','IVANOVA@GMAIL.COM',NULL),(24,'nina','smith','smith@gmail.com',NULL),(25,'meerim','ermekbaeva','meerim@gmail.com','1234');
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservation` (
  `Id_reservation` int NOT NULL AUTO_INCREMENT,
  `Id_client` int DEFAULT NULL,
  `Id_tour` int DEFAULT NULL,
  `client_email` varchar(30) DEFAULT NULL,
  `tour_country` varchar(30) DEFAULT NULL,
  `price` int DEFAULT NULL,
  PRIMARY KEY (`Id_reservation`),
  KEY `Id_client` (`Id_client`),
  KEY `Id_tour` (`Id_tour`),
  CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`Id_client`) REFERENCES `clients` (`Id_client`) ON DELETE SET NULL,
  CONSTRAINT `reservation_ibfk_2` FOREIGN KEY (`Id_tour`) REFERENCES `tours` (`Id_tour`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` VALUES (1,25,2,'meerim@gmail.com','Egypt',NULL),(2,25,15,'meerim@gmail.com','Egypt',NULL),(3,25,16,'meerim@gmail.com','Egypt',NULL),(4,25,5,'meerim@gmail.com','Spain',NULL),(5,25,14,'meerim@gmail.com','Spain',64800),(7,25,6,'meerim@gmail.com','Greece',55000);
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tours`
--

DROP TABLE IF EXISTS `tours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tours` (
  `Id_tour` int NOT NULL AUTO_INCREMENT,
  `Country` varchar(20) DEFAULT NULL,
  `Price` decimal(8,2) DEFAULT NULL,
  `Departure_date` date DEFAULT NULL,
  `Arrival_date` date DEFAULT NULL,
  `Hotel_name` varchar(20) DEFAULT NULL,
  `Free_places` int DEFAULT NULL,
  PRIMARY KEY (`Id_tour`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tours`
--

LOCK TABLES `tours` WRITE;
/*!40000 ALTER TABLE `tours` DISABLE KEYS */;
INSERT INTO `tours` VALUES (1,'Turkey',32000.00,'2021-08-31','2021-10-01','Palace',20),(2,'Egypt',60000.00,'2021-09-05','2021-10-03','Amar Sina',33),(3,'Turkey',32000.00,'2021-08-31','2021-10-01','Palace',20),(4,'Italy',50000.00,'2021-09-06','2021-10-02','Hilton Sorrento',41),(5,'Spain',58000.00,'2021-10-13','2021-11-08','Plaza',52),(6,'Greece',55000.00,'2021-09-22','2021-10-13','Limneon Resort',30),(7,'Greece',52500.00,'2021-09-22','2021-10-13','Greece Resort',30),(8,'Turkey',43500.00,'2021-09-22','2021-10-13','Turkey Resort',23),(9,'Turkey',41300.00,'2021-09-22','2021-10-13','Turkey Resort',10),(10,'Italy',59300.00,'2021-09-22','2021-10-13','Italy Resort',15),(11,'Italy',60300.00,'2021-09-13','2021-10-25','Glossy Resort',35),(12,'Italy',65800.00,'2021-09-12','2021-10-15','Posh Resort',14),(13,'Spain',75800.00,'2021-09-10','2021-10-04','Spain Resort',30),(14,'Spain',64800.00,'2021-09-18','2021-10-01','Lux Resort',20),(15,'Egypt',80800.00,'2021-09-15','2021-10-20','Egypt Resort',25),(16,'Egypt',58800.00,'2021-09-28','2021-10-29','Egypt Resort',17);
/*!40000 ALTER TABLE `tours` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-06 11:55:20
