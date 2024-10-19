-- 코드를 입력하세요
SELECT CATEGORY, sum(sales) 
from BOOK b, BOOK_SALES s
where b.book_id = s.book_id and 
SALES_DATE between to_date('2022-01-01','YYYY-MM-DD') and 
to_date('2022-01-31','YYYY-MM-DD')
group by CATEGORY 
order by CATEGORY;