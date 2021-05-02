INSERT INTO `towns` (`id`, `name`)
VALUES (1, 'Sofia'), (2, 'Plovdiv'), (3, 'Varna');

INSERT INTO `minions` (`name`, `age`, `town_id`)
VALUES ('Kevin', 22, 1),
('Bob', 15, 3),
('Steward', NULL, 2);