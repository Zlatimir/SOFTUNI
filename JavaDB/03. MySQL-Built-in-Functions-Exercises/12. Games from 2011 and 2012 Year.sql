SELECT `name`, substr(`start`, 1, 10) AS `start` FROM `games`
WHERE substr(`start`, 1, 4) IN ('2011', '2012')
ORDER BY `start`, `name` LIMIT 50;

/*
SELECT 
    `name`, DATE_FORMAT(`start`, '%Y-%m-%d') AS 'start'
FROM
    `games`
WHERE
    YEAR(`start`) BETWEEN 2011 AND 2012
ORDER BY `start` , `name`
LIMIT 50;
*/