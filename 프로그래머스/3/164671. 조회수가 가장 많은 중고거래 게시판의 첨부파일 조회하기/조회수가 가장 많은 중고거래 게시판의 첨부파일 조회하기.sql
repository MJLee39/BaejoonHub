-- 코드를 입력하세요
SELECT '/home/grep/src/'||b.board_id||'/'||file_id||file_name||file_ext as FILE_PATH 
FROM used_goods_board b, used_goods_file f 
where b.board_id = f.board_id and 
views = (select max(views) from used_goods_board) 
order by file_id desc;