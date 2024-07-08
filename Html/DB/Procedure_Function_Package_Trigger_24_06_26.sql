-- 부서 번호를 입력 받아 사원 리스트 처리
set serveroutput on;

--CREATE OR REPLACE PROCEDURE listByDeptno(p_deptno IN employees.department_id%TYPE)
--IS 
--	CURSOR employee_cursors IS
--		SELECT * FROM employees
--			WHERE department_id = p_deptno;
--	
--	employee_record employee_cursors%ROWTYPE;
--BEGIN
--	DBMS_OUTPUT.PUT_LINE('==============사원 리스트==============');
--	FOR employee_record IN employee_cursors LOOP
--		DBMS_OUTPUT.PUT_LINE(p_deptno || ' ' || employee_record.employee_id
--												|| ' ' || employee_record.last_name);
--	END LOOP;
--END;

--EXECUTE listByDeptno(30);

--CREATE TABLE JOBS2 AS SELECT * FROM JOBS;

--CREATE OR REPLACE PROCEDURE insertJob22Row(p_job_id IN jobs2.job_id%TYPE, p_job_title IN jobs2.job_title%TYPE, 
--                                    p_min_salary IN jobs2.min_salary%TYPE, p_max_salary IN jobs2.max_salary%TYPE)
--IS 
--BEGIN
--    DBMS_OUTPUT.PUT_LINE('추가되는 행(ROW) 데이터 정보');
--    DBMS_OUTPUT.PUT_LINE(p_job_id || ' ' || p_job_title || ' ' || p_min_salary || ' ' || p_max_salary);
--    INSERT INTO JOBS2 VALUES(p_job_id, p_job_title, p_min_salary, p_max_salary);
--    COMMIT;
--    DBMS_OUTPUT.PUT_LINE('추가되었습니다.');
--END;
--
--EXECUTE insertJob22Row('a', 'IT', 100, 1000);
--DROP procedure insertJOBS2Row;

--ALTER TABLE JOBS2 ADD CONSTRAINT jobs2_job_id_pk PRIMARY KEY(JOB_ID);

--CREATE OR REPLACE PROCEDURE validJobID(p_job_id IN jobs2.job_id%TYPE, p_job_title IN jobs2.job_title%TYPE, 
--                                    p_min_salary IN jobs2.min_salary%TYPE, p_max_salary IN jobs2.max_salary%TYPE)
--IS
--    CNT NUMBER;
--BEGIN
--    select count(*) into CNT from JOBS2
--    where job_id = p_job_id;
--
--    
--    IF CNT < 1 then
--        INSERT INTO jobs2 (job_id, job_title, min_salary, max_salary)
--        VALUES (p_job_id, p_job_title, p_min_salary, p_max_salary);
--    ELSE 
--        update jobs2 set job_title = p_job_title, min_salary = p_min_salary, max_salary = p_max_salary
--            where job_id = p_job_id;
--    END IF;
--END;    
--
--EXECUTE validJobID('a', 'IT', 1012, 121210);
--EXECUTE validJobID('aaa', 'IT', 1012, 121210);
--
--CREATE OR REPLACE PROCEDURE validJobID(p_job_id IN jobs2.job_id%TYPE, p_job_title IN jobs2.job_title%TYPE, 
--                                    p_min_salary IN jobs2.min_salary%TYPE, p_max_salary IN jobs2.max_salary%TYPE)
--IS
--    CNT NUMBER;
--BEGIN
--    select count(*) into CNT from JOBS2
--    where job_id = p_job_id;
--
--    
--    IF CNT < 1 then
--        INSERT INTO jobs2 (job_id, job_title, min_salary, max_salary)
--        VALUES (p_job_id, p_job_title, p_min_salary, p_max_salary);
--    ELSE 
--        update jobs2 set job_title = p_job_title, min_salary = p_min_salary, max_salary = p_max_salary
--            where job_id = p_job_id;
--    END IF;
--END;    
--
--EXECUTE validJobID('a', 'IT', 1012, 121210);
--EXECUTE validJobID('aaa', 'IT', 1012, 121210);

--CREATE OR REPLACE PROCEDURE validJobID3(p_job_id IN jobs2.job_id%TYPE, p_job_title IN jobs2.job_title%TYPE, 
--                                    p_min_salary IN jobs2.min_salary%TYPE := 100, 
--                                    p_max_salary IN jobs2.max_salary%TYPE := 1000)
--IS
--    CNT NUMBER;
--BEGIN
--    select count(*) into CNT from JOBS2
--    where job_id = p_job_id;
--
--    
--    IF CNT < 1 then
--        INSERT INTO jobs2 (job_id, job_title, min_salary, max_salary)
--        VALUES (p_job_id, p_job_title, p_min_salary, p_max_salary);
--    ELSE 
--        update jobs2 set job_title = p_job_title, min_salary = p_min_salary, max_salary = p_max_salary
--            where job_id = p_job_id;
--    END IF;
--END;    

--EXECUTE validJobID3('a', 'IT');
--EXECUTE validJobID3('aaa', 'IT');

CREATE OR REPLACE PROCEDURE validJobID4(p_job_id IN jobs2.job_id%TYPE, p_job_title IN jobs2.job_title%TYPE, 
                                    p_min_salary IN jobs2.min_salary%TYPE := 100, 
                                    p_max_salary IN jobs2.max_salary%TYPE := 1000,
                                    p_result OUT NUMBER)
IS
    CNT NUMBER;
BEGIN
    select count(*) into CNT from JOBS2
    where job_id = p_job_id;

    
    IF CNT < 1 then
        p_result := 1;
        INSERT INTO jobs2 (job_id, job_title, min_salary, max_salary)
        VALUES (p_job_id, p_job_title, p_min_salary, p_max_salary);
    ELSE 
        p_result := 2;
        update jobs2 set job_title = p_job_title, min_salary = p_min_salary, max_salary = p_max_salary
            where job_id = p_job_id;
    END IF;
END;

DECLARE
    p_result NUMBER;
BEGIN
    validJobID4('d', 'd1', 200, 2000, p_result);
    IF p_result = 1 THEN
        DBMS_OUTPUT.PUT_LINE('추가되었습니다.');
    ELSE 
        DBMS_OUTPUT.PUT_LINE('수정되었습니다.');
    END IF;
END;  

CREATE OR REPLACE FUNCTION getSalary(p_no employees.employee_id%TYPE)
	RETURN NUMBER
IS
	v_salary NUMBER;
BEGIN
	SELECT SALARY INTO v_salary
		FROM employees
		WHERE employee_id = p_no;
	RETURN v_salary;
END;

SELECT getSalary(100) FROM dual;

CREATE OR REPLACE FUNCTION getName(p_no employees.employee_id%TYPE)
    RETURN VARCHAR2
IS
    v_name VARCHAR2(20) := null;
BEGIN
    SELECT LAST_NAME INTO v_name
    FROM EMPLOYEES WHERE employee_id = p_no;

    RETURN v_name;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN '해당 사원 없음.';
END;


SELECT getName(100) FROM dual;

CREATE OR REPLACE PACKAGE my_package
IS
	PROCEDURE getEmployee(in_id IN employees.employee_id%TYPE,
												out_id OUT employees.employee_id%TYPE,
												out_name OUT employees.first_name%TYPE,
												out_salary OUT employees.salary%TYPE);
	
	FUNCTION getSalary(p_no employees.employee_id%TYPE)
		RETURN  NUMBER;
END;

-- 패키지 본문
CREATE OR REPLACE PACKAGE BODY my_package
IS
	PROCEDURE getEmployee(in_id IN employees.employee_id%TYPE,
												out_id OUT employees.employee_id%TYPE,
												out_name OUT employees.first_name%TYPE,
												out_salary OUT employees.salary%TYPE)
	IS
	BEGIN
		SELECT employee_id, first_name, salary INTO out_id, out_name, out_salary
		FROM employees WHERE employee_id = in_id;
	END;
	-- 프로시저 종료
	
	FUNCTION getSalary(p_no employees.employee_id%TYPE)
		RETURN  NUMBER
	IS
		v_salary NUMBER;
	BEGIN
		SELECT SALARY INTO v_salary
			FROM employees
			WHERE employee_id = p_no;
		RETURN v_salary;
	END;
	-- 함수 종료
END;
-- 패키지 종료

SELECT my_package.getSalary(100) FROM dual;

SELECT my_package.getSalary(100)FROM dual;

-- 프로시저 실행
DECLARE
	p_id NUMBER;
	p_name VARCHAR2(50);
	p_salary NUMBER;
BEGIN
	my_package.getEmployee(100, p_id, p_name, p_salary);
	DBMS_OUTPUT.PUT_LINE(p_id || ' '|| p_name || ' ' || p_salary);
END;

CREATE TABLE emp14(
	empno NUMBER PRIMARY KEY,
	ename VARCHAR2(20),
	job VARCHAR2(20)
);

CREATE OR REPLACE TRIGGER trg_01
	AFTER INSERT
	ON emp14
	BEGIN
		DBMS_OUTPUT.PUT_LINE('신입 사원이 추가 되었습니다.');
END;

INSERT INTO emp14 VALUES(1, '홍길동', '개발');

CREATE TABLE sal01(
	salno NUMBER PRIMARY KEY,
	sal NUMBER,
	empno NUMBER REFERENCES emp14(empno)
);

CREATE SEQUENCE sa01_salno_seq;

CREATE OR REPLACE TRiGGER trg_02
	AFTER INSERT
	ON emp14
	FOR EACH ROW
	BEGIN
		INSERT INTO sal01 VALUES(sa01_salno_seq.NEXTVAL, 4000, :NEW.empno);
END;

INSERT INTO emp14 VALUES(3, '박길동', '영업');

CREATE OR REPLACE TRiGGER trg_03
	AFTER DELETE
	ON emp14
	FOR EACH ROW
	BEGIN
		DELETE FROM SAL01 WHERE empno = :OLD.empno;
END;

DELETE FROM emp14 WHERE empno = 2;

ALTER TABLE employees02 ADD(retire_date date);

CREATE OR REPLACE PACKAGE hr_pkg IS
    --신규 사원 입력
    --신규사원 사번 => 마지막(최대)사번 + 1
    --신규사원 등록
    PROCEDURE new_emp_proc(ps_emp_name IN VARCHAR2,
	pe_email IN VARCHAR2,
	pj_job_id IN VARCHAR2,
	pd_hire_date IN VARCHAR2);
    -- TO_DATE(pdhire_date, 'YYYY-MM-DD');

   -- 퇴사 사원 처리
   --퇴사한 사원은 사원테이블에서 삭제하지 않고 퇴사일자(retire_date)를 NULL에서 갱신
   PROCEDURE retire_emp_proc(pn_employee_id IN NUMBER);

END;

CREATE OR REPLACE PACKAGE BODY hr_pkg 
IS
    PROCEDURE new_emp_proc(ps_emp_name IN VARCHAR2,
	pe_email IN VARCHAR2,
	pj_job_id IN VARCHAR2,
	pd_hire_date IN VARCHAR2)
  IS
    vn_emp_id employees02.employee_id%TYPE; 
    vd_hire_date DATE := TO_DATE(pd_hire_date, 'YYYY-MM-DD');

  BEGIN
        --신규사원 사번 => 마지막(최대)사번 + 1
        SELECT  NVL(MAX(employee_id), 0) + 1
	INTO vn_emp_id
	FROM employees02;

      --신규사원 등록
       INSERT INTO employees02(employee_id, last_name, hire_date, email, job_id)
	VALUES(vn_emp_id, ps_emp_name, vd_hire_date, pe_email, pj_job_id);

       COMMIT;

       EXCEPTION WHEN OTHERS THEN
	dbms_output.put_line('insert error');
	ROLLBACK;

  END new_emp_proc;
    
    PROCEDURE retire_emp_proc(pn_employee_id IN NUMBER)
  IS
    vn_cnt NUMBER := 0;
    e_no_data EXCEPTION;
  BEGIN
      UPDATE employees02
	SET retire_date = SYSDATE
	WHERE employee_id = pn_employee_id
	AND retire_date IS NULL;

      --UPDATE된 건수를 가져오기
      vn_cnt := SQL%ROWCOUNT;

     --갱신된 건수가 0이면 사용자 예외처리
     IF vn_cnt = 0 THEN
        RAISE e_no_data; --인위적으로 사용자 예외 발생
     END IF;

     COMMIT;

     EXCEPTION WHEN e_no_data THEN
	dbms_output.put_line(pn_employee_id ||'는 퇴사대상이 아닙니다.');
	ROLLBACK;

   END retire_emp_proc;
END;    

DECLARE
BEGIN
    hr_pkg.new_emp_proc('suho', 'suho@email.com', 'IT_PROG', SYSDATE);
END;
        
DECLARE
BEGIN
    hr_pkg.retire_emp_proc(209);
END;
