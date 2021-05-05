SELECT `country_name`, `iso_code` FROM `countries`
WHERE length(lower(`country_name`)) - length(replace(lower(`country_name`), 'a', '')) >= 3
ORDER BY `iso_code`; 