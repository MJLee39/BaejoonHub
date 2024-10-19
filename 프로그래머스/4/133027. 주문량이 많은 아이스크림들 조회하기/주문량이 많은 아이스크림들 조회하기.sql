-- 코드를 입력하세요
select flavor from (
    SELECT j.FLAVOR 
    from FIRST_HALF f, JULY j 
    where f.flavor = j.flavor 
    group by j.FLAVOR 
    order by sum(f.TOTAL_ORDER + j.TOTAL_ORDER) desc
) 
where rownum <= 3;
