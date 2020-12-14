DROP TABLE MEMO CASCADE CONSTRAINTS;
DROP SEQUENCE MEMO_SQ;
CREATE TABLE MEMO(
    NUM     NUMBER(8) PRIMARY KEY,
    ID      VARCHAR2(30),
    CONTENT VARCHAR2(2000),
    RDATE   DATE DEFAULT SYSDATE NOT NULL,
    IP      VARCHAR2(30));
CREATE SEQUENCE MEMO_SQ NOCACHE NOCYCLE MAXVALUE 99999999;
-- 1. 메모 등록(memoInsert)
INSERT INTO MEMO (NUM, ID, CONTENT, IP) VALUES (MEMO_SQ.NEXTVAL, 'aaa','좋네요','192.168.20.31');
INSERT INTO MEMO (NUM, ID, CONTENT, IP) VALUES (MEMO_SQ.NEXTVAL, 'bbb','좋네요zz','192.168.20.31');
INSERT INTO MEMO (NUM, ID, CONTENT, IP) VALUES (MEMO_SQ.NEXTVAL, 'ccc','즐거운 봄','192.168.20.31');
commit;
-- 2. 메모 리스트(memoList)
SELECT * FROM MEMO ORDER BY NUM DESC;
SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM MEMO ORDER BY NUM DESC) A)
    WHERE RN BETWEEN 1 AND 3;
-- 3. 메모 갯수 (getCnt)
SELECT COUNT(*) FROM MEMO;
-- insert70을 위하여
alter system set processes=500 scope=spfile;
shutdown immediate;
startup;