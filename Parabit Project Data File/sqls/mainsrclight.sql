-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 09, 2020 at 05:03 AM
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
-- Table structure for table `mainsrclight`
--

DROP TABLE IF EXISTS `mainsrclight`;
CREATE TABLE IF NOT EXISTS `mainsrclight` (
  `Sno` int(1) DEFAULT NULL,
  `Typeofelectricity` varchar(30) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mainsrclight`
--

INSERT INTO `mainsrclight` (`Sno`, `Typeofelectricity`) VALUES
(1, 'Solar Panels'),
(2, 'Wind turbines'),
(3, 'Running water'),
(4, 'Portable generator'),
(5, 'Inverter generator'),
(6, 'Standby generator'),
(7, 'Industrial generator'),
(8, 'electricity');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
