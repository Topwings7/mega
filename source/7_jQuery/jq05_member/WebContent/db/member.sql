DROP TABLE MEMBER CASCADE CONSTRAINTS;
CREATE TABLE MEMBER(
    ID VARCHAR2(30) PRIMARY KEY,
    PW VARCHAR2(30), 
    NAME VARCHAR2(30),
    BIRTH DATE,
    GENDER VARCHAR2(30),
    EMAIL VARCHAR2(30) UNIQUE,
    TEL VARCHAR2(30),
    ADDRESS VARCHAR2(30)
);
INSERT INTO MEMBER (ID, PW, NAME, BIRTH, GENDER, EMAIL, TEL, ADDRESS)
    VALUES ('aaa','111','홍길동','1990/01/01','m','hong@naver.com','010-9999-9999','서울');
SELECT * FROM MEMBER WHERE ID='aaa';
SELECT * FROM MEMBER WHERE EMAIL='hong@naver.com';
SELECT * FROM MEMBER;
commit;
SELECT * FROM MEMBER WHERE ID='aaa' and PW='111';