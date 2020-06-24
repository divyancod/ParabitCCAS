-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 08, 2020 at 04:46 AM
-- Server version: 5.1.53
-- PHP Version: 5.3.4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `parabitccasbharat`
--

-- --------------------------------------------------------

--
-- Table structure for table `kicthen`
--

CREATE TABLE IF NOT EXISTS `kicthen` (
  `SNo` int(1) DEFAULT NULL,
  `AvailibiltyofKitchen&LPG/PNGConntion` varchar(40) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kicthen`
--

INSERT INTO `kicthen` (`SNo`, `AvailibiltyofKitchen&LPG/PNGConntion`) VALUES
(1, 'Cooking In Kitchen'),
(2, 'Cooking Inside House But Not In Kitchen'),
(3, 'Cooking In Open/Outside House'),
(4, 'No Cooking');
