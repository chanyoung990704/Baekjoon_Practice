-- 결과를 저장할 COUNT 컬럼을 가진 단일 행 쿼리
SELECT COUNT(*) AS COUNT
FROM ECOLI_DATA
WHERE 
    -- 2번 형질이 없어야 함 (비트 AND 연산 결과가 0)
    (GENOTYPE & 2) = 0
    AND 
    -- 1번 또는 3번 형질이 있어야 함 (비트 AND 연산 결과가 0이 아님)
    ((GENOTYPE & 1) > 0 OR (GENOTYPE & 4) > 0)
