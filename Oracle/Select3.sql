/*
    ORDER BY == Sorting
    
    SELECT COLUMN CALUE SUBQUERY
    FROM TABLE SUBQUERY
    WHERE IF
    
    ORDER BY COLUMN ( ASC, DESC )
*/

SELECT
    first_name, hire_date FROM employees
    ORDER BY hire_date ASC; -- 뒤에 아무것도 안적으면 자동으로 ASC
    
SELECT
    first_name, salary FROM employees
    ORDER BY salary DESC;
    
-- ALIAS
SELECT employee_id, first_name, salary * 12 AS ANNNSAL
FROM EMPLOYEES
ORDER BY ANNSAL DESC; -- ALIAS도 넣을 수 있다

SELECT
    first_name, NVL(commission_pct,0) FROM employees
    ORDER BY commission_pct ASC NULLS FIRST;    -- 나중에 null을 다른 프로그램에 옮길 때 오류가 날 수 있으므로 미리 바꿔준다. 이 때 바꿔준 값에 따라 null을 맨 앞에 오게하거나 맨 뒤에 오게 할 수도.

/*
    GORUP BY : 그룹으로 묶는 기능
    HAVING : 묶을 때의 조건
*/

SELECT
    DISTINCT job_id, employee_id FROM employees; -- 겹치는 내용을 없애줄 수는 있지만 DISTINCT는 완전히 출력용임. 뒤에 다른 항목이 붙거나 하면 묶인 게 풀릴 수도 있음

SELECT
    job_id, employee_id FROM employees
    GROUP BY job_id;    -- JOB_ID로 묶긴 했는데, 그렇게 묶인 EMPLOYEE_ID를 어떻게 표현할 지 정의를 안해줘서 오류가 남.

/*
    통계 - GROUP FUNCTION
        - COUNT
        - SUM
        - AVG
        - MAX
        - MIN
*/

SELECT
    COUNT(salary), COUNT(*), SUM(salary), AVG(salary), MAX(salary), MIN(salary) FROM employees
    WHERE job_id = 'IT_PROG';
    -- 여기의 SELECT에 JOB_ID를 넣으면 또 오류가 난다. 묶은 게 아니기 때문.
    -- GROUP BY를 사용할 경우 표현할 수 있는 범위가 더 늘어남.

SELECT job_id, COUNT(*), SUM(salary), AVG(salary), MAX(salary), MIN(salary)
    FROM employees
    GROUP BY job_id    -- 묶은 내용을 어떻게 표현할지 정의했기 때문에 올바르게 사용가능.
    ORDER BY COUNT(*) DESC;

SELECT department_id, SUM(SALARY)
    FROM employees
    GROUP BY department_id
    HAVING SUM(SALARY) >= 50000;
    
-- (급여가 5000이상 받는 사원)만으로 합계를 내서 JOB_ID로 그룹화 => HAVING 절 아님
-- (급여의 합계가 20000)을 초과하는 업무명 => STATIC FUNCTION이 들어갔음 -> HAVING 절
SELECT job_id, SUM(salary)
    FROM employees
    WHERE salary >= 5000    -- GROUP BY를 쓰기 전에 먼저 SALARY가 5000 이상인 사람들로 한번 걸러냄
    GROUP BY JOB_ID
    HAVING SUM(SALARY) > 20000;
    -- ORDER BY SUM(SALARY) DESC/ASC; => 가장 마지막에 시행됨
    -- SUM(SALARY)를 구하는 데 사용된 SALARY는 5000 이상인 것들로만 구성되어 있으며, 그 값이 20000이 넘는 JOB_ID만 출력
    -- 실행 순서: WHERE -> GROUP BY -> HAVING -> SELECT -> ORDER BY




    