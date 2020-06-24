-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 19, 2020 at 02:52 PM
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
-- Table structure for table `pbtemployeetable`
--

DROP TABLE IF EXISTS `pbtemployeetable`;
CREATE TABLE IF NOT EXISTS `pbtemployeetable` (
  `SNo` int(8) DEFAULT NULL,
  `CEID` varchar(15) DEFAULT NULL,
  `CRepEmpID` varchar(15) DEFAULT NULL,
  `GEID` varchar(15) DEFAULT NULL,
  `EmpANo` varchar(12) DEFAULT NULL,
  `EmpName` varchar(30) DEFAULT NULL,
  `Grade` int(1) DEFAULT NULL,
  `EmpDesig` varchar(30) DEFAULT NULL,
  `WorkExp` varchar(200) DEFAULT NULL,
  `WorkExpCensus` varchar(200) DEFAULT NULL COMMENT 'post-year',
  `EmpMob` varchar(12) DEFAULT NULL,
  `EmpOffMob` varchar(12) DEFAULT NULL,
  `Email` varchar(30) DEFAULT NULL,
  `UserID` varchar(15) DEFAULT NULL,
  `Pass` varchar(10) DEFAULT NULL,
  `PIN` varchar(10) DEFAULT NULL,
  `AreaCity` varchar(50) DEFAULT NULL,
  `AreaDist` varchar(50) DEFAULT NULL,
  `AreaState` varchar(50) DEFAULT NULL,
  `ControlCentreNo` varchar(15) DEFAULT NULL,
  `ComputerNo` varchar(10) DEFAULT NULL,
  `EmpPhoto` blob,
  `OTP` varchar(4) NOT NULL,
  `Note` varchar(70) DEFAULT NULL,
  `PerCommt` varchar(70) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pbtemployeetable`
--

INSERT INTO `pbtemployeetable` (`SNo`, `CEID`, `CRepEmpID`, `GEID`, `EmpANo`, `EmpName`, `Grade`, `EmpDesig`, `WorkExp`, `WorkExpCensus`, `EmpMob`, `EmpOffMob`, `Email`, `UserID`, `Pass`, `PIN`, `AreaCity`, `AreaDist`, `AreaState`, `ControlCentreNo`, `ComputerNo`, `EmpPhoto`, `OTP`, `Note`, `PerCommt`, `Status`) VALUES
(1, '11603', '0', '100720', '100716588054', 'Rajat Chauhan', 2, 'Director of Census Operation', 'Senior Manager-3', 'Principle Charge Officer-2011', '9999994698', '9999962856', 'RajatChauhan@gmail.com', 'D11603', 'hello@123', '180001', NULL, NULL, NULL, '10101', '100125', '', '1601', '0', '0', '0'),
(2, '11604', '0', '100721', '100682706546', 'Sanjhan Mahajan', 2, 'Director of Census Operation', 'Manager-4', 'No', '9999929637', '9999982228', 'SanjhanMahajan@gmail.com', 'D11604', 'hello@123', '180001', NULL, NULL, NULL, '10102', '100126', '', '1601', '0', '0', '0'),
(3, '11605', '0', '100722', '100977594033', 'Ram Kumar', 2, 'Director of Census Operation', 'Senior Manager-5', 'Charge Officer-2011', '9999928640', '9999954565', 'RamKumar@gmail.com', 'D11605', 'hello@123', '180001', NULL, NULL, NULL, '10103', '100127', '', '1601', '0', '0', '0'),
(4, '11606', '0', '100723', '100525382291', 'Sanjay Sinha', 2, 'Director of Census Operation', 'Asst. Manager-5', 'Principle Charge Officer-2011', '9999959251', '9999996258', 'SanjaySinha@gmail.com', 'D11606', 'hello@123', '180001', NULL, NULL, NULL, '10104', '100128', '', '1601', '0', '0', '0'),
(5, '11607', '0', '100724', '100603791261', 'Rakesh Gaur', 2, 'Director of Census Operation', 'Senior Manager-2', 'Charge Officer-2011', '9999922861', '9999935268', 'RakeshGaur@gmail.com', 'D11607', 'hello@123', '180002', NULL, NULL, NULL, '10105', '100129', '', '1601', '0', '0', '0'),
(6, '11608', '0', '100725', '100486190208', 'Md.Irfan', 2, 'Director of Census Operation', 'Senior Manager-2', 'Principle Charge Officer-2011', '9999939679', '9999901641', 'Md.Irfan@gmail.com', 'D11608', 'hello@123', '180004', NULL, NULL, NULL, '10106', '100130', '', '1601', '0', '0', '0'),
(7, '11609', '0', '100726', '100099230040', 'Md.Kaif Khan', 2, 'Director of Census Operation', 'Senior Manager-1,Manager-5', 'No', '9999969210', '9999964288', 'Md.KaifKhan@gmail.com', 'D11609', 'hello@123', '180005', NULL, NULL, NULL, '10107', '100131', '', '1601', '0', '0', '0'),
(8, '11610', '0', '100727', '100507036838', 'Sanjana Sinha', 2, 'Director of Census Operation', 'Senior Manager-2,Asst Manager-2', 'Charge Officer-2011', '9999902640', '9999915055', 'SanjanaSinha@gmail.com', 'D11610', 'hello@123', '180001', NULL, NULL, NULL, '10108', '100132', '', '1601', '0', '0', '0'),
(9, '11611', '0', '100728', '100615054973', 'Rahul Kumar Verm', 2, 'Director of Census Operation', 'Asst.Manager-5', 'No', '9999951391', '9999931325', 'RahulKumarVerm@gmail.com', 'D11611', 'hello@123', '180002', NULL, NULL, NULL, '10109', '100133', '', '1601', '0', '0', '0'),
(10, '11612', '0', '100729', '100257695020', 'Ram Mohan Prasad', 2, 'Director of Census Operation', 'Manager-10', 'Charge Officer-2011', '9999976513', '9999940807', 'RamMohanPrasad@gmail.com', 'D11612', 'hello@123', '180009', NULL, NULL, NULL, '10110', '100134', '', '1601', '0', '0', '0'),
(11, '11613', '0', '100730', '100757082215', 'M.Nawaz', 2, 'Director of Census Operation', 'Manager-2,Clerk-10', 'Principle Charge Officer-2011', '9999929363', '9999945839', 'M.Nawaz@gmail.com', 'D11613', 'hello@123', '180002', NULL, NULL, NULL, '10111', '100135', '', '1601', '0', '0', '0'),
(12, '11614', '0', '100731', '100896763491', 'Alia Bhatt', 2, 'Director of Census Operation', 'Senior Manager-5,Manager-8', 'Charge Officer-2011', '9999966807', '9999916936', 'AliaBhatt@gmail.com', 'D11614', 'hello@123', '180006', NULL, NULL, NULL, '10112', '100136', '', '1601', '0', '0', '0'),
(13, '11615', '0', '100732', '100067642210', 'Kriti Sinha', 2, 'Director of Census Operation', 'Senior Manager-0.5,Manager-9', 'No', '9999946087', '9999982660', 'KritiSinha@gmail.com', 'D11615', 'hello@123', '180005', NULL, NULL, NULL, '10113', '100137', '', '1601', '0', '0', '0'),
(14, '11616', '0', '100733', '100861699852', 'Rakesh Dubey', 2, 'Director of Census Operation', 'Senior Clerk-15', 'No', '9999918974', '9999965894', 'RakeshDubey@gmail.com', 'D11616', 'hello@123', '180005', NULL, NULL, NULL, '10114', '100138', '', '1601', '0', '0', '0'),
(15, '11617', '0', '100734', '100201376119', 'Purshotam Kumar', 2, 'Director of Census Operation', 'Manager-1,Asst.Manager-5', 'No', '9999990743', '9999948279', 'PurshotamKumar@gmail.com', 'D11617', 'hello@123', '180007', NULL, NULL, NULL, '10115', '100139', '', '1601', '0', '0', '0'),
(16, '11618', '0', '100735', '100604046629', 'Abhishek Kumar', 2, 'Director of Census Operation', 'Senior Manager-5', 'Principle Charge Officer-2011', '9999975939', '9999948677', 'AbhishekKumar@gmail.com', 'D11618', 'hello@123', '180002', NULL, NULL, NULL, '10116', '100140', '', '1601', '0', '0', '0'),
(17, '11619', '0', '100736', '100789843685', 'Rajv Ranjan', 2, 'Director of Census Operation', 'Head Clerk-9', 'Principle Charge Officer-2011', '9999953671', '9999933457', 'RajvRanjan@gmail.com', 'D11619', 'hello@123', '180001', NULL, NULL, NULL, '10117', '100141', '', '1601', '0', '0', '0'),
(18, '11620', '0', '100737', '100551021206', 'Sumit Kumar', 2, 'Director of Census Operation', 'Senior Manager-2', 'Principle Charge Officer-2011', '9999979673', '9999996378', 'SumitKumar@gmail.com', 'D11620', 'hello@123', '180009', NULL, NULL, NULL, '10118', '100142', '', '1601', '0', '0', '0'),
(19, '11621', '0', '100738', '100960894516', 'Deepansh Kumar', 2, 'Director of Census Operation', 'Senior Manager-2,Manager-5,Clerk-3', 'Charge Officer-2011', '9999958970', '9999970644', 'DeepanshKumar@gmail.com', 'D11621', 'hello@123', '180004', NULL, NULL, NULL, '10119', '100143', '', '1601', '0', '0', '0'),
(20, '11622', '0', '100739', '100158103860', 'Md.Faizan Khan', 2, 'Director of Census Operation', 'Senior Manager-5', 'Charge Officer-2011', '9999924343', '9999999501', 'Md.FaizanKhan@gmail.com', 'D11622', 'hello@123', '180004', NULL, NULL, NULL, '10120', '100144', '', '1601', '0', '0', '0'),
(21, '11623', '0', '100740', '100401358901', 'Md.Asif Alam', 2, 'Director of Census Operation', 'Senior Manager-1,Manager-5', 'No', '9999958819', '9999988164', 'Md.AsifAlam@gmail.com', 'D11623', 'hello@123', '180003', NULL, NULL, NULL, '10121', '100145', '', '1601', '0', '0', '0'),
(22, '11624', '0', '100741', '100969124100', 'Kumar Prakash', 2, 'Director of Census Operation', 'Senior Manager-0.5,Asst.Manager-10', 'No', '9999992983', '9999943376', 'KumarPrakash@gmail.com', 'D11624', 'hello@123', '180002', NULL, NULL, NULL, '10122', '100146', '', '1601', '0', '0', '0'),
(23, '11625', '0', '100742', '100294704903', 'Rishi Narayan', 2, 'Director of Census Operation', 'Manager-12', 'Principle Charge Officer-2011', '9999990167', '9999917670', 'RishiNarayan@gmail.com', 'D11625', 'hello@123', '180003', NULL, NULL, NULL, '10123', '100147', '', '1601', '0', '0', '0'),
(24, '11626', '0', '100743', '100772648055', 'Md.Iqubal', 2, 'Director of Census Operation', 'Manager-2,Clerk-2', 'Charge Officer-2011', '9999964629', '9999948641', 'Md.Iqubal@gmail.com', 'D11626', 'hello@123', '180009', NULL, NULL, NULL, '10124', '100148', '', '1601', '0', '0', '0'),
(25, '11627', '0', '100730', '101097588472', 'R.P. Yadav', 2, 'Director of Census Operation', 'Manager-5', 'Charge Officer -2011,Charge Officer-2001', '9090322043', '9090743064', 'R.P.Yadav@gmail.com', 'D11627', 'hello@123', '180002', NULL, NULL, NULL, '10101', '100151', '', '1601', '0', '0', '0'),
(26, '11628', '0', '100731', '101012075715', 'Aryan Kumar', 2, 'Director of Census Operation', 'Senior Manager-5,Manager-5', 'Principle Charge Officer-2011', '9090257568', '9090511955', 'AryanKumar@gmail.com', 'D11628', 'hello@123', '180003', NULL, NULL, NULL, '10101', '100152', '', '1601', '0', '0', '0'),
(27, '11629', '0', '100732', '101063604903', 'Reyansh Verma', 2, 'Director of Census Operation', 'Senior Manager-5,Manager-6', 'No', '9090612539', '9090540562', 'ReyanshVerma@gmail.com', 'D11629', 'hello@123', '180004', NULL, NULL, NULL, '10101', '100153', '', '1601', '0', '0', '0'),
(28, '11630', '0', '100733', '101078901861', 'Vivan singh', 2, 'Director of Census Operation', 'Senior Manager-5,Manager-3', 'No', '9090850474', '9090852322', 'Vivansingh@gmail.com', 'D11630', 'hello@123', '180005', NULL, NULL, NULL, '10101', '100154', '', '1601', '0', '0', '0'),
(29, '11631', '0', '100734', '101090126903', 'Krishna Kumar', 2, 'Director of Census Operation', 'Manager-8', 'Charge Officer -2011,Charge Officer-2001', '9090538189', '9090584785', 'KrishnaKumar@gmail.com', 'D11631', 'hello@123', '180006', NULL, NULL, NULL, '10101', '100155', '', '1601', '0', '0', '0'),
(30, '11632', '0', '100735', '101059906981', 'Atharv Ram', 2, 'Director of Census Operation', 'Asst.Manager-5', 'No', '9090332553', '9090604019', 'AtharvRam@gmail.com', 'D11632', 'hello@123', '180007', NULL, NULL, NULL, '10101', '100156', '', '1601', '0', '0', '0'),
(31, '11633', '0', '100736', '101033715237', 'Ayyan singh', 2, 'Director of Census Operation', 'Senior Manager-10', 'No', '9090529934', '9090620762', 'Ayyansingh@gmail.com', 'D11633', 'hello@123', '180008', NULL, NULL, NULL, '10101', '100157', '', '1601', '0', '0', '0'),
(32, '11634', '0', '100737', '101069970249', 'Ishan Khatar', 2, 'Director of Census Operation', 'Asst.Manager-5', 'No', '9090842361', '9090596892', 'IshanKhatar@gmail.com', 'D11634', 'hello@123', '180009', NULL, NULL, NULL, '10101', '100158', '', '1601', '0', '0', '0'),
(33, '11635', '0', '100738', '101073865874', 'Dhruv Rathe', 2, 'Director of Census Operation', 'Manager-4,clerk-4', 'No', '9090639066', '9090632328', 'DhruvRathe@gmail.com', 'D11635', 'hello@123', '180010', NULL, NULL, NULL, '10101', '100159', '', '1601', '0', '0', '0'),
(34, '11636', '0', '100739', '101018183248', 'Rayan Chiudhary', 2, 'Director of Census Operation', 'Manager-3,clerk-5', 'No', '9090905272', '9090764829', 'RayanChiudhary@gmail.com', 'D11636', 'hello@123', '180011', NULL, NULL, NULL, '10101', '100160', '', '1601', '0', '0', '0'),
(35, '11637', '0', '100740', '101084456931', 'Kabir Singh', 2, 'Director of Census Operation', 'Manager-10,clerk-1', 'No', '9090402517', '9090569686', 'KabirSingh@gmail.com', 'D11637', 'hello@123', '180012', NULL, NULL, NULL, '10101', '100161', '', '1601', '0', '0', '0'),
(36, '11638', '0', '100741', '101015213244', 'Md.Abdul', 2, 'Director of Census Operation', 'Senior Manager-5,Asst.Manager-5', 'No', '9090436482', '9090070378', 'Md.Abdul@gmail.com', 'D11638', 'hello@123', '180013', NULL, NULL, NULL, '10101', '100162', '', '1601', '0', '0', '0'),
(37, '11639', '0', '100742', '101018107585', 'Md.Sameer', 2, 'Director of Census Operation', 'Senior Manager-5,Asst.Manager-5', 'Charge Officer -2011,Charge Officer-2001', '9090323269', '9090680877', 'Md.Sameer@gmail.com', 'D11639', 'hello@123', '180001', NULL, NULL, NULL, '10101', '100163', '', '1601', '0', '0', '0'),
(38, '11640', '0', '100743', '101078604214', 'Avi kumar', 2, 'Director of Census Operation', 'Asst.Manager-3', 'Principle Charge Officer-2011', '9090310123', '9090774823', 'Avikumar@gmail.com', 'D11640', 'hello@123', '180009', NULL, NULL, NULL, '10101', '100164', '', '1601', '0', '0', '0'),
(39, '11641', '0', '100744', '101050615612', 'Samar Kumar', 2, 'Director of Census Operation', 'Senior Manager-5', 'No', '9090448456', '9090396379', 'SamarKumar@gmail.com', 'D11641', 'hello@123', '180016', NULL, NULL, NULL, '10101', '100165', '', '1601', '0', '0', '0'),
(40, '11642', '0', '100745', '101029189037', 'Pratyush Srivastava', 2, 'Director of Census Operation', 'Senior Manager-9', 'No', '9090785602', '9090662622', 'PratyushSrivastava@gmail.com', 'D11642', 'hello@123', '180017', NULL, NULL, NULL, '10101', '100166', '', '1601', '0', '0', '0'),
(41, '11643', '0', '100746', '101055439986', 'Tejas Prakash', 2, 'Director of Census Operation', 'Senior Manager-12', 'No', '9090862227', '9090244485', 'TejasPrakash@gmail.com', 'D11643', 'hello@123', '180018', NULL, NULL, NULL, '10101', '100167', '', '1601', '0', '0', '0'),
(42, '11644', '0', '100747', '101022266426', 'Rohan Kumar', 2, 'Director of Census Operation', 'Senior Manager-1,Manager-1,Asst.Manager-5', 'No', '9090090597', '9090128386', 'RohanKumar@gmail.com', 'D11644', 'hello@123', '180019', NULL, NULL, NULL, '10101', '100168', '', '1601', '0', '0', '0'),
(43, '11645', '0', '100748', '101072776358', 'Daksh Singh', 2, 'Director of Census Operation', 'Manager-2,Clerk-5', 'No', '9090514446', '9090172809', 'DakshSingh@gmail.com', 'D11645', 'hello@123', '180020', NULL, NULL, NULL, '10101', '100169', '', '1601', '0', '0', '0'),
(44, '11646', '0', '100749', '101043082297', 'Manan singh', 2, 'Director of Census Operation', 'Manager-1,Clerk-7', 'No', '9090175756', '9090747478', 'Manansingh@gmail.com', 'D11646', 'hello@123', '180021', NULL, NULL, NULL, '10101', '100170', '', '1601', '0', '0', '0'),
(45, '11647', '0', '100750', '101057245117', 'Pranav Ram', 2, 'Director of Census Operation', 'Senior Manager-5,Asst.Manager-5', 'Charge Officer -2011,Charge Officer-2001', '9090159984', '9090746760', 'PranavRam@gmail.com', 'D11647', 'hello@123', '180022', NULL, NULL, NULL, '10101', '100171', '', '1601', '0', '0', '0'),
(46, '11648', '0', '100751', '101007901668', 'Abhiram kumar', 2, 'Director of Census Operation', 'Asst.Manager-5', 'No', '9090129926', '9090104046', 'Abhiramkumar@gmail.com', 'D11648', 'hello@123', '180007', NULL, NULL, NULL, '10101', '100172', '', '1601', '0', '0', '0'),
(47, '11649', '0', '100752', '101058195212', 'Samarth Sinha', 2, 'Director of Census Operation', 'Asst.Manager-2', 'No', '9090282647', '9090559155', 'SamarthSinha@gmail.com', 'D11649', 'hello@123', '180001', NULL, NULL, NULL, '10101', '100173', '', '1601', '0', '0', '0'),
(48, '11650', '0', '100753', '101008956335', 'Md.Imran', 2, 'Director of Census Operation', 'Manager-12', 'No', '9090083825', '9090681376', 'Md.Imran@gmail.com', 'D11650', 'hello@123', '180002', NULL, NULL, NULL, '10101', '100174', '', '1601', '0', '0', '0'),
(49, '11651', '0', '100754', '101092902458', 'Md.Khalid Hussen', 2, 'Director of Census Operation', 'Senior Manager-5,Manager-28', 'Principle Charge Officer-2011', '9090323330', '9090804918', 'Md.KhalidHussen@gmail.com', 'D11651', 'hello@123', '180007', NULL, NULL, NULL, '10101', '100175', '', '1601', '0', '0', '0'),
(50, '11652', '0', '100755', '101090992444', 'Potuli', 2, 'Director of Census Operation', 'Manager-8', 'No', '9090409959', '9090854455', 'Potuli@gmail.com', 'D11652', 'hello@123', '180009', NULL, NULL, NULL, '10101', '100176', '', '1601', '0', '0', '0'),
(51, '11653', '0', '100756', '101038863783', 'Shayam Prakash', 2, 'Director of Census Operation', 'Senior Manager-5,Asst.Manager-2', 'Charge Officer -2011,Charge Officer-2001', '9090323962', '9090444805', 'ShayamPrakash@gmail.com', 'D11653', 'hello@123', '180012', NULL, NULL, NULL, '10101', '100177', '', '1601', '0', '0', '0'),
(52, '11654', '0', '100757', '101074791086', 'Saurav Sinha', 2, 'Director of Census Operation', 'Manager-5', 'No', '9090552780', '9090283518', 'SauravSinha@gmail.com', 'D11654', 'hello@123', '180011', NULL, NULL, NULL, '10101', '100178', '', '1601', '0', '0', '0'),
(53, '11655', '0', '100758', '101094940703', 'Hemant Arya', 2, 'Director of Census Operation', 'Manager-3', 'No', '9090007637', '9090831900', 'HemantArya@gmail.com', 'D11655', 'hello@123', '180018', NULL, NULL, NULL, '10101', '100179', '', '1601', '0', '0', '0'),
(54, '11656', '0', '100759', '101044484738', 'Himanshu', 2, 'Director of Census Operation', 'Senior Manager-5,Asst.Manager-5', 'Charge Officer -2011,Charge Officer-2001', '9090823084', '9090187980', 'Himanshu@gmail.com', 'D11656', 'hello@123', '180019', NULL, NULL, NULL, '10101', '100180', '', '1601', '0', '0', '0'),
(0, '11601', 'Home Ministry', '556739', '823778439987', 'Shudhanshu Vaidya', 1, 'Census Commissioner', NULL, NULL, '8147483647', '7147489647', 'SudhansuVaidya@gmail.co', 'Sudhansu93425', 'hello@123', NULL, 'All the cities of India ', 'All the District of India', 'All the State of India', '1001', '5100239009', NULL, '1601', NULL, NULL, '1'),
(55, '11657', '0', '100765', '101035001302', 'Kumar Sanu', 3, 'Priciple Charge Officer', 'Manager-3', 'Charge Officer-2011', '9826366479', '9331677126', 'KumarSanu@gmail.com', 'P11657', 'hello@123', '180001', NULL, NULL, NULL, '20101', '200250', '', '1601', '0', '0', '0'),
(56, '11658', '0', '100766', '101046645708', 'Rajat Kumar Singh', 3, 'Priciple Charge Officer', 'Manager-6,Clerk-5', 'No', '9728479784', '9149139670', 'RajatKumarSingh@gmail.com', 'P11658', 'hello@123', '180001', NULL, NULL, NULL, '20102', '200251', '', '1601', '0', '0', '0'),
(57, '11659', '0', '100767', '101069175333', 'Arnav Raj', 3, 'Priciple Charge Officer', 'Manager-3,Senior Clerk-5,Clerk-5', 'No', '9126972111', '9615722892', 'ArnavRaj@gmail.com', 'P11659', 'hello@123', '180007', NULL, NULL, NULL, '20103', '200252', '', '1601', '0', '0', '0'),
(58, '11660', '0', '100768', '101054380083', 'Ashish Nigam', 3, 'Priciple Charge Officer', 'Manager-1,Senior Clerk-2', 'No', '9148375532', '9841480428', 'AshishNigam@gmail.com', 'P11660', 'hello@123', '180009', NULL, NULL, NULL, '20104', '200253', '', '1601', '0', '0', '0'),
(59, '11661', '0', '100769', '101052576772', 'Md.Asif Khan', 3, 'Priciple Charge Officer', 'Clerk-12', 'No', '9181616131', '9948693428', 'Md.AsifKhan@gmail.com', 'P11661', 'hello@123', '180012', NULL, NULL, NULL, '20105', '200254', '', '1601', '0', '0', '0'),
(60, '11662', '0', '100770', '101038064367', 'Abhay Mishra', 3, 'Priciple Charge Officer', 'Manager-3', 'No', '9889270275', '9325604774', 'AbhayMishra@gmail.com', 'P11662', 'hello@123', '180001', NULL, NULL, NULL, '20106', '200255', '', '1601', '0', '0', '0'),
(61, '11663', '0', '100771', '101052179274', 'Aditya Verma', 3, 'Priciple Charge Officer', 'Manager-1,Clerk-5', 'No', '9790564200', '9224440261', 'AdityaVerma@gmail.com', 'P11663', 'hello@123', '180002', NULL, NULL, NULL, '20107', '200256', '', '1601', '0', '0', '0'),
(62, '11664', '0', '100772', '101092662034', 'Ahsan Kumar', 3, 'Priciple Charge Officer', 'Manager-4,Clerk-2,Cashier-1', 'Charge Officer-2011', '9996362690', '9669323380', 'AhsanKumar@gmail.com', 'P11664', 'hello@123', '180003', NULL, NULL, NULL, '20108', '200257', '', '1601', '0', '0', '0'),
(63, '11665', '0', '100773', '101034919293', 'Ajay devgun', 3, 'Priciple Charge Officer', 'Manager-7', 'No', '9750432799', '9544423338', 'Ajaydevgun@gmail.com', 'P11665', 'hello@123', '180001', NULL, NULL, NULL, '20109', '200258', '', '1601', '0', '0', '0'),
(64, '11666', '0', '100774', '101094223788', 'Ajjet Kumar Singh', 3, 'Priciple Charge Officer', 'Clerk-2', 'No', '9748701034', '9685242218', 'AjjetKumarSingh@gmail.com', 'P11666', 'hello@123', '180016', NULL, NULL, NULL, '20110', '200259', '', '1601', '0', '0', '0'),
(65, '11667', '0', '100775', '101088866800', 'Akanksha kumar singh', 3, 'Priciple Charge Officer', 'Manager-6,Clerk-5', 'No', '9164909173', '9429703501', 'Akankshakumarsingh@gmail.com', 'P11667', 'hello@123', '180001', NULL, NULL, NULL, '20111', '200260', '', '1601', '0', '0', '0'),
(66, '11668', '0', '100776', '101062892540', 'Akhil dubey', 3, 'Priciple Charge Officer', 'Manager-3', 'No', '9840227839', '9635071771', 'Akhildubey@gmail.com', 'P11668', 'hello@123', '190001', NULL, NULL, NULL, '20112', '200261', '', '1601', '0', '0', '0'),
(67, '11669', '0', '100777', '101089159438', 'Deepak Chauhan', 3, 'Priciple Charge Officer', 'Manager-6,Clerk-5', 'Charge Officer-2011', '9379865982', '9948490781', 'DeepakChauhan@gmail.com', 'P11669', 'hello@123', '190002', NULL, NULL, NULL, '20113', '200262', '', '1601', '0', '0', '0'),
(68, '11670', '0', '100778', '101054065017', 'Devraj verma', 3, 'Priciple Charge Officer', 'Senior Manager-3', 'No', '9476193050', '9608347756', 'Devrajverma@gmail.com', 'P11670', 'hello@123', '190003', NULL, NULL, NULL, '20114', '200263', '', '1601', '0', '0', '0'),
(69, '11671', '0', '100779', '101022690121', 'Dilip Thakur', 3, 'Priciple Charge Officer', 'Senior Manager-2,Manager-8', 'No', '9418216166', '9506495662', 'DilipThakur@gmail.com', 'P11671', 'hello@123', '190004', NULL, NULL, NULL, '20115', '200264', '', '1601', '0', '0', '0'),
(70, '11672', '0', '100780', '101090668987', 'Dilip Kumar', 3, 'Priciple Charge Officer', 'Manager-1,Clerk-8', 'No', '9754471462', '9058297128', 'DilipKumar@gmail.com', 'P11672', 'hello@123', '190005', NULL, NULL, NULL, '20116', '200265', '', '1601', '0', '0', '0'),
(71, '11673', '0', '100781', '101098555562', 'Dinesh Singh', 3, 'Priciple Charge Officer', 'Manager-3,Senior Clerk-5,Clerk-1', 'No', '9942610720', '9873974402', 'DineshSingh@gmail.com', 'P11673', 'hello@123', '190006', NULL, NULL, NULL, '20117', '200266', '', '1601', '0', '0', '0'),
(72, '11674', '0', '100782', '101038456363', 'Jagjit Kumar Singh', 3, 'Priciple Charge Officer', 'Manager-3', 'Charge Officer-2011', '9647546385', '9953819949', 'JagjitKumarSingh@gmail.com', 'P11674', 'hello@123', '190007', NULL, NULL, NULL, '20118', '200267', '', '1601', '0', '0', '0'),
(73, '11675', '0', '100783', '101059856246', 'Jay Shankar', 3, 'Priciple Charge Officer', 'Manager-6,Clerk-5', 'No', '9112919269', '9813471823', 'JayShankar@gmail.com', 'P11675', 'hello@123', '190008', NULL, NULL, NULL, '20119', '200268', '', '1601', '0', '0', '0'),
(74, '11676', '0', '100784', '101012058499', 'Jayant Sinha', 3, 'Priciple Charge Officer', 'Manager-4,Senior Clerk-10', 'No', '9828233566', '9962012479', 'JayantSinha@gmail.com', 'P11676', 'hello@123', '190009', NULL, NULL, NULL, '20120', '200269', '', '1601', '0', '0', '0'),
(75, '11677', '0', '100785', '101024234066', 'Ram Kumar Iyer', 3, 'Priciple Charge Officer', 'Manager-2Clerk-2', 'No', '9822956016', '9891597671', 'RamKumarIyer@gmail.com', 'P11677', 'hello@123', '190010', NULL, NULL, NULL, '20121', '200270', '', '1601', '0', '0', '0'),
(76, '11678', '0', '100786', '101018830056', 'Md.Asif Ali', 3, 'Priciple Charge Officer', 'Clerk-9', 'No', '9767098149', '9708842606', 'Md.AsifAli@gmail.com', 'P11678', 'hello@123', '190005', NULL, NULL, NULL, '20122', '200271', '', '1601', '0', '0', '0'),
(77, '11679', '0', '100787', '101090497938', 'Md.Junaid', 3, 'Priciple Charge Officer', 'Manager-6,Clerk-5', 'No', '9747983740', '9144262644', 'Md.Junaid@gmail.com', 'P11679', 'hello@123', '190006', NULL, NULL, NULL, '20123', '200272', '', '1601', '0', '0', '0'),
(78, '11680', '0', '100788', '101022582678', 'Md.Abdul Khan', 3, 'Priciple Charge Officer', 'Asst.Manager-5', 'Charge Officer-2011', '9306964796', '9792147862', 'Md.AbdulKhan@gmail.com', 'P11680', 'hello@123', '190009', NULL, NULL, NULL, '20124', '200273', '', '1601', '0', '0', '0'),
(79, '11681', '0', '100789', '101019753578', 'Maneesh Kumar', 3, 'Priciple Charge Officer', 'Manager-3', 'No', '9837373955', '9190129844', 'ManeeshKumar@gmail.com', 'P11681', 'hello@123', '190010', NULL, NULL, NULL, '20125', '200274', '', '1601', '0', '0', '0'),
(80, '11682', '0', '100790', '101041122789', 'Manish Ram', 3, 'Priciple Charge Officer', 'Manager-3,Clerk-4', 'No', '9503128030', '9499024613', 'ManishRam@gmail.com', 'P11682', 'hello@123', '190018', NULL, NULL, NULL, '20126', '200275', '', '1601', '0', '0', '0'),
(81, '11683', '0', '100791', '101068335955', 'Sachin Singh', 3, 'Priciple Charge Officer', 'Clerk-4', 'No', '9021031599', '9016455522', 'SachinSingh@gmail.com', 'P11683', 'hello@123', '190012', NULL, NULL, NULL, '20127', '200276', '', '1601', '0', '0', '0'),
(82, '11684', '0', '100792', '101048006283', 'Sanjiv Verma', 3, 'Priciple Charge Officer', 'Clerk-4', 'No', '9574247580', '9604133661', 'SanjivVerma@gmail.com', 'P11684', 'hello@123', '190015', NULL, NULL, NULL, '20128', '200277', '', '1601', '0', '0', '0'),
(83, '11685', '0', '100793', '101011333166', 'Sashi Kumar', 3, 'Priciple Charge Officer', 'Manager-3', 'No', '9043257917', '9436012389', 'SashiKumar@gmail.com', 'P11685', 'hello@123', '190019', NULL, NULL, NULL, '20129', '200278', '', '1601', '0', '0', '0'),
(84, '11690', '', '100800', '101025388450', 'Dayanand Sinha', 4, 'Charge Officer', 'Senior Clerk-3', ' Charge Officer-2011', '8989933226', '8989985620', 'DayanandSinha@gmail.com', 'C11690', 'hello@123', '180001', NULL, NULL, NULL, '301010', '300125', '', '1601', '0', '0', '0'),
(85, '11691', '', '100801', '101030665924', 'Kumar Ashqin', 4, 'Charge Officer', 'Senior Clerk-4', 'No', '8989916291', '8989954751', 'KumarAshqin@gmail.com', 'C11691', 'hello@123', '180001', NULL, NULL, NULL, '301011', '300126', '', '1601', '0', '0', '0'),
(86, '11692', '', '100802', '101021661923', 'Md.Alam Akhtar', 4, 'Charge Officer', 'Senior Clerk-5', 'Charge Officer-2011', '8989995805', '8989924591', 'Md.AlamAkhtar@gmail.com', 'C11692', 'hello@123', '180001', NULL, NULL, NULL, '301012', '300127', '', '1601', '0', '0', '0'),
(87, '11693', '', '100803', '101042804019', 'Md.Naveen', 4, 'Charge Officer', 'Asst. Manager-5', ' Charge Officer-2011', '8989989168', '8989902132', 'Md.Naveen@gmail.com', 'C11693', 'hello@123', '180002', NULL, NULL, NULL, '301013', '300128', '', '1601', '0', '0', '0'),
(88, '11694', '', '100804', '101052527604', 'Farhan Qureshi', 4, 'Charge Officer', 'Senior Clerk-2', 'Charge Officer-2011', '8989922309', '8989920877', 'FarhanQureshi@gmail.com', 'C11694', 'hello@123', '180004', NULL, NULL, NULL, '301014', '300129', '', '1601', '0', '0', '0'),
(89, '11695', '', '100805', '101089902983', 'Md.Akbar', 4, 'Charge Officer', 'Senior Clerk-2', ' Charge Officer-2011', '8989969287', '8989950639', 'Md.Akbar@gmail.com', 'C11695', 'hello@123', '180005', NULL, NULL, NULL, '301015', '300130', '', '1601', '0', '0', '0'),
(90, '11696', '', '100806', '101022964912', 'Hariom Surya', 4, 'Charge Officer', 'Senior Clerk-1,Clerk-5', 'No', '8989907319', '8989948185', 'HariomSurya@gmail.com', 'C11696', 'hello@123', '180001', NULL, NULL, NULL, '301016', '300131', '', '1601', '0', '0', '0'),
(91, '11697', '', '100807', '101039259594', 'Santosh Kumar', 4, 'Charge Officer', 'Senior Clerk-2,Asst Clerk-2', 'Charge Officer-2011', '8989964133', '8989915931', 'SantoshKumar@gmail.com', 'C11697', 'hello@123', '180002', NULL, NULL, NULL, '301017', '300132', '', '1601', '0', '0', '0'),
(92, '11698', '', '100808', '101027749401', 'Prabhat Pandey', 4, 'Charge Officer', 'Asst.Clerk-5', 'No', '8989920768', '8989932049', 'PrabhatPandey@gmail.com', 'C11698', 'hello@123', '180009', NULL, NULL, NULL, '301018', '300133', '', '1601', '0', '0', '0'),
(93, '11699', '', '100809', '101018827632', 'Rahul Ravi', 4, 'Charge Officer', 'Clerk-10', 'Charge Officer-2011', '8989945352', '8989927099', 'RahulRavi@gmail.com', 'C11699', 'hello@123', '180002', NULL, NULL, NULL, '301019', '300134', '', '1601', '0', '0', '0'),
(94, '11700', '', '100810', '101084025851', 'Avinash Kumar', 4, 'Charge Officer', 'Clerk-2,Clerk-10', ' Charge Officer-2011', '8989985734', '8989912039', 'AvinashKumar@gmail.com', 'C11700', 'hello@123', '180006', NULL, NULL, NULL, '301020', '300135', '', '1601', '0', '0', '0'),
(95, '11701', '', '100811', '101098705656', 'Ashish Verma', 4, 'Charge Officer', 'Senior Clerk-5,Clerk-8', 'Charge Officer-2011', '8989976704', '8989988160', 'AshishVerma@gmail.com', 'C11701', 'hello@123', '180005', NULL, NULL, NULL, '301021', '300136', '', '1601', '0', '0', '0'),
(96, '11702', '', '100812', '101019694215', 'Vishal Kumar', 4, 'Charge Officer', 'Senior Clerk-0.5,Clerk-9', 'No', '8989922709', '8989947697', 'VishalKumar@gmail.com', 'C11702', 'hello@123', '180005', NULL, NULL, NULL, '301022', '300137', '', '1601', '0', '0', '0'),
(97, '11703', '', '100813', '101065421582', 'Avinash Kumar', 4, 'Charge Officer', 'Senior Clerk-15', 'No', '8989972713', '8989977847', 'AvinashKumar@gmail.com', 'C11703', 'hello@123', '180007', NULL, NULL, NULL, '301023', '300138', '', '1601', '0', '0', '0'),
(98, '11704', '', '100814', '101084961821', 'Dee raj', 4, 'Charge Officer', 'Clerk-1,Asst.Clerk-5', 'No', '8989982515', '8989915348', 'Deeraj@gmail.com', 'C11704', 'hello@123', '180002', NULL, NULL, NULL, '301024', '300139', '', '1601', '0', '0', '0'),
(99, '11705', '', '100815', '101061188146', 'Piyush Kumar', 4, 'Charge Officer', 'Senior Clerk-5', ' Charge Officer-2011', '8989948729', '8989951468', 'PiyushKumar@gmail.com', 'C11705', 'hello@123', '180001', NULL, NULL, NULL, '301025', '300140', '', '1601', '0', '0', '0'),
(100, '11706', '', '100816', '101014642676', 'Sadique Jamil', 4, 'Charge Officer', 'Head Clerk-9', ' Charge Officer-2011', '8989963089', '8989951023', 'SadiqueJamil@gmail.com', 'C11706', 'hello@123', '180009', NULL, NULL, NULL, '301026', '300141', '', '1601', '0', '0', '0'),
(101, '11707', '', '100817', '101069266437', 'Eklav raj', 4, 'Charge Officer', 'Senior Clerk-2', ' Charge Officer-2011', '8989940119', '8989965863', 'Eklavraj@gmail.com', 'C11707', 'hello@123', '180004', NULL, NULL, NULL, '301027', '300142', '', '1601', '0', '0', '0'),
(102, '11708', '', '100818', '101061067799', 'Mohti Kumar Patel', 4, 'Charge Officer', 'Senior Clerk-2,Clerk-5,Clerk-3', 'Charge Officer-2011', '8989913469', '8989934336', 'MohtiKumarPatel@gmail.com', 'C11708', 'hello@123', '180004', NULL, NULL, NULL, '301028', '300143', '', '1601', '0', '0', '0'),
(103, '11709', '', '100819', '101094113424', 'Bankim kumar', 4, 'Charge Officer', 'Senior Clerk-5', 'Charge Officer-2011', '8989979869', '8989953843', 'Bankimkumar@gmail.com', 'C11709', 'hello@123', '180003', NULL, NULL, NULL, '301029', '300144', '', '1601', '0', '0', '0'),
(104, '11710', '', '100820', '101085902430', 'Anikta Arya', 4, 'Charge Officer', 'Senior Clerk-1,Clerk-5', 'No', '8989937013', '8989963686', 'AniktaArya@gmail.com', 'C11710', 'hello@123', '180002', NULL, NULL, NULL, '301030', '300145', '', '1601', '0', '0', '0'),
(105, '11711', '', '100821', '101023871925', 'Raj S Saurav', 4, 'Charge Officer', 'Senior Clerk-0.5,Asst.Clerk-10', 'No', '8989934709', '8989917475', 'RajSSaurav@gmail.com', 'C11711', 'hello@123', '180003', NULL, NULL, NULL, '301031', '300146', '', '1601', '0', '0', '0'),
(106, '11712', '', '100822', '101023962618', 'Naman Kindra', 4, 'Charge Officer', 'Clerk-12', ' Charge Officer-2011', '8989932321', '8989991881', 'NamanKindra@gmail.com', 'C11712', 'hello@123', '180009', NULL, NULL, NULL, '301032', '300147', '', '1601', '0', '0', '0'),
(107, '11713', '', '100823', '101063859206', 'Anuj Alok', 4, 'Charge Officer', 'Senior Clerk-2,Clerk-2', 'Charge Officer-2011', '8989999128', '8989980478', 'AnujAlok@gmail.com', 'C11713', 'hello@123', '180012', NULL, NULL, NULL, '301033', '300148', '', '1601', '0', '0', '0'),
(108, '11714', '', '100824', '101092705785', 'Siddharat Kumar Singh', 4, 'Charge Officer', 'Senior Clerk-3', 'No', '8989966262', '8989955158', 'SiddharatKumarSingh@gmail.com', 'C11714', 'hello@123', '180016', NULL, NULL, NULL, '301034', '300149', '', '1601', '0', '0', '0'),
(109, '11715', '', '100825', '101045263675', 'meena Singh', 4, 'Charge Officer', 'Senior Clerk-4', 'No', '8989968626', '8989973504', 'meenaSingh@gmail.com', 'C11715', 'hello@123', '180019', NULL, NULL, NULL, '301035', '300150', '', '1601', '0', '0', '0'),
(110, '11716', '', '100826', '101053048275', 'Shashwat Prashant', 4, 'Charge Officer', 'Senior Clerk-5', 'No', '8989998209', '8989932774', 'ShashwatPrashant@gmail.com', 'C11716', 'hello@123', '180022', NULL, NULL, NULL, '301036', '300151', '', '1601', '0', '0', '0'),
(111, '11717', '', '100827', '101027295580', 'Animesh Kumar', 4, 'Charge Officer', 'Asst. Manager-5', 'No', '8989983173', '8989999543', 'AnimeshKumar@gmail.com', 'C11717', 'hello@123', '180009', NULL, NULL, NULL, '301037', '300152', '', '1601', '0', '0', '0'),
(112, '11718', '', '100828', '101054716599', 'Brajesh Rajput', 4, 'Charge Officer', 'Senior Clerk-2', 'No', '8989953149', '8989986108', 'BrajeshRajput@gmail.com', 'C11718', 'hello@123', '180001', NULL, NULL, NULL, '301038', '300153', '', '1601', '0', '0', '0');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
