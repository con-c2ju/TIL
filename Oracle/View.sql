/*
    View : 가상 테이블. DUAL과는 다르다.
    실제 테이블을 보여주는 창문과 같음. 실체가 없는 테이블.
    다른 테이블에 접근하기 위한 테이블
    
    테이블 <------- View -------- User
    한개의 뷰로 여러개의 테이블 검색 가능
    속도가 빠름!
    제한 설정이 가능 ex)readonly
*/

CREATE VIEW UB_TEST01
AS
SELECT job_id, job_title, min_salary
FROM jobs;

SELECT * FROM ub_test01;    -- 이 출력결과는 jobs 테이블이지 view가 아님.

INSERT INTO ub_test01(JOB_ID, JOB_TITLE, MIN_SALARY)
VALUES('DEVELOPER', '웹개발자', 10000); --  이렇게 넣으면 jobs 테이블에 추가됨 

SELECT * FROM jobs;

ROLLBACK;   -- 되돌림
COMMIT; -- 적용 <==== sqldeveloper를 사용할 땐 commit을 꼭 해줘야한다. 안그러면 결과를 확인할 수 없음

-- READONLY: INSERT, DELETE, UPDATE 불가
CREATE VIEW DEPTVIEW
AS SELECT department_id, department_name, location_id 
    FROM departments
WITH READ ONLY;

SELECT * FROM DEPTVIEW; -- 잘 출력됨

-- 사원번호, 이름, 부서번호, 부서명, 지역번호
CREATE VIEW DEPT_EMP_VIEW
AS SELECT e.employee_id, e.first_name, d.department_id, d.department_name, d.location_id
    FROM employees e, departments d
    WHERE e.department_id = d.department_id;
    
SELECT * FROM DEPT_EMP_VIEW
WHERE employee_id = 100;    -- 접근이 훨씬 수월해짐