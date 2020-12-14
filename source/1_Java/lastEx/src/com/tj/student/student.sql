DROP TABLE STUDENT;
DROP TABLE MAJOR;
DROP SEQUENCE STUDENT_SEQ;
CREATE TABLE MAJOR(
    mNO NUMBER(1,0),
    mNAME VARCHAR2(50),
    PRIMARY KEY(mNO));
CREATE SEQUENCE STUDENT_SEQ MAXVALUE 999 NOCACHE NOCYCLE;
CREATE TABLE STUDENT(
    sNO VARCHAR2(10),
    sNAME VARCHAR2(50),
    mNO NUMBER(1,0),
    SCORE NUMBER(3,0) DEFAULT 0 CHECK(SCORE>=0 AND SCORE<=100),
    sEXPEL NUMBER(1,0) DEFAULT 0 CHECK(sEXPEL=0 OR sEXPEL=1),
    PRIMARY KEY(sNO),
    FOREIGN KEY(mNO) REFERENCES MAJOR(mNO));
INSERT INTO MAJOR VALUES (1, '��ǻ�Ͱ���');
INSERT INTO MAJOR VALUES (2, '�濵������');
INSERT INTO MAJOR VALUES (3, '���������');
INSERT INTO MAJOR VALUES (4, '����������');
INSERT INTO MAJOR VALUES (5, '���ؿ�ȭ��');
COMMIT;
SELECT * FROM MAJOR;
-- �ܼ� StudentMng
-- 1��. �̸�, ������, ������ �Է¹޾� 
--    �й��� �������� �̿��Ͽ� "����⵵||�а���ȣ||������ȣ"�� �Է��Ѵ�
SELECT * FROM STUDENT;
INSERT INTO STUDENT (sNO, sNAME, mNO, SCORE) VALUES
    (TO_CHAR(SYSDATE, 'YYYY')
    ||(SELECT mNO FROM MAJOR WHERE mNAME='��ǻ�Ͱ���')
    ||TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL,'000')),
    '���켺',(SELECT mNO FROM MAJOR WHERE mNAME='��ǻ�Ͱ���'), 90) ;
SELECT * FROM STUDENT;
--2�� ������ ���ϴ� �а��̸��� �Է¹޾�
--    �а��� ��ȸ�� ������ �߰��Ͽ� ������ ���� ������ �̸�(��ȣ)�� ���
SELECT ROWNUM RANK, sNAME||'('||sNO||')' NAME_NO, mNAME, SCORE
    FROM (SELECT * FROM STUDENT S, MAJOR M WHERE S.mNO=m.mNO AND mNAME='��ǻ�Ͱ���'
            ORDER BY SCORE DESC);
--3�� ������  
--     ���������� ���� ��ü �л��� ��ȸ �� ������ ���� ������ �Ʒ��� ���� ����Ѵ�
--���     �̸�(studentID)         �а�      	����
--������������������������������������������������
--1��    	������(20205005)     ���ؿ�ȭ��     	100
SELECT ROWNUM RANK, sNAME||'('||sNO||')' NAME_NO, mNAME, SCORE
    FROM (SELECT * FROM STUDENT S, MAJOR M WHERE S.mNO=m.mNO AND sEXPEL=0
            ORDER BY SCORE DESC);

-- ����StudentMng���� �ʿ��� Query
-- 0. ùȭ�鿡 �����̸��� �޺��ڽ��� �߰�(mName)
SELECT MNAME FROM MAJOR;
-- 1. �й��˻� (sNo, sName, mName, score)
SELECT SNO, SNAME, MNAME, SCORE FROM STUDENT S, MAJOR M 
    WHERE S.MNO=M.MNO AND SNO='20201001';
-- 2. �̸��˻� (sNo, sName, mName, score)
SELECT SNO, SNAME, MNAME, SCORE FROM STUDENT S, MAJOR M 
    WHERE S.MNO=M.MNO AND SNAME='���켺';
-- 3. �����˻� (rank, name_no, mName, score) - 1 ������(20205005) ���ؿ�ȭ��(5) 100
SELECT ROWNUM RANK, sNAME||'('||sNO||')' NAME_NO, mNAME||'('||mNO||')' mNAME, SCORE
    FROM (SELECT S.*, MNAME FROM STUDENT S, MAJOR M 
            WHERE S.mNO=m.mNO AND mNAME='��ǻ�Ͱ���'
            ORDER BY SCORE DESC);
-- 4. �л��Է�
INSERT INTO STUDENT (sNO, sNAME, mNO, SCORE) VALUES
    (TO_CHAR(SYSDATE, 'YYYY')
    ||(SELECT mNO FROM MAJOR WHERE mNAME='���ؿ�ȭ��')
    ||TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL,'000')),
    '�ű浿',(SELECT mNO FROM MAJOR WHERE mNAME='���ؿ�ȭ��'), 40);
COMMIT;
-- 5. �л�����
UPDATE STUDENT SET  sNAME='�ű浿', 
                    mNO=(SELECT mNO FROM MAJOR WHERE mNAME='���������'),
                    SCORE = 70
                WHERE SNO='20205008';
COMMIT;
-- 6. �л���� (rank, name_no, mName, score) - 1 ������(20205005) ���ؿ�ȭ��(5) 100
SELECT ROWNUM RANK, sNAME||'('||sNO||')' NAME_NO, mNAME||'('||MNO||')' MNAME, SCORE
    FROM (SELECT S.*, MNAME FROM STUDENT S, MAJOR M 
            WHERE S.mNO=m.mNO AND sEXPEL=0
            ORDER BY SCORE DESC);
-- 7. ���������  (rank, name_no, mName, score) - 1 ������(20205005) ���ؿ�ȭ��(5) 100
SELECT ROWNUM RANK, sNAME||'('||sNO||')' NAME_NO, mNAME||'('||mNO||')' mNAME, SCORE
    FROM (SELECT S.*, mNAME FROM STUDENT S, MAJOR M 
            WHERE S.mNO=m.mNO AND sEXPEL=1
            ORDER BY SCORE DESC);
-- 8. ����ó��
UPDATE STUDENT SET sEXPEL = 1 WHERE SNO=20201004;

