-- 코드를 입력하세요
SELECT a.AUTHOR_ID, AUTHOR_NAME, CATEGORY, sum(SALES*PRICE) as TOTAL_SALES 
from BOOK b, AUTHOR a, BOOK_SALES s 
where b.AUTHOR_ID = a.AUTHOR_ID and 
b.book_id = s.book_id and 
SALES_DATE between to_date('2022-01-01','YYYY-MM-DD') and 
to_date('2022-01-31','YYYY-MM-DD') 
group by a.AUTHOR_ID, AUTHOR_NAME, CATEGORY 
order by a.AUTHOR_ID, category desc;