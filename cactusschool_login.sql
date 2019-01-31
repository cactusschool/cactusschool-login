-- --------------------------------------------------------
-- Host:                         localhost
-- Server version:               10.1.28-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win32
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for cactusschool_login
DROP DATABASE IF EXISTS `cactusschool_login`;
CREATE DATABASE IF NOT EXISTS `cactusschool_login` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `cactusschool_login`;

-- Dumping structure for table cactusschool_login.address
DROP TABLE IF EXISTS `address`;
CREATE TABLE IF NOT EXISTS `address` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT,
  `school_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `address_name` varchar(100) NOT NULL,
  `address_line1` varchar(75) NOT NULL,
  `address_line2` varchar(75) DEFAULT NULL,
  `address_line3` varchar(75) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `pin_code` varchar(10) DEFAULT NULL,
  `dist_code` varchar(4) DEFAULT NULL,
  `state_code` varchar(4) DEFAULT NULL,
  `country_code` varchar(4) DEFAULT NULL,
  `delete_ind` varchar(2) DEFAULT NULL,
  `delete_reason` varchar(100) DEFAULT NULL,
  `create_user` varchar(100) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `update_user` varchar(100) DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`address_id`),
  KEY `FK_address_school_master` (`school_id`),
  KEY `FK_address_users` (`user_id`),
  CONSTRAINT `FK_address_school_master` FOREIGN KEY (`school_id`) REFERENCES `school_master` (`school_id`),
  CONSTRAINT `FK_address_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table cactusschool_login.address: ~0 rows (approximately)
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;

-- Dumping structure for table cactusschool_login.role_access
DROP TABLE IF EXISTS `role_access`;
CREATE TABLE IF NOT EXISTS `role_access` (
  `role_access_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `role_access_permission` enum('CREATE','READ','UPDATE','DELETE') NOT NULL,
  `delete_ind` varchar(2) DEFAULT NULL,
  `delete_reason` varchar(100) DEFAULT NULL,
  `create_user` varchar(50) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `update_user` varchar(50) DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`role_access_id`),
  KEY `FK_role_access_role_master` (`role_id`),
  CONSTRAINT `FK_role_access_role_master` FOREIGN KEY (`role_id`) REFERENCES `role_master` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- Dumping data for table cactusschool_login.role_access: ~7 rows (approximately)
/*!40000 ALTER TABLE `role_access` DISABLE KEYS */;
INSERT INTO `role_access` (`role_access_id`, `role_id`, `role_access_permission`, `delete_ind`, `delete_reason`, `create_user`, `create_date`, `update_user`, `update_date`) VALUES
	(1, 1, 'CREATE', NULL, NULL, NULL, NULL, NULL, NULL),
	(2, 1, 'READ', NULL, NULL, NULL, NULL, NULL, NULL),
	(3, 1, 'UPDATE', NULL, NULL, NULL, NULL, NULL, NULL),
	(4, 1, 'DELETE', NULL, NULL, NULL, NULL, NULL, NULL),
	(5, 4, 'READ', NULL, NULL, NULL, NULL, NULL, NULL),
	(6, 3, 'CREATE', NULL, NULL, NULL, NULL, NULL, NULL),
	(7, 3, 'READ', NULL, NULL, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `role_access` ENABLE KEYS */;

-- Dumping structure for table cactusschool_login.role_master
DROP TABLE IF EXISTS `role_master`;
CREATE TABLE IF NOT EXISTS `role_master` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) NOT NULL,
  `role_desc` varchar(100) NOT NULL,
  `delete_ind` varchar(2) DEFAULT NULL,
  `delete_reason` varchar(100) DEFAULT NULL,
  `create_user` varchar(50) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `update_user` varchar(50) DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Dumping data for table cactusschool_login.role_master: ~4 rows (approximately)
/*!40000 ALTER TABLE `role_master` DISABLE KEYS */;
INSERT INTO `role_master` (`role_id`, `role_name`, `role_desc`, `delete_ind`, `delete_reason`, `create_user`, `create_date`, `update_user`, `update_date`) VALUES
	(1, 'ADMIN', 'Admin user', NULL, NULL, 'ashish', '2019-01-31 00:48:28', NULL, NULL),
	(2, 'PRINCIPAL', 'Principal', NULL, NULL, 'ashish', '2019-01-31 00:49:03', NULL, NULL),
	(3, 'TEACHER', 'Teacher', NULL, NULL, NULL, '2019-01-31 00:49:19', NULL, NULL),
	(4, 'PARENT', 'Parents', NULL, NULL, NULL, '2019-01-31 00:49:38', NULL, NULL);
/*!40000 ALTER TABLE `role_master` ENABLE KEYS */;

-- Dumping structure for table cactusschool_login.school_master
DROP TABLE IF EXISTS `school_master`;
CREATE TABLE IF NOT EXISTS `school_master` (
  `school_id` int(11) NOT NULL AUTO_INCREMENT,
  `school_parent_id` int(11) NOT NULL,
  `school_group_name` varchar(150) DEFAULT NULL,
  `school_name` varchar(150) NOT NULL,
  `address_id` int(11) NOT NULL COMMENT 'Physical address and phone number',
  `context_root` varchar(50) NOT NULL,
  `db_name` varchar(50) NOT NULL,
  `school_code` varchar(50) NOT NULL,
  `sms_sender_id` varchar(50) NOT NULL,
  `contract_id` int(11) NOT NULL COMMENT 'Contract Details',
  `delete_ind` varchar(2) NOT NULL,
  `delete_reason` varchar(100) NOT NULL,
  `create_user` varchar(100) NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_user` varchar(100) NOT NULL,
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`school_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table cactusschool_login.school_master: ~0 rows (approximately)
/*!40000 ALTER TABLE `school_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `school_master` ENABLE KEYS */;

-- Dumping structure for table cactusschool_login.users
DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `middle_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `parent_id` int(11) DEFAULT '0' COMMENT 'Parent if of students can be stored here',
  `account_locked` bit(1) DEFAULT b'0',
  `end_date` timestamp NULL DEFAULT NULL COMMENT 'End date null means the user is active else not active',
  `delete_ind` varchar(2) DEFAULT NULL,
  `delete_reason` varchar(100) DEFAULT NULL,
  `last_logged_in` timestamp NULL DEFAULT NULL,
  `create_user` varchar(50) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `update_user` varchar(50) DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Dumping data for table cactusschool_login.users: ~5 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`user_id`, `user_name`, `password`, `first_name`, `middle_name`, `last_name`, `parent_id`, `account_locked`, `end_date`, `delete_ind`, `delete_reason`, `last_logged_in`, `create_user`, `create_date`, `update_user`, `update_date`) VALUES
	(1, 'ashish', '$2a$10$u0pzkxGOPKkq1iufN19OtO/tsT1vq0FI58RUMWYq7nG8bZJBLar3u', 'Ashish', 'Kumar', 'Mondal', 0, b'0', NULL, NULL, NULL, '2019-01-31 00:47:54', 'ashish', '2019-01-31 00:47:58', NULL, NULL),
	(2, 'madhurjya', '$2a$10$u0pzkxGOPKkq1iufN19OtO/tsT1vq0FI58RUMWYq7nG8bZJBLar3u', 'Madhurjya', NULL, 'Saikia', 0, b'0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(3, 'rajesh', '$2a$10$u0pzkxGOPKkq1iufN19OtO/tsT1vq0FI58RUMWYq7nG8bZJBLar3u', 'Rajesh', NULL, 'Karmakar', 0, b'0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(4, 'pranab', '$2a$10$u0pzkxGOPKkq1iufN19OtO/tsT1vq0FI58RUMWYq7nG8bZJBLar3u', 'Pranab', NULL, NULL, 0, b'0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(5, 'admin', '$2a$10$u0pzkxGOPKkq1iufN19OtO/tsT1vq0FI58RUMWYq7nG8bZJBLar3u', 'Admin', NULL, 'Admin', 0, b'0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

-- Dumping structure for table cactusschool_login.user_role
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE IF NOT EXISTS `user_role` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `delete_ind` varchar(2) DEFAULT NULL,
  `delete_reason` varchar(100) DEFAULT NULL,
  `create_user` varchar(50) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `update_user` varchar(50) DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`user_role_id`),
  KEY `FK__users` (`user_id`),
  KEY `FK__role_master` (`role_id`),
  CONSTRAINT `FK__role_master` FOREIGN KEY (`role_id`) REFERENCES `role_master` (`role_id`),
  CONSTRAINT `FK__users` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table cactusschool_login.user_role: ~2 rows (approximately)
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` (`user_role_id`, `user_id`, `role_id`, `delete_ind`, `delete_reason`, `create_user`, `create_date`, `update_user`, `update_date`) VALUES
	(1, 1, 1, NULL, NULL, 'ashish', '2019-01-31 03:17:33', NULL, NULL),
	(2, 3, 4, NULL, NULL, 'ashish', '2019-01-31 03:17:40', NULL, NULL);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
