-- phpMyAdmin SQL Dump
-- version 2.11.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 08, 2020 at 09:12 AM
-- Server version: 5.0.45
-- PHP Version: 5.2.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Database: `parabitccasbharat`
--

-- --------------------------------------------------------

--
-- Table structure for table `CoolingFac`
--

CREATE TABLE IF NOT EXISTS `coolingfac` (
  `SNo` int(2) default NULL,
  `Type` varchar(50) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `CoolingFac`
--

INSERT INTO `CoolingFac` (`SNo`, `Type`) VALUES
(1, 'Fan'),
(2, 'Cooler'),
(3, 'Air Conditioner/AC'),
(4, 'Fan and Cooler'),
(5, 'Cooler and AC'),
(6, 'Fan and AC'),
(7, 'Fan and Cooler and AC'),
(8, 'Heat Pump'),
(9, 'Indirect Direct Evaporating Cooling System (IDEC)'),
(10, 'Cooling Towers'),
(11, 'Air Cooling Unit'),
(12, 'Roof Cooling'),
(13, 'Oil Cooling'),
(14, 'Steel Process Cooling'),
(15, 'Other');
