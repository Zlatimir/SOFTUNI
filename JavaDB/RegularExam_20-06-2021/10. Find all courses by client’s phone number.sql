DROP FUNCTION IF EXISTS udf_courses_by_client;

DELIMITER ##

CREATE FUNCTION udf_courses_by_client (phone_num VARCHAR (20))
RETURNS INT
DETERMINISTIC
BEGIN
	
    RETURN 
    (SELECT count(co.client_id) FROM courses AS co
    JOIN clients AS cl ON co.client_id = cl.id
    WHERE cl.phone_number = phone_num
	 );
    
END ##

DELIMITER ;

SELECT udf_courses_by_client ('(803) 6386812') as `count`; 

SELECT udf_courses_by_client ('(831) 1391236') as `count`;

SELECT udf_courses_by_client ('(704) 2502909') as `count`;