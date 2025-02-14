SELECT 
    ROUTE, 
    CONCAT(ROUND(SUM(D_BETWEEN_DIST), 1), "km") AS TOTAL_DISTANCE,
    CONCAT(ROUND(SUM(D_BETWEEN_DIST) / COUNT(D_BETWEEN_DIST), 2), "km") AS AVERAGE_DISTANCE
FROM 
    SUBWAY_DISTANCE
GROUP BY 
    ROUTE
ORDER BY 
    ROUND(SUM(D_BETWEEN_DIST), 1) desc