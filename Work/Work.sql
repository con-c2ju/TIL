-- << 과제 >>
-- 문제1) EMPLOYEES Table의 모든 자료를 출력하여라.
SELECT * FROM employees;

-- 문제2) EMPLOYEES Table의 컬럼들을 모두 출력하라.
SELECT column_name
    FROM USER_TAB_COLS WHERE TABLE_NAME = 'EMPLOYEES';
DESC employees; -- <= 더 간단한 버전

-- 문제3) EMPLOYEES Table에서 사원 번호, 이름, 급여, 담당업무를 출력하여라.
SELECT
    employee_id,
    first_name,
    salary,
    job_id
    FROM employees;

-- 문제4) 모든 종업원의 급여를 $300증가 시키기 위해서 덧셈 연산자를 사용하고 결과에 SALARY+300을 디스플레이 합니다.
SELECT salary + 300 AS "SALARY+300"
    FROM employees;

-- 문제5) EMP 테이블에서 사원번호, 이름, 급여, 보너스, 보너스 금액을 출력하여라. 
-- (참고로 보너스는 월급 + (월급*커미션))
SELECT
    employee_id,
    first_name,
    salary,
    NVL(salary + (salary * commission_pct), 0),
    salary * commission_pct
    FROM employees;
/*
    NVL(컬럼, 컬럼의 값이 null이면 설정되는 값)
*/

-- 문제6) EMPLOYEES 테이블에서 LAST_NAME을 이름으로 SALARY을 급여로 출력하여라.
SELECT
    last_name "이름",
    salary "급여"
    FROM employees;

-- 문제7) EMPLOYEES 테이블에서 LAST_NAME을 Name으로 SALARY * 12를 Annual Salary(연봉)로 출력하여라
SELECT
    last_name "Name",
    salary * 12 "Annual Salary"
    FROM employees;

-- 문제8) EMPLOYEES 테이블에서 이름과 업무를 연결하여 출력하여라. 
SELECT first_name ||' ' || job_id
    FROM employees;

-- 문제9) EMPLOYEES 테이블에서 이름과 업무를 “KING is a PRESIDENT” 형식으로 출력하여라. 
SELECT
    UPPER(last_name) || ' is a ' || job_id
    FROM employees;

-- 문제10) EMPLOYEES 테이블에서 이름과 연봉을 “KING: 1 Year salary = 60000” 형식으로 출력하여라. 
SELECT
    UPPER(last_name) || ': 1 Year Salary = ' || salary * 12
    FROM employees;

-- 문제11) EMPLOYEES 테이블에서 JOB을 모두 출력하라.
SELECT DISTINCT job_id
    FROM employees;