SELECT teams.`name` AS team_name, established, fan_base, COUNT(players.id) AS players_count
FROM teams LEFT JOIN players 
ON players.team_id = teams.id;