select BOARD_ID, WRITER_ID, TITLE, PRICE,
    CASE
        WHEN STATUS = 'SALE' THEN '판매중'
        WHEN STATUS = 'RESERVED' THEN '예약중'
        WHEN STATUS = 'DONE' THEN '거래완료'
    END AS STATUS
from used_goods_board
where created_date LIKE '2022-10-05%'
order by BOARD_ID DESC