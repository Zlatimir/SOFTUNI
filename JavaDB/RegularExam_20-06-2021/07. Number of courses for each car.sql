SELECT c.id AS car_id, c.make, c.mileage, count(co.car_id) AS count_of_courses, round(AVG(co.bill), 2) AS avg_bill
FROM cars AS c
LEFT JOIN courses AS co ON co.car_id = c.id
GROUP BY c.id
HAVING count_of_courses != 2
ORDER BY count_of_courses DESC, c.id;
