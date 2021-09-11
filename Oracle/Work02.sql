-- hr 정렬
-- 문제1) EMPLOYEES 테이블에서 입사일자 순으로 정렬하여 사원번호, 이름, 업무, 급여, 입사일자,부서번호를 출력하라.
SELECT employee_id, first_name, job_id, salary, hire_date, department_id
    FROM employees
    ORDER BY hire_date;

-- 문제2) EMPLOYEES 테이블에서 가장 최근에 입사한 순으로 사원번호, 이름, 업무, 급여, 입사일자,부서번호를 출력하라.
SELECT employee_id, first_name, job_id, salary, hire_date, department_id
    FROM employees
    ORDER BY hire_date DESC;

-- 문제3) EMPLOYEES 테이블에서 부서번호로 정렬한 후 부서번호가 같을 경우 급여가 많은 순으로 정렬하여 사원번호, 성명, 업무, 부서번호, 급여를 출력하여라.
SELECT employee_id, first_name, job_id, department_id, salary
    FROM employees
    ORDER BY department_id ASC, salary DESC;

-- 문제4) EMPLOYEES 테이블에서 첫번째 정렬은 부서번호로 두번째 정렬은 업무로 세번째 정렬은 급여가 많은 순으로 정렬하여 
-- 사원번호, 성명, 입사일자, 부서번호, 업무, 급여를 출력하여라.
SELECT employee_id, first_name, hire_date, job_id, salary
    FROM employees
    ORDER BY department_id ASC,
            job_id ASC,
            salary DESC;



-- hr 표준함수

-- 문제1) EMPLOYEES 테이블에서 King의 정보를 대문자로 검색하고 사원번호, 성명, 담당업무(대문자로),부서번호를 출력하라.
SELECT employee_id, last_name, UPPER(job_id), department_id
    FROM employees
    WHERE UPPER(last_name) LIKE 'KING';

-- 문제2) DEPARTMENTS 테이블에서 (부서번호와 부서이름), 부서이름과 위치번호를 합하여 출력하도록 하라.
SELECT '(' || department_id ||' ' || department_name || ')', department_name || location_id
    FROM departments;
    
SELECT CONCAT(department_id, department_name), CONCAT(department_name, location_id)
    FROM departments;

-- 문제3) EMPLOYEES 테이블에서 이름의 첫 글자가 ‘K’ 보다 크고 ‘Y’보다 적은 사원의 사원번호, 이름, 업무, 급여, 부서번호를 출력하라. 
-- 단 이름순으로 정렬하여라.
SELECT employee_id, first_name, job_id, salary, department_id
    FROM employees
    WHERE first_name > 'K' AND first_name < 'Y';
    ORDER BY first_name;

SELECT employee_id, first_name, job_id, salary, department_id
    FROM employees
    WHERE SUBSTR(first_name, 1, 1) > 'K' AND SUBSTR(first_name, 1, 1) < 'Y'
    -- WHERE SUBSTR(first_name,1,1) BETWEEN 'L' AND 'W'
    ORDER BY first_name;

-- 문제4) EMPLOYEES 테이블에서 20번 부서 중 이름의 길이 및 급여의 자릿수를 사원번호, 이름, 이름의 문자의 길이, 급여, 급여의 자릿수를 출력하라.
-- LENGTHB() -> 한글은 2글자로 침. LENGTH() -> 글자수만 봄. 숫자가 들어가도 문자열로 본다.
SELECT employee_id, first_name, LENGTH(first_name), salary, LENGTH(salary)
    FROM employees
    WHERE department_id = 20;

-- 문제5) EMPLOYEES 테이블의 이름에서  ‘e’자의 위치를 출력하라.
SELECT first_name, INSTR(first_name, 'e')
    FROM employees;

-- 문제6) ROUND 함수를 사용하여 4567.678의 소수가 다음과 같이 출력되도록 하라.
4568
4568
4567.68
4600

SELECT ROUND(4567.678), ROUND(4567.678,2), ROUND(4567.678,-2)
FROM DUAL;

-- 문제7) EMPLOYEES 테이블에서 부서번호가 80인 사람의 급여를 30으로 나눈 나머지를 구하여 출력하라.
SELECT
    MOD(salary, 30) FROM employees
    WHERE department_id = 80;
-- 문제8) EMPLOYEES 테이블에서 30번 부서 중 이름과 담당 업무를 연결하여 출력하여라. 
-- 단 담당 업무를 한 줄 아래로 출력하라.
SELECT
    first_name||CHR(10)||job_id FROM employees
    WHERE department_id = 30;

-- 문제9) EMPLOYEES 테이블에서 현재까지 근무일 수가 몇주 몇일 인가를 출력하여라. 
-- 단 근무 일수가 많은 사람 순으로 출력하여라.
SELECT SYSDATE - TO_DATE(hire_date)
    FROM employees
    ORDER BY TRUNC(SYSDATE) - TO_DATE(hire_date, 'YY/MM/DD') ASC;

SELECT first_name, hire_date,
    TRUNC(SYSDATE - hire_date) AS "총 근무일수",
    TRUNC(SYSDATE - TO_DATE('21/09/07')),    -- SYSDAY
    TRUNC(TO_DATE('21/09/10') - TO_DATE('21/05/04'))
    TRUNC((SYSDATE - hire_date)/7) AS "총 근무 주일수",
    TRUNC(MOD((SYSDATE - hire_date)/7) AS "나머지 근무일수"
    FROM employees
    ORDER BY "총 근무일수" DESC;

-- 문제10) EMPLOYEES 테이블에서 부서 50에서 급여 앞에 $를 삽입하고 3자리마다 ,를 출력하라
SELECT
    TO_CHAR(salary, '$999,999') FROM employees
    WHERE department_id = 50;
    




-- hr 그룹핑
-- 문제1) EMPLOYEES 테이블에서 모든 SALESMAN(SA_)에 대하여 급여의 평균, 최고액, 최저액, 합계를 구하여 출력하여라.
SELECT
    AVG(salary), MIN(salary), MAX(salary), SUM(salary)
    FROM employees
    GROUP BY job_id
    HAVING job_id LIKE 'SA_%';

SELECT AVG(salary), MIN(salary), MAX(salary), SUM(salary)
    FROM emlployees
    WHERE job_id LIKE 'SA_%';

-- 문제2) EMPLOYEES 테이블에 등록되어 있는 인원수, 보너스가 NULL이 아닌 인원수, 보너스의 평균, 등록되어 있는 부서의 수를 구하여 출력하라.
SELECT
    COUNT(*), COUNT(commission_pct), TRUNC(AVG(salary * commission_pct)), COUNT(DISTINCT department_id)
    FROM employees;

-- 문제3) EMPLOYEES 테이블에서 부서별로 인원수, 평균 급여, 최저급여, 최고 급여, 급여의 합을 구하여 출력하라.
SELECT COUNT(*), AVG(salary), MIN(salary), MAX(salary), SUM(salary)
FROM employees
GROUP BY department_id;

-- 문제4) EMPLOYEES 테이블에서 각 부서별로 인원수,급여의 평균, 최저 급여, 최고 급여, 급여의 합을 구하여 급여의 합이 많은 순으로 출력하여라.
SELECT
    COUNT(*), AVG(salary), MIN(salary), MAX(salary), SUM(salary) AS "급여의 합"
    FROM employees
    GROUP BY department_id
    ORDER BY "급여의 합" DESC;
    

-- 문제5) EMPLOYEES 테이블에서 부서별, 업무별 그룹하여 결과를 부서번호, 업무, 인원수, 급여의 평균, 급여의 합을 구하여 출력하여라.
SELECT
    department_id, job_id, COUNT(*), AVG(salary), SUM(salary)
    FROM employees
    GROUP BY department_id, job_id;

-- 문제6) EMPLOYEES 테이블에서 부서 인원이 4명보다 많은 부서의 부서번호, 인원수, 급여의 합을 구하여 출력하여라
SELECT department_id, COUNT(*), SUM(salary)
    FROM employees
    GROUP BY department_id
    HAVING COUNT(*) > 4;

-- 문제7) EMPLOYEES 테이블에서 급여가 최대 10000이상인 부서에 대해서 부서번호, 평균 급여, 급여의 합을 구하여 출력하여라.
SELECT  department_id, AVG(salary), SUM(salary)
    FROM employees
    GROUP BY department_id
    HAVING MAX(salary) >= 10000;

-- 문제8) EMPLOYEES 테이블에서 업무별 급여의 평균이 10000 이상인 업무에 대해서 업무명,평균 급여, 급여의 합을 구하여 출력하라.
SELECT  job_id, AVG(salary), SUM(salary)
    FROM employees
    GROUP BY job_id
    HAVING AVG(salary) >= 10000;

-- 문제9) EMPLOYEES 테이블에서 전체 월급이 10000을 초과하는 각 업무에 대해서 업무와 월급여 합계를 출력하라. 
-- 단 판매원(SA_)은 제외하고  월 급여 합계로 정렬(내림차순)하라.
SELECT  job_id, SUM(salary)
    FROM employees
    WHERE job_id NOT LIKE 'SA_%'
    GROUP BY job_id
    HAVING SUM(salary) > 10000
    ORDER BY SUM(salary) DESC;







