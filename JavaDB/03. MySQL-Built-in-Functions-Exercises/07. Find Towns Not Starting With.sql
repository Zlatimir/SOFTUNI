SELECT `town_id`, `name` FROM `towns`
WHERE substring(lower(`name`), 1, 1) NOT IN ('r', 'd', 'b') ORDER BY `name`;