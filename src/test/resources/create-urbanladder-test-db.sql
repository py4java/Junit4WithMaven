DROP SCHEMA IF EXISTS `urbanladderdbtestdb`;
CREATE SCHEMA `urbanladderdbtestdb`;
USE `urbanladderdbtestdb`;

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `category_no` int(11) NOT NULL AUTO_INCREMENT,
  `category_nm` varchar(45) NOT NULL,
  PRIMARY KEY (`category_no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `product_no` int(11) NOT NULL AUTO_INCREMENT,
  `product_nm` varchar(45) NOT NULL,
  `product_desc` varchar(45) DEFAULT NULL,
  `product_price` varchar(45) DEFAULT NULL,
  `category_no` int(11) NOT NULL,
  PRIMARY KEY (`product_no`),
  KEY `category_no_idx` (`product_no`),
  KEY `category_no_idx1` (`category_no`),
  CONSTRAINT `category_no` FOREIGN KEY (`category_no`) REFERENCES `category` (`category_no`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
