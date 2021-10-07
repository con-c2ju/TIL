-- 문제1) EMPLOYEES 테이블에서 20번 부서의 세부 사항을 포함하는 EMP_20 VIEW를 생성 하라
CREATE VIEW EMP_20_VIEW
AS SELECT * FROM employees WHERE department_id = 20;

SELECT * FROM emp_20_view;

CREATE OR REPLACE VIEW EMP_20_VIEW  -- 생성 혹은 수정을 하도록 해주는 뷰. 잘못쓰면 테이블 데이터 날아갈수도 있다...
AS SELECT * FROM employees WHERE department_id = 20;

-- 문제2) EMPLOYEES 테이블에서 30번 부서만 
-- EMPLOYEE_ID 를 emp_no 로 LAST_NAME을 name으로 SALARY를 sal로 바꾸어 EMP_30 VIEW를 생성하라.
CREATE OR REPLACE VIEW EMP_30_VIEW
-- CREATE OR REPLACE VIEW EMP_30_VIEW(emp_no, name, sal) 이렇게 해도 됨
AS SELECT employee_id emp_no, last_name name, salary sal
FROM employees WHERE department_id = 30;

SELECT * FROM emp_30_view;

-- 문제3) 부서별로 부서명,최소 급여,최대 급여,부서의 평균 급여를 포함하는 DEPT_SUM VIEW을 생성하여라.
CREATE VIEW DEPT_SUM_VIEW
AS SELECT d.department_name , MIN(e.salary) minsal, MAX(e.salary) maxsal, AVG(e.salary) avgsal
FROM employees e, departments d
WHERE e.department_id = d.department_id
GROUP BY d.department_name;

SELECT * FROM dept_sum_view;

-- 문제4) 앞에서 생성한 EMP_20,EMP_30 VIEW을 삭제하여라.
DROP VIEW emp_20_view;
DROP VIEW emp_30_view;



















