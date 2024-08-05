CREATE TABLE board(
seq NUMBER,
title VARCHAR2(50),
writer VARCHAR2(50),
contents VARCHAR2(200),
regdat DATE,
hitcount NUMBER
);

INSERT INTO board VALUES(1, 'a1', 'a', 'a', sysdate, 0);
INSERT INTO board VALUES(2, 'a2', 'a', 'a', sysdate, 0);
INSERT INTO board VALUES(3, 'a3', 'a', 'a', sysdate, 0);
INSERT INTO board VALUES(4, 'a4', 'a', 'a', sysdate, 0);
INSERT INTO board VALUES(5, 'a5', 'a', 'a', sysdate, 0);
INSERT INTO board VALUES(6, 'a6', 'a', 'a', sysdate, 0);
INSERT INTO board VALUES(7, 'a7', 'a', 'a', sysdate, 0);
INSERT INTO board VALUES(8, 'a8', 'a', 'a', sysdate, 0);
INSERT INTO board VALUES(9, 'a9', 'a', 'a', sysdate, 0);
INSERT INTO board VALUES(10, 'a10', 'a', 'a', sysdate, 0);

SELECT * FROM board;
SELECT ROWNUM, bt.*
FROM (SELECT * FROM board WHERE SEQ <= 5 ORDER BY SEQ DESC) bt
WHERE ROWNUM <= 5;

SELECT * FROM (
SELECT ROWNUM AS ROW_NUM, temp.*
FROM (SELECT * FROM board
            ORDER BY seq DESC) temp
)
WHERE ROW_NUM BETWEEN 6 AND 10;

delete FROM board;
commit;

CREATE SEQUENCE board_seq;

INSERT INTO board VALUES(board_seq.nextval, 'a1', 'a', 'a', sysdate, 0);
INSERT INTO board(seq, title, writer, contents, regdat, hitcount)
(select board_seq.nextval, title, writer, contents, regdat, hitcount from board);

ALTER TABLE board add constraint board_seq_pk PRIMARY KEY(seq);

SELECT count(*) From board;

explain plan
set statement_id = 'qwe'
for SELECT * FROM board
where seq = 9999;

SELECT * FROM TABLE(DBMS_XPLAN.DISPLAY('PLAN_TABLE','qwe','ALL'));
