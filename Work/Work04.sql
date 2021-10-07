-- hr
-- 문제1) 사원들의 이름, 부서번호, 부서명을 출력하라
SELECT e.first_name, e.department_id, d.department_name
    FROM employees e, departments d
    WHERE e.department_id = d.department_id(+);

-- 문제2) 30번 부서의 사원들의 이름,직업,부서명을 출력하라
SELECT e.first_name, j.job_title, d.department_name
    FROM employees e, departments d, jobs j
    WHERE e.department_id = d.department_id
        AND e.job_id = j.job_id
        AND e.department_id = 30;

-- 문제3) 커미션을 받는 사원의 이름, 직업, 부서번호,부서명을 출력하라
SELECT e.first_name, j.job_title, e.department_id, d.department_name
    FROM employees e, departments d, jobs j
    WHERE e.commission_pct IS NOT NULL
        AND e.department_id = d.department_id
        AND e.job_id = j.job_id;
    
-- 문제4) 지역번호 2500 에서 근무하는 사원의 이름, 직업,부서번호,부서명을 출력하라
SELECT e.first_name, j.job_title, e.department_id, d.department_name
    FROM employees e, departments d, jobs j
    WHERE e.department_id = d.department_id
        AND e.job_id = j.job_id
        AND d.location_id = 2500;

-- 문제5) 이름에 A가 들어가는 사원들의 이름과 부서이름을 출력하라
SELECT e.first_name, d.department_name
    FROM employees e, departments d
    WHERE e.department_id = d.department_id
        AND e.first_name LIKE '%A%';

-- 문제6) 사원이름과 그 사원의 관리자 이름을 출력하라
SELECT a.first_name employee, b.first_name manager
    FROM employees a, employees b   -- a:사원 b:관리자
    WHERE a.manager_id = b.employee_id;

-- 문제7) 사원이름과 부서명과 월급을 출력하는데 월급이 3000 이상인 사원을 출력하라
SELECT e.first_name, d.department_name
    FROM employees e, departments d
    WHERE e.department_id = d.department_id
        AND e.salary >= 3000;

-- 문제8) TJ 이란 사원보다 늦게 입사한 사원의 이름과 입사일을 출력하라
SELECT a.first_name, a.hire_date
    FROM employees a, employees b   -- a:사원 b:TJ
    WHERE a.hire_date > b.hire_date
        AND b.first_name = 'TJ';    -- 이거 안넣으면 cross join 된다

-- 문제9) 급여가 3000에서 5000사이인 사원의 이름과 소속부서명 출력하라
SELECT e.first_name, d.department_name
    FROM employees e, departments d
    WHERE e.department_id = d.department_id
        AND e.salary BETWEEN 3000 AND 5000;

-- 문제10) ACCOUNTING 부서 소속 사원의 이름과 입사일 출력하라
SELECT e.first_name, e.hire_date
    FROM employees e, departments d
    WHERE e.department_id = d.department_id
        AND d.department_name = 'Accounting';

-- 문제11) 급여가 3000이하인 사원의 이름과 급여, 근무지
SELECT e.first_name, e.salary, l.street_address
    FROM employees e, departments d, locations l
    WHERE e.department_id = d.department_id
        AND d.location_id = l.location_id
        AND e.salary <= 3000;

/*
101번 사원에 대해 아래의 결과를 산출하는 쿼리를 작성해보자.
사번  사원명 job명칭   job시작일자 job종료일자 job수행부서명
*/
SELECT e.employee_id, e.first_name, j.job_title, jh.start_date, jh.end_date, d.department_name
    FROM employees e, departments d , jobs j, job_history jh
    WHERE jh.department_id = d.department_id
        AND jh.job_id = j.job_id
        AND e.employee_id = jh.employee_id
        AND e.employee_id = 101;    -- AND가 아니라 OR도 가능하지만, OR을 섞어 쓴다면 조건문을 배열하는 순서에 따라 결과가 달라질 수 있음
        -- AND 조건일때도 먼저 수행하고 싶은 게 있다면 괄호를 넣으면 됨
-- 일단 생각나는 건 다 써보면서 수정하자. 가능한 한 중복은 피하는 게 좋다
-- self join은 외래키가 아님. join을 하기위해 외래키와 외래키를 바로 연결하지는 못함...