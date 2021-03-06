DROP TABLE MEMBER CASCADE CONSTRAINTS;
CREATE TABLE MEMBER(
    ID VARCHAR2(30) PRIMARY KEY,
    PW VARCHAR2(30) NOT NULL,
    NAME VARCHAR2(30) NOT NULL,
    EMAIL VARCHAR2(30),
    BIRTH DATE NOT NULL,
    RDATE DATE NOT NULL,
    ADDRESS VARCHAR2(200));
-- 1. 회원가입시 id 중복체크를 위한 SQL
SELECT * FROM MEMBER WHERE ID='aaa';
-- 2. 회원가입 SQL
INSERT INTO MEMBER (ID, PW, NAME, EMAIL, BIRTH, RDATE, ADDRESS) 
    VALUES ('aaa','1','홍길동',null, '1990-01-01',SYSDATE, '서울시 종로구 수표로 105 육의전빌딩 803호');
INSERT INTO MEMBER (ID, PW, NAME, EMAIL, BIRTH, RDATE, ADDRESS) 
    VALUES ('bbb','1','이소영',null, '1980-01-01',SYSDATE, '서울시 용산구');
-- 3. 로그인할 때 (ID/PW)
SELECT * FROM MEMBER WHERE ID='aaa';
-- 4. ID로 DTO 가져오기
SELECT * FROM MEMBER WHERE ID='aaa';
-- 5. 회원정보 수정
UPDATE MEMBER SET PW='111',
                NAME='김길동',
                EMAIL='a@a.com',
                BIRTH='1990-01-01',
                ADDRESS='서울시 용산구'
        WHERE ID='aaa';
commit;
SELECT * FROM member;