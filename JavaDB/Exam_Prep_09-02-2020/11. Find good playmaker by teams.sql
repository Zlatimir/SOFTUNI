DROP PROCEDURE IF EXISTS udp_find_playmaker;

DELIMITER ##

CREATE PROCEDURE udp_find_playmaker(IN min_dribble_points INT, team_name VARCHAR(45))
BEGIN
	SELECT concat_ws(' ', p.first_name, p.last_name) AS full_name,
			p.age, p.salary, sd.dribbling, sd.speed, te.name FROM players AS p
    JOIN skills_data AS sd ON p.skills_data_id = sd.id
    JOIN teams AS te ON p.team_id = te.id
    WHERE te.`name` = team_name AND sd.dribbling > min_dribble_points
    ORDER BY sd.speed DESC LIMIT 1;
END##

DELIMITER ;

CALL udp_find_playmaker (20, 'Skyble');