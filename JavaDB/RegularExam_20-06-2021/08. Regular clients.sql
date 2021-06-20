SELECT cl.full_name, count(co.car_id) AS count_of_cars, sum(co.bill) AS total_sum
FROM clients AS cl
JOIN courses AS co ON co.client_id = cl.id
GROUP BY co.client_id
HAVING SUBSTR(cl.full_name, 2, 1) = 'a'
AND count(co.car_id) > 1
ORDER BY cl.full_name;