-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 09, 2020 at 04:21 AM
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
-- Table structure for table `cookfuel`
--

CREATE TABLE IF NOT EXISTS `cookfuel` (
  `SNo` int(2) DEFAULT NULL,
  `MainFuelUsedForKithen` varchar(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cookfuel`
--

INSERT INTO `cookfuel` (`SNo`, `MainFuelUsedForKithen`) VALUES
(1, 'Firwood'),
(2, 'Crop Residue'),
(3, 'Cowdung Cake'),
(4, 'Coal/Lignite/Characo'),
(5, 'Kerosene'),
(6, 'LPG/PNG'),
(7, 'EInduction'),
(8, 'Emicrowave Owen'),
(9, 'Bio-Gas'),
(10, 'Solar'),
(11, 'AnyOther');
