-- 2019.12.20_ 3��. JOIN(���̺���� JOIN)
SELECT * FROM EMP; -- �������(14��)
SELECT * FROM DEPT; -- �μ�����

SELECT * FROM EMP WHERE ENAME='SMITH';
SELECT * FROM DEPT;
SELECT * FROM EMP, DEPT WHERE ENAME='SMITH'; -- (1) CROSS JOIN
-- (2) ����JOIN(EQUI JOIN) : 2���� ���̺� ������ �ʵ尡 �ִ� ���(DEPT, EMP���̺� DEPTNO)
SELECT * FROM EMP, DEPT
    WHERE ENAME='SMITH' AND EMP.DEPTNO=DEPT.DEPTNO;
SELECT * FROM EMP, DEPT
    WHERE EMP.DEPTNO=DEPT.DEPTNO;
SELECT E.*, DNAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO; -- ���̺��� ������ �ָ� ����.
-- ���, �̸�, �μ���ȣ, �μ��̸�, �ٹ���
SELECT EMPNO, ENAME, E.DEPTNO, DNAME, LOC FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO;
-- ���, �̸�, �޿�, �μ���ȣ(�μ��ڵ�), �μ���
SELECT EMP.EMPNO, EMP.ENAME, EMP.SAL, DEPT.DEPTNO, DEPT.DNAME FROM EMP, DEPT
    WHERE EMP.DEPTNO=DEPT.DEPTNO;
-- �̸�, ����, �޿�, �μ���, �ٹ���. �޿��� 2000�̻�
SELECT ENAME, JOB, SAL, DNAME, LOC FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND SAL>=2000;
-- �̸�, ����, �μ���, �ٹ���. �ٹ����� CHICAGO�� ���
SELECT ENAME, JOB, DNAME, LOC FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND LOC='CHICAGO';
-- �̸�, ����, �ٹ���. deptno�� 10 �Ǵ� 20�� ���, �޿��� ����
SELECT ENAME, JOB, LOC FROM EMP E, DEPT D 
    WHERE E.DEPTNO=D.DEPTNO AND E.DEPTNO IN (10,20)
    ORDER BY SAL;
-- �̸�, �޿�, comm, ����(��Ī), �μ���, �ٹ���. ����=(SAL+comm)*12 �� comm�� Null�̸� 0
SELECT ENAME, SAL, COMM, (SAL+NVL(COMM,0))*12 "����", DNAME, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO;
-- ������ JOB�� SALESMAN�̰ų� MANAGER�� ������� ������ ū ������� ���
SELECT ENAME, SAL, NVL(COMM, 0), (SAL+NVL(COMM,0))*12 "����", DNAME, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND JOB IN ('SALESMAN', 'MANAGER')
    ORDER BY ���� DESC;
-- �̸�, �޿�, �Ի���, �μ��ڵ�(��ȣ), �μ���. comm�� null�̰� �޿��� 1200�̻��� ���. 
        -- �μ���� ����. �μ����� ������ �޿�ū��
SELECT ENAME, SAL, HIREDATE, E.DEPTNO, DNAME FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND COMM IS NULL AND SAL>=1200
    ORDER BY DNAME, SAL DESC;
-- źź������
--	���忡�� �ٹ��ϴ� ����� �̸��� �޿��� ����Ͻÿ�
SELECT ENAME, SAL FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND LOC='NEW YORK';
--	ACCOUNTING �μ� �Ҽ� ����� �̸��� �Ի����� ����Ͻÿ�
SELECT ENAME, HIREDATE FROM DEPT D, EMP E WHERE D.DEPTNO=E.DEPTNO AND DNAME='ACCOUNTING';
--	������ MANAGER�� ����� �̸�, �μ����� ����Ͻÿ�
SELECT ENAME, DNAME FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND JOB='MANAGER';
--	Comm�� null�� �ƴ� ����� �̸�, �޿�, �μ��ڵ�, �ٹ����� ����Ͻÿ�.
SELECT ENAME, SAL, E.DEPTNO, LOC FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND COMM IS NOT NULL;
    
-- (3) NON-EQUI JOIN (������ �ʵ尡 ���� 2���� ���̺��� JOIN)
SELECT * FROM EMP; -- ������̺�
SELECT * FROM SALGRADE; -- �޿� ��� ����
SELECT ENAME, SAL, SALGRADE.* FROM EMP, SALGRADE 
    WHERE ENAME='SMITH' AND SAL BETWEEN LOSAL AND HISAL;
SELECT ENAME, SAL, GRADE||'���' GRADE
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL;
-- �̸�, �޿� (�޿�>=2000)
SELECT ENAME, SAL FROM EMP WHERE SAL>=2000;
-- źź������
-- Comm�� null�� �ƴ� ����� �̸�, �޿�, ���, �μ���ȣ, �μ��̸�, �ٹ����� ����Ͻÿ�.
SELECT ENAME, SAL, GRADE, E.DEPTNO, DNAME, LOC
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL
        AND COMM IS NOT NULL;
-- �̸�, �޿�, �Ի���, �޿���� (�޿������ ū ������� ����, �޿������ ������ SAL ū �������)
SELECT ENAME, SAL, HIREDATE, GRADE FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL
    ORDER BY GRADE DESC, SAL DESC;
-- �̸�, �޿�, �Ի���, �޿����, �μ���, �ٹ���
SELECT ENAME, SAL, HIREDATE, GRADE, DNAME, LOC
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL;
-- �̸�, �޿�, ���, �μ��ڵ�, �ٹ���. �� comm �� null�ƴ� ���
SELECT ENAME, SAL, GRADE, E.DEPTNO, LOC FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL
        AND COMM IS NOT NULL;
-- �̸�, �޿�, �޿����, ����, �μ���, (�μ��� ���, �μ��� ������ ������) 
    --����=(sal+comm)*12 comm�� null�̸� 0
SELECT ENAME, SAL, GRADE, (SAL+NVL(COMM,0))*12 "����", DNAME
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL
    ORDER BY DNAME, ����;
-- �̸�, ����, �޿�, ���, �μ��ڵ�, �μ��� ���.
--�޿��� 1000~3000����. �������� : �μ���, �μ������� ������, ���������� �޿� ū��
SELECT ENAME, JOB, SAL, GRADE, E.DEPTNO, DNAME
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL
        AND SAL BETWEEN 1000 AND 3000
    ORDER BY DNAME, JOB, SAL DESC;   
-- �̸�, �޿�, ���, �Ի���, �ٹ���. 81�⿡ �Ի��� ���. ��� ū��
SELECT ENAME, SAL, GRADE, TO_CHAR(HIREDATE,'YY"��" MM"�� "DD"��" DY"����" AM HH:MI:SS'), 
    LOC
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL
        AND TO_CHAR(HIREDATE, 'YYYY') = '1981';

-- (4) SELF JOIN : �����̺��� ���� JOIN
SELECT EMPNO, ENAME, MGR FROM EMP; -- MGR : �����ӻ���� ���
SELECT WORKER.EMPNO, WORKER.ENAME, WORKER.MGR,  MANAGER.EMPNO, MANAGER.ENAME
    FROM EMP WORKER, EMP MANAGER
    WHERE WORKER.ENAME='SMITH' AND WORKER.MGR=MANAGER.EMPNO;
-- ���, ���ӻ���� �̸�
SELECT W.ENAME "����̸�", W.MGR "��������ӻ����", M.EMPNO "����ǻ��", M.ENAME "����̸�"
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO;
SELECT W.ENAME, M.ENAME FROM EMP W, EMP M WHERE W.MGR=M.EMPNO;
SELECT * FROM EMP;
-- XX�� ���� XX��
SELECT W.ENAME || '�� ���� ' || M.ENAME
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO;
--	�Ŵ����� KING�� ������� �̸��� ������ ����Ͻÿ�.
SELECT W.ENAME, W.JOB
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO AND M.ENAME='KING';
--	SCOTT�� ������ �μ���ȣ���� �ٹ��ϴ� ����� �̸��� ����Ͻÿ�(1�ܰ�)
SELECT E1.ENAME , E1.DEPTNO, E2.DEPTNO, E2.ENAME
    FROM EMP E1, EMP E2
    WHERE E1.ENAME='SCOTT' AND E1.DEPTNO=E2.DEPTNO; -- ���ܰ�
SELECT E2.ENAME FROM EMP E1, EMP E2
    WHERE E1.DEPTNO=E2.DEPTNO AND E1.ENAME='SCOTT' AND E2.ENAME <> 'SCOTT'; -- ���� ��
--	SCOTT�� ������ �ٹ������� �ٹ��ϴ� ����� �̸��� ����Ͻÿ�(2�ܰ� ��������)
SELECT E1.ENAME, E1.DEPTNO, D1.DNAME, E2.ENAME, E2.DEPTNO, D2.DNAME
    FROM EMP E1, DEPT D1, EMP E2, DEPT D2
    WHERE E1.DEPTNO=D1.DEPTNO AND E2.DEPTNO=D2.DEPTNO -- EQUI JOIN
        AND E1.ENAME='SCOTT' 
        AND D1.LOC=D2.LOC;    -- SELF JOIN (���ܰ�)
SELECT E2.ENAME FROM EMP E1, DEPT D1, EMP E2, DEPT D2
    WHERE E1.DEPTNO=D1.DEPTNO AND E2.DEPTNO=D2.DEPTNO AND D1.LOC=D2.LOC
        AND E1.ENAME='SCOTT' AND E2.ENAME <> 'SCOTT'; -- ���̺��� 4���� ���� �� ���� ��
        
-- TEST ��
SELECT * FROM DEPT;
INSERT INTO DEPT VALUES (50,'IT','DALLAS'); -- 1�� ����
SELECT * FROM EMP;
INSERT INTO EMP VALUES (9999,'ȫ�浿','MANAGER',7902,'19/12/20',1000,NULL,50);
ROLLBACK; -- INSERT ���

-- (5) OUTER JOIN : ���� ���ǿ� �������� �ʴ� ���� ��Ÿ���� �ϴ� ����
SELECT W.ENAME "����", W.MGR, M.EMPNO, M.ENAME "���ӻ��"
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO(+);
-- XX�� �Ŵ����� XX(��)�Դϴ�
SELECT W.ENAME || '�� �Ŵ����� ' || NVL(M.ENAME, '��') || '�Դϴ�'
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO(+);
-- ���� ����� ����Ʈ
SELECT M.ENAME FROM EMP W, EMP M WHERE W.MGR(+)=M.EMPNO AND W.ENAME IS NULL;
-- EQUI JOIN���� �սǵ� ������
SELECT * FROM EMP; -- 14�� (10,20,30)
SELECT * FROM DEPT; -- 4�� �μ� (10,20,30,40)
SELECT * FROM EMP, DEPT WHERE EMP.DEPTNO(+)=DEPT.DEPTNO;
-- �̸�, ����(JOB), �μ���(DNAME), �޿�(SAL) ���
    --(��, ������ ���� �μ��� �Բ� ���. �μ���, �޿�ū�� ����)
SELECT NVL(ENAME,'-'), NVL(JOB,'-'), DNAME, NVL(TO_CHAR(SAL, '9999'),'-') 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO(+) = D.DEPTNO
    ORDER BY DNAME, SAL DESC;
-- �� <�� ��������> PART1
--1. �̸�, ���ӻ��
SELECT W.ENAME, M.ENAME ���ӻ�� 
  FROM EMP W, EMP M
  WHERE W.MGR=M.EMPNO;
--2. �̸�, �޿�, ����, ���ӻ��
SELECT W.ENAME, W.SAL, W.JOB, M.ENAME ���ӻ��
  FROM EMP W, EMP M 
  WHERE W.MGR=M.EMPNO;
--3. �̸�, �޿�, ����, ���ӻ��. (��簡 ���� �������� ��ü ���� �� ���.
    --��簡 ���� �� '����'���� ���)
SELECT W.ENAME, W.SAL, W.JOB, NVL(M.ENAME,'����') ��� 
  FROM EMP W, EMP M 
  WHERE W.MGR=M.EMPNO(+);
--4. �̸�, �޿�, �μ���, ���ӻ���
SELECT W.ENAME, W.SAL, DNAME, M.ENAME ���ӻ���
  FROM EMP W, EMP M, DEPT D 
  WHERE W.DEPTNO=D.DEPTNO AND W.MGR=M.EMPNO;
--5. �̸�, �޿�, �μ��ڵ�, �μ���, �ٹ���, ���ӻ���, (��簡 ���� �������� ��ü ���� �� ���)
SELECT W.ENAME, W.SAL, W.DEPTNO, DNAME, LOC, NVL(M.ENAME,'����') ���� 
  FROM EMP W, EMP M, DEPT D
  WHERE W.MGR=M.EMPNO(+) AND W.DEPTNO=D.DEPTNO;
--6. �̸�, �޿�, ���, �μ���, ���ӻ���. �޿��� 2000�̻��� ���
SELECT W.ENAME, W.SAL, GRADE, DNAME, M.ENAME ���ӻ���
  FROM EMP W, EMP M, DEPT D, SALGRADE
  WHERE W.MGR=M.EMPNO(+) AND W.DEPTNO=D.DEPTNO AND W.SAL BETWEEN LOSAL AND HISAL
        AND w.sal>=2000; -- ���ӻ�簡 ���� �������� ����Ϸ��� (+) OUTER JOIN
        
--7. �̸�, �޿�, ���, �μ���, ���ӻ���, (���ӻ�簡 ���� �������� ��ü���� �μ��� �� ����)
SELECT W.ENAME, W.SAL, GRADE, DNAME, M.ENAME ���ӻ���
  FROM EMP W, EMP M, DEPT D, SALGRADE
  WHERE W.MGR=M.EMPNO(+) AND W.DEPTNO=D.DEPTNO AND W.SAL BETWEEN LOSAL AND HISAL
  ORDER BY DNAME;
--8. �̸�, �޿�, ���, �μ���, ����, ���ӻ���. ����=(�޿�+comm)*12 �� comm�� null�̸� 0
SELECT W.ENAME, W.SAL, GRADE, DNAME, (W.SAL+NVL(W.COMM,0))*12 ����, M.ENAME ����
  FROM EMP W, EMP M, DEPT D, SALGRADE 
  WHERE W.MGR=M.EMPNO(+) AND W.DEPTNO=D.DEPTNO AND W.SAL BETWEEN LOSAL AND HISAL;
--9. 8���� �μ��� �� �μ��� ������ �޿��� ū �� ����
SELECT W.ENAME, W.SAL, GRADE, DNAME, (W.SAL+NVL(W.COMM,0))*12 ����, M.ENAME ��� 
  FROM EMP W, EMP M, DEPT D, SALGRADE
  WHERE W.MGR=M.EMPNO(+) AND W.DEPTNO=D.DEPTNO AND W.SAL BETWEEN LOSAL AND HISAL
  ORDER BY DNAME, W.SAL DESC;
--  PART2
--1.EMP ���̺��� ��� ����� ���� �̸�,�μ���ȣ,�μ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT ENAME, E.DEPTNO, DNAME 
  FROM EMP E, DEPT D 
  WHERE E.DEPTNO=D.DEPTNO;
--2. EMP ���̺��� NEW YORK���� �ٹ��ϰ� �ִ� ����� ���Ͽ� �̸�,����,�޿�,�μ����� ���
SELECT ENAME, JOB, SAL, DNAME 
  FROM EMP E, DEPT D 
  WHERE E.DEPTNO=D.DEPTNO AND LOC='NEW YORK';
--3. EMP ���̺��� ���ʽ��� �޴� ����� ���Ͽ� �̸�,�μ���,��ġ�� ���
SELECT ENAME, DNAME, LOC
  FROM EMP E, DEPT D
  WHERE E.DEPTNO=D.DEPTNO AND COMM IS NOT NULL AND COMM <> 0;
--4. EMP ���̺��� �̸� �� L�ڰ� �ִ� ����� ���Ͽ� �̸�,����,�μ���,��ġ�� ���
SELECT ENAME, JOB, DNAME, LOC
  FROM EMP E, DEPT D
  WHERE E.DEPTNO=D.DEPTNO AND ENAME LIKE '%L%';
--5. ���, �����, �μ��ڵ�, �μ����� �˻��϶�. ������������ ������������
SELECT EMPNO, ENAME, D.DEPTNO, DNAME
  FROM EMP E, DEPT D
  WHERE E.DEPTNO=D.DEPTNO
  ORDER BY ENAME;
--6. ���, �����, �޿�, �μ����� �˻��϶�. 
    --�� �޿��� 2000�̻��� ����� ���Ͽ� �޿��� �������� ������������ �����Ͻÿ�
SELECT EMPNO, ENAME, SAL, DNAME
  FROM EMP E, DEPT D
  WHERE E.DEPTNO=D.DEPTNO AND SAL>=2000
  ORDER BY SAL DESC;
--7. ���, �����, ����, �޿�, �μ����� �˻��Ͻÿ�. �� ������ MANAGER�̸� �޿��� 2500�̻���
-- ����� ���Ͽ� ����� �������� ������������ �����Ͻÿ�.
SELECT EMPNO, ENAME, JOB, SAL, DNAME
  FROM EMP E, DEPT D
  WHERE E.DEPTNO=D.DEPTNO AND JOB='MANAGER' AND SAL>=2500
  ORDER BY EMPNO;
--8. ���, �����, ����, �޿�, ����� �˻��Ͻÿ�. ��, �޿����� ������������ �����Ͻÿ�
SELECT EMPNO, ENAME, JOB, SAL, GRADE
  FROM EMP, SALGRADE
  WHERE SAL BETWEEN LOSAL AND HISAL
  ORDER BY SAL DESC;
--9. ������̺��� �����, ����� ��縦 �˻��Ͻÿ�(��簡 ���� �������� ��ü)
SELECT W.ENAME �����, M.ENAME ���
  FROM EMP W, EMP M
  WHERE W.MGR=M.EMPNO(+);
--10. �����, ����, ����� ������ �˻��Ͻÿ�
SELECT W.ENAME ���, M.ENAME ���
  FROM EMP W, EMP M, EMP MM
  WHERE W.MGR=M.EMPNO AND M.MGR=MM.EMPNO;
--11. ���� ������� ���� ��簡 ���� ��� ������ �̸��� ��µǵ��� �����Ͻÿ�
SELECT W.ENAME ���, NVL(M.ENAME,'') ���, MM.ENAME "����� ���"
  FROM EMP W, EMP M, EMP MM
  WHERE W.MGR=M.EMPNO(+) AND M.MGR=MM.EMPNO(+);
SELECT W.ENAME ���, '��'||M.ENAME ���, '��'||MM.ENAME "����� ���"
  FROM EMP W, EMP M, EMP MM
  WHERE W.MGR=M.EMPNO(+) AND M.MGR=MM.EMPNO(+);