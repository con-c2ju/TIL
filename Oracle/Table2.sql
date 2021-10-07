/*
    무결성 : CONSTRAINT
            cloumn을 지정하는 성질
    
    Primary Key : 기본키. NULL을 허용하지 않음 & 중복을 허용하지 않음 (ex. ID)
    Unique Key : 고유키. NULL을 허용 & 중복을 허용하지 않음 (ex. email)
    Foreign Key : 외래키. 테이블과 테이블을 연결하는 것이 목적(=join이 목적)
                  NULL을 허용
                  외래키로 설정된 컬럼은 연결된 테이블의 컬럼에서 Primary Key나 Unique Key로 설정되어 있어야 함
    CHECK : 범위를 설정, 값을 지정할 수도 있다. 지정된 값 외에는 사용할 수 없다. NULL을 허용
    NOT NULL : NULL을 허용하지 않음 & 중복을 허용 (ex. 이름: 중복될 수는 있지만 빈캄일 수는 없음)
*/

-- NOT NULL
DROP TABLE TB_TEST04;

CREATE TABLE TB_TEST04(
    COL1 VARCHAR2(10) NOT NULL,     -- NULL값 설정 불가
    COL2 VARCHAR2(20) 
);

INSERT INTO tb_test04(COL1,COL2)
VALUES('BBB','');   -- NULL을 허용하면 빈칸을 넣을 수 있음

SELECT * FROM tb_test04;

-- CHECK: 지정된 값만 삽입 가능
CREATE TABLE TB_CHECK(
    COL1 VARCHAR2(10),
    COL2 VARCHAR2(20),
    CONSTRAINT CHK_01 CHECK( COL1 IN('사과', '배', '바나나') ),
    CONSTRAINT CHK_02 CHECK( COL2 > 0 and COL2 <= 10 )  -- 범위지정도 가능
);

INSERT INTO TB_CHECK(COL1, COL2)
VALUES('사과', 5);

INSERT INTO TB_CHECK(COL1, COL2)
VALUES('귤', 5); -- 제약 조건에 위배되어 삽입되지 않음

INSERT INTO TB_CHECK(COL1, COL2)
VALUES('사과', 11); -- 제약 조건에 위배되어 삽입되지 않음

INSERT INTO TB_CHECK(COL1, COL2)
VALUES('', 5); -- NULL 값 입력 가능

INSERT INTO TB_CHECK(COL2)
VALUES(5); -- 아예 입력 안하는 것도 가능

-- Primary Key = Uique + NOT NULL
CREATE TABLE TB_TEST05(
    COL_PK VARCHAR2(10) CONSTRAINT PK_TEST01 PRIMARY KEY,
    -- 그냥 PRIMARY KEY라고 적어놔도 되긴 하지만, 사용중에 PK를 풀어야 하는 경우도 생기기에 이름을 설정한 제약으로 만들어 지웠다 만들었다 할수 있도록 하기 위함
    COL2 VARCHAR2(20)
);

INSERT INTO tb_test05(COL_PK, COL2)
VALUES('AAA', '111');   -- 다시 넣을 수는 없음. (무결성 제약 조건 위반)

INSERT INTO tb_test05(COL_PK, COL2)
VALUES('BBB', '');  -- COL2는 NULL값 가능하니까 이건 가능

CREATE TABLE TB_TEST06(
    COL1_PK VARCHAR2(10) CONSTRAINT PK_TEST02 PRIMARY KEY,
    COL2_PK VARCHAR2(10) CONSTRAINT PK_TEST03 PRIMARY KEY,   -- table only can have one primary key
    COL2 VARCHAR2(20)
);

CREATE TABLE TB_TEST06(
    COL1_PK VARCHAR2(10),
    COL2_PK VARCHAR2(10),
    COL2 VARCHAR2(20),
    CONSTRAINT PK_TEST02 PRIMARY KEY(COL1_PK, COL2_PK)  -- 이렇게하면 Primary Key를 두개 넣을 수 있다 (하나의 제약으로 묶음)
);

CREATE TABLE TB_TEST07(
    COL1 VARCHAR2(10),
    COL2 VARCHAR2(10)
);
-- PK가 없는 테이블에 PK 만들어주기
ALTER TABLE TB_TEST07
ADD PRIMARY KEY(COL1);

-- FOREIGN KEY : 외래키
--               Join을 목적. 테이블 연결
--               기본테이블에서 컬럼이 PK, UK로 되어 있어야 한다
--               NULL을 허용   

CREATE TABLE DEPT(
    DEPARTMENT_ID VARCHAR2(10),
    DEPARTMENT_NAME VARCHAR2(20),
    LOCATION_ID NUMBER,
    CONSTRAINT PK_DEPT_TEST PRIMARY KEY(DEPARTMENT_ID)
);

INSERT INTO DEPT(DEPARTMENT_ID, DEPARTMENT_NAME, LOCATION_ID)
VALUES('10', '기획부', 100);

INSERT INTO DEPT(DEPARTMENT_ID, DEPARTMENT_NAME, LOCATION_ID)
VALUES('20', '관리부', 110);

INSERT INTO DEPT(DEPARTMENT_ID, DEPARTMENT_NAME, LOCATION_ID)
VALUES('30', '개발부', 120);

CREATE TABLE EMP(
   EMPNO VARCHAR2(10),
   ENAME VARCHAR2(20),
   DEPARTMENT_ID VARCHAR2(10),
   CONSTRAINT FK_EMP_TEST FOREIGN KEY(DEPARTMENT_ID) 
   REFERENCES DEPT(DEPARTMENT_ID)
);

INSERT INTO EMP(EMPNO, ENAME, DEPARTMENT_ID)
VALUES(1, '홍길동', '30');

INSERT INTO EMP(EMPNO, ENAME, DEPARTMENT_ID)
VALUES(2, '성춘향', '10');

INSERT INTO EMP(EMPNO, ENAME, DEPARTMENT_ID)
VALUES(3, '일지매', '20');

-- JOIN
-- inner join
SELECT *
FROM dept d, emp e
WHERE d.department_id = e.department_id;

--left join
SELECT *
FROM dept d, emp e
WHERE d.department_id = e.department_id(+);

-- full outer join
SELECT
    * FROM dept d FULL OUTER JOIN emp e
    ON d.department_id = e.department_id;