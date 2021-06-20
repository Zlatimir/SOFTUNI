DROP PROCEDURE IF EXISTS udp_courses_by_address;

DELIMITER $$

CREATE PROCEDURE udp_courses_by_address (address_name VARCHAR (100))
BEGIN

	SELECT a.`name`, cl.full_name, 
    CASE 
        WHEN co.bill <= 20 THEN 'Low'
        WHEN co.bill <= 30 THEN 'Medium'
        ELSE 'High'
    END
	AS level_of_bill, c.make, c.`condition`, ca.`name` FROM addresses AS a
    JOIN courses AS co ON co.from_address_id = a.id
    JOIN clients AS cl ON co.client_id = cl.id
    JOIN cars AS c ON co.car_id = c.id
    JOIN categories AS ca ON c.category_id = ca.id
    WHERE a.`name` = address_name
    ORDER BY c.make, cl.full_name;
        
END $$

DELIMITER ;

CALL udp_courses_by_address('700 Monterey Avenue');

CALL udp_courses_by_address('66 Thompson Drive');