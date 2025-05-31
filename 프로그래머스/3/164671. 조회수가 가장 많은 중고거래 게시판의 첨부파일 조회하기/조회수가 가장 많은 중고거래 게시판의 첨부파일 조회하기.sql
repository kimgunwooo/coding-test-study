-- -- 코드를 입력하세요

-- SELECT '/home/grep/src/'
--     || BOARD_FILE.BOARD_ID
--     || '/'
--     || FILE_ID
--     || FILE_NAME
--     || FILE_EXT                         AS "FILE_PATH"
--   FROM USED_GOODS_FILE  BOARD_FILE
--   JOIN USED_GOODS_BOARD BOARD
--     ON BOARD_FILE.BOARD_ID = BOARD.BOARD_ID
--  WHERE VIEWS IN (
--                   SELECT MAX(VIEWS)
--                     FROM USED_GOODS_BOARD
--                 )
--  ORDER BY FILE_PATH DESC

SELECT '/home/grep/src/'
    || B.BOARD_ID
    || '/'
    || B.FILE_ID
    || B.FILE_NAME
    || B.FILE_EXT  AS "FILE_PATH"
FROM 
(
    SELECT A.BOARD_ID
    FROM
    (
        SELECT
            BOARD_ID,
            RANK() OVER(ORDER BY VIEWS DESC) rn
        FROM USED_GOODS_BOARD
        ORDER BY VIEWS DESC
    ) A
    WHERE rn = 1
) C, USED_GOODS_FILE B
WHERE C.BOARD_ID = B.BOARD_ID
ORDER BY FILE_PATH DESC