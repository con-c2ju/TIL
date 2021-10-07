/*
    SEQUENCE : 유일한 값(중복되지 않은 값)을 생성해주는 오브젝트
               회원번호, 게시판 글번호 등에 적용 가능
               초기화 불가능. 삭제 후에 다시 생성해야함
    int count = 0;
    While(true){
    count++;    <-- count는 이제 같은 숫자가 나올 수 없음
    }               SEQUENCE가 이것과 비슷한 맥락..
*/

-- SEQUENCE 생성
CREATE SEQUENCE TESTSEQ
INCREMENT BY 1  -- 1씩 증가
START WITH 1    -- 시작하는 숫자
MAXVALUE 100
MINVALUE 1;

-- CURRVAL = 현재의 SEQ
SELECT TESTSEQ.CURRVAL  -- NEXTVAL로 진행하지 않은 상태에서 실행하면 오류남
    FROM DUAL;    -- 시퀀스는 가상테이블에서 확인하는 방법밖에 없음

-- NEXTVAL = 진행값
SELECT TESTSEQ.NEXTVAL
    FROM DUAL;

-- 수정
ALTER SEQUENCE TESTSEQ
INCREMENT BY 3; -- 이렇게 수정해도 이미 생성된 값이 변하지 않음. 그럴려면 삭제하고 새로 만들어야함

-- 삭제
DROP SEQUENCE TESTSEQ;


-- [ 예시 ] --
INSERT INTO employees(employee_id, last_name, email, hire_date, job_id) -- NOT NULL로 되어있는 모든 요소
VALUES(EMPLOYEES_SEQ.nextval, '홍', 'hgd@daum.net', '21/09/13', 'IT_PROG');

ROLLBACK;