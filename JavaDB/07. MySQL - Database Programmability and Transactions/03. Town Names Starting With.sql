DROP PROCEDURE IF EXISTS usp_get_towns_starting_with;

DELIMITER ##

CREATE PROCEDURE usp_get_towns_starting_with(start_with VARCHAR(50))
BEGIN
	SELECT `name` AS `town_name` FROM towns
    WHERE `name` LIKE concat(start_with,'%')
    ORDER BY `name`;
END##

DELIMITER ;

CALL usp_get_towns_starting_with('b');