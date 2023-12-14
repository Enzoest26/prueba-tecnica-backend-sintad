CREATE DATABASE  IF NOT EXISTS `prueba_tecnica_sintad` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `prueba_tecnica_sintad`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: prueba_tecnica_sintad
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `tb_entidad`
--

DROP TABLE IF EXISTS `tb_entidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_entidad` (
  `id_entidad` bigint NOT NULL AUTO_INCREMENT,
  `id_tipo_documento` int NOT NULL,
  `nro_documento` varchar(25) NOT NULL,
  `razon_social` varchar(100) NOT NULL,
  `nombre_comercial` varchar(100) DEFAULT NULL,
  `id_tipo_contribuyente` int DEFAULT NULL,
  `direccion` varchar(250) DEFAULT NULL,
  `telefono` varchar(50) DEFAULT NULL,
  `estado` int DEFAULT NULL,
  PRIMARY KEY (`id_entidad`),
  UNIQUE KEY `nro_documento_UNIQUE` (`nro_documento`),
  KEY `fk_tb_entidad_tb_tipo_documento1_idx` (`id_tipo_documento`),
  KEY `fk_tb_entidad_tb_tipo_contribuyente1_idx` (`id_tipo_contribuyente`),
  CONSTRAINT `tb_entidad_ibfk_2` FOREIGN KEY (`id_tipo_contribuyente`) REFERENCES `tb_tipo_contribuyente` (`id_tipo_contribuyente`),
  CONSTRAINT `tb_entidad_ibfk_3` FOREIGN KEY (`id_tipo_documento`) REFERENCES `tb_tipo_documento` (`id_tipo_documento`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_entidad`
--

LOCK TABLES `tb_entidad` WRITE;
/*!40000 ALTER TABLE `tb_entidad` DISABLE KEYS */;
INSERT INTO `tb_entidad` VALUES (1,3,'20505327552','SYL S.A.C','SYL CARGO NOMBRE COMERCIAL',1,'Jr. Comandante Jimenez Nro. 166 Int. a (entre Cuadra 7 y 8 Javier Padro Oeste)','79845612',1),(2,3,'20543844838','PUNTUAL EXPRESS S.A.C.','',1,'MZA. F LOTE. 29 AS.RSD.MONTECARLO II LIMA - LIMA - SAN MARTIN DE PORRE','',1),(3,3,'10410192999','ALVAREZ MACHUCA RENZO GUSTAVO','',3,'AV. LOS ALISOS MZA. G LOTE. 05 ASC. LA ALBORADA DE OQUENDO III ETAPA (CRUCE PTE OQUENDO CON AV.NESTOR GAMBETTA) PROV. CONST. DEL CALLAO - PROV. CONST. DEL CALLAO - CALLAO','',1),(4,3,'20600131037','CARNICOS MAFER S.A.C.','',2,'CAL.EL UNIVERSO NRO. 327 URB. LA CAMPIÑA ZONA CINCO (ALTURA ','',1),(5,3,'20556528218','SUMAQUINARIA S.A.C.','',2,'AV. M.SUCRE NRO. 455 DPTO. 603 LIMA - LIMA - MAGDALENA DEL MAR','',1),(6,3,'20545412528','OASIS FOODS S.A.C.','',2,'CAL. FRANCISCO MASIAS NRO. 370 URB. SAN EUGENIO (PISO 7) LIM','',1),(7,3,'20510620195','INVERSIONES PRO3 SAC','',2,'AV. AUTOPIDTA RAMIRO PRIALE LOTE. 02 A.V. PROP HUERTOS DE HU','',1),(8,3,'20498383361','REPUESTOS DAVID DIESEL E.I.R.L.','',2,'CAR.VIA EVITAMIENTO MZA. 857 LOTE. 7 SEC. IRRIGACION EL CURAL 1 AREQUIPA - AREQUIPA - CERRO COLORADO','',1),(9,6,'CNAH00003','ANHUI HAYVO PROTECTIVE PRODUCT MANUFACTURING CO.,LTD','',4,'173 FENGLE AVENUE,ECNOMIC DEVELOPMENT ZONE,QUANJIAO COUNTY','',1);
/*!40000 ALTER TABLE `tb_entidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipo_contribuyente`
--

DROP TABLE IF EXISTS `tb_tipo_contribuyente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_tipo_contribuyente` (
  `id_tipo_contribuyente` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `estado` int DEFAULT NULL,
  PRIMARY KEY (`id_tipo_contribuyente`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipo_contribuyente`
--

LOCK TABLES `tb_tipo_contribuyente` WRITE;
/*!40000 ALTER TABLE `tb_tipo_contribuyente` DISABLE KEYS */;
INSERT INTO `tb_tipo_contribuyente` VALUES (1,'Natural Sin Negocio',1),(2,'Juridica',1),(3,'Natural Con Negocio',1),(4,'No Domiciliado',1);
/*!40000 ALTER TABLE `tb_tipo_contribuyente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipo_documento`
--

DROP TABLE IF EXISTS `tb_tipo_documento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_tipo_documento` (
  `id_tipo_documento` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(20) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `estado` int DEFAULT NULL,
  PRIMARY KEY (`id_tipo_documento`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipo_documento`
--

LOCK TABLES `tb_tipo_documento` WRITE;
/*!40000 ALTER TABLE `tb_tipo_documento` DISABLE KEYS */;
INSERT INTO `tb_tipo_documento` VALUES (1,'4','CARNET DE EXTRANJERIA','CARNET DE EXTRANJERIA',1),(2,'7','PASAPORTE','PASAPORTE',1),(3,'11','PARTIDA DE NACIMIENTO - IDENTIDAD','PARTIDA DE NACIMIENTO - IDENTIDAD',1),(4,'99','OTROS','OTROS',1),(5,'6','RUC','REGISTRO UNICO DEL CONTRIBUYENTE',1),(6,'1','DNI','DOCUMENTO NACIONAL DE IDENTIDAD 2',0);
/*!40000 ALTER TABLE `tb_tipo_documento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'prueba_tecnica_sintad'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-14 11:30:13
