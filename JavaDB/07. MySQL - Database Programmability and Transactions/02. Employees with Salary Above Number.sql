DELIMITER ##
CREATE PROCEDURE usp_get_employees_salary_above(salary_limit DOUBLE(19,4))
BEGIN
	SELECT first_name, last_name, salary_limit FROM employees AS e
    WHERE e.salary >= salary_limit
    ORDER BY first_name, last_name;
END##
DELIMITER ;

CALL usp_get_employees_salary_above (48100);

DROP PROCEDURE usp_get_employees_salary_above;
