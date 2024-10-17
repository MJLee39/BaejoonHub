-- 코드를 입력하세요
SELECT user_id, nickname, 
city||' '||street_address1||' '||street_address2 전체주소, 
substr(tlno,1,3)||'-'||substr(tlno,4,4)||'-'||substr(tlno,8,4) 전화번호 
from USED_GOODS_BOARD b, USED_GOODS_USER u
where WRITER_ID = user_id 
group by user_id, nickname, street_address1, street_address2, tlno, city
having count(board_id) >= 3
order by user_id desc;