SELECT a.mac, COUNT(e.salt) AS salt_count
FROM account a
         JOIN encryptions e ON e.account_id = a.id
WHERE e.is_active = true
  AND LENGTH(e.salt) < 8
GROUP BY a.mac
ORDER BY a.mac ASC;


SELECT
    CASE
        WHEN c.is_promoted = 1 THEN CONCAT('[PROMOTED] ', c.name)
        ELSE c.name
        END AS name,
    c.phone,
    CASE
        WHEN c.is_promoted = 1 THEN NULL
        ELSE CONCAT(
                REPEAT('*', FLOOR(AVG(cat.review_rating))), ' ',
                '(', ROUND(AVG(cat.review_rating), 1), ', based on ',
                COUNT(cat.review_rating), ' reviews)'
            )
        END AS rating
FROM companies c
         LEFT JOIN categories cat ON cat.company_id = c.id
GROUP BY c.id, c.name, c.phone, c.is_promoted
ORDER BY
    c.is_promoted ASC,                   -- 0 (non-promoted) first
    AVG(cat.review_rating) DESC,        -- higher average rating next
    COUNT(cat.review_rating) DESC;      -- more reviews next
