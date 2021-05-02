CREATE TABLE `people`
(`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
`name` VARCHAR(200) NOT NULL,
`picture` BLOB,
`height` DECIMAL(5, 2),
`weight` DECIMAL(5, 2),
`gender` CHAR(1) NOT NULL,
`birthdate` DATE NOT NULL,
`biography` LONGTEXT);

INSERT INTO `people` (`name`, `gender`, `birthdate`)
VALUES
('Petar Petrov', 'm', '2000-01-01'),
('Hristo Hristov', 'm', '2010-02-02'),
('Ana Hristova', 'f', '2000-02-04'),
('Maria Koleva', 'f', '1995-02-02'),
('Hristo Petrov', 'm', '2010-02-02');

