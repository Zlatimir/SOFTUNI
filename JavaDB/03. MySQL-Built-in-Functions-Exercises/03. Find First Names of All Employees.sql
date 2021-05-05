SELECT `first_name` FROM `employees`
WHERE `department_id` IN (3, 10) && substring(`hire_date`, 1, 4) >= '1995' && substring(`hire_date`, 1, 4) <= '2005';