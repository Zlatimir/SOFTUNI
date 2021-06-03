SELECT count(salary) as ''
FROM employees
GROUP BY manager_id
HAVING manager_id is NULL;