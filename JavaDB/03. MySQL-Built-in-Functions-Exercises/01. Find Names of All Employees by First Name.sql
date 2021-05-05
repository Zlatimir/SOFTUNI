SELECT `first_name`, `last_name` FROM `employees`
WHERE lower(SUBSTRING(`first_name`, 1, 2)) = 'sa';