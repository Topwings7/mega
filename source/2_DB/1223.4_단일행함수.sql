-- 2019.12.20 ~ 12.23 4�� ������ �Լ� (�ݴ븻 : �������Լ�=�׷��Լ�)
SELECT ENAME, TO_CHAR(HIREDATE, 'YY-MM-DD DY"����" AM HH:MI:SS') FROM EMP; -- ������
SELECT SUM(SAL) FROM EMP; -- EMP���̺��� SAL���� �� - �׷��Լ�(�������Լ�)
SELECT DEPTNO, SUM(SAL) FROM EMP GROUP BY DEPTNO;
-- ������ �Լ��� ���� : ���ڰ����Լ�, ����ó���Լ�, ��¥�����Լ�, ����ȯ�Լ�, VNL(), DECODE�Լ�, ETC..
-- (1)���ڰ����Լ�
SELECT ABS(-9) FROM DUAL;
-- �ƹ� �ǹ� ���� 1��¥�� ���̺� : DUAL
SELECT * FROM DUAL;
SELECT FLOOR(34.5678) FROM DUAL; -- �Ҽ��� ���ϸ� ����
SELECT FLOOR(34.5678*10)/10 FROM DUAL;
SELECT TRUNC(34.5678, 2) FROM DUAL; -- �Ҽ��� ���ڸ����� ����
SELECT TRUNC(156.54, -1) FROM DUAL; -- 150
SELECT TRUNC(156.54, -2) FROM DUAL; -- 100
-- �̸�, SAL(�����ڸ��������� ���)
SELECT ENAME, TRUNC(SAL, -3) FROM EMP;
SELECT ROUND(34.5678) FROM DUAL;-- �Ҽ������� �ݿø�
SELECT ROUND(34.5678,1) FROM DUAL; -- �Ҽ��� ���ڸ����� , �ݿø�
SELECT ROUND(34.5678,3) FROM DUAL;
SELECT ROUND(34.5678, -1) FROM DUAL; -- 30
-- �̸�, SAL(�����ڸ� �ݿø� ���)
SELECT ENAME, ROUND(SAL, -3) FROM EMP;
SELECT CEIL(34.5678) FROM DUAL; -- �Ҽ��� �ø�
SELECT FLOOR(10/4) FROM DUAL;
SELECT POWER(3,2) FROM DUAL; -- 3�� 2�� = 9
SELECT MOD('9',6) FROM DUAL;
-- Ȧ���޿� �Ի��� �������� ��� �ʵ� ���
SELECT * FROM EMP WHERE MOD(TO_CHAR(HIREDATE, 'MM'),2) = 1;

-- (2) ���ڰ����Լ�
SELECT UPPER('abcABC') FROM DUAL;-- �빮�ڷ�
SELECT LOWER('abcABC') FROM DUAL; -- �ҹ��ڷ�
SELECT INITCAP('abcABC') FROM DUAL;-- ù��°���ڸ� �빮��, �������� �ҹ���
-- JOB�� MANAGER�� ������ ��� �ʵ�
SELECT * FROM EMP WHERE UPPER(JOB)='MANAGER';
SELECT EMPNO, LOWER(JOB) FROM EMP WHERE LOWER(JOB)='manager';
SELECT EMPNO, INITCAP(ENAME), INITCAP(JOB) FROM EMP;
-- CONCAT(A, B)
SELECT CONCAT(CONCAT('AB','CD'),'EF') FROM DUAL;
SELECT CONCAT('ABC','DEF') FROM DUAL;
SELECT CONCAT(CONCAT('ABC','DEF'),'GHI') FROM DUAL;
-- XXX�� JOB�̴�
SELECT CONCAT(CONCAT(ENAME, '�� '),CONCAT(JOB,'�̴�')) TITLE FROM EMP;
-- SUBSTR(str, ������ ��ġ, ������ ����) ù��° ��ġ�� 1.
-- SUBSTRB(str, ������ ��ġ, ������ ����)
SELECT SUBSTR('welcome to Oracle',3,2) FROM DUAL; -- lc
--             123456789
SELECT SUBSTR('welcome to Oracle',-3,2) FROM DUAL; -- ������ ��ġ�� ������ ��� -1�� ���� ��
-- �츮�� �ý��ۿ����� ��¥ ���� : 81/01/02
-- SUBSTR�Լ��� �̿��ؼ� ¦�����ڿ� �Ի��� ������ ��� �ʵ� ���
SELECT * FROM EMP WHERE MOD(SUBSTR(HIREDATE, -2, 2),2)=0; --SUBSTR(HIREDATE, -2, 2):����
SELECT SUBSTR('�����ͺ��̽�',2,2) FROM DUAL; -- ����
SELECT SUBSTRB('�����ͺ��̽�',4,6) FROM DUAL; -- B(BYTE) 
-- 9���� �Ի��� ����� ��� �ʵ带 ���
SELECT * FROM EMP WHERE HIREDATE LIKE '%/09/%'; -- LIKE
SELECT * FROM EMP WHERE SUBSTR(HIREDATE, 4, 2)='09'; -- SUBSTR()�Լ� '81/01/01'
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'MM')= '09'; -- TO_CHAR() �Լ�
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'MM')=9;
SELECT SUBSTR('ABCD',2,3) FROM DUAL;  -- 2��° ��ġ�� ���ں��� 3���� ��� : BCD
SELECT SUBSTRB('ABCD',2,3) FROM DUAL; -- 2��° BYTE ��ġ���� 3BYTE ��� : BCD
SELECT SUBSTR('����Ŭ���',2,3) FROM DUAL; -- 2��° ��ġ���ں��� 3���� : ��Ŭ��
SELECT SUBSTRB('����Ŭ���',4,6) FROM DUAL; -- 4��° BYTE��ġ 3BYTE ��� 
-- LENGTH(����):������ ���̼�, LENGTHB(����):������ BYTE��
SELECT LENGTH('ABCD'), LENGTHB('ABCD') FROM DUAL;
SELECT LENGTH('����Ŭ'), LENGTHB('����Ŭ') FROM DUAL;
-- INSTR(string, ã������) : string���� ã�������� ��ġ
-- INSTR(string, ã������, ������ġ) : ������ġ���� string���� ã�������� ��ġ
-- INSTR(string, ã������, ������ġ, K) : string���� ������ġ���� K��° ������ ã�������� ��ġ
SELECT INSTR('ABCABCABC','B') FROM DUAL;   -- 2
SELECT INSTR('ABCABCABC','B',3) FROM DUAL; -- 5
SELECT INSTR('ABCABCABC','B',3,2) FROM DUAL; -- 3��° ��ġ���� 3��° ������ 'B'�� ��ġ�� : 8
-- 9���� �Ի��� ������ ��� �ʵ� ���
SELECT * FROM EMP WHERE INSTR(HIREDATE, '09')=4;
-- LPAD(����, 10, '*')  - ���ڸ� 10�ڸ� Ȯ���ϰ� ���� ���ڸ� *�� ä��ϴ�
SELECT LPAD('ORACLE', 20, '#') FROM DUAL;
-- RPAD(����, 10, '*') - ���ڸ� 10�ڸ� Ȯ���ϰ� ������ ���ڸ��� *�� ä��ϴ�
SELECT RPAD('ORACLE',20, '*') FROM DUAL;
SELECT ENAME, LPAD(SAL, 6, '*') FROM EMP;
-- TRIM, LTRIM, RTRIM
SELECT TRIM('   ORACLE DB   ') FROM DUAL;
SELECT LTRIM('   ORACLE DB   '), RTRIM('    ORACLE DB   ') FROM DUAL;
SELECT TRIM('_' FROM '___ORACLE DB_____') FROM DUAL;
-- REPLACE(����, ������, �ٲܱ���)
SELECT REPLACE('abcabc','a','999') FROM DUAL;
-- źź������
-- 83�⵵�� �Ի��� ������ ��� �ʵ� ����ϱ�
-- SUBSTR, INSTR, TO_CHAR, LIKE
SELECT * FROM EMP WHERE SUBSTR(HIREDATE, 1, 2)='83';
SELECT * FROM EMP WHERE INSTR(HIREDATE, '83')=1;
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'YY')='83';
SELECT * FROM EMP WHERE HIREDATE LIKE '%83%';
-- �̸��� E�� ������ ����� ��� �ʵ� ����ϱ�(SUBSTR, INSTR, LIKE)
SELECT * FROM EMP WHERE ENAME LIKE '%E';
SELECT * FROM EMP WHERE SUBSTR(ENAME, -1,1)='E';
SELECT * FROM EMP WHERE INSTR(ENAME, 'E', LENGTH(ENAME))=LENGTH(ENAME);
-- �̸��� E�� ������ ����� �̸�(****E) ����ϱ�
SELECT ENAME, LPAD(SUBSTR(ENAME, -1,1), LENGTH(ENAME), '*') FROM EMP
    WHERE ENAME LIKE '%E';
-- ���, �̸�(S****), ��å, �Ի���(81/09/**)
SELECT EMPNO, ENAME, JOB, HIREDATE FROM EMP;
SELECT EMPNO, RPAD(SUBSTR(ENAME, 1, 1), LENGTH(ENAME), '*'), JOB,
    RPAD(SUBSTR(HIREDATE, 1, 6), 8, '*') FROM EMP;
SELECT TO_CHAR(HIREDATE, 'YY/MM/**') FROM EMP;
-- ���, �̸�, ��å�� ���(��å�� �̸��� ���ڿ� ����ŭ�� ǥ��)
SELECT EMPNO, ENAME, SUBSTR(JOB, 1, LENGTH(ENAME)) FROM EMP;
-- 82��12���� �Ի��� �������� ��� �ʵ带 ���
SELECT * FROM EMP WHERE HIREDATE BETWEEN '82/12/01' AND '82/12/31';
SELECT * FROM EMP WHERE HIREDATE LIKE '82/12/%';
SELECT * FROM EMP WHERE SUBSTR(HIREDATE, 1, 5)='82/12';
SELECT * FROM EMP WHERE INSTR(HIREDATE, '82/12')=1;
-- �̸��� ����° ���ڰ� R�� ����� �̸��� ��� ( LIKE, SUBSTR, INSTR)
SELECT ENAME FROM EMP WHERE ENAME LIKE '__R%';
SELECT ENAME FROM EMP WHERE SUBSTR(ENAME, 3, 1) = 'R';
SELECT ENAME FROM EMP WHERE INSTR(ENAME, 'R', 3)=3;

-- (3) ��¥���� ������ �Լ�
SELECT SYSDATE "��������" FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YY-MM-DD DY"����" HH24:MI:SS') FROM DUAL;
SELECT SYSDATE-1 "����", SYSDATE "����", SYSDATE+1 "����" FROM DUAL;
SELECT TO_CHAR(SYSDATE+14, 'YY-MM-DD HH24') FROM DUAL;
-- �̸�, �Ի���, �ٹ�����
SELECT ENAME, HIREDATE, FLOOR(SYSDATE-HIREDATE) "�ٹ�����" FROM EMP;
SELECT ENAME, HIREDATE, TRUNC(SYSDATE-HIREDATE) "�ٹ�����" FROM EMP;
SELECT ENAME, HIREDATE, TRUNC((SYSDATE-HIREDATE)/365) "�ٹ����" FROM EMP;
-- MONTHS_BETWEEN(Ư����¥, Ư����¥) ; �� ��¥���� ������
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) "�ٹ��޼�" FROM EMP;
SELECT ENAME, TRUNC(MONTHS_BETWEEN(HIREDATE, SYSDATE)) FROM EMP;
-- ADD_MONTHS(Ư����¥, N) ; Ư����¥����  N������
-- ENAME, HIREDATE(�Ի���), �����Ⱓ��������(������ �Ի��� 6��������)
SELECT ENAME, HIREDATE, ADD_MONTHS(HIREDATE, 6) FROM EMP;
-- NEXT_DAY(Ư����¥, '��') Ư����¥�� ó�� �����ϴ� ��
SELECT SYSDATE, NEXT_DAY(SYSDATE, '�����') FROM DUAL;
-- ����̸�, �Ի���, �Ի��� �´� ù�ָ�
SELECT ENAME, HIREDATE, NEXT_DAY(HIREDATE, '��') FROM EMP;
-- LAST_DAY(Ư����¥) ; Ư����¥�� ���� ����
-- ENAME, �Ի���, ���޳�(����)
SELECT ENAME, HIREDATE, LAST_DAY(HIREDATE) "31����" FROM EMP;
-- �̴��� ����
SELECT LAST_DAY(SYSDATE) FROM DUAL;
-- ROUND(�ݿø�), TRUNC(����) - YEAR, MONTH, DAY, ����
SELECT ROUND(SYSDATE, 'YEAR') FROM DUAL; -- YEAR �ݿø� ��� : ����� 1��1��
SELECT TRUNC(SYSDATE, 'YEAR') FROM DUAL; -- YEAR ����   ��� : ���� 1��1��
SELECT ROUND(SYSDATE, 'MONTH') FROM DUAL; -- MONTH �ݿø� ��� : ����� 1��
SELECT TRUNC(SYSDATE, 'MONTH') FROM DUAL; -- MONTH ���� ��� : �̹��� 1��
SELECT ROUND(SYSDATE, 'DAY') FROM DUAL; -- DAY �ݿø� ��� : �� �Ͽ���
SELECT ROUND(TO_DATE('191226','YYMMDD'), 'DAY') FROM DUAL;-- DAY �ݿø� ��� : ����� �Ͽ���
SELECT TRUNC(TO_DATE('191222','YYMMDD'), 'DAY') FROM DUAL; 
--DEFAULT �ݿø���� : 0��0��0��
SELECT TO_CHAR(ROUND(SYSDATE),'YY-MM-DD HH24:MI:SS') FROM DUAL;
SELECT TO_CHAR(TRUNC(SYSDATE), 'YY-MM_DD HH24:MI:SS') FROM DUAL;
-- źź������
-- ENAME, �Ի���, �Ի��ϴ��� 1��
SELECT ENAME, HIREDATE, TRUNC(HIREDATE, 'MONTH') FROM EMP;
-- ENAME, �Ի���, ���޳�(����)
SELECT ENAME, HIREDATE, LAST_DAY(HIREDATE) FROM EMP;
-- ENAME, �Ի���, ���޳�(25��)
SELECT ENAME, HIREDATE, ROUND(HIREDATE-9, 'MONTH')+24 "���޳�" FROM EMP;
SELECT SYSDATE-1, SYSDATE, SYSDATE+7 FROM DUAL; -- ��¥ ��� ����

-- ENAME, �Ի���, ���޳�(17��)
SELECT ENAME, HIREDATE, ROUND(HIREDATE-1, 'MONTH')+16 "���޳�" FROM EMP;

-- ENAME, �Ի���, SAL(����), �̶����� ���� ������
SELECT ENAME, HIREDATE, SAL, SAL*TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) FROM EMP;
-- ENAME, �Ի���, SAL, COMM, �̶����� ȸ�翡�� ���� ��
SELECT ENAME, HIREDATE, SAL, COMM,
    SAL*TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE))+NVL(COMM,0)*TRUNC((SYSDATE-HIREDATE)/365)
    FROM EMP;

-- (4) ����ȯ�Լ�
-- TO_CHAR(��¥, ����) ��¥�� ���ڷ�
-- YY(�⵵) MM(��) MON(���̸�) D(��) DY(����) AM(����/����) HH(12�ð�����) HH24(24�ð�����) MI(��) SS(��)
-- ���ϳ��� ���ĺ��̳� Ư������ ��� ���� �ܷ����� ��� ""�ȿ�
SELECT ENAME, SAL, TO_CHAR(HIREDATE, 'YYYY/MON/DD DY AM HH:MI:SS') FROM EMP;
SELECT TO_CHAR(SYSDATE, 'YY"��"MM"��"DD DY HH"��"MI"��"SS"��"') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'MM-DD') FROM DUAL;
-- TO_CHAR(����, ����) ���ڸ� ���ڷ�
-- ���ϳ� 0 (�ڸ���, �ڸ����� ���� ������ 0���� ä���)
--       9 (�ڸ���, �ڸ����� ���� ������ ä���� �ʴ´�)
--       L (���� ��ȭ���� ����)
--       $ ($ ��ȭ������ ����)
--       , (õ�������� ,�� ���̰� ���� ��)
SELECT ENAME, SAL, TO_CHAR(SAL, 'L000,000.0') FROM EMP;
SELECT ENAME, SAL, TO_CHAR(SAL, '$999,999.9') FROM EMP;

-- TO_DATE(����, ����) ���ڸ� ��¥���� '191216'
-- DATE_FORMET�� �� ���¿��� 81��5��1�Ϻ��� 83�� 5��1�� ���̿� �Ի��� �������� ��� �ʵ�
SELECT * FROM EMP 
    WHERE HIREDATE BETWEEN TO_DATE('19810501','YYYYMMDD') AND
                        TO_DATE('19830501','YYYYMMDD');
-- 2019,8,1�κ��� ������ ����°����
SELECT CEIL(SYSDATE - TO_DATE('20190801','YYYYMMDD')) FROM DUAL;

-- TO_NUMBER(����, ����) ���ڸ� ���ڷ� '9,876' -> 9876
SELECT TO_NUMBER('1,000', '9,999') +1000 FROM DUAL;

-- (5) NULL ���� �Լ� = NVL(���ϼ��� �ִ� ������,���̸��ž���)
-- ����̸�, ����� �̸�(��簡 ������ 'CEO'��� ���)
SELECT W.ENAME "����̸�", NVL(M.ENAME,'CEO') "������̸�"
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO(+);
-- ����̸�, MGR(MGR�� NULL�̸� 'CEO'��� ���)
SELECT ENAME, NVL(TO_CHAR(MGR,'9999'),'CEO') MGR FROM EMP;
-- (6) DECODE(������, ��1, ���1, ��2, ���2, ��3, ���3, ....., ��N,���N, �׿ܰ��)
SELECT ENAME, E.DEPTNO, DNAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO;
SELECT ENAME, DEPTNO, DECODE(DEPTNO, 10, 'ACCOUNTING', 20, 'RESEARCH', 30, 'SALES',
                                     40, 'OPERATIONS') AS "DNAME" FROM EMP;
SELECT ENAME, DEPTNO, CASE WHEN DEPTNO=10 THEN 'ACCOUNTING'
                           WHEN DEPTNO=20 THEN 'RESEARCH'
                           WHEN DEPTNO=30 THEN 'SALES'
                           WHEN DEPTNO=40 THEN 'OPERATIONS'
                           ELSE 'ETC' END AS "DNAME" FROM EMP;
SELECT ENAME, DEPTNO, CASE DEPTNO WHEN 10 THEN 'ACCOUNTING'
                                  WHEN 20 THEN 'RESEARCH'
                                  WHEN 30 THEN 'SALES'
                                  WHEN 40 THEN 'OPERATION' END DNAME FROM EMP;
-- ������ SAL�� �̿��ؼ� ������ SAL�� JOB�� ���� 'ANALYST' 10%�λ� 'SALESMAN' 20%�λ�, 
                                           --'MANAGER' 30%�λ� 'CLERK' 40%�λ�
                                           -- �׿ܴ� ��������
-- ���, �̸�, ������ SAL, �λ�� SAL
SELECT EMPNO, ENAME, SAL, CASE WHEN JOB='ANALYST' THEN SAL*1.1
                            WHEN JOB='SALESMAN' THEN SAL*1.2
                            WHEN JOB='MANAGER' THEN SAL*1.3
                            WHEN JOB='CLERK' THEN SAL*1.4
                            ELSE SAL END "�λ�� SAL" FROM EMP;
SELECT EMPNO, ENAME, SAL, CASE JOB WHEN 'ANALYST' THEN SAL*1.1
                            WHEN 'SALESMAN' THEN SAL*1.2
                            WHEN 'MANAGER' THEN SAL*1.3
                            WHEN 'CLERK' THEN SAL*1.4
                            ELSE SAL END "�λ�� SAL" FROM EMP;
SELECT EMPNO, ENAME, SAL, DECODE(JOB, 'ANALYST', SAL*1.1, 'SALESMAN', SAL*1.2,
                    'MANAGER', SAL*1.3, 'CLERK', SAL*1.4, SAL) "�λ�� SAL" FROM EMP;
-- �Ի��� �⵵��
SELECT ENAME, TO_CHAR(HIREDATE, 'YYYY') FROM EMP; -- '1980'
SELECT ENAME, EXTRACT(YEAR FROM HIREDATE) FROM EMP; -- �⵵(1980)�� �����ϴ� �Լ�
SELECT ENAME, EXTRACT(MONTH FROM HIREDATE) FROM EMP;

-- (7) �׿�
-- LEVEL, START WITH, CONNECT BY PRIOR
SELECT LEVEL, LPAD(' ', LEVEL*2)||'>'||ENAME, MGR FROM EMP
    START WITH MGR IS NULL
    CONNECT BY PRIOR EMPNO=MGR; -- �������� �Ʒ������� ���� ����
-- <�� ��������>
-- 1. ���� ��¥�� ����ϰ� TITLE�� ��Current Date���� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT SYSDATE "Current Date" FROM DUAL;

-- 2. EMP ���̺��� ���� �޿��� 15%�� ������ �޿��� ����Ͽ�,
-- �����ȣ,�̸�,����,�޿�,������ �޿�(New Salary),������(Increase)�� ����ϴ� SELECT ����
SELECT EMPNO, ENAME, JOB, SAL, SAL*1.15 "������ �޿�(New Salary)",SAL*0.15 "������(Increase)" 
    FROM EMP;
--3. �̸�, �Ի���, �Ի��Ϸκ��� 6���� �� ���ƿ��� ������ ���Ͽ� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME, HIREDATE, NEXT_DAY(ADD_MONTHS(HIREDATE, 6), '��') "6������ ������" FROM EMP;

--4. �̸�, �Ի���, �Ի��Ϸκ��� ��������� ������, �޿�, �Ի��Ϻ��� ��������� ���� �޿��� �Ѱ踦 ���
SELECT ENAME, HIREDATE, trunc(MONTHS_BETWEEN(SYSDATE, HIREDATE)) ������, SAL, 
        MONTHS_BETWEEN(SYSDATE, HIREDATE)*SAL �޿��Ѱ� 
    FROM EMP;
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) ������, SAL, 
        TO_CHAR(TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE))*SAL, 'L9,999,999') �޿��Ѱ� 
    FROM EMP;
--5. ��� ����� �̸��� �޿�(15�ڸ��� ��� ������ �� ���� ��*���� ��ġ)�� ���
SELECT ENAME, LPAD(SAL, 15, '*') FROM EMP;
--6. ��� ����� ������ �̸�,����,�Ի���,�Ի��� ������ ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME, JOB, HIREDATE, TO_CHAR(HIREDATE, 'DAY') from EMP;
SELECT ENAME, JOB, HIREDATE, TO_CHAR(HIREDATE, 'DY"����"') from EMP;

--7. �̸��� ���̰� 6�� �̻��� ����� ������ �̸�,�̸��� ���ڼ�,������ ���
SELECT ENAME, LENGTH(ENAME), JOB FROM EMP WHERE LENGTH(ENAME)>= 6;
--8. ��� ����� ������ �̸�, ����, �޿�, ���ʽ�, �޿�+���ʽ��� ���
SELECT ENAME, JOB, SAL �޿�, COMM ���ʽ�, SAL+NVL(COMM,0) "�޿�+���ʽ�" FROM EMP;
-- 9.��� ���̺��� ������� 2��° ���ں��� 3���� ���ڸ� �����Ͻÿ�. 
SELECT  ENAME, SUBSTR(ENAME, 2,3) FROM EMP;

--10. ��� ���̺��� �Ի����� 12���� ����� ���, �����, �Ի����� �˻��Ͻÿ�. 
SELECT EMPNO, ENAME, HIREDATE FROM EMP WHERE HIREDATE LIKE '%/12/%';
SELECT EMPNO, ENAME, HIREDATE FROM EMP WHERE SUBSTR(HIREDATE, 4,2)='12'; 
SELECT EMPNO, ENAME, HIREDATE FROM EMP WHERE INSTR(HIREDATE, '12', 4)=4;
--  �ý��ۿ� ���� DATEFORMAT �ٸ� �� �����Ƿ� �Ʒ��� ����� �˾ƺ���
SELECT EMPNO, ENAME, HIREDATE FROM EMP WHERE EXTRACT(MONTH FROM HIREDATE)=12;
SELECT EMPNO, ENAME, HIREDATE FROM EMP WHERE TO_CHAR(HIREDATE, 'MM') = '12';

--11. ������ ���� ����� �˻��� �� �ִ� SQL ������ �ۼ��Ͻÿ�
--EMPNO		ENAME		�޿�
--7369		SMITH		*******800
--7499		ALLEN		******1600
--7521		WARD		******1250
--����.
SELECT EMPNO, ENAME, LPAD(SAL, 10, '*') �޿� FROM EMP;
-- 12. ������ ���� ����� �˻��� �� �ִ� SQL ������ �ۼ��Ͻÿ�
-- EMPNO	 ENAME 	�Ի���
-- 7369	  SMITH		1980-12-17
-- ��.
SELECT EMPNO, ENAME, TO_CHAR(HIREDATE, 'YYYY-MM-DD') �Ի��� FROM EMP;

-- 13. ��� ���̺��� �޿��� ���� ���, �̸�, �޿�, ����� �˻��ϴ� SQL ������ �ۼ� �Ͻ� ��.
-- �޿��� 0~1000 E / 1001~2000 D / 2001~3000 C / 3001~4000 B / 4001~5000 A
SELECT EMPNO, ENAME, SAL,
 			 CASE WHEN SAL BETWEEN    0 AND 1000 THEN 'E'
                  WHEN SAL BETWEEN 1001 AND 2000 THEN 'D'
          		  WHEN SAL BETWEEN 2001 AND 3000 THEN 'C'
                  WHEN SAL BETWEEN 3001 AND 4000 THEN 'B'
                  WHEN SAL BETWEEN 4001 AND 5000 THEN 'A' END ��� FROM EMP;
SELECT EMPNO, ENAME, SAL,
  			CASE WHEN SAL >= 0 AND SAL<= 1000 THEN 'E'
                 WHEN SAL >= 1001 AND SAL<= 2000 THEN 'D'
                 WHEN SAL >= 2001 AND SAL<= 3000 THEN 'C'
                 WHEN SAL >= 3001 AND SAL<= 4000 THEN 'B'
                 WHEN SAL >= 4001 AND SAL<=5000 THEN 'A' END ��� FROM EMP;
SELECT EMPNO, ENAME, SAL,
  			CASE TRUNC((SAL-1)/1000) WHEN 0 THEN 'E' 
                                     WHEN 1 THEN 'D'
                                     WHEN 2 THEN 'C' 
                                     WHEN 3 THEN 'B' 
            ELSE 'A' END ��� FROM EMP;
SELECT EMPNO, ENAME, SAL, 
        DECODE(TRUNC((SAL-1)/1000), 0, 'E', 1, 'D', 2, 'C', 3, 'B', 'A') ��� 
    FROM EMP;
--------�޿���- 0~999 E / 1000~1999 D / 2000~2999 C / 3000~3999 B / 4000�̻� A
SELECT EMPNO, ENAME, SAL, 
        DECODE(TRUNC(SAL/1000), 0, 'E', 1, 'D', 2, 'C', 3, 'B', 'A') ��� 
    FROM EMP;
SELECT EMPNO, ENAME, SAL, CASE TRUNC(SAL/1000) WHEN 0 then 'E' 
                                               WHEN 1 THEN 'D' 
                                               WHEN 2 THEN 'C' 
                                               WHEN 3 THEN 'B'
                          ELSE 'A' END ��� FROM EMP;

--14. ��� ���̺��� �μ� ��ȣ�� 20�� ����� ���, �̸�, ����, �޿��� ����Ͻÿ�.
    --(�޿��� �տ� $�� �����ϰ�3�ڸ����� ,�� ����Ѵ�)
SELECT EMPNO, ENAME, JOB, TO_CHAR(SAL, '$9,999,999') FROM EMP 
    WHERE DEPTNO=20;
DESC EMP;

    
    
    
    
    