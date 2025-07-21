SELECT 
    MONTH(start_date) AS MONTH,
    car_id AS CAR_ID,
    COUNT(*) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE start_date >= '2022-08-01' 
  AND start_date <= '2022-10-31'
  AND car_id IN (
      SELECT car_id
      FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
      WHERE start_date >= '2022-08-01' 
        AND start_date <= '2022-10-31'
      GROUP BY car_id
      HAVING COUNT(*) >= 5
  )
GROUP BY MONTH(start_date), car_id
HAVING COUNT(*) > 0
ORDER BY MONTH(start_date) ASC, car_id DESC;