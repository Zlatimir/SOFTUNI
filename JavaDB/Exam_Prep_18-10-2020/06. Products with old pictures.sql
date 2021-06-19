SELECT `name` AS product_name, price, best_before, CONCAT(LEFT(description, 10),'...') AS short_description, pictures.url
FROM products 
JOIN pictures ON products.picture_id = pictures.id
WHERE char_length(description) > 100
AND left(pictures.added_on, 4) < 2019
AND products.price > 20
ORDER BY products.price DESC;