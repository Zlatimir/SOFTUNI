SELECT p.id, concat_ws(' ', first_name, last_name) AS full_name, age,
position, hire_date FROM players AS p JOIN skills_data AS sk
WHERE p.position = 'A' AND p.hire_date IS NULL
AND p.skills_data_id = sk.id AND sk.strength > 50
ORDER BY p.salary, p.age;