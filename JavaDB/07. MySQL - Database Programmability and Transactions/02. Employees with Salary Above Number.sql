DROP PROCEDURE IF EXISTS usp_get_employees_salary_above;

DELIMITER ##
CREATE PROCEDURE usp_get_employees_salary_above(salary_limit DOUBLE(19,4))
BEGIN
	SELECT first_name, last_name FROM employees AS e
    WHERE e.salary >= salary_limit
    ORDER BY first_name, last_name;
END##
DELIMITER ;

CALL usp_get_employees_salary_above (45000);

DROP PROCEDURE usp_get_employees_salary_above;
