-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 02, 2020 at 04:13 AM
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
-- Database: `parabitccasbharat`
--

-- --------------------------------------------------------

--
-- Table structure for table `pbtcensus_hh`
--

DROP TABLE IF EXISTS `pbtcensus_hh`;
CREATE TABLE IF NOT EXISTS `pbtcensus_hh` (
  `SNo` int(10) DEFAULT NULL,
  `UCID` int(10) DEFAULT NULL,
  `FSNo` int(10) DEFAULT NULL,
  `StUt` varchar(20) DEFAULT NULL,
  `Dist` varchar(20) DEFAULT NULL,
  `Tehsil` varchar(20) DEFAULT NULL,
  `TownVillage` varchar(20) DEFAULT NULL,
  `WardNo` varchar(10) DEFAULT NULL,
  `HNoAdd` varchar(100) DEFAULT NULL,
  `PinCode` varchar(6) DEFAULT NULL,
  `ENumNo` varchar(10) DEFAULT NULL,
  `RCardNo` varchar(10) DEFAULT NULL,
  `RCardType` varchar(9) DEFAULT NULL COMMENT 'APL  BPL AAY Annapurna',
  `UID` varchar(12) DEFAULT NULL,
  `BirthCertNo` varchar(15) DEFAULT NULL,
  `MarrCertNo` varchar(15) DEFAULT NULL,
  `PoliceVerNo` varchar(20) DEFAULT NULL,
  `SSSMID` varchar(9) DEFAULT NULL,
  `Name` varchar(30) DEFAULT NULL,
  `RelToHead` varchar(20) DEFAULT NULL,
  `HeadUID` varchar(12) DEFAULT NULL,
  `HeadRegMobNo` varchar(10) DEFAULT NULL,
  `MobNo` varchar(10) DEFAULT NULL,
  `UtillNo` varchar(10) DEFAULT NULL,
  `Email` varchar(40) DEFAULT NULL,
  `Gender` varchar(1) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `Age` int(3) DEFAULT NULL,
  `Wt` int(3) DEFAULT NULL,
  `Ht` float DEFAULT NULL,
  `BMI` float DEFAULT NULL,
  `BGroup` varchar(4) DEFAULT NULL,
  `VID` varchar(10) DEFAULT NULL,
  `Passport` varchar(8) DEFAULT NULL,
  `PanCardNo` varchar(10) DEFAULT NULL,
  `IFSC` varchar(11) DEFAULT NULL,
  `BankAccNo` varchar(18) DEFAULT NULL,
  `NetBank` varchar(1) DEFAULT NULL,
  `MobBank` varchar(1) DEFAULT NULL,
  `PensionID` varchar(12) DEFAULT NULL,
  `Religion` varchar(15) DEFAULT NULL,
  `Community` varchar(15) DEFAULT NULL,
  `Category` varchar(15) DEFAULT NULL,
  `Cast` varchar(15) DEFAULT NULL,
  `MarStatus` varchar(20) DEFAULT NULL,
  `AproMarriageAge` varchar(3) DEFAULT NULL,
  `PWD` varchar(1) DEFAULT NULL,
  `PWDID` varchar(25) DEFAULT NULL,
  `MTongue` varchar(50) DEFAULT NULL,
  `RWLang` varchar(50) DEFAULT NULL,
  `HomeLang` varchar(50) DEFAULT NULL,
  `LitStatus` varchar(1) DEFAULT NULL,
  `CEduStatus` varchar(20) DEFAULT NULL,
  `CInstNmCity` varchar(100) DEFAULT NULL,
  `CInstType` varchar(15) DEFAULT NULL,
  `TechDeg` varchar(30) DEFAULT NULL,
  `NonTechDeg` varchar(30) DEFAULT NULL,
  `NCCNSS` varchar(1) DEFAULT NULL,
  `JobSeek` varchar(1) DEFAULT NULL,
  `CWStatus` varchar(1) DEFAULT NULL,
  `CWCatg` varchar(3) DEFAULT NULL COMMENT 'Non Eco Act, Eco Act, Both'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
