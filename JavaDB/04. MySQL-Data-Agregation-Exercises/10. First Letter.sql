SELECT DISTINCT left(`first_name`, 1) AS `first_letter` FROM `wizzard_deposits`
GROUP BY `first_name`, `deposit_group`
HAVING `deposit_group` = 'Troll Chest' 
ORDER BY `first_letter`;
