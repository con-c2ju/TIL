
/*
열 (항목) : column
행 : row, record

엑셀의 구성과 같음
*/

SELECT
    * FROM employees;
-- 한줄 주석문

-- table 생성
/*
CREATE TABLE 테이블명 (
    컬럼명: 자료형,
    컬럼명2: 자료형,
        :
);
*/

-- 자료형
/*
    [Java]                          [DB]                              [MySQL]
    String        VARCHAR, CHAR(거의안씀), LONG(2GB까지 들어감)           VARCHAR
    int           INTEGER, NUMBER 
    double        NUMBER
    Date          DATE
*/

-- 문자열
-- CHAR
CREATE TABLE TB_CHAR(
    COL1 CHAR(10 BYTE),
    COL2 CHAR(10 CHAR),
    COL3 CHAR(10)
);

-- 데이터 넣기
/*
INSERT INTO 테이블명( 컬럼명1, 컬럼명2 ....)
VALUES (값1, 값2 ...)
*/

INSERT INTO TB_CHAR(COL1, COL2, COL3)
VALUES('a', 'b', 'c');   -- 한글: 원래는 2byte인데 여기선 3byte

INSERT INTO TB_CHAR(COL1, COL2, COL3)
VALUES('가나', '가나', '가나');

INSERT INTO TB_CHAR(COL1, COL2, COL3)
VALUES('가나다', '가나다', '가나다');

SELECT * FROM tb_char; -- 테이블 이름 소문자로 적어도 상관 없다

SELECT col1, col2, col3,
    LENGTHB(col1), LENGTHB(col2), LENGTHB(col3)
    FROM tb_char;
    
/*
    10 CHAR
    가 -> 3 BYTE = 3 + 9(남은 칸수) => 12
    가나 -> 6BYTE = 6 + 8 => 14
    가나다 -> 9 BYTE = 9 + 7 => 16
*/

-- VARCHAR2
CREATE TABLE TB_VARCHAR(
    COL1 VARCHAR2(10 BYTE),
    COL2 VARCHAR2(10 CHAR),
    COL3 VARCHAR2(10)
);

INSERT INTO tb_varchar(COL1, COL2, COL3)
VALUES('ABC', 'ABC', 'ABC');

INSERT INTO tb_varchar(COL1, COL2, COL3)
VALUES('가나다', '가나다', '가나다');

SELECT col1, col2, col3,
    LENGTHB(col1), LENGTHB(col2), LENGTHB(col3)
    FROM tb_varchar; -- CHAR와는 달리 BYTE 용량이 적합함. (글자수에 따른 용량). CHAR보다 자주 쓰이는 이유

-- LONG
-- 최대 2GB까지 저장 가능
-- 테이블당 1개의 컬럼에만 사용 가능
CREATE TABLE TB_LONG (
    COL LONG
);

INSET INTO tb_long(COL)
VALUES('ABCDE');

SELECT COL, LEHNGTHB(COL)
FROM tb_long;   -- LONG에는 LENGTHB가 사용불가능함.

-- 숫자 (INTEGER, NUMBER)
CREATE TABLE TB_INTEGER(
    COL1 INTEGER,
    COL2 INTEGER
);

INSERT INTO tb_integer(COL1,COL2)
VALUES(123, 456);

INSERT INTO tb_integer(COL1,COL2)
VALUES(123, 456.1); -- 소수가 자동으로 정수로 변환

INSERT INTO tb_integer(COL1,COL2)
VALUES('123', '456'); -- 문자열도 자동으로 정수로 변환

CREATE TABLE TB_NUMBER(
    COL1 NUMBER,
    COL2 NUMBER(5),
    COL3 NUMBER(5, 2),
    COL4 NUMBER(*, 2)   -- 앞부분: 자라수 / 뒷부분: 소수점 자리수
);

INSERT INTO tb_number(COL1, COL2, COL3, COL4)
VALUES (1234.5678, 12345.12, 123.456, 123.456789);
-- 정수만 필요하다면 INTEGER로 충분하지만, 소수까지 써야한다면 NUMBER

-- 날짜
-- 연도, 월, 일 시, 분, 초
CREATE TABLE TB_DATE(
    COL1 DATE,
    COL2 DATE
);
INSERT INTO tb_date(COL1, COL2)
VALUES('21/09/09', SYSDATE - 1);

INSERT INTO tb_date(COL1, COL2)
VALUES('21-09-09', SYSDATE - 1);
-- SYSDATE: 자동으로 오늘날짜. -1하면 어제날짜
-- 문자열로 입력할때 /, - 등 다양한 토큰 사용 가능

INSERT INTO tb_date(COL1, COL2)
VALUES(TO_DATE('2021-09-09 11:55:23', 'YYYY-MM-DD HH:MI:SS'), SYSDATE - 1);
-- 시간까지 넣고싶은 경우엔 함수(TO_DATE) 써야함
-- 출력결과는 여전히 날짜만 나오지만 시분초 정보까지 담겨있다

DROP TABLE TB_CHAR;

/*
    VARCHAR2
    INTEGER < NUMBER
    DATE
*/
