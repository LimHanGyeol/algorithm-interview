-- Programmers
-- SQL - Level4
-- 우유와 요거트가 담긴 장바구니 (sql - leve4)
SELECT
    DISTINCT C1.CART_ID
FROM
    CART_PRODUCTS AS C1
JOIN
    CART_PRODUCTS AS C2
ON
    C1.CART_ID = C2.CART_ID
WHERE
    C1.NAME = 'Milk'
AND
    C2.NAME = 'Yogurt';
