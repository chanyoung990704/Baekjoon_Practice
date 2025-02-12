-- 코드를 작성해주세요
select i.ITEM_ID AS ITEM_ID, ITEM_NAME
from item_info i
join item_tree t on i.item_id = t.item_id
where parent_item_id is NULL
order by i.item_id