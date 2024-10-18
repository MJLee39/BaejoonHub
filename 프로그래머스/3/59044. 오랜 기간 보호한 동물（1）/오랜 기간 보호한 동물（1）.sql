-- 코드를 입력하세요
select name, datetime 
from(SELECT i.name, i.DATETIME 
    from ANIMAL_INS i, ANIMAL_OUTS o 
    where i.ANIMAL_ID = o.ANIMAL_ID(+) and 
    o.ANIMAL_ID is null 
    order by DATETIME)
where rownum <= 3;
