-- 코드를 입력하세요
SELECT 
    CASE
        WHEN PRICE < 10000 THEN 0
        ELSE FLOOR(PRICE / 10000) * 10000
    END AS PRICE_GROUP,
    COUNT(*) AS PRODUCTS
FROM PRODUCT
GROUP BY PRICE_GROUP
ORDER BY PRICE_GROUP