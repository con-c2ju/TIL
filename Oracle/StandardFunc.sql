-- Standard Function (표준함수)

-- DUAL TABLE : 가상 테이블 -> 간단히 결과확인만 하는 테이블
SELECT 1 FROM DUAL;
SELECT 'A' FROM DUAL;
SELECT '가' FROM DUAL;
SELECT '가나다' FROM DUAL;
SELECT 36 * 24 FROM DUAL;

-- [문자 함수]
-- CHR( NUMBER ) : ASCII 값을 문자로 변환 ex) A == 65
SELECT CHR(65) FROM DUAL;
SELECT CHR(48) FROM DUAL;

-- CONCAT
SELECT CONCAT('HELLO', 'WORLD') FROM DUAL;
SELECT '내 점수는 ' || CHR(65) || '입니다' FROM DUAL;
-- "내 점수는 " + CHAR(65) + "입니다"

-- LPAD(RPAD) : 전체 칸 중 빈칸을 지정문자(빈문자)로 채운다
SELECT LPAD('BBB', 10) FROM DUAL; -- 칸의 왼쪽을 빈칸으로 채움
SELECT RPAD('BBB', 10) FROM DUAL; -- 칸의 오른쪽을 빈칸으로 채움
SELECT LPAD('BBB', 10, '-') FROM DUAL; -- 오버로드 되어있음. 빈칸을 -로 채움
SELECT RPAD('BBB', 10, '0') FROM DUAL;

-- INSTR == indexOf         "abcde" indexOf('b) -> 1
SELECT INSTR('123ABC456DEFABC', 'A') FROM DUAL; -- 4가 나온다. DB에는 0번지가 없음
SELECT INSTR('123ABC456DEFABC', 'A', 6) FROM DUAL;  -- 6번지에서부터 찾으라는 뜻
SELECT INSTR('123ABC456DEFABCABC', 'A', 6, 1) FROM DUAL;    -- 6번지에서부터 찾되 첫번째로 나오는 문자의 자리값
SELECT INSTR('123ABC456DEFABC', 'X') FROM DUAL; -- 0이 나옴. Java는 0을 쓰니까 -1이 나오지만...

-- ★ REPLACE : 문자열 치환
SELECT REPLACE('AAAABCD', 'A') FROM DUAL; -- 무엇으로 바꿀지 아무것도 지정안한 상태. 그냥 해당하는 문자들이 삭제된다
SELECT REPLACE('AAAABCD', 'AA', 'a') FROM DUAL; -- 문자'열'치환. 문자열을 하나로 치고 통째로 바꿔줄 수도 있다.

-- ★ SUBSTR : substring()과는 좀 다름
-- Java의 경우 "ABCDE" -> substring(1, 3) ==> BC. 1번지부터 시작해서 3번지 '전'까지 출력
SELECT SUBSTR('ABCDE', 3) FROM DUAL;    -- 3번지부터 시작해서 끝까지. CDE
SELECT SUBSTR('ABCDE', 3, 1) FROM DUAL; -- 여기서 1은 '글자의 갯수'임. 3번지부터 시작해서 한글자만 출력한다는 뜻

-- [숫자]
-- 올림
SELECT CELL(13.1) FROM DUAL; -- 14가 나옴

-- 내림
SELECT FLOOR(13.9) FROM DUAL; -- 13이 나옴

-- 나눈 나머지 (Java의 %)
SELECT MOD(3, 2) FROM DUAL; -- 1이 나옴

-- 승수 (Java의 Math.pow)
SELECT POWER(3, 2) FROM DUAL; -- 3의 2제곱. 9가 나옴

-- 반올림
SELECT ROUND(13.5) FROM DUAL; -- 14가 나옴

-- 부호 (+:1, 0:0, -:-1)
SELECT SIGN(13.4) FROM DUAL; -- 양수라서 1나옴

-- 버림(소수점 값을)
SELECT TRUNC(123.4567) FROM DUAL; -- 소수점이 전부 사라짐
SELECT TRUNC(123.4567, 2) FROM DUAL; -- 소수점 둘째자리 까지 나옴
SELECT TRUNC(123.4567, 1) FROM DUAL; -- 소수점 첫째자리까지 나옴
SELECT TRUNC(123.4567, -1) FROM DUAL; -- 10의자리까지 버림

-- 변환함수
-- TO_CHAR : 문자열 변환함수
SELECT TO_CHAR(SYSDATE) FROM DUAL; -- 평소랑 똑같이 출력되지만 문자열 상태
SELECT TO_CHAR(SYSDATE, 'YYYY/MM/DD HH:MI:SS') FROM DUAL; -- 형식 지정도 가능

SELECT TO_CHAR(COL1, 'YYYY/MM/DD HH:MI:SS') FROM TB_DATE; -- 시간까지 지정한 행만 시간이 제대로 출력됨
SELECT TO_CHAR(10000000, '$999,999,999') FROM DUAL; -- 돈 단위도 지정해줄 수 있음. 돈 단위를 없애면 숫자로 나옴(지금은 문자열 상태)

-- TO_DATE : 날짜형 변환함수 (VARCHAR2 -> DATE)
SELECT TO_DATE('20210909') FROM DUAL;    -- 형태는 같지만 날짜형으로 나옴
SELECT TO_DATE('20210909', 'YYYY/MM/DD') FROM DUAL; -- 형식 지정 가능

-- TO_NUMBER = 숫자형 변환함수 (VARCHAR2 -> NUMBER)       Integer.parseInt("1000")
SELECT TO_NUMBER('12345') + 45 FROM DUAL; -- 문자열 상태여도 더해지긴 하지만 원래는 문법오류임

-- LAST_DAY : 해당하는 달의 마지막 날
SELECT LAST_DAY('21/09/09') FROM DUAL;  -- 2021/09/30 출력

SELECT LAST_DAY(TO_DATE('211012', 'YYMMDD')) FROM DUAL; -- 형식지정 가능


SELECT SYSDATE
    ,EXTRACT(YEAR FROM SYSDATE)
    ,EXTRACT(MONTH FROM SYSDATE)
    ,EXTRACT(DAY FROM SYSDATE)
    ,EXTRACT(HOUR FROM CAST(SYSDATE AS TIMESTAMP))
    ,EXTRACT(MINUTE FROM CAST(SYSDATE AS TIMESTAMP))
    ,EXTRACT(SECOND FROM CAST(SYSDATE AS TIMESTAMP))
FROM DUAL;
-- 년도, 월, 일, 시, 분, 초