CREATE TABLE emp01(
empno NUMBER,
ename VARCHAR2(20),
job VARCHAR2(20),
deptno NUMBER
);

INSERT INTO emp01 VALUES(null, null, 'IT', 30);

CREATE TABLE emp02(
empno NUMBER not null,
ename VARCHAR2(20) not null,
job VARCHAR2(20),
deptno NUMBER
);

INSERT INTO emp02 VALUES(null, null, 'IT', 30);

INSERT INTO emp02 VALUES(100, 'kim', 'IT', 30);
INSERT INTO emp02 VALUES(100, 'park', 'IT', 30);

CREATE TABLE emp03(
empno NUMBER UNIQUE,
ename VARCHAR2(20) not null,
job VARCHAR2(20),
deptno NUMBER
);

INSERT INTO emp03 VALUES(100, 'kim', 'IT', 30);
INSERT INTO emp03 VALUES(100, 'park', 'IT', 30);

CREATE TABLE emp04(
empno NUMBER PRIMARY KEY,
ename VARCHAR2(20) not null,
job VARCHAR2(20),
deptno NUMBER
);

INSERT INTO emp04 VALUES(100, 'kim', 'IT', 30);
INSERT INTO emp04 VALUES(100, 'park', 'IT', 30);

INSERT INTO emp04 VALUES(200, 'kim', 'IT', 3000);


CREATE TABLE emp05(
empno NUMBER PRIMARY KEY,
ename VARCHAR2(20) not null,
job VARCHAR2(20),
deptno NUMBER REFERENCES departments(department_id)
);

INSERT INTO emp05 VALUES(200, 'kim', 'IT', 3000);

CREATE TABLE emp06(
empno NUMBER,
ename VARCHAR2(20) not null,
job VARCHAR2(20),
deptno NUMBER,

CONSTRAINT emp06_empno_pk PRIMARY KEY(empno),
CONSTRAINT emp06_deptno_fk FOREIGN KEY(deptno)
	REFERENCES departments(department_id)
);

CREATE TABLE emp07(
empno NUMBER,
ename VARCHAR2(20),
job VARCHAR2(20),
deptno NUMBER
);

ALTER TABLE emp07
 ADD CONSTRAINT emp07_empno_pk PRIMARY KEY(empno);
 
ALTER TABLE emp07
 ADD CONSTRAINT emp07_empno_FK FOREIGN KEY(deptno)
 REFERENCES departments(department_id);

ALTER TABLE emp07
 MODIFY ename CONSTRAINT emp07_ename_nn NOT NULL;
 
CREATE TABLE emp08(
empno NUMBER,
ename VARCHAR2(20),
job VARCHAR2(20),
deptno NUMBER
);

ALTER TABLE emp08
 ADD CONSTRAINT emp08_empno_pk PRIMARY KEY(empno)
 ADD CONSTRAINT emp08_empno_FK FOREIGN KEY(deptno)
 REFERENCES departments(department_id)
 MODIFY ename CONSTRAINT emp08_ename_nn NOT NULL;


create table emp09 (
    empno number,
    ename varchar2(20),
    job VARCHAR2(20),
    deptno number,
    gender char(1) check (gender in('M','F'))
);

INSERT INTO emp09 VALUES(200, 'KIM', 'IT', 30, 'A');

create table emp10 (
    empno number,
    ename varchar2(20),
    job VARCHAR2(20),
    deptno number,
    loc VARCHAR2(20) DEFAULT 'Seoul'
);

INSERT INTO emp10 (empno, ename, job, deptno) VALUES(300, 'KIM', 'IT', 30);

create table emp11 (
    empno number,
    ename varchar2(20),
    job VARCHAR2(20),
    deptno number,
    
    CONSTRAINT emp11_empno_ename_pk PRIMARY KEY(empno, ename)
);

INSERT INTO emp11 VALUES(200, 'KIM', 'IT', 30);
INSERT INTO emp11 VALUES(200, 'PARK', 'IT', 30);

DROP TABLE emp12;
create table emp12 (
    empno number,
    ename varchar2(20),
    job VARCHAR2(20),
    deptno number,
    
    CONSTRAINT emp12_departnment_id_fk FOREIGN KEY(deptno)
    REFERENCES dept01(department_id)
);

INSERT INTO emp12 VALUES (100, 'kim', 'it', 20);
DELETE FROM emp12 WHERE deptno = 20;
DELETE FROM dept01 WHERE department_id = 20;

SELECT * FROM dept01;

create table emp13 (
    empno number,
    ename varchar2(20),
    job VARCHAR2(20),
    deptno number references dept01(department_id) 
    ON DELETE CASCADE
);

insert into emp13 values(100, 'kim', 'it', 10);
delete from emp13 where deptno = 10;
delete from dept01 where department_id = 10;

SELECT employee_id, department_id FROM employees
WHERE last_name = 'King';

SELECT department_id, department_name FROM departments
WHERE department_id in (80, 90);

SELECT * FROM employees;

SELECT e.employee_id, d.department_id, d.department_name FROM employees e, departments d
WHERE e.department_id= d.department_id
AND e.last_name = 'King';

SELECT e.employee_id, d.department_id, d.department_name FROM employees e
JOIN departments d
on e.department_id= d.department_id;

SELECT e.first_name, e.last_name, e.email, e.department_id, 
d.department_name, j.job_id, j.job_title
FROM employees e, departments d, jobs j
WHERE e.department_id = d.department_id 
AND e.job_id = j.job_id;

SELECT e.first_name, e.last_name, e.email, e.department_id, 
d.department_name, j.job_id, j.job_title
FROM employees e
JOIN departments d
ON e.department_id = d.department_id 
JOIN jobs j
ON e.job_id = j.job_id;

SELECT e.first_name, e.last_name, e.department_id, 
j.job_id, j.job_title, l.city
FROM employees e, jobs j, locations l, departments d
WHERE e.department_id = d.department_id
AND e.job_id = j.job_id
AND d.location_id = l.location_id
AND l.city = 'Seattle';

SELECT e.first_name, e.last_name, e.department_id, 
j.job_id, j.job_title, l.city
FROM employees e
JOIN departments d
ON e.department_id = d.department_id
JOIN jobs j
ON e.job_id = j.job_id
JOIN locations l
ON d.location_id = l.location_id
AND l.city = 'Seattle';
