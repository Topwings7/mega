--1 TO_DATE �������Լ��� �̿��Ͽ� EMP ���̺��� 
--hiredate�� 1981�� 2�� 20�� 1981�� 5�� 1�� ���̿� �Ի��� ����� �����, ��å, 
--�Ի����� ���� �Ի��Ϻ��� �ֱ� �Ի��� ������ �����Ͽ� ���
SELECT ENAME, JOB, HIREDATE FROM EMP 
  WHERE HIREDATE BETWEEN TO_DATE('19810220','YYYYMMDD')
  AND TO_DATE('19810501','YYYYMMDD')  ORDER BY HIREDATE;

SELECT ENAME, JOB, HIREDATE FROM EMP
  WHERE HIREDATE BETWEEN TO_DATE('1981/02/20','YYYY/MM/DD')
  AND TO_DATE('1981/05/01','YYYY/MM/DD')  ORDER BY HIREDATE;
--2 EMP���̺�� DEPT���̺��� �̿��Ͽ� �����, �޿�, �μ���ȣ, �μ���, �ٹ���, ���ӻ����� 
-- ����Ͻÿ�. ��, ���ӻ�簡 ���� ��� ���ӻ����� ������������ ��� ����Ͻÿ�.
SELECT W.ENAME, W.SAL, W.DEPTNO, DNAME, LOC, NVL(M.ENAME,'����') ����
  FROM EMP W, EMP M, DEPT D  WHERE W.MGR=M.EMPNO(+) AND W.DEPTNO=D.DEPTNO;

SELECT W.ENAME, W.SAL, W.DEPTNO, DNAME, LOC, NVL(M.ENAME,'����') ����
  FROM EMP W, EMP M, DEPT D  WHERE W.DEPTNO=D.DEPTNO AND W.MGR=M.EMPNO(+);
--3 EMP���̺��� ����� ���ĺ� L�� �ִ� ����� ���� �����, ��å, �μ���, �ٹ����� ���
SELECT ENAME, JOB, DNAME, LOC
  FROM EMP E, DEPT D
  WHERE E.DEPTNO=D.DEPTNO AND ENAME LIKE '%L%';
--4 SALGRADE ���̺��� LOSAL�� ������� �޿�, HISAL�� ��� �ְ� �޿��� �̿��Ͽ�, 
--EMP���̺��� ����� ���, �����, ��å, �޿�, �޿������ �޿��������� �������� �����Ͽ� ���
SELECT EMPNO, ENAME, JOB, SAL, GRADE
  FROM EMP, SALGRADE
  WHERE SAL BETWEEN LOSAL AND HISAL
  ORDER BY SAL DESC;   
--5 EMP ���̺��� �μ���ȣ�� 20���� ����� ���, �����, �޿��� ����ϵ� 
-- �޿� �տ��� $�� ���̰�, ���ڴ� 3�ڸ����� �޸�(,)�� �߰��Ͽ� ���
SELECT EMPNO, ENAME, TO_CHAR(SAL, '$99,999') FROM EMP WHERE DEPTNO=20;
--6 EMP���̺�� DEPT ���̺��� ���� ������� 5�� �̻��� �μ���� ������� ����ϴ� 
-- SQL���� �׷��Լ��� ���̺� JOIN�� �̿��Ͽ� �ۼ��Ͻÿ�.
SELECT DNAME, COUNT(*) FROM EMP E, DEPT D
    	WHERE E.DEPTNO=D.DEPTNO GROUP BY DNAME HAVING COUNT(*)>=5;
--7 EMP���̺��� ������� ��FORD���� ������ ��å(JOB)�� �޿�(SAL)�� ���� ����� ��� ���� ���
SELECT * FROM EMP WHERE (JOB, SAL) IN (SELECT JOB, SAL FROM EMP 
                                    WHERE ENAME='FORD') AND ENAME != 'FORD';
SELECT * FROM emp WHERE (JOB, SAL) = (SELECT JOB, SAL FROM EMP 
                                    WHERE ENAME='FORD') AND ENAME <> 'FORD';
--8 EMP���̺��� �̸�(ENAME)�� ��KING���� ����� ���Ӻ����� �����(ENAME)�� �޿�(SAL)�� ����ϴ� SQL���� �ۼ��Ͻÿ�(��������, EXISTS�����ڸ� �̿��� ��������, SELF-JOIN).
SELECT ename, sal FROM emp 
    WHERE mgr=(SELECT empno FROM emp WHERE ename='KING');
SELECT ENAME, SAL FROM EMP W 
    WHERE EXISTS (SELECT * FROM EMP M WHERE M.EMPNO=W.MGR 
                                AND ENAME='KING');
SELECT W.ENAME, W.SAL FROM EMP W, EMP M
                   WHERE W.MGR=M.EMPNO AND M.ENAME='KING';
--1 EMP ���̺��� �޿�(SAL)�� ������ �μ��� ��� �޿����� ���� ����鸸 ���, �����, 
--�޿�, �μ���ȣ�� ����ϴ� SQL���� �ۼ��Ͻÿ�.
SELECT empno, ename, sal, DEPTNO FROM emp e WHERE sal > (SELECT avg(sal) 
	     FROM emp WHERE e.deptno=deptno);

--2 EMP ���̺��� ������� ��FORD���� ����� �����ϴ� SQL���� �ۼ��Ͻÿ�.
DELETE FROM EMP WHERE ENAME='FORD';
--3 EMP ���̺��� �޿�(SAL)�� 3000�̻��� ����鸸 �޿�(SAL)�� 10% �λ��Ű�� SQL���� �ۼ��Ͻÿ�.
UPDATE EMP SET SAL=SAL*1.1 WHERE SAL>=3000;
--4 EMP���̺��� SCOTT����� �μ���ȣ(DEPTNO)�� 20������, ��å(JOB)�� MANAGER�� �����ϴ� SQL���� �ۼ��Ͻÿ�
UPDATE EMP SET DEPTNO=20, JOB='MANAGER' WHERE ENAME=��SCOTT��;
--5 EMP ���̺�� DEPT ���̺��� �̿��Ͽ�, ��DALLAS������ �ٹ��ϴ� �������� �޿�(SAL)�� 1000�� �λ��Ű�� SQL���� �ۼ��Ͻÿ�.
UPDATE EMP SET SAL = SAL+1000 
    WHERE DEPTNO=(SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS');
--6 EMP ���̺��� �ֱ��Ի��ϼ����� 6��°�� ������� �ֱ��Ի��� �� 10��° �������
--���, �����, �Ի����� ����ϴ� SQL���� �ۼ��Ͻÿ�.
SELECT RN, EMPNO, ENAME, HIREDATE
    FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM EMP ORDER BY HIREDATE DESC) A)
    WHERE RN BETWEEN 6 AND 10;

SELECT EMPNO, ENAME, HIREDTEE
    FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM EMP ORDER BY HIREDATE DESC) A)
    WHERE RN BETWEEN 6 AND 10;
--7 �����ͺ��̽����� Ʈ������� ������ ó���� �� ������ ���Ѵ�. �����͸� �����ϱ� ���� INSERT, UPDATE, DELETE ���� ��ɵ��� ����ʰ� ���ÿ� Ʈ������� ����Ǵµ�, �̵� INSERT, UPDATE, DELETE�۾��� ���������� �����ͺ��̽��� �ݿ���ó���ǵ��� ��ɾ �ۼ��Ͻÿ�.
COMMIT;