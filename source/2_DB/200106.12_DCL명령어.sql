-- DCL (CREATE USER ~, ALTER USER~, GRANT, REVOKE, DROP USER) - DBA������ ���� �� ����
CREATE USER gong IDENTIFIED BY gong; -- ����� ����
ALTER USER gong IDENTIFIED BY tiger; -- ��й�ȣ ����
select * from empv1;
GRANT CREATE SESSION TO gong;
-- ������ grant(���Ѻο�)���� �ʰ� ���Ѱ�ü�� ���� �ѹ��� ������ �ִ°�
CREATE ROLE ROLLEX1; -- ROLLEX1���� ��ü ����
-- ROLLEX1�� �α���, ���̺����, ������� �� �ִ� ���� ��ü
GRANT CREATE SESSION, CREATE TABLE, CREATE VIEW TO ROLLEX1; 
GRANT ROLLEX1 TO gong;
GRANT SELECT ON EMPv1 TO gong; -- gong�� scott�� ������ �ִ� EMPv1 ���̺��� SELECT
SHOW USER;
GRANT ALL ON EMPv1 TO gong;
select * from empV1;
select * from emp;
GRANT ALL ON SALGRADE TO gong;
REVOKE ALL ON SALGRADE FROM gong;
GRANT SELECT ON SALGRADE TO gong;
DROP USER gong CASCADE; -- ����� ����




