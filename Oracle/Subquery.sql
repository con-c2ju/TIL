-- ★★★★★ sub query
/*
    Query 안의 Query
    select (select * from) 이 되는 식
    
    SELECT 단일row 단일column (==한 레코드 내의 하나의 자료만 가능)
    FROM
    WHERE
    
*/

-- [SELECT] --
SELECT employee_id, first_name,
    (SELECT first_name
        FROM employees
        WHERE employee_id = 100)    -- SELECT 구절은 이렇게만 허용됨. 딱 하나의 자료값만 가져올 수 있다
    FROM employees; -- 실행할 경우 subquery 부분에 Steven만 계속 출력됨
    
SELECT employee_id, first_name,
    (SELECT first_name, salary  -- 이렇게 하나 이상의 값을 받으려고 하면 오류가 난다. (다중 column)
        FROM employees
        WHERE employee_id = 100)
    FROM employees; -- sub query 혼자만 실행하면 문제가 없지만, 전체를 실행하면 오류 발생

SELECT employee_id, first_name,
    (SELECT first_name
        FROM employees) -- 이 경우도 오류발생. (다중row)
    FROM employees;

SELECT first_name, SUM(salary), AVG(salary) -- first_name 때문에 제대로 실행안됨. 그래도 first_name을 같이 출력하고 싶을 때 사용하는 게 select 구문
FROM employees
GROUP BY department_id;

-- SELECT 구문을 유용하게 쓸 때
SELECT first_name,
    (SELECT SUM(salary) FROM employees),
    (SELECT AVG(salary) FROM employees) -- ※ 각 계산식마다 괄호쳐줘야함 (하나의 자료값만 넣기 가능)
FROM employees; -- 경고가 나오지만 동작함

-- [FROM] --
SELECT first_name, salary
    FROM (SELECT employee_id, first_name, salary    -- 여기 속한 자료값중에 위쪽에 적힌 자료값이 없으면 오류남
            FROM employees
            WHERE department_id = 100)
    WHERE salary > 8000;
    
-- 업무별로 급여의 합계, 인원수, 사원명, 월급을 표현하고 싶을 때
SELECT job_id, SUM(salary), COUNT(*), first_name
    FROM employees
    GROUP BY job_id;    -- GROUP BY의 문제점: 한번 묶으면 다시 풀 수 없음. 이름 같은 자료랑 같이 확인 불가능
    
SELECT e.employee_id, e.salary,
    e. job_id, j.job_id, j."급여의 합계", j.인원수
    FROM employees e,
        (SELECT job_id, SUM(salary) as "급여의 합계", COUNT(*) as 인원수
            FROM employees
            GROUP BY job_id) j  -- 임시 테이블을 따로 하나 만들고 거기서 값을 받아옴. group으로 묶지 않아도 된다!
    WHERE e.job_id = j.job_id;

-- WHERE (제일 자주쓰이는 느낌)
-- 평균 급여보다 많이 받는 사람
SELECT first_name, salary
    FROM employees
    WHERE salary > (SELECT AVG(salary) FROM employees);

-- department_id = 90의 사원 업무만을 산출
SELECT job_id, first_name, department_id
    FROM employees
    WHERE job_id IN(SELECT job_id
                    FROM employees
                    WHERE department_id = 90);

-- 부서별로 가장 급여를 적게 받는 사원과 같은 급여를 받는 사원
SELECT first_name, salary, department_id
    FROM employees
    WHERE salary IN(SELECT MIN(salary)
                    FROM employees
                    GROUP BY department_id);

-- 부서별로 가장 급여를 많이 받는 사원의 이름, 급여, 부서번호
SELECT department_id, salary, first_name    -- 그룹절을 서브쿼리로 만들어서 각각 이름같은 자료도 출력할 수 있음
    FROM employees
    WHERE (department_id, salary) IN(SELECT department_id, MAX(salary)
                                        FROM employees
                                        GROUP BY department_id)
ORDER BY department_id;