-- 코드를 입력하세요
SELECT distinct(c.car_id) 
from CAR_RENTAL_COMPANY_CAR c, CAR_RENTAL_COMPANY_RENTAL_HISTORY r 
where c.car_id = r.car_id and 
CAR_TYPE = '세단' and 
START_DATE between to_date('2022-10-01','YYYY-MM-DD') and 
to_date('2022-10-31','YYYY-MM-DD') 
order by c.car_id desc;