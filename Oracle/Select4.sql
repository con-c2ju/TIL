-- 특수쿼리
-- CASE == switch
SELECT employee_id, first_name, phone_number,
    CASE SUBSTR(phone_number, 1, 3)
        WHEN '515' THEN '서울'
        WHEN '590' THEN '부산'
        WHEN '650' THEN '광주'
        ELSE '기타'
    END AS 지역   -- 마지막에 꼭 END 붙여주기
FROM employees;

SELECT employee_id, first_name, phone_number,
    CASE
        WHEN SUBSTR(phone_number, 1, 3) = '515' THEN '서울'
        WHEN SUBSTR(phone_number, 1, 3) = '590' THEN '부산'
        WHEN SUBSTR(phone_number, 1, 3) = '650' THEN '광주'
        ELSE '기타'
    END AS "지역"
FROM employees;

-- DECODE
SELECT employee_id, first_name, phone_number,
    DECODE( SUBSTR(phone_number, 1, 3),
            '515', '서울',
            '590', '부산',
            '650', '광주',
            '기타' ) AS 지역
FROM employees;

-- 집합
/*
    합집합 : UNION - outer join
    차집합 : MINUS
    교집합 : INTERSECT - inner join
*/

-- UNION
SELECT job_id
FROM employees
WHERE job_id IN('AD_VP', 'FI_ACCOUNT')
UNION ALL
SELECT job_id
FROM jobs
WHERE job_id IN('AD_VP', 'FI_ACCOUNT');

-- INRESECT
SELECT employee_id
    FROM employees
INTERSECT
SELECT manager_id
    FROM employees;
    
-- INNER JOIN
SELECT DISTINCT b.employee_id
    FROM employees a, employees b
    WHERE a.manager_id = b.employee_id;
    
-- MINUS
SELECT employee_id
    FROM employees
MINUS
SELECT  manager_id
    FROM employees;
    
-- OVER() 함수
-- SELECT 절에서만 사용
-- GROUP BY를 보관하기 위해 나온 함수
SELECT department_id COUNT(*)OVER()
    FROM employees; -- GREOUP BY를 안써도 일단 에러가 안남
SELECT department_id, COUNT(DISTINCT department_id)OVER()
    FROM employees;
    
-- PARTITION BY == SELECT절 안의 GROUP BY
SELECT department_name, COUNT(*)OVER(PARTITION BY department_id)
    FROM departments;
    
SELECT department_id, first_name, salary,
        COUNT(*)OVER(PARTITION BY department_id)
    FROM employees;
    
-- COUNT(*)OVER(): 전체 행 반환
-- COUNT(*)OVER(PARTITION BY column): 해당 컬럼을 그룹으로 묶어 row의 수 반환

-- 분석함수
/*
    순위함수 - 숫자를 할당하기 위한 함수
    RANK() 1 2 3 3 5 6
    DERSE_RANK() 1 2 3 3 4 5
    ROW_NUMBER() 1 2 3 4 5 6 - 정렬에 따라 순번을 매김
    ROWNUM  1 2 3 4 5 6 - 순번을 매기고 정렬함
*/
SELECT employee_id, first_name 
FROM employees
WHERE employee_id >= 100 AND employee_id <= 109;

SELECT employee_id, first_name, salary 
FROM employees
ORDER BY salary DESC;

SELECT ROWNUM, employee_id, first_name, salary,
    RANK()OVER(ORDER BY salary DESC) as RANK,
    DENSE_RANK()OVER(ORDER BY salary DESC) AS DENSE_RANK,
    ROW_NUMBER()OVER(ORDER BY salary DESC) AS ROW_NUMBER 
FROM employees;

SELECT ROWNUM, employee_id, first_name, salary 
FROM employees
WHERE ROWNUM <= 10;

SELECT ROWNUM, employee_id, first_name, salary 
FROM employees
WHERE ROWNUM > 10 AND ROWNUM <= 20;

-- 1. 순위(정렬)
-- 2. 번호지정
-- 3. 범위를 지정

SELECT RNUM, employee_id, first_name, salary 
FROM
    (SELECT ROWNUM AS RNUM, employee_id, first_name, salary  -- 2. 번호지정
    FROM(   
            SELECT employee_id, first_name, salary      -- 1. 순위(정렬)
            FROM employees
            ORDER BY salary DESC    )
    )
WHERE RNUM >= 1 AND RNUM <= 10;    -- 3. 범위를 지정


/*
SELECT 절
    SELECT 컬럼, 표준함수, 그룹함수, 서브쿼리, OVER(), PARTITIO BY
    FROM 테이블, 서브쿼리
    [WHERE] 조건 IN AND OR NULL ALL ANY > < >= <= != <> 서브쿼리
    [GROUP BY] 컬럼
    [HAVING] 그룹핑 조건
    [ORDER BY] 컬럼 ASC, DESC
    [START BY] 계층형

JOIN
    INNER
    FULL OUTER
    CROSS
    OUTER (LEFT, RIGHT)
    SELF
*/