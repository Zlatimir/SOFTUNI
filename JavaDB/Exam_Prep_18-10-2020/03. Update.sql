UPDATE employees
SET salary = salary - 500, manager_id = 3
WHERE store_id NOT IN (5, 14)
AND LEFT(hire_date,4) > '2003';