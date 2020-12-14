-- VI. SUB QUERY
-- SCOTT�� �ٹ��ϴ� �μ��̸�
SELECT DNAME FROM DEPT D, EMP E WHERE E.DEPTNO=D.DEPTNO AND ENAME='SCOTT'; -- JOIN
SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT'; -- ��������
SELECT DNAME FROM DEPT 
    WHERE DEPTNO=(SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT'); -- ��������
-- ���������� ���� : �����༭������, �����༭������
-- JOB�� 'MANAGER'�� ����� �μ��̸�
SELECT DEPTNO FROM EMP WHERE JOB='MANAGER'; -- ��������(3��)
SELECT DNAME FROM DEPT
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE JOB='MANAGER');
SELECT DNAME FROM DEPT
    WHERE DEPTNO IN (10,20,30);

-- ������ ��������
SELECT MAX(SAL) FROM EMP; -- �ְ�ݾ� SAL
-- �ְ�ݾ�SAL�� �޴»���� �̸�, �ְ�ݾ�SAL
SELECT ENAME, SAL FROM EMP WHERE SAL=(SELECT MAX(SAL) FROM EMP);
-- SCOTT�� ���� �μ��� �ٹ��ϴ� ����� �̸�
SELECT ENAME FROM EMP 
    WHERE DEPTNO=(SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT')
        AND ENAME<>'SCOTT';
-- SCOTT�� ���� �ٹ����� �ٹ��ϴ� ����� �̸�
SELECT * FROM DEPT;
INSERT INTO DEPT VALUES (50,'IT','DALLAS');
SELECT * FROM EMP;
INSERT INTO EMP VALUES (9999,'ȫ�浿',NULL, NULL, NULL, 9000, NULL, 50);
ROLLBACK; -- INSERT ���
SELECT LOC FROM DEPT D, EMP E WHERE D.DEPTNO=E.DEPTNO AND ENAME='SCOTT';--��������
SELECT ENAME FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND 
    LOC=(SELECT LOC FROM DEPT D, EMP E WHERE D.DEPTNO=E.DEPTNO AND ENAME='SCOTT')
    AND ENAME<>'SCOTT';
-- 'SCOTT'�� ���� JOB�� ���� ������� ��� ���� ���
SELECT * FROM EMP WHERE JOB=(SELECT JOB FROM EMP WHERE ENAME='SCOTT');
-- 'scott'�� �޿��� �����ϰų� �� ���� �޴� ����̸��� �޿����
SELECT ENAME, SAL FROM EMP WHERE SAL>=(SELECT SAL FROM EMP WHERE ENAME='SCOTT');
-- ���ӻ���� KING�� ����� �̸��� �޿�
SELECT ENAME, SAL FROM EMP WHERE MGR = (SELECT EMPNO FROM EMP WHERE ENAME='KING');
-- ��ձ޿� ���ϸ� �޴� ������ ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL<=(SELECT AVG(SAL) FROM EMP);
-- �μ���ȣ, �μ��� �ִ�޿�, �� �ִ�޿����޴»�����̸�, �׻���Ǳ޿�
SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO; -- ��������
SELECT DEPTNO, SAL, ENAME FROM EMP
    WHERE (DEPTNO, SAL) IN (SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO);
-- ����������༭������ : SCOTT�� JOB�� ���� �μ���ȣ�� ���� ����� ��� �ʵ带 ���
SELECT * FROM EMP 
    WHERE (JOB, DEPTNO) = (SELECT JOB, DEPTNO FROM EMP
    WHERE ENAME='SCOTT');
-- �����༭������ : ���������� �������� ������ IN, ALL, ANY=SOME, EXISTS
-- �μ���ȣ, DEPTNO(�μ���ȣ=�μ��ڵ�)���� �ִ�޿�, �� �ִ�޿��� �޴� ����� �̸�
SELECT DEPTNO, SAL, ENAME FROM EMP
    WHERE (DEPTNO, SAL) IN (SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO);
-- �Խó⵵, �Ի�⺰�ּұ޿�, �� �ּұ޿��� �޴� ��� �̸�
-- ��������(�Ի�⵵���ּұ޿�)
SELECT TO_CHAR(HIREDATE, 'YY'), MIN(SAL) 
    FROM EMP GROUP BY TO_CHAR(HIREDATE, 'YY');
SELECT SUBSTR(EXTRACT(YEAR FROM HIREDATE),3,2), MIN(SAL) 
    FROM EMP GROUP BY SUBSTR(EXTRACT(YEAR FROM HIREDATE),3,2);
-- ��������(�������� �Ի�⵵, �Ի�⵵���ּұ޿�, �׻���̸�)
SELECT TO_CHAR(HIREDATE, 'YY') YEAR, SAL, ENAME FROM EMP
    WHERE (TO_CHAR(HIREDATE, 'YY'), SAL) IN 
            (SELECT TO_CHAR(HIREDATE, 'YY'), MIN(SAL) 
                FROM EMP GROUP BY TO_CHAR(HIREDATE, 'YY'))
    ORDER BY YEAR;
-- �޿��� 3000�̻� �޴� ����� �Ҽӵ� �μ��� ������ �μ����� �ٹ��ϴ� ������� ��� �ʵ� ���
-- ��������(�޿��� 3000�̻� �޴� ������ �μ���ȣ)
SELECT DEPTNO FROM EMP WHERE SAL>=3000; -- �����༭������
-- ��������(������������ ���� �μ���ȣ�� ���� �μ��� �ٹ� �������� ��� �ʵ�)
SELECT * FROM EMP WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE SAL>=3000);
-- �μ����� �Ի����� ���� ���� ����� �μ���ȣ, �̸�, �Ի����� ���
-- �������� (�μ��� ���� ���� �Ի���)
SELECT DEPTNO, MAX(HIREDATE) FROM EMP GROUP BY DEPTNO;
-- ��������(�μ���ȣ, �̸�, �Ի���, ���� �������� ��� ���� ģ��)
SELECT DEPTNO, ENAME, HIREDATE FROM EMP
    WHERE (DEPTNO, HIREDATE) 
            IN (SELECT DEPTNO, MAX(HIREDATE) FROM EMP GROUP BY DEPTNO)
    ORDER BY DEPTNO;
-- JOB(��å)�� ���� ���� ������ �޴� ����� �̸�, JOB(��å), ����.
SELECT JOB, MIN(SAL) FROM EMP GROUP BY JOB; -- ��������(JOB�� MIN(SAL))
SELECT ENAME, JOB, SAL FROM EMP
    WHERE (JOB, SAL) IN (SELECT JOB, MIN(SAL) FROM EMP GROUP BY JOB);
-- 30�� �μ� ��� �� �޿��� ���� ���� ������� �� ���� �޿��� �޴� ����� �̸�, �޿�
SELECT SAL FROM EMP WHERE DEPTNO=30; -- ��������
SELECT ENAME, SAL FROM EMP
    WHERE SAL > ALL (SELECT SAL FROM EMP WHERE DEPTNO=30);
SELECT ENAME, SAL FROM EMP
    WHERE SAL > (SELECT MAX(SAL) FROM EMP WHERE DEPTNO=30);
-- 30�� �μ� ��� �޿� �� ���� ������(950)���� ���� �޿��� ���� ����� �̸�, �޿�
SELECT ENAME, SAL FROM EMP
    WHERE SAL > ANY (SELECT SAL FROM EMP WHERE DEPTNO=30);
SELECT ENAME, SAL FROM EMP
    WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE DEPTNO=30);
-- ���Ӻ��ϰ� �ִ� ������ �����ȣ, �̸�, �޿� ���
SELECT EMPNO, ENAME, SAL FROM EMP 
    WHERE EMPNO IN (SELECT MGR FROM EMP);

SELECT EMPNO, ENAME, SAL FROM EMP MANAGER
    WHERE EXISTS (SELECT EMPNO FROM EMP WORKER WHERE WORKER.MGR=MANAGER.EMPNO);

SELECT EMPNO, ENAME, SAL FROM EMP MANAGER
    WHERE EXISTS (SELECT EMPNO FROM EMP WHERE MGR=MANAGER.EMPNO);
-- ���, �̸�, �μ���ȣ, SAL, �ش������μ���� (SELECT���� SUBQUERY)
SELECT EMPNO, ENAME, DEPTNO, SAL, (SELECT AVG(SAL) FROM EMP WHERE DEPTNO=E.DEPTNO)
    FROM EMP E;
-- ���Ӻ��ϰ� ���� �������� ��� ������ ���
-- SELF JOIN+OUTER JOIN �̿�
SELECT MANAGER.* FROM EMP WORKER, EMP MANAGER
    WHERE WORKER.MGR(+) = MANAGER.EMPNO AND WORKER.MGR IS NULL;
-- IN ������ �̿�
SELECT * FROM EMP WHERE EMPNO  IN (7902, 7698, NULL); -- A
SELECT * FROM EMP WHERE EMPNO=7902 OR EMPNO=7698 OR EMPNO=NULL; -- A

SELECT * FROM EMP WHERE EMPNO NOT IN (7902, 7698, NULL); -- B (A�� �ݴ�)
SELECT * FROM EMP WHERE EMPNO!=7902 AND EMPNO!=7698 AND EMPNO!=NULL; -- B(A�� �ݴ�)

SELECT * FROM EMP WHERE EMPNO NOT IN (SELECT MGR FROM EMP WHERE MGR IS NOT NULL);

-- EXISTS ������ �̿�
SELECT * FROM EMP MANAGER
    WHERE NOT EXISTS (SELECT * FROM EMP WHERE MGR=MANAGER.EMPNO);

-- źź������ ����
-- �μ����� ���� �޿��� ���� �޴� ����� ����(��� ��ȣ, ����̸�, �޿�, �μ���ȣ)�� ���
        --(IN ������ �̿�)
SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO; -- ��������
SELECT EMPNO, ENAME, SAL, DEPTNO FROM EMP 
    WHERE (DEPTNO, SAL) IN (SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO);

--����(JOB)�� MANAGER�� ����� ���� �μ��� �μ� ��ȣ�� �μ���� ������ ���(IN)
SELECT DEPTNO, DNAME, LOC FROM DEPT 
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE JOB='MANAGER');
    
--SAL�� 3000�̻��� ����� �� ���� ����� ����� �ش� ��޺� �ְ� ������ �޴� ������� 
        --���, �̸�, ����, �Ի���, �޿�, �޿������ ���
SELECT GRADE, MAX(SAL) FROM EMP, SALGRADE 
    WHERE SAL BETWEEN LOSAL AND HISAL AND SAL>=3000 GROUP BY GRADE; -- ��������
SELECT EMPNO, ENAME, JOB, HIREDATE, SAL, GRADE 
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL AND
        (GRADE, SAL) IN 
        (SELECT GRADE, MAX(SAL) FROM EMP, SALGRADE 
            WHERE SAL BETWEEN LOSAL AND HISAL AND 
                    SAL>=3000 GROUP BY GRADE); -- ��������

-- �Ի��� �б⺰�� ���� ���� ������ �޴� ������� 
    --�б�, ���, �̸�, JOB, �����, �Ի���, �޿�, �󿩸� ����ϼ���
SELECT HIREDATE, CEIL(EXTRACT(MONTH FROM HIREDATE)/3) QUARTER FROM EMP;
SELECT HIREDATE, CEIL(TO_CHAR(HIREDATE, 'MM')/3) QUARTER FROM EMP;
-- ��������(�б⺰ ������� ����)
SELECT CEIL(EXTRACT(MONTH FROM HIREDATE)/3), MAX(SAL) FROM EMP
    GROUP BY CEIL(EXTRACT(MONTH FROM HIREDATE)/3);
SELECT CEIL(EXTRACT(MONTH FROM HIREDATE)/3) QUARTER, EMPNO, ENAME, JOB, MGR, 
        HIREDATE, SAL, COMM FROM EMP
    WHERE (CEIL(EXTRACT(MONTH FROM HIREDATE)/3), SAL) IN
        (SELECT CEIL(EXTRACT(MONTH FROM HIREDATE)/3), MAX(SAL) FROM EMP
                        GROUP BY CEIL(EXTRACT(MONTH FROM HIREDATE)/3))
    ORDER BY QUARTER;

--SALESMAN ��� ����� ���� �޿��� ���� �޴� ������� �̸��� �޿��� ����(��� ����)�� ����ϵ�
    -- ���� ���(JOB='SALESMAN')�� ������� �ʴ´�.(ALL�̿�)
SELECT ENAME, SAL, JOB FROM EMP 
    WHERE SAL > ALL(SELECT SAL FROM EMP WHERE JOB='SALESMAN') ;
SELECT ENAME, SAL, JOB FROM EMP
    WHERE SAL > (SELECT MAX(SAL) FROM EMP WHERE JOB='SALESMAN');
    
-- SALESMAN �Ϻ� � �� ������� �޿��� ���� �޴� ������� �̸��� �޿��� ����(��� ����)��
    --����ϵ� ���� ����� �����ؼ� ���(ANY)
SELECT ENAME, SAL, JOB FROM EMP 
    WHERE SAL > ANY (SELECT SAL FROM EMP WHERE JOB='SALESMAN');
    
SELECT ENAME, SAL, JOB FROM EMP
    WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE JOB='SALESMAN');
    
-- SAL�� 3000�̸��� ��� �߿� ���� �ֱٿ� �Ի��� ����� �����ȣ�� �̸�, ����, 
    --�Ի����� ���
SELECT EMPNO, ENAME, SAL, HIREDATE FROM EMP 
    WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP WHERE SAL<3000);
SELECT EMPNO, ENAME, SAL, HIREDATE FROM EMP 
    WHERE HIREDATE >= ALL (SELECT HIREDATE FROM EMP WHERE SAL<3000);

-- ������ ��SALESMAN���� ����� �޴� �޿��� �ּ� �޿����� ���� �޴� ������� 
    --�̸�, �޿�, ����, �μ���ȣ�� ����ϵ� �μ���ȣ�� 20���� ����� �����Ѵ�(ANY ������ �̿�)
SELECT ENAME, SAL, JOB, DEPTNO FROM EMP
    WHERE SAL > ANY (SELECT SAL FROM EMP WHERE JOB='SALESMAN') AND DEPTNO <> 20;
SELECT ENAME, SAL, JOB, DEPTNO FROM EMP 
    WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE JOB='SALESMAN') AND DEPTNO <> 20;




-- �� �ɿ�������
--1. ������̺��� ���� ���� �Ի��� ����� �̸�, �޿�, �Ի���
SELECT ENAME, SAL, HIREDATE FROM EMP WHERE HIREDATE=(SELECT MIN(HIREDATE) FROM EMP);

-- 2. ȸ�翡�� ���� �޿��� ���� ����� �̸�, �޿�
SELECT ENAME, SAL FROM EMP WHERE SAL=(SELECT MIN(SAL) FROM EMP);

-- 3. ȸ�� ��պ��� �޿��� ���� �޴� ����� �̸�, �޿�, �μ��ڵ�
SELECT ENAME, SAL, DEPTNO FROM EMP WHERE SAL>(SELECT AVG(SAL) FROM EMP);

--4. ȸ�� ��� ������ �޿��� �޴� ����� �̸�, �޿�, �μ���
SELECT ENAME, SAL, DNAME FROM EMP E, DEPT D 
    WHERE E.DEPTNO=D.DEPTNO AND SAL<=(SELECT AVG(SAL) FROM EMP);
    
--5. SCOTT���� ���� �Ի��� ����� �̸�, �޿�, �Ի���, �޿� ���
SELECT ENAME, SAL, HIREDATE, GRADE 
    FROM EMP, SALGRADE 
        WHERE SAL BETWEEN LOSAL AND HISAL
        AND HIREDATE<(SELECT HIREDATE FROM EMP WHERE ENAME='SCOTT');
        
--6. 5��(SCOTT���� ���� �Ի��� ����� �̸�, �޿�, �Ի���, �޿� ���)�� �μ��� �߰��ϰ� 
    --�޿��� ū �� ����
SELECT ENAME, SAL, HIREDATE, GRADE, DNAME 
    FROM EMP E, SALGRADE, DEPT D 
    WHERE SAL BETWEEN LOSAL AND HISAL AND 
        D.DEPTNO=E.DEPTNO AND 
        HIREDATE<(SELECT HIREDATE FROM EMP WHERE ENAME='SCOTT')  
        ORDER BY SAL DESC;
        
--7. ������̺��� BLAKE ���� �޿��� ���� ������� ���, �̸�, �޿��� �˻�
SELECT EMPNO, ENAME, SAL FROM EMP 
    WHERE SAL>(SELECT SAL FROM EMP WHERE ENAME='BLAKE');
    
--8. ������̺��� MILLER���� �ʰ� �Ի��� ����� ���, �̸�, �Ի����� �˻��Ͻÿ�
SELECT EMPNO, ENAME, HIREDATE FROM EMP 
    WHERE HIREDATE > (SELECT HIREDATE FROM EMP 
                        WHERE ENAME='MILLER');
                        
--9. ������̺��� �����ü ��� �޿����� �޿��� ���� ������� ���, �̸�, �޿��� �˻�
SELECT EMPNO, ENAME, SAL FROM EMP 
    WHERE SAL > (SELECT AVG(SAL) FROM EMP);
    
--10. ������̺��� CLARK�� ���� �μ���, ����� 7698�� ������ �޿����� 
        -- ���� �޿��� �޴� ������� ���, �̸�, �޿� �˻�
SELECT DEPTNO FROM EMP WHERE ENAME='CLARK'; -- ��������(CLARK�� �μ���ȣ)
SELECT SAL FROM EMP WHERE EMPNO=7698;  -- ��������(7698��� ������ �޿�)
SELECT EMPNO, ENAME, SAL FROM EMP 
    WHERE DEPTNO=(SELECT DEPTNO FROM EMP WHERE ENAME='CLARK') 
    AND SAL > (SELECT SAL FROM EMP WHERE EMPNO=7698);
    
--11.  �����ȭ. ������̺��� CLARK�� ���� �μ����̸�, ����� 7698�� ������ �޿����� 
    --  ���� �޿��� �޴� ������� ���, �̸�, �޿� �˻�
SELECT DNAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND ENAME='CLARK';-- ��������1
SELECT SAL FROM EMP WHERE EMPNO=7698; -- ��������2
SELECT EMPNO, ENAME, SAL FROM EMP E, DEPT D 
    WHERE E.DEPTNO=D.DEPTNO AND 
        DNAME=(SELECT DNAME FROM EMP E, DEPT D 
            WHERE E.DEPTNO=D.DEPTNO AND ENAME='CLARK') 
        AND SAL > (SELECT SAL FROM EMP WHERE EMPNO=7698);

--12.  ��� ���̺��� BLAKE�� ���� �μ��� �ִ� ��� ����� �̸��� �Ի����ڸ� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT ENAME, HIREDATE FROM EMP 
    WHERE DEPTNO=(SELECT DEPTNO FROM EMP WHERE ENAME='BLAKE');

--13.  ��� ���̺��� ��� �޿� �̻��� �޴� ��� �������� ���ؼ� �����ȣ�� �̸��� ���
        --(�� �޿��� ���� ������ ����Ͽ���.)
SELECT EMPNO, ENAME FROM EMP 
    WHERE SAL>=(SELECT AVG(SAL) FROM EMP) ORDER BY SAL DESC;

-- ���⼭���ʹ� �����༭������, ������ �����༭������
-- 14. ��� ���̺��� �̸��� ��T���� �ִ� ����� �ٹ��ϴ� �μ����� �ٹ��ϴ� ��� �������� ����
    --��� ��ȣ,�̸�,�޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�. �� �����ȣ ������ ����Ͽ���.
SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%T%'; 
SELECT EMPNO, ENAME, SAL FROM emp 
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%T%')
    ORDER BY EMPNO;

-- 15. ��� ���̺��� �μ� ��ġ�� Dallas�� ��� �������� ���� �̸�,����,�޿��� ���
SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS'; -- 20�� �μ� ���ϼ�������
SELECT ENAME, JOB, SAL FROM EMP 
    WHERE DEPTNO in (SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS');
SELECT ENAME, JOB, SAL FROM EMP E, DEPT D 
    WHERE E.DEPTNO=D.DEPTNO AND LOC='DALLAS';

-- 16. EMP ���̺��� King���� �����ϴ� ��� ����� �̸��� �޿��� ����ϴ� SELECT��
SELECT ENAME, SAL FROM EMP 
    WHERE MGR=(SELECT EMPNO FROM EMP WHERE ENAME='KING');
    
SELECT ENAME, SAL FROM EMP W 
    WHERE EXISTS (SELECT * FROM EMP WHERE EMPNO=W.MGR AND ENAME='KING');

-- 17. ��� ���̺��� SALES�μ� ����� �̸�,������ ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT ENAME, JOB FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME='SALES');
SELECT ENAME, JOB FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND DNAME='SALES';

-- 18. ��� ���̺��� ������ �μ� 30�� ���� ���޺��� ���� ����� ���
SELECT * FROM EMP WHERE SAL>(SELECT MIN(SAL)  FROM EMP WHERE DEPTNO=30);
SELECT * FROM EMP WHERE SAL > ANY (SELECT sal  FROM EMP WHERE DEPTNO=30);

-- 19. �μ� 10���� �μ� 30�� ����� ���� ������ �ð� �ִ� ����� �̸��� ������ ���
SELECT ENAME, JOB FROM EMP WHERE DEPTNO=10 AND 
            JOB IN (SELECT JOB FROM EMP WHERE DEPTNO=30);

-- 20. ��� ���̺��� FORD�� ������ ���޵� ���� ����� ��� ������ ���
SELECT * FROM EMP 
    WHERE (JOB, SAL) = (SELECT JOB, SAL FROM EMP 
                        WHERE ENAME='FORD') AND ENAME != 'FORD';

-- 21. �̸��� JONES�� ������ JOB�� ���ų� 
    --������ FORD ���� �̻��� ����� ������ �̸�,����,�μ���ȣ,�޿��� ����ϴ� SELECT���� �ۼ�.
    -- ��, ������ ���ĺ� ��, ������ ���� ������ ����Ͽ���.
SELECT JOB FROM EMP WHERE ENAME='JONES';--������ ��������
SELECT SAL FROM EMP WHERE ENAME='FORD'; --������ ��������
SELECT ENAME, JOB, DEPTNO, SAL FROM EMP 
    WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME='JONES') OR 
        SAL>=(SELECT SAL FROM EMP WHERE ENAME='FORD')
    ORDER BY JOB, SAL DESC;

-- 22. ��� ���̺��� SCOTT �Ǵ� WARD�� ������ ���� ����� ������ �̸�,����,�޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT ENAME, JOB, SAL FROM EMP 
    WHERE SAL IN (SELECT SAL FROM EMP WHERE ENAME='SCOTT' OR ENAME='WARD') 
        AND ENAME NOT IN ('SCOTT', 'WARD');
SELECT ENAME, JOB, SAL FROM EMP 
    WHERE SAL IN (SELECT SAL FROM EMP WHERE ENAME IN ('SCOTT','WARD')) 
        AND ENAME NOT IN ('SCOTT','WARD');

-- 23. ��� ���̺��� CHICAGO���� �ٹ��ϴ� ����� ���� ������ �ϴ� ������� �̸�,������ ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT ENAME, JOB FROM EMP 
    WHERE JOB IN (SELECT JOB FROM EMP E, DEPT D 
                    WHERE E.DEPTNO=D.DEPTNO AND LOC='CHICAGO');
    
-- 24. ��� ���̺��� ������ �μ��� ��� ���޺��� ���� ����� �����ȣ,�̸�,�޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
--�����ȣ, �̸�, �޿�, DEPTNO, �ش�μ������SAL
SELECT EMPNO, ENAME, SAL
    FROM EMP E
    WHERE SAL > (SELECT AVG(SAL) FROM EMP WHERE DEPTNO=E.DEPTNO);

-- 25. �������� ������ ��� ���޺��� ���� ����� �μ���ȣ,�̸�,�޿��� ���
SELECT JOB, AVG(SAL) FROM EMP GROUP BY JOB;
SELECT DEPTNO,ENAME,SAL FROM EMP 
    WHERE SAL < ALL(SELECT AVG(SAL) FROM EMP
        GROUP BY JOB); --������������ϰ� �ƴϴ�.�̷��� ���� �����Ű���
SELECT DEPTNO, ENAME, SAL FROM EMP E 
    WHERE SAL < (SELECT AVG(SAL) FROM EMP WHERE E.JOB=JOB);

-- 26 ��� ���̺��� ��� �Ѹ� �̻����κ��� ���� ���� �� �ִ� ����� 
    --����,�̸�,�����ȣ,�μ���ȣ�� ���(��, �μ���ȣ ������ �������� ����)
SELECT JOB, ENAME, EMPNO, DEPTNO FROM EMP M 
    WHERE EXISTS (SELECT EMPNO FROM EMP W WHERE M.EMPNO=W.MGR) 
    ORDER BY DEPTNO;
SELECT JOB, ENAME, EMPNO, DEPTNO FROM EMP
    WHERE EMPNO IN (SELECT MGR FROM EMP);
-- 27. ��� ���̺��� ���� ����� �����ȣ,�̸�,����,�μ���ȣ�� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP E 
    WHERE NOT EXISTS (SELECT EMPNO FROM EMP WHERE E.EMPNO=MGR);
SELECT M.EMPNO, M.ENAME, M.JOB, M.DEPTNO FROM EMP W, EMP M 
    WHERE W.MGR(+)=M.EMPNO AND W.ENAME IS NULL; 
-- �������� ����� NULL�� �־� �Ʒ��� ���Ǵ� �� ��
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP
    WHERE EMPNO NOT IN (SELECT DISTINCT MGR FROM EMP); 
--�׷��� �Ʒ��� ���� ��
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP
    WHERE EMPNO NOT IN (SELECT DISTINCT MGR FROM EMP WHERE MGR IS NOT NULL);