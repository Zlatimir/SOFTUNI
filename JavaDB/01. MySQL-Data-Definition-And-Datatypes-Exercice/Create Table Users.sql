CREATE TABLE `users`(
`id` BIGINT UNSIGNED PRIMARY KEY UNIQUE AUTO_INCREMENT NOT NULL,
`username` VARCHAR(30) UNIQUE NOT NULL,
`password` VARCHAR(25) NOT NULL,
`profile_picture` BLOB(900000),
`last_login_time` TIMESTAMP DEFAULT NOW(),
`is_deleted` BOOLEAN DEFAULT FALSE);

INSERT INTO `users`(`username`, `password`)
VALUES
('user1', 'password1'),
('user2', 'password2'),
('user3', 'password3'),
('user4', 'password4'),
('user5', 'password5');