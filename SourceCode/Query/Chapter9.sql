/****************************
	     CHAPTER 09
****************************/

-- 1
CREATE TABLE dept(
	id INTEGER,
	name VARCHAR(25)
)

ALTER TABLE dept
ADD CONSTRAINT id_pk PRIMARY KEY (id)

-- 2 
INSERT INTO dept(id, name)
SELECT department_id, department_name
FROM departments;

SELECT * FROM dept;


-- 3
CREATE TABLE emp (
	id INT,
	last_name VARCHAR(25),
	first_name VARCHAR(25),
	dept_id INT
)
ALTER TABLE emp
ADD CONSTRAINT fk_dept_id
	FOREIGN KEY (dept_id) REFERENCES dept(id)


-- 4
CREATE TABLE employees2 AS TABLE employees WITH NO DATA;

ALTER TABLE employees2
DROP COLUMN email, 
DROP COLUMN phone_number, 
DROP COLUMN hire_date, 
DROP COLUMN job_id, 
DROP COLUMN commission_pct,
DROP COLUMN manager_id

ALTER TABLE employees2
RENAME department_id TO dept_id


-- 5
DROP TABLE emp;