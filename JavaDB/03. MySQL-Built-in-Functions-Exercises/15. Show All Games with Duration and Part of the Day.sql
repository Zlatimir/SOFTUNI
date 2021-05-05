SELECT `name` AS `game`, 
CASE
	WHEN HOUR(`start`) BETWEEN 0 and 11 THEN 'Morning'
    WHEN hour(`start`) BETWEEN 12 AND 17 THEN 'Afternoon'
    ELSE 'Evening'
END
AS 'Part of the Day',
CASE
	WHEN `duration` <= 3 THEN 'Extra Short'
    WHEN `duration` > 3 && `duration` <=6 THEN 'Short'
    WHEN `duration` > 6 && `duration` <=10 THEN 'Long'
    ELSE 'Extra Long'
END
AS 'Duration'
FROM `games`;