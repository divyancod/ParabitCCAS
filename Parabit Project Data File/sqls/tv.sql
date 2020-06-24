-- phpMyAdmin SQL Dump
-- version 2.11.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 09, 2020 at 05:01 AM
-- Server version: 5.0.45
-- PHP Version: 5.2.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Database: `parabitccasbharat`
--

-- --------------------------------------------------------

--
-- Table structure for table `tv`
--

CREATE TABLE IF NOT EXISTS `tv` (
  `SNo` int(2) default NULL,
  `TVTypes` varchar(20) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tv`
--

INSERT INTO `tv` (`SNo`, `TVTypes`) VALUES
(2, 'LED'),
(1, 'LCD'),
(3, 'Plasma'),
(4, 'OLED'),
(5, 'QLED'),
(6, 'DLP'),
(7, 'DLD'),
(8, 'MICRO LED'),
(9, '3DTV');
