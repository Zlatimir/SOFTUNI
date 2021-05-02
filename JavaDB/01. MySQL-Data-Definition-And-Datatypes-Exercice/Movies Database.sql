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

INSERT INTO `directors` (`director_name`)
VALUES 
('Director_1'),
('Director_2'),
('Director_3'),
('Director_4'),
('Director_5');

INSERT INTO `genre` (`genre_name`)
VALUES
('Genre_1'),
('Genre_2'),
('Genre_3'),
('Genre_4'),
('Genre_5');

INSERT INTO `categories` (`category_name`)
VALUES
('Category_1'),
('Category_2'),
('Category_3'),
('Category_4'),
('Category_5');

INSERT INTO `movies`
(`title`,`director_id`,`copyright_year`,`length`,`genre_id`,`category_id`,`rating`)
VALUES
('Movie-1',3,'1998','2:45:10',5,1,10),
('Movie-2',3,'1987','2:10:10',2,3,8),
('Movie-3',3,'1999','1:45:10',5,4,10),
('Movie-4',3,'2010','1:58:10',4,2,6),
('Movie-5',3,'1998','2:45:10',1,1,10);
