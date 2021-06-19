DROP FUNCTION IF EXISTS udf_top_paid_employee_by_store;
USE softuni_stores_system;
DELIMITER ##

CREATE FUNCTION udf_top_paid_employee_by_store(store_name VARCHAR(50))
RETURNS VARCHAR(100)
DETERMINISTIC
BEGIN
	
    RETURN 
    (SELECT concat(first_name, ' ', middle_name, '. ', last_name, ' works in store for ',floor(datediff('2020-10-18', hire_date)/365.25), ' years')
	AS full_info
	FROM employees AS e
	JOIN stores AS s ON e.store_id = s.id
	WHERE s.`name` = store_name
	ORDER BY salary DESC LIMIT 1);
    
END##

DELIMITER ;


SELECT udf_top_paid_employee_by_store('Stronghold') as 'full_info';

SELECT udf_top_paid_employee_by_store('Keylex') as 'full_info';
