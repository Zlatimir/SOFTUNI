SELECT reverse(s.`name`) AS reversed_name, concat_ws('-', UPPER(t.`name`), a.`name`) AS full_address, count(e.id) AS employees_count
FROM employees AS e
JOIN stores AS s ON e.store_id = s.id
JOIN addresses AS a ON s.address_id = a.id
JOIN towns AS t ON a.town_id = t.id
GROUP BY s.`name`
ORDER BY full_address;