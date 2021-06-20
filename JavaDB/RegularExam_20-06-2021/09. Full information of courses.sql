SELECT a.`name`, 
	if((hour(co.`start`) >= 6 && hour(co.`start`) <= 20),  'Day', 'Night') AS day_time,
co.bill, cl.full_name, c.make, c.model, ca.`name` AS category_name
FROM addresses AS a
JOIN courses AS co ON co.from_address_id = a.id
JOIN clients AS cl ON co.client_id = cl.id
JOIN cars AS c ON co.car_id = c.id
JOIN categories AS ca ON c.category_id = ca.id
ORDER BY co.id;
