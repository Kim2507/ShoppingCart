-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.8.3-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.0.0.6468
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for shoppingcart
CREATE DATABASE IF NOT EXISTS `shoppingcart` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `shoppingcart`;

-- Dumping structure for table shoppingcart.cart
CREATE TABLE IF NOT EXISTS `cart` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tax_rate` double NOT NULL,
  `pre_tax_price` double NOT NULL,
  `total_price` double NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `product_counter` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKg5uhi8vpsuy0lgloxk2h4w5o6` (`user_id`),
  CONSTRAINT `FKg5uhi8vpsuy0lgloxk2h4w5o6` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table shoppingcart.cart: ~3 rows (approximately)
INSERT INTO `cart` (`id`, `tax_rate`, `pre_tax_price`, `total_price`, `user_id`, `product_counter`) VALUES
	(1, 0.05, 181.5, 190.57500000000002, 1, 33),
	(2, 0.05, 27.5, 28.875, 2, 5),
	(3, 0.05, 55, 57.75, 3, 10),
	(4, 0.05, 0, 0, 5, 0);

-- Dumping structure for table shoppingcart.category
CREATE TABLE IF NOT EXISTS `category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table shoppingcart.category: ~7 rows (approximately)
INSERT INTO `category` (`id`, `category_name`) VALUES
	(1, 'Black Tea'),
	(2, 'Green Tea'),
	(3, 'White Tea'),
	(4, 'Oolong Tea'),
	(5, 'Yellow Tea'),
	(6, 'Puer Tea'),
	(10, 'Herbal Tea');

-- Dumping structure for table shoppingcart.products
CREATE TABLE IF NOT EXISTS `products` (
  `product_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `stock_quantity` int(11) NOT NULL,
  `cart_id` bigint(20) DEFAULT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `FKaohdy515ap03vw8l89w6g9c6y` (`cart_id`),
  KEY `FK1cf90etcu98x1e6n9aks3tel3` (`category_id`),
  CONSTRAINT `FK1cf90etcu98x1e6n9aks3tel3` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `FKaohdy515ap03vw8l89w6g9c6y` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table shoppingcart.products: ~3 rows (approximately)
INSERT INTO `products` (`product_id`, `description`, `name`, `price`, `stock_quantity`, `cart_id`, `category_id`) VALUES
	(1, 'desc', 'Black Tea', 5.5, 10, 3, 1),
	(2, 'desc', 'Green Tea', 5.5, 11, NULL, 2),
	(3, 'desc', 'Chamomile', 5.5, 11, NULL, 10);

-- Dumping structure for table shoppingcart.roles
CREATE TABLE IF NOT EXISTS `roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ofx66keruapi6vyqpv6f2or37` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table shoppingcart.roles: ~1 rows (approximately)
INSERT INTO `roles` (`id`, `name`) VALUES
	(1, 'ROLE_USER');

-- Dumping structure for table shoppingcart.spring_session
CREATE TABLE IF NOT EXISTS `spring_session` (
  `PRIMARY_ID` char(36) NOT NULL,
  `SESSION_ID` char(36) NOT NULL,
  `CREATION_TIME` bigint(20) NOT NULL,
  `LAST_ACCESS_TIME` bigint(20) NOT NULL,
  `MAX_INACTIVE_INTERVAL` int(11) NOT NULL,
  `EXPIRY_TIME` bigint(20) NOT NULL,
  `PRINCIPAL_NAME` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`PRIMARY_ID`),
  UNIQUE KEY `SPRING_SESSION_IX1` (`SESSION_ID`),
  KEY `SPRING_SESSION_IX2` (`EXPIRY_TIME`),
  KEY `SPRING_SESSION_IX3` (`PRINCIPAL_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- Dumping data for table shoppingcart.spring_session: ~0 rows (approximately)

-- Dumping structure for table shoppingcart.spring_session_attributes
CREATE TABLE IF NOT EXISTS `spring_session_attributes` (
  `SESSION_PRIMARY_ID` char(36) NOT NULL,
  `ATTRIBUTE_NAME` varchar(200) NOT NULL,
  `ATTRIBUTE_BYTES` blob NOT NULL,
  PRIMARY KEY (`SESSION_PRIMARY_ID`,`ATTRIBUTE_NAME`),
  CONSTRAINT `SPRING_SESSION_ATTRIBUTES_FK` FOREIGN KEY (`SESSION_PRIMARY_ID`) REFERENCES `spring_session` (`PRIMARY_ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- Dumping data for table shoppingcart.spring_session_attributes: ~0 rows (approximately)

-- Dumping structure for table shoppingcart.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `state` varchar(255) DEFAULT NULL,
  `zip_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table shoppingcart.users: ~5 rows (approximately)
INSERT INTO `users` (`id`, `address`, `city`, `email`, `name`, `password`, `state`, `zip_code`) VALUES
	(1, '782 Main St', 'Malden', 'kim@gmail.com', 'Kim Trinh', '$2a$10$s9105u4ri2NgzqwKfSUJWu/R9LaYWHPTyOhZCl3/bTSjyA45nub2a', 'CA', '23213'),
	(2, '32 freg', 'quincy', 'rol@gmail.com', 'Rol Lei', '$2a$10$Wxt4ICKWMh43vN5xRucy.ub..XYu.94iqVVyk7i6Ia1AyV37nBS42', 'ma', '32321'),
	(3, '78 Main ST', 'Malden', 'christ@gmail.com', 'Christ  Trinh', '$2a$10$Jq51AofhetC4MNUVWLGOke91EDJw.B71HecuiwZJuNYRgIc34rkRW', 'LA', '32131'),
	(4, '78 Hope Ave', 'Saugus', 'malik@gmail.com', 'Malik A', '$2a$10$1Qanf4wse7pIDcjuJMxAquvqVE5SRj6qsKyZ5U5xvaEJbwSRk83NG', 'TX', '03821'),
	(5, '232', '2324', 'a@gmail.com', 'A B', '$2a$10$Q4ec0gmBH1aJViJAfs5.mOj.8H2fVwm6RvGSxNcxPe/.8fxieEhX2', '21421', '242');

-- Dumping structure for table shoppingcart.users_roles
CREATE TABLE IF NOT EXISTS `users_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  KEY `FKj6m8fwv7oqv74fcehir1a9ffy` (`role_id`),
  KEY `FK2o0jvgh89lemvvo17cbqvdxaa` (`user_id`),
  CONSTRAINT `FK2o0jvgh89lemvvo17cbqvdxaa` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKj6m8fwv7oqv74fcehir1a9ffy` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table shoppingcart.users_roles: ~5 rows (approximately)
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES
	(1, 1),
	(2, 1),
	(3, 1),
	(4, 1),
	(5, 1);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
