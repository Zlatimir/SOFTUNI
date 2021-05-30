DELIMITER ##

CREATE FUNCTION udf_stadium_players_count (stadium_name VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE e_count INT;
    SET e_count := (SELECT COUNT(p.id) FROM stadiums AS s
    LEFT JOIN teams AS t ON s.id = t.stadium_id
    LEFT JOIN players AS p ON t.id = p.team_id
    WHERE s.name = stadium_name);
    RETURN e_count;
END##

DELIMITER ;

SELECT udf_stadium_players_count ('Jaxworks') as `count`;

SELECT udf_stadium_players_count ('Linklinks') as `count`; 