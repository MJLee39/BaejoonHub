-- 코드를 입력하세요
SELECT car_id, 
NVL2(MAX(case when 
         to_date('2022-10-16','YYYY-MM-DD') 
         between start_date and end_date 
         then 1 else NULL end
        ),
'대여중','대여 가능') as AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
group by car_id 
order by car_id desc;