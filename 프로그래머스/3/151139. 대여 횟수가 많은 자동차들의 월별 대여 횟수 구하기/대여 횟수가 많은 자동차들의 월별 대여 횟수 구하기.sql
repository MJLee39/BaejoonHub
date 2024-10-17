-- 코드를 입력하세요
SELECT to_number(to_char(START_DATE,'MM')) as month, 
car_id, 
count(*) as records 
from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
where (START_DATE between to_date('2022-08-01','YYYY-MM-DD') and 
    to_date('2022-10-31','YYYY-MM-DD')) and 
    car_id in (select car_id from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
              where (START_DATE between to_date('2022-08-01','YYYY-MM-DD') and 
                       to_date('2022-10-31','YYYY-MM-DD'))
                group by car_id 
                having count(*) >= 5)
group by to_number(to_char(START_DATE,'MM')), car_id 
order by month asc, car_id desc;