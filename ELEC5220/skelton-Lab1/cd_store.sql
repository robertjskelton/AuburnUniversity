-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 21, 2014 at 03:40 AM
-- Server version: 5.6.16
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `cd_store`
--

-- --------------------------------------------------------

--
-- Table structure for table `cd_store`
--

CREATE TABLE IF NOT EXISTS `cd_store` (
  `item_number` int(4) NOT NULL AUTO_INCREMENT,
  `artist` varchar(30) NOT NULL,
  `cd_name` varchar(30) NOT NULL,
  `price` float NOT NULL,
  `quantity` int(5) NOT NULL,
  `genre` text NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`item_number`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `cd_store`
--

INSERT INTO `cd_store` (`item_number`, `artist`, `cd_name`, `price`, `quantity`, `genre`, `description`) VALUES
(1, 'Auburn Band', 'Marching ', 14.99, 57, 'Band Music', 'The 2014 Marching Band "Sounds of Auburn"'),
(2, 'Led Zeppelin', 'I', 9.99, 5, 'Rock', 'The greatest album ever recorded. '),
(3, 'AC/DC', 'Back in Black', 5.99, 112, 'Rock', 'Classic album by AC/DC. ');

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE IF NOT EXISTS `customers` (
  `cust_id` int(5) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(40) NOT NULL,
  `address_1` varchar(30) NOT NULL,
  `address_2` varchar(30) NOT NULL,
  `city` varchar(30) NOT NULL,
  `state` char(2) NOT NULL,
  `zip` char(5) NOT NULL,
  `telephone` varchar(14) NOT NULL,
  `cc_num` varchar(16) NOT NULL,
  `cc_type` varchar(20) NOT NULL,
  `cc_expire` date NOT NULL,
  PRIMARY KEY (`cust_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`cust_id`, `first_name`, `last_name`, `address_1`, `address_2`, `city`, `state`, `zip`, `telephone`, `cc_num`, `cc_type`, `cc_expire`) VALUES
(1, 'Aubie', 'Tiger', '101 Auburn Ave', '', 'Auburn', 'AL', '36830', '3348444444', '123456789123456', 'Visa', '2014-10-23');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE IF NOT EXISTS `orders` (
  `order_id` varchar(50) NOT NULL,
  `cust_id` int(5) NOT NULL,
  `item_ordered` int(5) NOT NULL,
  `quantity` int(5) NOT NULL,
  `date_ordered` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
