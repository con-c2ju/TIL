/*
    SELECT
    FROM ==> 이것들만 써선 데이터를 너무 많이 가져옴
    
    WHERE: 조건절 (if문에 해당)
    - 비교연산자 ( > < >= <= != <> <- 이것도 같지않다임 )
    - NULL, IS NULL, IS NOT NULL
    - AND(Java의 &&), OR(Java의 ||), 우선순위:()에 넣어주기
*/

-- 조건: 이름이 Julia
SELECT first_name, salary
    FROM employees
    WHERE first_name = 'Julia';

-- 조건: 월급이 $9000 이상인 사람
SELECT first_name, salary
    FROM employees
    WHERE salary >= 9000;
    
-- 조건: 이름이 Shanta 보다 큰 사람(??)
SELECT first_name
    FROM employees
    WHERE first_name >= 'Shanta';   -- 출력된다. 알파벳 순서상 뒤에 있는 사람들이 나옴.
    
-- 조건: 이름의 첫문자가 J보다 큰 사람
SELECT
    first_name FROM employees
    WHERE first_name >= 'J';
    
-- 조건: 매니저가 없는 사원
SELECT
    first_name FROM employees
    WHERE manager_id is null;   -- MANAGER_ID = NULL 로는 실행안됨. MANAGER_ID = ''도 안됨

-- && = AND. 오라클에서는 && 안쓴다.
-- 조건: 이름이 John, 월급이 5000 이상
SELECT
    first_name, salary FROM employees
    WHERE first_name = 'John'
        AND salary >= 5000;
        
-- || = OR
SELECT
    first_name, last_name FROM employees
    WHERE first_name = 'John'
        OR last_name = 'Vollman';

-- 조건: 2007년 12월 31일 '이후'에 입사한 사원
SELECT
    first_name, hire_date FROM employees
    WHERE hire_date > '07/12/31';

SELECT
    first_name, hire_date FROM employees
    WHERE hire_date > TO_DATE('20071231', 'YYYYMMDD');

/*
    예약어: WHERE절과 함께 쓰이는 것들
    - ALL(=AND), ANY(=OR)
    - IN, NOT IN : 속해있는지 아닌지
    - BETWEEN : 범위연산
    - ★ LIKE
*/

-- ALL
SELECT
    first_name FROM employees
    WHERE first_name = ALL('Julia', 'John');
    -- first_name = 'Julia' AND first_name = 'John';
    -- 위에서처럼 여러 값을 갖지 않는 변수도 있으므로 자주 쓰이진 않음

-- ANY
SELECT
    first_name FROM employees
    WHERE first_name = ANY('Julia', 'John');
    -- first_name = 'Julia' OR first_name = 'John';

SELECT
    first_name, salary FROM employees
    WHERE salary = ANY(8000, 3200, 6000);
    
-- IN : ANY와 거의 같음 (OR 조건이라는 소리)
SELECT
    first_name, salary FROM employees
    WHERE salary IN(8000, 3200, 6000);  -- ANY와의 차이: =을 안씀. IN/NOT IN으로 구분
-- ALL/ANY나 IN이나 범위를 지정하는 게 아님. 특정 값을 정해두고 그것과 같은지 비교하는 것

-- BETWEEN
SELECT
    first_name, salary FROM employees
    WHERE salary BETWEEN 3200 AND 9000; -- 기본적으로 값을 포함하는 범위
    -- WHERE salary >= 3200 AND salary <=9000;
    
SELECT
    first_name, salary FROM employees
    WHERE salary NOT BETWEEN 3200 AND 9000; -- 앞에 NOT을 붙일 수 있음
    -- WHERE salary < 3200 OR salary > 9000;
    
-- ★ LIKE
SELECT
    first_name FROM employees
    WHERE first_name LIKE 'G_ra_d'; -- 언더바(_): 어떤 글자든 한글자를 의미

SELECT
    first_name FROM employees
    WHERE first_name LIKE 'K%y';    -- 퍼센트(%): 중간에 들어간 문자열이 무엇이든 허용
    
SELECT
    first_name, hire_date FROM employees
    WHERE hire_date LIKE '06%'; -- %는 뒤에 문자가 없어도 상관없음

SELECT
    first_name, hire_date FROM employees
    WHERE hire_date LIKE '%06'; -- 앞에 문자가 없어도 상관없음

SELECT
    first_name, hire_date FROM employees
    WHERE first_name LIKE '%z%'; -- 앞뒤에 어떤 문자가 오든(문자가 없어도 됨) z가 포함되면 출력