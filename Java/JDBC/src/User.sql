
CREATE TABLE USERDTO(
	ID VARCHAR2(50),
	NAME VARCHAR2(50),
	AGE NUMBER(3),
	JOINDATE DATE
);	-- 새로운 테이블이 생성됨

-- 이 sql을 저장하면 데이터베이스와 연결하는 일종의 클래스가 생성된다고 보면 됨. (JDBC 참조)

SELECT * FROM USERDTO;