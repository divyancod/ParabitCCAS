-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Mar 31, 2020 at 07:34 PM
-- Server version: 5.7.26
-- PHP Version: 7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `parabitproject`
--

-- --------------------------------------------------------

--
-- Table structure for table `pbtaadhar`
--

DROP TABLE IF EXISTS `pbtaadhar`;
CREATE TABLE IF NOT EXISTS `pbtaadhar` (
  `ASNo` int(11) DEFAULT NULL,
  `ANo` varchar(12) DEFAULT NULL,
  `FstName` varchar(20) DEFAULT NULL,
  `MidName` varchar(20) DEFAULT NULL,
  `LstName` varchar(20) DEFAULT NULL,
  `Gender` char(1) DEFAULT NULL,
  `MobNo` varchar(10) DEFAULT NULL,
  `FhAadNo` varchar(12) DEFAULT NULL,
  `HusAdhrNo` varchar(12) DEFAULT NULL,
  `MothAdhrNo` varchar(12) DEFAULT NULL,
  `WifAadNo` varchar(12) DEFAULT NULL,
  `HNo` varchar(20) DEFAULT NULL,
  `SRL` varchar(60) DEFAULT NULL,
  `LMrk` varchar(60) DEFAULT NULL,
  `ALS` varchar(60) DEFAULT NULL,
  `VTC` varchar(60) DEFAULT NULL,
  `PO` varchar(60) DEFAULT NULL,
  `Tehsil` varchar(60) DEFAULT NULL,
  `District` varchar(20) DEFAULT NULL,
  `State` varchar(20) DEFAULT NULL,
  `PIN` int(8) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `Email` varchar(60) DEFAULT NULL,
  `Note` varchar(20) DEFAULT NULL,
  `Comment` varchar(20) DEFAULT NULL,
  `Status` char(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pbtaadhar`
--

COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
