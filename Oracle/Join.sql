/*
    JOIN
    두 개 이상의 테이블의 데이터를 검색하는 방법
    보통 두 개 이상의 행(row)들의 공통된 값(기본키, 외래키)을 사용해서 Join한다
    
    기본키(Primary Key): 테이블에서 중복이 되지 않는 키 == 주민번호 (emplyees 테이블에선 사원번호) -> PK
    외래키(Foreign Key): 다른 테이블에서 PK, UK인 경우가 많다. -> FK
    UK: 기본키는 아니지만 마찬가지로 중복이 되지 않는 키. HR 데이터베이스에서는 email이 UK다.
    
    Join의 종류
        - ★★★★★Inner Join: 교집합
        - full outer join: 합집합
        - cross hoin
            ★★★outer join
            ★★★left koin
        - ★★★★★self join: 자기 자신을 조인. 교집합이지만, 합집합으로 사용할 수도있음
    
*/

-- inner join
--ANSI SQL: 어떤 SQL에도 적용가능
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name
    FROM employees e INNER JOIN departments d
    ON e.department_id = d.department_id;
    
-- Oracle: 오라클에서만 적용
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name
    FROM employees e, departments d
    WHERE e.department_id = d.department_id;
    
-- cross join
-- ansi
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e CROSS JOIN departments d;

-- oracle
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e, departments d;

-- full outer join
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name 
FROM employees e FULL OUTER JOIN departments d
    ON e.department_id = d.department_id;

-- oracle
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name 
FROM employees e, departments d
WHERE e.department_id = d.department_id(+)
UNION
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name 
FROM employees e, departments d
WHERE e.department_id(+) = d.department_id;

-- Outer Join
-- left
-- ansi
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e LEFT OUTER JOIN departments d
    ON e.department_id = d.department_id;

-- oracle
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name 
FROM employees e, departments d
WHERE e.department_id = d.department_id(+);

-- 차집합
-- left
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name 
FROM employees e, departments d
WHERE e.department_id = d.department_id(+)
    AND d.department_id IS NULL;

-- right
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name 
FROM employees e, departments d
WHERE e.department_id(+) = d.department_id
    AND e.department_id IS NULL;

-- 전체집합 중 교집합만 제외
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name 
FROM employees e FULL OUTER JOIN departments d
    ON e.department_id = d.department_id
WHERE e.department_id IS NULL
    OR d.department_id IS NULL;

-- 2개 이상 테이블로도 join 가능
-- 특정 직원의 정보 출력: 부서명, 업무명, 이름은 Nancy
SELECT e.first_name, e.department_id, d.department_id,
e.job_id, j.job_id, d.department_name, j.job_title
FROM employees e, departments d, jobs j
WHERE e.first_name = 'Nancy'
    AND e.department_id = d.department_id
    AND e.job_id = j.job_id;

-- self join: 같은 테이블을 조인
-- 사원과 상사의 정보를 가져올 때
SELECT a.employee_id, a.first_name,
    a.manager_id, b.employee_id,
    b.first_name
FROM employees a, employees b -- a:사원, b:상사 테이블이라고 생각하자.
WHERE a.manager_id = b.employee_id;