-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 09, 2020 at 06:00 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 5.6.40

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
-- Table structure for table `pc`
--

CREATE TABLE `pc` (
  `SNo` int(2) DEFAULT NULL,
  `PCType` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pc`
--

INSERT INTO `pc` (`SNo`, `PCType`) VALUES
(1, 'Laptop'),
(2, 'Desktop'),
(3, 'Tablet'),
(4, 'Pocket PC'),
(5, 'Utra Mobile PC'),
(6, 'Laptop,Desktop'),
(7, 'Laptop,Tablet'),
(8, 'Laptop,PocketPC'),
(9, 'Laptop,Ultra mobile PC'),
(10, 'Desktop,Tablet'),
(11, 'Desktop,PocketPC'),
(12, 'Desktop,Ultra Mobile PC'),
(13, 'Tablet,Ultra Mobile PC'),
(14, 'Tablet,Pocket PC'),
(15, 'Pocket PC,Ultra Mobile PC'),
(16, 'Laptop,Desktop,Tablet'),
(17, 'Laptop,Desktop,PocketPC'),
(18, 'Laptop,Desktop,Ultr Mobile PC'),
(19, 'Laptop,Tablet,PocketPC'),
(20, 'Laptop,Tablet,Ultra Mobile PC'),
(21, 'Laptop,PocketPC,Ultra Mobile PC'),
(22, 'Desktop,Tablet,PocketPC'),
(23, 'Desktop,Tablet,Ultra Mobile PC'),
(24, 'Desktop,PocketPC,Ultra Mobile PC'),
(25, 'Tablet,PocketPC,Ultra Mobile PC'),
(26, 'Laptop,Desktop,Tablet,PocketPC'),
(27, 'Laptop,Desktop,Tablet,Ultra Mobile PC'),
(28, 'Laptop,Tablet,PocketPC,Ultra Mobile PC,'),
(29, 'Laptop,Desktop,PocketPC,Ultra Mobile PC'),
(30, 'Desktop,Tablet,PocketPC,Ultra Mobile PC'),
(31, 'Laptop,Desktop,Tablet,PocketPC,Ultra Mobile PC');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
