-- phpMyAdmin SQL Dump
-- version 2.11.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 08, 2020 at 02:03 PM
-- Server version: 5.0.45
-- PHP Version: 5.2.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Database: `parabitccasbharat`
--

-- --------------------------------------------------------

--
-- Table structure for table `tvsig`
--

CREATE TABLE IF NOT EXISTS `tvsig` (
  `SNo` int(1) default NULL,
  `TypeTvSig` varchar(20) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tvsig`
--

INSERT INTO `tvsig` (`SNo`, `TypeTvSig`) VALUES
(1, 'TataSky'),
(2, 'DishTV'),
(3, 'AirtelDigitalTV'),
(4, 'VideoconD2H'),
(5, 'IndependentTV'),
(6, 'RelianceDigitalTV'),
(7, 'SunDirect'),
(8, 'DDFreeDish');
