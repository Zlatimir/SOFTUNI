UPDATE coaches
SET coach_level = coach_level + 1
WHERE id IN (SELECT coach_id FROM players_coaches)
AND LEFT(first_name,1) = 'A';