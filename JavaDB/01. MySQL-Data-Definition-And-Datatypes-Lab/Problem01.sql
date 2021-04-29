CREATE SCHEMA `gamebar` DEFAULT CHARACTER SET utf8;

CREATE TABLE `employees` (
  `id` INT(10) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));
  
  CREATE TABLE `categories` (
  `id` INT(10) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));
  
CREATE TABLE `products` (
  `id` INT(10) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `category_id` INT(10) NULL,
  PRIMARY KEY (`id`));