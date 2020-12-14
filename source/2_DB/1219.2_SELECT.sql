-- SELECT �� (2019.12.19)
SELECT * FROM TAB; -- scott�� ������ �ִ� ��� ���̺�
SELECT * FROM EMP; -- emp ���̺��� ��� �ʵ�(��), ��� ������(��)
SELECT * FROM DEPT;
DESC DEPT; -- DEPT ���̺��� ����(�ʵ庰 Ÿ��)
SELECT EMPNO, ENAME, SAL, JOB FROM EMP; -- Ư�� �ʵ常 ���
SELECT EMPNO AS "���", ENAME AS "�̸�", SAL AS "�޿�", JOB AS "�۾�" FROM EMP;
SELECT EMPNO "���", ENAME "�̸�", SAL "�޿�", JOB "�۾�" FROM EMP; -- �ʵ� ����(�ѱ�)
SELECT EMPNO "NO", ENAME "NAME", SAL "SALARY", JOB "J" FROM EMP;
SELECT EMPNO AS "NO", ENAME AS NAME, SAL AS SALARY, JOB AS J FROM EMP;
SELECT EMPNO NUM, ENAME NAME, SAL SALARY, JOB J FROM EMP; -- �ʵ庰��(����)
SELECT EMPNO ���, ENAME �̸�, SAL �޿�, JOB �۾� FROM EMP;
-- EMP���̺��� EMPNO, ENAME, DEPTNO(�μ���ȣ) �ʵ��� ��� ������
SELECT EMPNO, ENAME, DEPTNO FROM EMP;
-- �� WHERE ������ �񱳿����ڸ� ���
-- SAL�� 3000�� ������ ���, �̸�, �޿��� LIST (title : ���, �̸�, �޿�)
SELECT EMPNO "���", ENAME "�̸�", SAL "�޿�" FROM EMP WHERE SAL =3000; 
-- SAL�� 3000�� �ƴ� ������ EMPNO, ENAME, SAL, COMM �ʵ带 LIST
SELECT EMPNO, ENAME, SAL, COMM FROM EMP WHERE SAL != 3000;
SELECT EMPNO, ENAME, SAL, COMM FROM EMP WHERE SAL <> 3000;
SELECT EMPNO, ENAME, SAL, COMM FROM EMP WHERE SAL ^= 3000;
-- �μ���ȣ(DEPTNO)�� 10���� ������ ��� �ʵ带 LIST
SELECT * FROM EMP WHERE DEPTNO=10;
-- ENAME�� FORD�� ������ ��� �ʵ�
SELECT * FROM EMP WHERE ENAME='FORD'; --���ڴ� '�� , �ʵ��� ������ �ٶ��� "
SELECT * FROM EMP WHERE ENAME='ford';
select * from emp where ename='FORD';
-- SAL�� 2000�̻� 3000�̸��� ������ ��� �ʵ�
SELECT * FROM EMP WHERE SAL>=2000 AND SAL<3000; -- �񱳿����� ���ڰ���
SELECT * FROM EMP WHERE ENAME<'FP'; -- �񱳿����� ���ڵ� ����
-- HIREDATE(�Ի���)�� 82(82/01/01)�� ������ �Ի��� ������ ��� �ʵ�
SELECT * FROM EMP WHERE HIREDATE < '82/01/01'; -- �񱳿����� ��¥�� ����
-- 82�⵵�� �Ի��� ������ ��� �ʵ�
SELECT * FROM EMP WHERE HIREDATE>='82/01/01' AND HIREDATE<='82/12/31';
-- 10���μ��̰ų� JOB�� 'MANAGER'�� ������ �̸�, �޿��� LIST
SELECT ENAME, SAL FROM EMP WHERE DEPTNO=10 OR JOB='MANAGER';
-- 10�� �μ��� �ƴ� ��� ������ ��� �ʵ� LIST
SELECT * FROM EMP WHERE DEPTNO != 10;
SELECT * FROM EMP WHERE DEPTNO <> 10;
SELECT * FROM EMP WHERE DEPTNO ^= 10;
-- SAL(����). SAL�� 2000�̻��� ������ �̸�, ������ LIST(COMM�� �����ϰ� ����)
SELECT ENAME, SAL*12 "����" FROM EMP WHERE SAL>2000;
--��������� �����, ��������, �ø�����(10%�λ�)�� LIST
SELECT ENAME, SAL, SAL*1.1 UPGRADESAL FROM EMP;
-- SAL(����), ����(SAL*12+COMM) . ��� ������ ���ؼ� �̸�,����,��,���� �ʵ� ����ϴ� SQL
-- ����������� NULL�Ȱ� ������ ����� NULL -> NVL(NULL�ϼ��� �ִ� �ʵ�, 0)
SELECT ENAME, SAL, COMM, SAL*12+COMM FROM EMP; 
-- NVL(NULL�ϼ����ִ��ʵ�, 0) ; ù��°�Ű������� �ι�°�Ű������� Ÿ�� ��ġ
SELECT ENAME, SAL, NVL(COMM,'0$'), SAL*12+NVL(COMM, 0) FROM EMP; -- Ÿ�Ժ���ġ(x)
DESC EMP;
SELECT ENAME, NVL(HIREDATE, '81/01/01') FROM EMP;
SELECT ENAME, NVL(MGR,'�ְ�濵��') FROM EMP; -- NVL�Լ��� �Ű����� Ÿ�� ����ġ (x)
DESC EMP;
SELECT ENAME, NVL(MGR, 9999) FROM  EMP;
-- �������� : AND OR
-- ||(���Ῥ����) : ���̳� ���ڸ� ����
SELECT ENAME || ' ' || JOB FROM EMP;
-- "SMITH IS CLERK"(ENAME IS JOB) ��µǰ� TITLE�� EMPLOYEES��� ��� ���� LIST
SELECT ENAME || ' IS ' || JOB AS "EMPLOYEES" FROM EMP;
-- SMITH�� ������ xx�� (����:SAL*12+COMM) TITLE:SALARY
SELECT ENAME||'�� ������ '||(SAL*12+NVL(COMM,0)) "SALARY" FROM EMP;
-- EMP���̺��� JOB (����� ����� �ߺ��� ���� : DISTINCT)
SELECT DISTINCT JOB FROM EMP;
SELECT DISTINCT DEPTNO FROM EMP;
SELECT DISTINCT JOB, DEPTNO FROM EMP;
-- �� ��Ʈ 3page �������� �� Ǯ��
--1. emp ���̺��� ���� ���
DESC emp;
--2. emp ���̺��� ��� ������ ��� 
SELECT * FROM emp;
--3. ������(scott)���� ��밡���� ���̺� ���
SELECT * FROM TAB;
--4. emp ���̺��� ���, �̸�, �޿�, ����, �Ի��� ���
SELECT EMPNO, ENAME, SAL, JOB, HIREDATE FROM EMP;
--5. emp ���̺��� �޿��� 2000�̸��� ����� ���, �̸�, �޿� ���
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL < 2000;

--6. �Ի����� 81/02���Ŀ� �Ի��� ����� ���, �̸�, ����, �Ի��� ���
SELECT EMPNO, ENAME, JOB, HIREDATE FROM EMP WHERE HIREDATE >= '81/02/01';
--7. ������ SALESMAN�� ����� ��� �ڷ� ���
SELECT * FROM EMP WHERE JOB = 'SALESMAN';
--8. ������ CLERK�� �ƴ� ����� ��� �ڷ� ���
SELECT * FROM EMP WHERE JOB != 'CLERK';
SELECT * FROM EMP WHERE JOB <> 'CLERK';
SELECT * FROM EMP WHERE JOB ^= 'CLERK';
--9. �޿��� 1500�̻��̰� 3000������ ����� ���, �̸�, �޿� ���
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL>=1500 AND SAL<=3000;
--10. �μ��ڵ尡 10���̰ų� 30�� ����� ���, �̸�, ����, �μ��ڵ� ���
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE DEPTNO=10 OR DEPTNO=30;
--11. ������ SALESMAN�̰ų� �޿��� 3000�̻��� ����� ���, �̸�, ����, �μ��ڵ� ���
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE JOB='SALESMAN' OR SAL>=3000;
--12. �޿��� 2500�̻��̰� ������ MANAGER�� ����� ���, �̸�, ����, �޿� ���
SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE SAL>=2500 AND JOB = 'MANAGER';
--13.��ename�� XXX �����̰� ������ XX�١� ��Ÿ�Ϸ� ��� ���
SELECT ENAME||'��(��) ������ '||job||'�� ������'||(SAL*12+NVL(COMM,0)) FROM EMP;
-- SQL������
-- BETWEEN A AND B : A���� B���� (A, B����, A�� ������)
--�޿��� 1500�̻��̰� 3000������ ����� ���, �̸�, �޿� ���
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL BETWEEN 1500 AND 3000;
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL BETWEEN 3000 AND 1500;
-- �ʵ�� IN (LIST1, ..., LIST2) 
--  �μ��ڵ尡 10���̰ų� 30�� ����� ���, �̸�, ����, �μ��ڵ� ���
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE DEPTNO=10 OR DEPTNO=30;
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE DEPTNO IN (10,30);
-- �ʵ� LIKE  ���� ; ���ϵ�ī��(%):0���̻��� ����, ���ϵ�ī��(_):1���̻��� ����
-- �̸��� M���� �����ϴ� ����� ��� �ʵ带 ����ض�
SELECT * FROM EMP WHERE ENAME LIKE 'M%';
-- �̸��� N�� ����ִ� ����� ��� �ʵ�
SELECT * FROM EMP WHERE ENAME LIKE '%N%';
-- 82�⵵�� �Ի��� ����� EMPNO, ENAME, JOB, SAL, HIREDATE, DEPTNO�� ���
SELECT EMPNO, ENAME, JOB, SAL, HIREDATE, DEPTNO FROM EMP 
    WHERE HIREDATE BETWEEN '82/01/01' AND '82/12/31';
SELECT EMPNO, ENAME, JOB, SAL, HIREDATE, DEPTNO FROM EMP 
    WHERE HIREDATE LIKE '82/__/__';
-- 2���� �Ի��� ����� ��� �ʵ�
SELECT * FROM EMP WHERE HIREDATE LIKE '__/02/__';
-- IS NULL
-- ��(COMM)�� NULL�� ������ ��� 
SELECT * FROM EMP WHERE COMM IS NULL;
-- NOT �ʵ� BETWEEN A AND B
-- NOT �ʵ�� IN (LIST1, ..., LIST2)
-- NOT �ʵ�� LIKE ����
-- IS NOT NULL
SELECT * FROM EMP WHERE COMM IS NOT NULL;
-- ���� ORDER BY �ʵ� (������������)
--      ORDER BY �ʵ� DESC (������������)
-- �޿��� ���� ������� ���(��� �ʵ�, ��� ����)
SELECT * FROM EMP ORDER BY SAL DESC;
-- �޿��� ���� ������� ���
SELECT * FROM EMP ORDER BY SAL ASC;
-- �ֱٿ� �Ի��� ��������� ��� ������ ��� �ʵ� ���
SELECT * FROM EMP ORDER BY HIREDATE DESC;
-- �̸��� ���ĺ� ����� ��� ������ ��� �ʵ� ���
SELECT * FROM EMP ORDER BY ENAME;
-- ������ ���� ������ ��� ������ �̸�, SAL, ������ ���
SELECT ENAME, SAL, SAL*12+NVL(COMM,0) "����" FROM EMP ORDER BY ����;
-- ������ 2000�̻��� ������ �̸�, ������ ���(���������� ����)
-- FROM�� -> WHERE�� -> SELECT�� -> ORDER BY��
SELECT ENAME, SAL*12+NVL(COMM,0) "����"
    FROM EMP
    WHERE (SAL*12+NVL(COMM,0))>=2000
    ORDER BY ����;
-- �� �� ��������
SELECT HIREDATE FROM EMP;
ALTER SESSION SET NLS_DATE_FORMAT='RR/MM/DD'; -- DATE�� ������

--1.	EMP ���̺��� sal�� 3000�̻��� ����� empno, ename, job, sal�� ���
SELECT EMPNO, ENAME, JOB, SAL 
    FROM EMP 
    WHERE SAL>3000;
--2.	EMP ���̺��� empno�� 7788�� ����� ename�� deptno�� ���
SELECT ENAME, DEPTNO 
    FROM EMP 
    WHERE EMPNO=7788;
--3.	������ 24000�̻��� ���, �̸�, �޿� ��� (�޿�������)
SELECT EMPNO, ENAME, SAL 
  FROM EMP 
  WHERE (SAL*12+NVL(COMM,0))>=24000 
  ORDER BY SAL;
--4.	EMP ���̺��� hiredate�� 1981�� 2�� 20�� 1981�� 5�� 1�� ���̿� �Ի��� ����� 
--ename,job,hiredate�� ����ϴ� SELECT ������ �ۼ� (�� hiredate ������ ���)
SELECT ENAME, JOB, HIREDATE FROM EMP 
  WHERE HIREDATE BETWEEN '81/02/20' AND '81/05/01' 
  ORDER BY HIREDATE;

SELECT ENAME, JOB, HIREDATE FROM EMP 
  WHERE HIREDATE>= '81/02/20' AND HIREDATE<='81/05/01' 
  ORDER BY HIREDATE ;

SELECT ENAME, JOB, HIREDATE FROM EMP 
  WHERE HIREDATE BETWEEN TO_DATE('1981/02/20','YYYY/MM/DD') 
        AND TO_DATE('1981/05/01' ,'YYYY/MM/DD')
  ORDER BY HIREDATE;
  
--5.	EMP ���̺��� deptno�� 10,20�� ����� ��� ������ ��� (�� ename������ ����)
SELECT * FROM EMP WHERE DEPTNO=10 OR DEPTNO=20 ORDER BY ENAME;
SELECT * FROM EMP WHERE DEPTNO IN (10,20) ORDER BY ENAME;
--6.	EMP ���̺��� sal�� 1500�̻��̰� deptno�� 10,30�� ����� ename�� sal�� ���
-- (�� HEADING�� employee�� Monthly Salary�� ���)
SELECT ENAME "employee", SAL "Monthly Salary" FROM EMP 
  WHERE SAL>=1500 AND DEPTNO IN (10,30);
SELECT ENAME employee, SAL "Monthly Salary" FROM EMP 
  WHERE SAL>=1500 AND (DEPTNO=10 OR DEPTNO=30);

-- ���� �ý����� DATE�� ����
ALTER SESSION SET NLS_DATE_FORMAT='RR/MM/DD';
-- TO_CHAR(��¥���ʵ�, 'YYYY/MM/DD') -> YYYY/MM/DD��Ÿ���� ���������� ��ȯ �Լ�
-- TO_DATE('1981/01/01', 'YYYY/MM/DD') -> ���ڸ� ��¥������ ��ȯ �Լ�
--7.	EMP ���̺��� hiredate�� 1982���� ����� ��� ������ ���
SELECT * FROM EMP WHERE HIREDATE LIKE '82%';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'YYYY/MM/DD') LIKE '1982%';

--8.	�̸��� ù�ڰ� C����  P�� �����ϴ� ����� �̸�, �޿� �̸��� ����
SELECT ENAME, SAL FROM EMP 
  WHERE (ENAME BETWEEN 'C' AND 'Q') AND ENAME!='Q'
  ORDER BY SAL, ENAME;
  
--9.	EMP ���̺��� comm�� sal���� 10%�� ���� ��� ����� ���Ͽ� �̸�, �޿�, �󿩱��� 
--����ϴ� SELECT ���� �ۼ�
SELECT ENAME, SAL, COMM FROM EMP WHERE COMM>SAL*1.1 ;

--10.	EMP ���̺��� job�� CLERK�̰ų� ANALYST�̰� sal�� 1000,3000,5000�� �ƴ�
--��� ����� ������ ���
SELECT * FROM EMP WHERE (JOB='CLERK' OR JOB='ANALYST') 
  AND SAL NOT IN (1000,3000,5000);
SELECT * FROM EMP WHERE JOB IN('CLERK','ANALYST') 
  AND SAL NOT IN (1000,3000,5000);
SELECT * FROM EMP WHERE (job='CLERK' OR job='ANALYST') 
  AND NOT (SAL IN (1000,3000,5000));
--11.	EMP ���̺��� ename�� L�� �� �ڰ� �ְ� deptno�� 30�̰ų� �Ǵ� mgr�� 7782�� ����� 
--��� ������ ����ϴ� SELECT ���� �ۼ��Ͽ���.
SELECT * FROM EMP 
  WHERE ENAME LIKE '%L%L%' AND (DEPTNO=30 OR MGR=7782);
  
--12.	��� ���̺��� �Ի����� 81�⵵�� ������ ���,�����, �Ի���, ����, �޿��� ���
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP 
  WHERE HIREDATE LIKE '81%';
  
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP
  WHERE HIREDATE BETWEEN '81/01/01' AND '81/12/31';
  
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP
  WHERE HIREDATE BETWEEN TO_DATE('1981/01/01','YYYY/MM/DD') 
                AND TO_DATE('1981/12/31','YYYY/MM/DD');
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP 
  WHERE TO_CHAR(HIREDATE,'YYMMDD') BETWEEN '810101' AND '811231';
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP 
  WHERE TO_CHAR(HIREDATE,'YYMM') BETWEEN '8101' AND '8112';
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP 
  WHERE TO_CHAR(HIREDATE,'YY') = '81';
--13.	��� ���̺��� �Ի�����81���̰� ������ 'SALESMAN'�� �ƴ� ������ ���, �����, �Ի���, 
-- ����, �޿��� �˻��Ͻÿ�.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP 
  WHERE HIREDATE LIKE '81%' AND JOB!='SALESMAN';
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP 
  WHERE TO_CHAR(HIREDATE,'YY') = '81' AND JOB!='SALESMAN';
--14.	��� ���̺��� ���, �����, �Ի���, ����, �޿��� �޿��� ���� ������ �����ϰ�, 
-- �޿��� ������ �Ի����� ���� ������� �����Ͻÿ�.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP 
      ORDER BY SAL DESC, HIREDATE;
--15.	��� ���̺��� ������� �� ��° ���ĺ��� 'N'�� ����� ���, ������� �˻��Ͻÿ�
SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE '__N%';
--16.	��� ���̺�������(SAL*12)�� 35000 �̻��� ���, �����, ������ �˻� �Ͻÿ�.
SELECT EMPNO, ENAME, SAL*12 ���� FROM EMP WHERE SAL*12 > 35000;




