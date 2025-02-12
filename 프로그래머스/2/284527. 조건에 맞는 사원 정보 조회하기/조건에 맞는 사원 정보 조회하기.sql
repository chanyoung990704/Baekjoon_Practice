-- 코드를 작성해주세요
select sum(score) as SCORE, 
e.emp_no AS EMP_NO, EMP_NAME, POSITION, EMAIL
from hr_employees e
join hr_grade g on e.emp_no = g.emp_no
group by e.emp_no
ORDER BY SCORE DESC
LIMIT 0,1