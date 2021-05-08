CREATE TABLE people(
person_id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(30) NOT NULL,
salary DECIMAL(10,2),
passport_id INT);

CREATE TABLE passports(
passport_id INT PRIMARY KEY AUTO_INCREMENT,
passport_number VARCHAR(30));

ALTER TABLE passports AUTO_INCREMENT = 101;

INSERT INTO passports (passport_number)
VALUES
('N34FG21B'),
('K65LO4R7'),
('ZE657QP2');

INSERT INTO people(first_name, salary, passport_id)
VALUES
('Roberto', 43300, 102),
('Tom', 56100, 103),
('Yana', 60200, 101);

ALTER TABLE passports
ADD CONSTRAINT
UNIQUE(passport_number);

ALTER TABLE people
ADD CONSTRAINT
UNIQUE(passport_id);

ALTER TABLE people
ADD CONSTRAINT fk_people_passports
FOREIGN KEY (passport_id)
REFERENCES passports(passport_id);

/*
SELECT first_name, passport_number FROM people
JOIN passports ON people.passport_id = passports.passport_id;
*/