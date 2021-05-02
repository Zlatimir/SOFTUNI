CREATE SCHEMA `movies`;

USE `movies`;

CREATE TABLE `directors`(
`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
`director_name` VARCHAR(50) NOT NULL,
`notes` VARCHAR(200));

CREATE TABLE `genre`(
`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
`genre_name` VARCHAR(30) NOT NULL,
`notes` VARCHAR(200));

CREATE TABLE `categories`(
`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
`category_name` VARCHAR(30) NOT NULL,
`notes` VARCHAR(200));

CREATE TABLE `movies`(
`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
`title` VARCHAR(100) NOT NULL,
`director_id` INT NOT NULL,
`copyright_year` YEAR NOT NULL,
`length` TIME NOT NULL,
`genre_id` INT NOT NULL,
`category_id` INT NOT NULL,
`rating` INT NOT NULL,
`notes` VARCHAR(200));

ALTER TABLE `movies`
ADD CONSTRAINT `fk_directors`
FOREIGN KEY (`director_id`)
REFERENCES `directors`(`id`);

ALTER TABLE `movies`
ADD CONSTRAINT `fk_genre`
FOREIGN KEY (`genre_id`)
REFERENCES `genre`(`id`),
ADD CONSTRAINT `fk_category`
FOREIGN KEY (`category_id`)
REFERENCES `categories`(`id`);

