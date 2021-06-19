DROP PROCEDURE IF EXISTS udp_update_product_price;

DELIMITER $$

CREATE PROCEDURE udp_update_product_price (address_name VARCHAR (50))
BEGIN
    DECLARE increase_level INT;
    IF address_name LIKE '0%' THEN SET increase_level = 100;
    ELSE SET increase_level = 200;
    END IF;
    
    UPDATE products AS p SET p.price = p.price + increase_level
    WHERE p.id IN
				(SELECT p_s.product_id FROM addresses AS a
                JOIN stores AS s ON s.address_id = a.id
                JOIN products_stores  AS p_s ON p_s.store_id = s.id
                WHERE a.`name` = address_name);
    
END $$

DELIMITER ;

CALL udp_update_product_price('07 Armistice Parkway');
SELECT name, price FROM products WHERE id = 15;

CALL udp_update_product_price('1 Cody Pass');
SELECT name, price FROM products WHERE id = 17;