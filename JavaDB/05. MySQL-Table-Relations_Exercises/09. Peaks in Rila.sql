SELECT mountains.mountain_range, peaks.peak_name, peaks.elevation AS `peak_elevation`
FROM mountains
JOIN peaks ON mountains.id = peaks.mountain_id
WHERE mountain_range = 'Rila'
ORDER BY peak_elevation DESC;

