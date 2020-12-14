-- V. �׷��Լ� : SUM, AVG, MIN, MAX, COUNT, STDDEV, VARIANCE
SELECT SUM(SAL) FROM EMP;
SELECT DEPTNO, SUM(SAL) FROM EMP GROUP BY DEPTNO; -- DEPNO ���� SAL�� SUM�� ���
SELECT DEPTNO, SUM(SAL) 
    FROM EMP 
    WHERE ENAME!='SMITH'
    GROUP BY DEPTNO
    HAVING SUM(SAL)>9000
    ORDER BY DEPTNO;
-- EMP���̺��� ���SAL
SELECT ROUND(AVG(SAL),2) FROM EMP;
SELECT COUNT(*) FROM EMP; -- EMP ���̺��� ���
SELECT SUM(SAL)/COUNT(*), AVG(SAL) FROM EMP;
SELECT SUM(COMM) FROM EMP; -- �׷��Լ��� ��� NULL���� �����ϰ� ���
SELECT SUM(COMM)/COUNT(COMM), AVG(COMM) FROM EMP;
SELECT COUNT(COMM) FROM EMP;
SELECT VARIANCE(SAL) �л�, STDDEV(SAL) ǥ������ FROM EMP;
SELECT DEPTNO, AVG(SAL), STDDEV(SAL) FROM EMP GROUP BY DEPTNO
    ORDER BY AVG(SAL);
SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO;
SELECT COUNT(JOB) FROM EMP; -- JOB �����Ͱ� �ִ� ���
SELECT JOB FROM EMP;
SELECT DISTINCT JOB FROM EMP;
SELECT COUNT(DISTINCT JOB) FROM EMP; -- �ߺ��� �����͸� ������ ���
-- źź������
-- ���� �ֱٿ� �Ի��� ������ �Ի��ϰ� ���� ���ʿ� �Ի��� ������ �Ի��� ���
SELECT MIN(SAL), MAX(SAL) FROM EMP;
SELECT MIN(ENAME), MAX(ENAME) FROM EMP;
SELECT MIN(HIREDATE) "�����Ի���", MAX(HIREDATE) "�ֱ��Ի���" FROM EMP;
-- �ֱ��Ի���, �ֱ��Ի��Ϻ��Ϳ��ñ����ϼ�, �����Ի���, �����Ի��Ϻ��Ϳ��ñ����ϼ�
SELECT MAX(HIREDATE), TO_CHAR(TRUNC(SYSDATE-MAX(HIREDATE)), '99,999'), 
    MIN(HIREDATE), TRUNC(SYSDATE-MIN(HIREDATE)) FROM EMP;
-- 10�� �μ� �Ҽ��� ����� ��� �޿�
SELECT AVG(SAL) FROM EMP WHERE DEPTNO=10;
-- 10�� �μ� �Ҽ��� COMM(�󿩱�)�� �޴� ����� ����?
SELECT COUNT(COMM) FROM EMP WHERE DEPTNO=10; -- DEPTNO�� 10�� �� ����
-- AVG(SAL)�� 2000�̻� ( �׷��Լ��� ���� ������ WHERE ���� �ƴϰ� HAVING���� )
SELECT DEPTNO, AVG(SAL) FROM EMP GROUP BY DEPTNO HAVING AVG(SAL)>2000; 
-- �μ���ȣ�� ��ձ޿�, �޿��ּҰ�, �޿��ִ밪
SELECT DEPTNO, AVG(SAL), MIN(SAL), MAX(SAL) FROM EMP GROUP BY DEPTNO;
-- �μ��� ��ձ޿��� ���(�μ��� ABCD������ ���)
SELECT DNAME, AVG(SAL)
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO
    GROUP BY DNAME
    ORDER BY DNAME;
-- �μ���ȣ�� ������� �󿩱��� �޴� �����
SELECT DEPTNO, COUNT(*), COUNT(COMM) FROM EMP GROUP BY DEPTNO;
-- �μ��̸��� ������� �󿩱� �޴� �����
SELECT DNAME �μ�, COUNT(*), COUNT(COMM) FROM EMP E, DEPT D
    WHERE D.DEPTNO=E.DEPTNO 
    GROUP BY DNAME
    ORDER BY �μ�;
-- GROUP BY �ʵ�1, �ʵ�2
SELECT DEPTNO, AVG(SAL) FROM EMP GROUP BY DEPTNO;
SELECT DEPTNO, JOB, AVG(SAL) FROM EMP GROUP BY DEPTNO, JOB ORDER BY DEPTNO;
-- GROUP BY ���� �ʵ尡 2�� �� �� �������� ���̱� ���� DECODE
SELECT DEPTNO, DECODE(JOB, 'CLERK', SAL, 0) CLERK,
               DECODE(JOB, 'MANAGER', SAL, 0) MANAGER,
               DECODE(JOB, 'PRESIDENT', SAL, 0) PRESIDENT,
               DECODE(JOB, 'ANALYST', SAL, 0) ANALYST,
               DECODE(JOB, 'SALESMAN', SAL, 0) SALESMAN FROM EMP;
               
SELECT DEPTNO, SUM(DECODE(JOB, 'CLERK', SAL, 0)) CLERK,
               SUM(DECODE(JOB, 'MANAGER', SAL, 0)) MANAGER,
               SUM(DECODE(JOB, 'PRESIDENT', SAL, 0)) PRESIDENT,
               SUM(DECODE(JOB, 'ANALYST', SAL, 0)) ANALYST,
               SUM(DECODE(JOB, 'SALESMAN', SAL, 0)) SALESMAN,
               SUM(SAL) "�μ����Ұ�"
               FROM EMP 
               GROUP BY ROLLUP(DEPTNO);
SELECT DEPTNO, JOB, SUM(SAL) FROM EMP GROUP BY DEPTNO, JOB;
SELECT DEPTNO, SUM(SAL) FROM EMP GROUP BY ROLLUP(DEPTNO);
SELECT DEPTNO, AVG(SAL) FROM EMP GROUP BY ROLLUP(DEPTNO);

SELECT JOB, DEPTNO, AVG(SAL) FROM EMP GROUP BY JOB, DEPTNO;
SELECT JOB, DEPTNO, AVG(SAL) FROM EMP GROUP BY ROLLUP(JOB, DEPTNO);
-- ���� ����� �ǹ����̺�� �ٲ㺸����
-- ����(JOB) ����(DEPTNO)�� AVG(SAL) �Ұ�����
--      	10���μ�	20���μ�	30���μ�	�Ұ�
--ANALYST	xxx	    xxx	    xxx	     xxx
--CLERK	    xxx	    xxx	    xxx      xxx
--MANAGER	xxx	    xxx	    xxx	     xxx
--PRESIDENT	xxx	    xxx	    xxx	     xxx
--SALESMAN	xxx	    xxx	    xxx	     xxx
--�Ұ�	    xxx	    xxx	    xxx	     xxx
SELECT JOB, DECODE(DEPTNO, 10, SAL) "10���μ�",
            DECODE(DEPTNO, 20, SAL) "20���μ�",
            DECODE(DEPTNO, 30, SAL) "30���μ�"
        FROM EMP;
SELECT JOB, ROUND(AVG(DECODE(DEPTNO, 10, SAL))) "10���μ�",
            ROUND(AVG(DECODE(DEPTNO, 20, SAL))) "20���μ�",
            ROUND(AVG(DECODE(DEPTNO, 30, SAL))) "30���μ�",
            ROUND(AVG(SAL)) "�Ұ�"
        FROM EMP GROUP BY ROLLUP(JOB);
-- �μ���ȣ�� ��ձ޿����(��ձ޿��� 2000�̻��� �׷츸 ���)
SELECT DEPTNO, AVG(SAL) FROM EMP GROUP BY DEPTNO HAVING AVG(SAL)>=2000;
-- �μ���ȣ�� �ִ�޿� ���
SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO;
-- �μ���ȣ�� �μ���ȣ, �ִ�޿�, ����̸� => ��������











-- ��<�� ��������>

-- 1. ��� ���̺��� �ο���,�ִ� �޿�,�ּ� �޿�,�޿��� ���� ����Ͽ� ���
SELECT COUNT(*), MAX(SAL), MIN(SAL), SUM(SAL) FROM EMP;
-- 2. ������̺��� ������ �ο����� ���Ͽ� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT JOB, COUNT(*) FROM EMP GROUP BY JOB;
--- 3. ������̺��� �ְ� �޿��� �ּ� �޿��� ���̴� ���ΰ� ����ϴ� SELECT������ �ۼ��Ͽ���.
SELECT MAX(SAL) - MIN(SAL) FROM EMP;
-- 4. �� �μ����� �ο���, �޿� ���, ���� �޿�, �ְ� �޿�, �޿��� ���� ����ϵ� �޿��� ���� ���� ������ ����϶�.
SELECT DEPTNO, COUNT(*), AVG(SAL), MIN(SAL), MAX(SAL), SUM(SAL) SUM_SAL 
    FROM EMP 
    GROUP BY DEPTNO 
    ORDER BY SUM_SAL DESC;
SELECT DEPTNO, COUNT(*), AVG(SAL), MIN(SAL), MAX(SAL), SUM(SAL) 
    FROM EMP
    GROUP BY DEPTNO 
    ORDER BY SUM(SAL) DESC;
SELECT DNAME, COUNT(*), AVG(SAL), MIN(SAL), MAX(SAL), SUM(SAL)
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO
    GROUP BY DNAME
    ORDER BY SUM(SAL) DESC;
-- 5. �μ���, ������ �׷��Ͽ� ����� �μ���ȣ, ����, �ο���, �޿��� ���, �޿��� ���� 
    --���Ͽ� ����϶�(��°���� �μ���ȣ, ���������� �������� ����)
SELECT DEPTNO, JOB, COUNT(*), AVG(SAL), SUM(SAL) 
    FROM EMP GROUP BY DEPTNO, JOB ORDER BY DEPTNO, JOB; -- �μ���ȣ, ������
    
SELECT DNAME, JOB, COUNT(*), AVG(SAL), SUM(SAL)
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO
    GROUP BY DNAME, JOB ORDER BY DNAME, JOB; -- �μ��̸�, ������
    
-- 6. ������, �μ��� �׷��Ͽ� �����  ����, �μ���ȣ, �ο���, �޿��� ���, �޿��� ���� ���Ͽ� 
-- ����϶�.(��°���� ������, �μ���ȣ �� �������� ����)
SELECT JOB, DEPTNO, COUNT(*), AVG(SAL), SUM(SAL) 
    FROM EMP GROUP BY JOB, DEPTNO ORDER BY JOB, DEPTNO;
    
-- 7~10�� HAVING ��    
--7. ������� 5���̻� �Ѵ� �μ���ȣ�� ������� ����Ͻÿ�.
SELECT DEPTNO, COUNT (*) 
  FROM EMP GROUP BY DEPTNO HAVING COUNT(*)>5; --�׷�(group by)�� ���� ������ having����

-- 8. ������� 5���̻� �Ѵ� �μ���� ������� ����Ͻÿ�
SELECT DNAME, COUNT(SAL) FROM EMP E, DEPT D
    	WHERE E.DEPTNO=D.DEPTNO GROUP BY DNAME HAVING COUNT(*)>=5;

--9. ��� ���̺��� ������ �޿��� ����� 3000�̻��� ������ ���ؼ� ������, ��� �޿�, 
--�޿��� ���� ���Ͽ� ����϶�
SELECT JOB, AVG(SAL), SUM(SAL) FROM EMP GROUP BY JOB HAVING AVG(SAL)>=3000;

--10. ������̺��� �޿����� 5000�� �ʰ��ϴ� �� ������ ���ؼ� ������ �޿��հ踦 ����϶� 
        --��, �޿� �հ�� �������� �����϶�.
SELECT JOB, SUM(SAL) SUMSAL
    FROM EMP GROUP BY JOB HAVING SUM(SAL)>5000 ORDER BY SUMSAL DESC;
SELECT JOB, SUM(SAL)
    FROM EMP GROUP BY JOB HAVING SUM(SAL)>5000 ORDER BY SUM(SAL) DESC;

--11. �μ��� �޿����, �μ��� �޿��հ�, �μ��� �ּұ޿��� ����϶�.
SELECT DNAME, AVG(SAL), MAX(SAL), MIN(SAL) 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO GROUP BY DNAME; -- �μ��̸���
    
SELECT DEPTNO, AVG(SAL), MAX(SAL), MIN(SAL) FROM EMP GROUP BY DEPTNO; -- �μ���ȣ��
    
--12. ���� 11���� �����Ͽ�, �μ��� �޿���� �ִ�ġ, �μ��� �޿����� �ִ�ġ, 
            --�μ��� �ּұ޿��� �ִ�ġ�� ����϶�.
SELECT MAX(AVG(SAL)), MAX(MAX(SAL)), MAX(MIN(SAL)) FROM EMP GROUP BY DEPTNO;

--13. ��� ���̺��� �Ʒ��� ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.(�⵵�� ������)
--   H_YEAR	COUNT(*)	MIN(SAL)	MAX(SAL)	AVG(SAL)	SUM(SAL)
--		80	  1		    800		    800		    800		    800
--		81	 10		    950		    5000		2282.5		22825
--		82	  2		    1300		3000		2150		4300
--		83	  1		    1100		1100		1100		1100
SELECT TO_CHAR(HIREDATE,'YY') H_YEAR, COUNT(*), MIN(SAL), MAX(SAL), AVG(SAL), 
        SUM(SAL) 
    FROM EMP GROUP BY TO_CHAR(HIREDATE,'YY') ORDER BY H_YEAR;

SELECT SUBSTR(EXTRACT(YEAR FROM HIREDATE),3,2) H_YEAR, 
        COUNT(*), MIN(SAL), MAX(SAL), AVG(SAL), SUM(SAL) 
    FROM EMP GROUP BY SUBSTR(EXTRACT(YEAR FROM HIREDATE),3,2) ORDER BY H_YEAR;

-- 14.  ������̺��� �Ʒ��� ����� ����ϴ� SELECT �� �ۼ�
-- TOTAL	1980	1981	1982	1983
--  14		  1	     10	      2	      1
SELECT EXTRACT(YEAR FROM HIREDATE), COUNT(*)  
    FROM EMP GROUP BY ROLLUP(EXTRACT(YEAR FROM HIREDATE));
SELECT DECODE(EXTRACT(YEAR FROM HIREDATE), '1980', 1) "1980",
       DECODE(EXTRACT(YEAR FROM HIREDATE), '1981', 1) "1981",
       DECODE(EXTRACT(YEAR FROM HIREDATE), '1982', 1) "1982",
       DECODE(EXTRACT(YEAR FROM HIREDATE), '1983', 1) "1983" FROM EMP;
SELECT COUNT(*) TOTAL, 
       COUNT(DECODE(EXTRACT(YEAR FROM HIREDATE), '1980', 1)) "1980",
       COUNT(DECODE(EXTRACT(YEAR FROM HIREDATE), '1981', 1)) "1981",
       COUNT(DECODE(EXTRACT(YEAR FROM HIREDATE), '1982', 1)) "1982",
       COUNT(DECODE(EXTRACT(YEAR FROM HIREDATE), '1983', 1)) "1983" FROM EMP;
SELECT COUNT(*) TOTAL,
       SUM(DECODE(EXTRACT(YEAR FROM HIREDATE), '1980', 1)) "1980",
       SUM(DECODE(EXTRACT(YEAR FROM HIREDATE), '1981', 1)) "1981",
       SUM(DECODE(EXTRACT(YEAR FROM HIREDATE), '1982', 1)) "1982",
       SUM(DECODE(EXTRACT(YEAR FROM HIREDATE), '1983', 1)) "1983" FROM EMP;
--15. ������̺��� �Ʒ��� ����� ����ϴ� SELECT �� �ۼ�(JOB ������ �������� ����)
-- JOB��, DEPTNO�� SUM(SAL)
--JOB		DEPTNO10	DEPTNO20	DEPTNO30     TOTAL
--ANALYST	     0		   6000		    0		6000
--CLERK		  1300		   1900		  950		4150
--��.
--SALESMAN	      0	 		0	 5600		 5600
SELECT JOB, DECODE(DEPTNO, 10, SAL, 0) "DEPTNO10",  -- ���� �ܰ� SQL
    DECODE(DEPTNO, 20, SAL, 0) "DEPTNO20",
    DECODE(DEPTNO, 30, SAL, 0) "DEPTNO30"
     FROM EMP ORDER BY JOB;
SELECT JOB, SUM(DECODE(DEPTNO, 10, SAL,0)) "DEPTNO 10",
            SUM(DECODE(DEPTNO, 20, SAL,0)) "DEPTNO 20",
            SUM(DECODE(DEPTNO, 30, SAL,0)) "DEPTNO 30",
            SUM(SAL) "TOTAL"
		FROM EMP GROUP BY JOB ORDER BY JOB;
        
--16. ������̺��� �ִ�޿�, �ּұ޿�, ��ü�޿���, ����� ���Ͻÿ�
SELECT MAX(SAL), MIN(SAL), SUM(SAL), AVG(SAL) FROM EMP;

--17. ������̺��� �μ��� �ο����� ���Ͻÿ�
SELECT DEPTNO, COUNT(*) FROM EMP GROUP BY DEPTNO;
SELECT DNAME, COUNT(*) FROM EMP E, DEPT D 
        WHERE E.DEPTNO=D.DEPTNO GROUP BY DNAME ORDER BY DNAME;
        
--18. ��� ���̺��� �μ��� �ο����� 6���̻��� �μ��ڵ带 ���Ͻÿ�
SELECT DEPTNO, COUNT(*) FROM EMP GROUP BY DEPTNO HAVING COUNT(*)>=6;

--19. ������̺��� ������ ���� ����� ������ �Ͻÿ�
--DNAME               CLERK    MANAGER     PRESIDENT    ANALYST   SALESMAN
--ACCOUNTING            1300       2450       5000          0          0
--RESEARCH              1900       2975          0       6000          0
--SALES                 950        2850          0          0       5600
SELECT DNAME, SUM(DECODE(JOB, 'CLERK', SAL, 0)) CLERK,
              SUM(DECODE(JOB, 'MANAGER', SAL,0)) MANAGER,
              SUM(DECODE(JOB, 'PRESIDENT', SAL,0)) PRESIDENT,
              SUM(DECODE(JOB, 'ANALYST', SAL,0)) ANALYST,
              SUM(DECODE(JOB, 'SALESMAN', SAL,0)) SALESMAN
              FROM EMP E, DEPT D
              WHERE E.DEPTNO=D.DEPTNO
              GROUP BY DNAME;
              
--20.  ������̺��� �޿��� ���� ������� ����� �ο��Ͽ� ������ ���� ����� ������ �Ͻÿ�. 
-- (��Ʈ self join, group by, count���)
--ENAME	    ���
--________________________
--KING		1
--SCOTT		2
--����
SELECT E1.ENAME, COUNT(E2.ENAME)+1 ���
    FROM EMP E1, EMP E2
    WHERE E1.SAL<E2.SAL(+)
    GROUP BY E1.ENAME
    ORDER BY ���;
SELECT ENAME, RANK() OVER(ORDER BY SAL DESC) RANK,
              DENSE_RANK() OVER (ORDER BY SAL DESC) D_RANK,
              ROW_NUMBER() OVER (ORDER BY SAL DESC) R_RANK FROM EMP;