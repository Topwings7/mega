DROP TABLE MEMBER CASCADE CONSTRAINTS;
CREATE TABLE MEMBER(
    ID VARCHAR2(20) PRIMARY KEY,
    NAME VARCHAR2(20) NOT NULL,
    PW VARCHAR2(20) NOT NULL, 
    PHONE1 VARCHAR2(10),
    PHONE2 VARCHAR2(10),
    PHONE3 VARCHAR2(10),
    GENDER VARCHAR2(10)
);
-- ȸ������(id, name, pw, phone1, phone2, phone3, gender)
INSERT INTO MEMBER VALUES ('bbb','ȫ�浿ȫ�浿ȫ','111','02','9999','9999','f');
-- �α��� (id, pw)
-- 1. id�� pw�� �´���
-- 2. id�� ������ �� ���̵��� ����� ����(session�� �߰��ϱ� ����)
SELECT * FROM MEMBER WHERE ID='aaa' AND PW='111';
-- ȸ����������
SELECT * FROM MEMBER WHERE ID='aaa';
UPDATE MEMBER 
    SET NAME='ȫ�浿', PW='111', PHONE1 = '010', PHONE2='8888',PHONE3='8888',GENDER='f'
    WHERE ID='aaa';
commit;
select * from member;





