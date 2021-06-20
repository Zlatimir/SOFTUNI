INSERT INTO clients
(full_name, phone_number)
SELECT concat(first_name, ' ', last_name), concat('(088) 9999', id * 2) FROM drivers
WHERE drivers.id >= 10 AND drivers.id <= 20;