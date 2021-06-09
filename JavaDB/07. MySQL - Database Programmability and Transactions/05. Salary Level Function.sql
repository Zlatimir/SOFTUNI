DROP FUNCTION IF EXISTS ufn_get_salary_level;

DELIMITER ##

CREATE FUNCTION ufn_get_salary_level(salary DECIMAL)
RETURNS VARCHAR(20)
DETERMINISTIC
BEGIN
	DECLARE salary_level VARCHAR(20);
    SET salary_level := (
		IF(salary<30000, 'Low',
			IF(salary>=30000 AND salary<=50000, 'Average', 'High')));
    RETURN salary_level;
END##

DELIMITER ;

SELECT ufn_get_salary_level(13500);