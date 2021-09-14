/*
    테이블은 그냥 공중에 떠있는 게 아님.
    테이블 스페이스(space): 테이블(object) 및 다른 object (view, sequence...) 저장하는 공간
    sqldeveloper에서 자동으로 만들 수 있음. (새 갤러리 - 데이터베이스 객체)
    속성에서 로깅은 자동저장 여부를 묻는 것, 파일 크기(테이블이 차지하는 영역)을 지정할 수 있음
*/

-- 테이블스페이스는 시스템계정으로만 생성가능
-- 보통 스페이스를 생성할때는 쿼리문을 사용해서 한다. 에디터를 쓰면 작성기록이 남지 않기 때문
CREATE TABLESPACE TABLESPACE2
DATAFILE 'D:\Temp\TEST_TBS.DBF' SIZE 10M
AUTOEXTEND ON NEXT 1M MAXSIZE UNLIMITED -- 추가되는 용량
LOGGING -- 기록되는지 여부
EXTENT MANAGEMENT LOCAL AUTOALLOCATE    -- 로컬/글로벌 영역에 만들지 여부
BLOCKSIZE 8K    -- 임시 저장공간 사이즈
SEGMENT SPACE MANAGEMENT AUTO
FLASHBACK ON;

-- object : CREATE(생성), ALTER(수정), DROP(삭제)
-- data : INSERT(생성), UPDATE(수정), DELETE(삭제)

-- 에디터로 만든 테이블스페이스 수정
ALTER TABLESPACE TABLESPACE1
RENAME TO TEST_TBS1;    -- 이름변경

-- 쿼리로 생성한 테이블스페이스 수정
ALTER DATABASE
DATAFILE 'D:\Temp\FILE_SPECIFICATION1' RESIZE 7M;

-- 에디터로 생성한 테이블스페이스 삭제 (DBA에서 우클릭해서 사제하기도 가능)
DROP TABLESPACE TEST_TBS1
INCLUDING CONTENTS AND DATAFILES
CASCADE CONSTRAINTS;


/*
    테이블 : 열(column)과 행(row)으로 구성
*/
CREATE TABLE TB_TEST01(
    COL1 VARCHAR2(10),
    COL2 VARCHAR2(10),
    COL3 VARCHAR2(10)
);  -- 테이블스페이스가 지정한 기초값으로 설정됨

CREATE TABLE TB_TEST02(
    COL1 VARCHAR2(10),
    COL2 VARCHAR2(10),
    COL3 VARCHAR2(10)
)TABLESPACE TABLESPACE2;    -- 직접 테이블스페이스 지정 가능

-- 테이블 복제 (데이터 포함)
CREATE TABLE TB_TEST03(JNAME, JTITLE, SALMIN, SALMAX)   -- 컬럼 이름 바꾸기 가능
AS
SELECT * FROM jobs; -- jobs 테이블의 데이터를 전부 불러와서 TB_TEST03에 복사

SELECT
    * FROM tb_test03;

DROP TABLE tb_test03;

-- 테이블 복제 (데이터 미포함)
CREATE TABLE TB_TEST04
AS
SELECT * FROM employees
WHERE 1 = 2;    -- 성립할 수 없는 조건을 입력하면 데이터를 가져오지 않음
-- 데이터 수정이 필요할 때 테이블을 복제하고 사용하면 데이터가 날아가도 괜찮음

-- 테이블명 수정 (오브젝트니까 ALTER 명령어 사용)
ALTER TABLE TB_TEST04
RENAME TO TB_TEST99;

-- 컬럼 추가
ALTER TABLE TB_TEST99
ADD NEWCOL VARCHAR2(20);    -- 같은이름 있으면 에러남

-- 컬럼 수정
ALTER TABLE TB_TEST99
MODIFY NEWCOL DATE; -- 자료형 변경 가능

-- 컬럼 삭제
ALTER TABLE TB_TEST99
DROP COLUMN NEWCOL;

-- 컬럼명 수정
ALTER TABLE TB_TEST99
RENAME COLUMN EMPLOYEE_ID TO EMPNO;

DROP TABLE TB_TEST99;

-- 완전삭제 (휴지통 완전히 비우기)
PURGE RECYCLEBIN;


SELECT * FROM tb_test03;
-- 데이터 추가: INSERT
INSERT INTO tb_test03(JNAME, JTITLE, SALMIN, SALMAX)    -- ★컬럼명은 적어주는 게 좋음
VALUES('SALES_AD', '영업부', 8000, 20000);

INSERT INTO tb_test03   -- 컬럼명을 다 빼놓으면 자동으로 순서대로 배치됨
VALUES('BALL_MO', '야구부', 8500, 25000);

INSERT INTO tb_test03(JTITLE, JNAME, SALMAX, SALMIN)    -- 컬럼의 순서를 바꿔서 입력할 수 있음
VALUES('창고부', 'STORAGE', 23000, 10000);

INSERT INTO tb_test03(JNAME, JTITLE, SALMAX)    -- 오류가 발생하는데, JTILE이 nullable No 상태이기 때문에 비워놓으면 안됨
VALUES('CALL', '전화상담', 20000);

-- 데이터 삭제: DELETE
DELETE FROM tb_test03
WHERE JNAME = 'STORAGE';    -- 컬럼 자체가 삭제됨

DELETE FROM tb_test03
WHERE SALMAX = 25000;   -- ※ 주의! 이렇게 지우다가 의도치 않은 데이터도 지울 수 있음

-- 데이터 수정: UPDATE
UPDATE tb_test03
SET jtitle = '개발부', salmax = 25000, salmin = 9000
WHERE jname = 'SALES_AD';